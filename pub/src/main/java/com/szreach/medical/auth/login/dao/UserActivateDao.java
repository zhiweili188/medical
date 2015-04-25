/**
 * Copyright (c) @2015-4-24. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.auth.login.dao;

import com.szreach.medical.auth.login.bean.UserActivate;
import com.szreach.medical.common.base.BaseDao;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-4-24
 * @Version: 1.0
 */
public interface UserActivateDao extends BaseDao<UserActivate> {
	public UserActivate getByUserId(String id);
}
