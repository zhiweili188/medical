/**
 * Copyright (c) @2015-3-23. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.auth.role.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.szreach.medical.auth.role.bean.Role;
import com.szreach.medical.auth.role.service.RoleService;
import com.szreach.medical.common.base.BaseAction;
import com.szreach.medical.common.base.BaseService;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-3-23
 * @Version: 1.0
 */
@Controller
@RequestMapping("/role")
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/all.do", produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String  all(Role query, Model model) {
		
		List<Role> list = roleService.getAll(query);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		return json;
	}
	@RequestMapping(value="/choose{userId}.do", produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String  getChoosableRoles(@PathVariable("userId") int userId) {
		
		List<Role> list = roleService.getChoosableRoles(userId);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		return json;
	}
	
	@RequestMapping(value="/edit{id}.do", produces={"application/json;charset=utf-8"})
	@ResponseBody
	public Role getRoleById(@PathVariable("id") int id, @RequestParam("systemId") int systemId) {
		Role role = roleService.getRoleByID(id, systemId);
		return role;
	}
	@Override
	public BaseService getService() {
		return roleService;
	}

	@Override
	protected String getPrefix() {
		return "/role";
	}
}
