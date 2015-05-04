/**
 * Copyright (c) @2015-4-29. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.coursetype.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.szreach.medical.common.base.AbstractBaseServiceImpl;
import com.szreach.medical.common.base.BaseDao;
import com.szreach.medical.common.base.PageBean;
import com.szreach.medical.coursetype.bean.CourseType;
import com.szreach.medical.coursetype.dao.CourseTypeDao;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-4-29
 * @Version: 1.0
 */
@Service("courseTypeService")
@Scope("prototype")
@Transactional
public class CourseTypeServiceImpl extends AbstractBaseServiceImpl<CourseType> implements CourseTypeService {

	@Autowired
	private CourseTypeDao courseTypeDao;

	@Override
	public BaseDao<CourseType> getBaseDao() {
		return courseTypeDao;
	}
	
	
}
