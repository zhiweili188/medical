/**
 * Copyright (c) @2015-3-25. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.auth.login.service;

import java.util.List;

import com.szreach.medical.auth.menu.bean.MenuBean;
import com.szreach.medical.auth.user.bean.LoginUser;
import com.szreach.medical.common.base.BaseService;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-3-25
 * @Version: 1.0
 */
public interface LoginService extends BaseService {
	public List<MenuBean> queryMenuTree(int userId);
	public int checkLogin(LoginUser user, LoginUser loginUser);
}
