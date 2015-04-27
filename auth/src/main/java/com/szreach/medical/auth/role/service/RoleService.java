/**
 * Copyright (c) @2015-3-23. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.auth.role.service;

import java.util.List;

import com.szreach.medical.auth.role.bean.Role;
import com.szreach.medical.common.base.BaseService;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-3-23
 * @Version: 1.0
 */
public interface RoleService extends BaseService<Role> {
	//public void insertRole(Role role);
	//public Role getRoleByID(Integer roleId);
	//public void updateRole(Role role);
	
	//public int count(Role query);
	
	//public List<Role> query(Role query, PageBean page);
	//public List<Role> getAll(Role query);
	
	public List<Role> getChoosableRoles(int userId);
	
	//public void delete(Integer roleId);
}
