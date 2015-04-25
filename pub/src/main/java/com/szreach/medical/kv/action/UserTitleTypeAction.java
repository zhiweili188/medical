/**
 * Copyright (c) @2015-4-15. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.kv.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.szreach.medical.common.annotation.SkipLogin;
import com.szreach.medical.common.base.BaseAction;
import com.szreach.medical.common.base.BaseService;
import com.szreach.medical.kv.bean.UserTitleType;
import com.szreach.medical.kv.service.UserTitleTypeService;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-4-15
 * @Version: 1.0
 */
@Controller
@RequestMapping("/utt")
@Scope("prototype")
public class UserTitleTypeAction extends BaseAction<UserTitleType> {

	@Autowired
	private UserTitleTypeService userTitleTypeService;
	@Override
	protected BaseService<UserTitleType> getService() {
		return userTitleTypeService;
	}
	
	@SkipLogin(value=true)
	@RequestMapping(value="/json.do", produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String  all(UserTitleType query, Model model) {
		
		List<UserTitleType> list = userTitleTypeService.getAll(query);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		return json;
	}
}
