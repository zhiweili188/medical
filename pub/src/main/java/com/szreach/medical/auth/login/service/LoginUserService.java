/**
 * Copyright (c) @2015-3-11. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.auth.login.service;

import com.szreach.medical.auth.login.bean.LoginUser;
import com.szreach.medical.common.base.BaseService;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-3-11
 * @Version: 1.0
 */
public interface LoginUserService extends BaseService<LoginUser> {
	//public void insertLoginUser(LoginUser user);
	//public LoginUser getLoginUserByID(Integer loginUserId);
	public LoginUser getByUserName(String userName);
	
	//public void updateLoginUser(LoginUser user);
	public void updatePwd(LoginUser user);
	public void updateActivateStatus(LoginUser user);
	
	

}
