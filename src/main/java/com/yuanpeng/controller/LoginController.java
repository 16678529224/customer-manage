package com.yuanpeng.controller;

import com.yuanpeng.BuilderJava.*;
import com.yuanpeng.domain.SysUser;
import com.yuanpeng.domain.User;
import com.yuanpeng.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.UUID;

@Controller
@RequestMapping("login")
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    SysUserService sysUserService;
    @GetMapping("/forget")
    public String forget(Model model){
        model.addAttribute("email","测试一下");
        return "login/forget";
    }
    @GetMapping("/reg")
    public String reg(Model model){
        model.addAttribute("email","测试一下");
        return "login/reg";
    }
    @GetMapping("/loginReg")
    public String loginReg(Model model){
        model.addAttribute("email","测试一下");
        model.addAttribute("isLogin","1");
        return "login/login";
    }
    /**
     * 生成验证码
     */
    @RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            logger.error("获取验证码失败>>>>   ", e);
        }
    }
    /**
     * 校验验证码
     */
    @ResponseBody
    @RequestMapping(value = "/checkVerify", method = RequestMethod.POST,headers = "Accept=application/json")
    public boolean checkVerify(@RequestParam String verifyInput, HttpSession session) {
        try{
            //从session中获取随机数
            String inputStr = verifyInput;
            String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
            if (random == null) {
                return false;
            }
            if (random.equals(inputStr)) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            logger.error("验证码校验失败", e);
            return false;
        }
    }

    /**
     * 登录
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/login")
    public Res login(@ModelAttribute SysUser sysUser,HttpServletRequest request,Model model) {

        BASE64Decoder decoder = new BASE64Decoder();
        String username = null;
        String password = null;
        try {
            username = new String(decoder.decodeBuffer(sysUser.getUsername()), "UTF-8");
            password = new String(decoder.decodeBuffer(sysUser.getPassword()), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return new Res(ResultCode.FAILED);
        }

        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //3.执行登录方法
        try {
            subject.login(token);//直接到UserRealm
            //登录成功
            //跳转到test.html
            return new Res(ResultCode.SUCCESS);
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登录失败:用户名不存在
            //model.addAttribute("msg", "用户名不存在");
            return new Res(ResultCode.FAILED_LOGIN_NO_USERNAME);
        }catch (IncorrectCredentialsException e) {
            //e.printStackTrace();
            //登录失败:密码错误
            //model.addAttribute("msg", "密码错误");
            return new Res(ResultCode.FAILED_LOGIN_INCORRECTCREDENTIALS);
        }catch (LockedAccountException e){
            return new Res(ResultCode.FAILED_LOGIN_SUODING);
        }

    }
    /**
     * 创建账户
     */
    @ResponseBody
    @PostMapping(value = "/saveSysUser")
    public Res saveSysUser(@ModelAttribute SysUser sysUser) {
        BASE64Decoder decoder = new BASE64Decoder();

        try {
            sysUser.setId(ToolUtils.getUuid());
            String usename = new String(decoder.decodeBuffer(sysUser.getUsername()), "UTF-8");
            sysUser.setUsername(usename);
            String password = new String(decoder.decodeBuffer(sysUser.getPassword()), "UTF-8");
            String salt = PasswordEncryption.generateSalt();//生成盐值
            String ciphertext = PasswordEncryption.getEncryptedPassword(password, salt);//密文
            sysUser.setSalt(salt);
            sysUser.setPassword(ciphertext);
            Res res = sysUserService.saveSysUser(sysUser);
            logger.debug("username=="+usename+"--------salt=="+salt+"--------ciphertext=="+ciphertext);
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return new Res(ResultCode.LOGIN_REG_ERROR);
    }

    /**
     * 语言选择
     * @param lang
     * @param request
     * @return
     */
    @ResponseBody
    @GetMapping("/language")
    public Res language(@RequestParam String lang,HttpServletRequest request){
        request.getSession().setAttribute("lang",lang);
        logger.debug(lang);
        return  new Res(ResultCode.SUCCESS);
    }
}
