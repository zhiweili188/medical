/**
 * Copyright (c) @2015-4-30. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.course.service;

import java.util.List;

import com.szreach.medical.common.base.BaseService;
import com.szreach.medical.course.bean.CourseSubject;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-4-30
 * @Version: 1.0
 */
public interface CourseSubjectService extends BaseService<CourseSubject> {
	public List<CourseSubject> queryTree();
	public int validate(CourseSubject entity);
}
