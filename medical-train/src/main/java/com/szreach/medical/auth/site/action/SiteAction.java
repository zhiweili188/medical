/**
 * Copyright (c) @2015-2-3. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.auth.site.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.szreach.medical.auth.role.bean.Role;
import com.szreach.medical.auth.site.bean.SiteBean;
import com.szreach.medical.auth.site.service.SiteService;
import com.szreach.medical.common.base.BaseAction;
import com.szreach.medical.common.base.BaseService;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-2-3
 * @Version: 1.0
 */
@Controller
@RequestMapping("/site")
@Scope("prototype")
public class SiteAction extends BaseAction<SiteBean> {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SiteService siteService;
	
	@Override
	protected String getPrefix() {
		return "/site";
	}

	@Override
	protected BaseService<SiteBean> getService() {
		return siteService;
	}

	@RequestMapping(value="/all.do", produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String  all(SiteBean query, Model model) {
		
		List<SiteBean> list = siteService.getAll(query);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		return json;
	}
}
