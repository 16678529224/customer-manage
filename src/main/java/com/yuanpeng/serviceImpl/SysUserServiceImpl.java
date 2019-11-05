package com.yuanpeng.serviceImpl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yuanpeng.BuilderJava.PasswordEncryption;
import com.yuanpeng.BuilderJava.Res;
import com.yuanpeng.BuilderJava.ResultCode;
import com.yuanpeng.domain.SysUser;
import com.yuanpeng.mapper.SysUserMapper;
import com.yuanpeng.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author yuanpeng
 * @since 2019-11-05
 */
@Service
@Transactional(readOnly = true)//从这一点设置的时间点开始（时间点a）到这个事务结束的过程中，其他事务所提交的数据，该事务将看不见！（查询中不会出现别人在时间点a之后提交的数据）
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    
	private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);
	
	
	@Override
	public SysUser contrastMobile(String str) {
		SysUser sysUser = new SysUser();
		sysUser.setMobile(str);
		sysUser = this.baseMapper.contrastMobile(sysUser);
		return sysUser;
		
	}
    @Override
    @Transactional
	public Res saveSysUser(SysUser sysUser){
        Integer byMobileNum = baseMapper.selcetMobileBySysUserNum(sysUser.getMobile());
        if(byMobileNum!=0){
            return new Res(ResultCode.LOGIN_REG_MOBILE);
        }
        Integer byUserNameNum = baseMapper.selcetUserNameBySysUserNum(sysUser.getUsername());
        if(byUserNameNum!=0){
            return new Res(ResultCode.LOGIN_REG_USERNAME);
        }
        Integer insertNum = this.baseMapper.insertSysUser(sysUser);
        if(insertNum==0){
            return new Res(ResultCode.LOGIN_REG_ERROR);
        }
        return new Res(ResultCode.SUCCESS);
    }
    @Override
    public Res login(SysUser sysUser, HttpServletRequest request){
        SysUser dataBankSysUser =  this.baseMapper.contrastMobile(sysUser);
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
