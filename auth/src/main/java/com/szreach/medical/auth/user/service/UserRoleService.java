/**
 * Copyright (c) @2015-3-30. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.auth.user.service;

import java.util.List;

import com.szreach.medical.auth.user.bean.UserRole;
import com.szreach.medical.common.base.BaseService;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-3-30
 * @Version: 1.0
 */
public interface UserRoleService extends BaseService {
	public List<UserRole> getUserRole(int userId);
}
