/**
 * Copyright (c) @2015-4-30. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.course.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szreach.medical.common.base.BaseAction;
import com.szreach.medical.common.base.BaseService;
import com.szreach.medical.course.bean.CourseSubject;
import com.szreach.medical.course.service.CourseSubjectService;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-4-30
 * @Version: 1.0
 */
@Controller
@RequestMapping("/courseSubject")  
@Scope("prototype")
public class CourseSubjectAction extends BaseAction<CourseSubject> {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private CourseSubjectService courseSubjectService;
	@Override
	protected BaseService<CourseSubject> getService() {
		return courseSubjectService;
	}
	
}
