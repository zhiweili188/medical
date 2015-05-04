/**
 * Copyright (c) @2015-4-30. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.course.dao;

import java.util.List;

import com.szreach.medical.common.base.BaseDao;
import com.szreach.medical.course.bean.CourseSubject;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-4-30
 * @Version: 1.0
 */
public interface CourseSubjectDao extends BaseDao<CourseSubject>{

	public List<CourseSubject> queryTree();
	public CourseSubject getByName(String subjectName);
}
