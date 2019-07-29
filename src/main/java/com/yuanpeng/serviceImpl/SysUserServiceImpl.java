package com.yuanpeng.serviceImpl;


import com.yuanpeng.BuilderJava.PasswordEncryption;
import com.yuanpeng.BuilderJava.Res;
import com.yuanpeng.BuilderJava.ResultCode;
import com.yuanpeng.domain.SysUser;
import com.yuanpeng.mapper.SysUserMapper;
import com.yuanpeng.service.SysUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Service
@Transactional(readOnly = true)//从这一点设置的时间点开始（时间点a）到这个事务结束的过程中，其他事务所提交的数据，该事务将看不见！（查询中不会出现别人在时间点a之后提交的数据）
public class SysUserServiceImpl  implements SysUserService
{
	@SuppressWarnings("unused")
	private static Log log = LogFactory.getLog(SysUserServiceImpl.class);
	private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);
	//Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private SysUserMapper sysUserMapper;
	@Override
	public SysUser contrastMobile(String str) {
		SysUser sysUser = new SysUser();
		sysUser.setMobile(str);
		sysUser = this.sysUserMapper.contrastMobile(sysUser);
		return sysUser;
	}
    @Override
    @Transactional
	public Res saveSysUser(SysUser sysUser){
        Integer byMobileNum = sysUserMapper.selcetMobileBySysUserNum(sysUser.getMobile());
        if(byMobileNum!=0){
            return new Res(ResultCode.LOGIN_REG_MOBILE);
        }
        Integer byUserNameNum = sysUserMapper.selcetUserNameBySysUserNum(sysUser.getUsername());
        if(byUserNameNum!=0){
            return new Res(ResultCode.LOGIN_REG_USERNAME);
        }
        Integer insertNum = this.sysUserMapper.insertSysUser(sysUser);
        if(insertNum==0){
            return new Res(ResultCode.LOGIN_REG_ERROR);
        }
        return new Res(ResultCode.SUCCESS);
    }
    @Override
    public Res login(SysUser sysUser, HttpServletRequest request){
        SysUser dataBankSysUser =  this.sysUserMapper.contrastMobile(sysUser);
        if(dataBankSysUser == null ||dataBankSysUser.getDelFlag() == 1 ){
            return new Res(ResultCode.FAILED_LOGIN_INVALID_ACCOUNT);
        }
        try {
            boolean result = PasswordEncryption.authenticate(sysUser.getPassword(), dataBankSysUser.getPassword(), dataBankSysUser.getSalt());//密码验证.
            if(result){
                request.getSession().setAttribute("loginUser",dataBankSysUser);
                return new Res(ResultCode.SUCCESS);
            }else{
                return new Res(ResultCode.FAILED_LOGIN_INCORRECTCREDENTIALS);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return new Res(ResultCode.FAILED);

    }


}
