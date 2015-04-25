/**
 * Copyright (c) @2015-4-15. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.course.apply.dao;

import com.szreach.medical.common.base.BaseDao;
import com.szreach.medical.course.apply.bean.UserRegister;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-4-15
 * @Version: 1.0
 */
public interface UserRegisterDao extends BaseDao<UserRegister> {

	public UserRegister getByUserId(String userId);
	public UserRegister getByIdCardNo(String idCardNo);
	public UserRegister getByEmail(String email);
}
