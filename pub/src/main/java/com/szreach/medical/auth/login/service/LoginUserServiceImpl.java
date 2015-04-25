/**
 * Copyright (c) @2015-3-11. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.auth.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.szreach.medical.auth.login.bean.LoginUser;
import com.szreach.medical.auth.login.dao.LoginUserDao;
import com.szreach.medical.common.base.AbstractBaseServiceImpl;
import com.szreach.medical.common.util.CommonTools;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-3-11
 * @Version: 1.0
 */
@Service("loginUserService")
@Scope("prototype")
@Transactional
public class LoginUserServiceImpl extends AbstractBaseServiceImpl<LoginUser>  implements LoginUserService {

	@Autowired
	private LoginUserDao loginUserDao;

	@Override
	public LoginUser getByID(Integer loginUserId) {
		return loginUserDao.get(loginUserId);
	}
	
	public LoginUser getByUserName(String userName) {
		return loginUserDao.getByUserName(userName);
	}

	
	public void updatePwd(LoginUser user) {
		user.setPasswd(CommonTools.getMD5(user.getPasswd()));
		loginUserDao.updatePwd(user);
	}

	public void updateActivateStatus(LoginUser user) {
		loginUserDao.updateActivateStatus(user);
	}

}
