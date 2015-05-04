/**
 * Copyright (c) @2015-4-29. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.coursetype.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szreach.medical.common.base.BaseAction;
import com.szreach.medical.common.base.BaseService;
import com.szreach.medical.coursetype.bean.CourseType;
import com.szreach.medical.coursetype.service.CourseTypeService;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-4-29
 * @Version: 1.0
 */
@Controller
@RequestMapping("/courseType")
@Scope("prototype")
public class CourseTypeAction extends BaseAction<CourseType> {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private CourseTypeService courseTypeService;
	@Override
	protected BaseService<CourseType> getService() {
		return courseTypeService;
	}
	@Override
	protected String getPrefix() {
		return "/courseType";
	}
	
}
