/**
 * Copyright (c) @2015-4-15. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.course.apply.dao;

import java.util.List;

import com.szreach.medical.common.base.BaseDao;
import com.szreach.medical.course.apply.bean.Course;
import com.szreach.medical.course.apply.bean.UserCourseApply;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-4-15
 * @Version: 1.0
 */
public interface CourseApplyDao extends BaseDao<Course> {
	public Course get(String id);
	public void decRemainQuota(String id);
	public List<Course> queryUserApplyCourse(UserCourseApply query);
}
