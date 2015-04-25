/**
 * Copyright (c) @2015-4-15. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.kv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.szreach.medical.common.base.AbstractBaseServiceImpl;
import com.szreach.medical.common.base.BaseDao;
import com.szreach.medical.kv.bean.UserIdentity;
import com.szreach.medical.kv.dao.UserIdentityDao;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-4-15
 * @Version: 1.0
 */
@Service("userIdentityService")
@Scope("prototype")
@Transactional
public class UserIdentityServiceImpl extends AbstractBaseServiceImpl<UserIdentity> implements UserIdentityService {
	@Autowired
	private UserIdentityDao userIdentityDao;
	@Override
	public BaseDao<UserIdentity> getBaseDao() {
		return userIdentityDao;
	}
}
