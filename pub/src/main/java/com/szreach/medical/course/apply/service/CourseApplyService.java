/**
 * Copyright (c) @2015-4-15. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.course.apply.service;

import java.util.List;

import com.szreach.medical.common.base.BaseService;
import com.szreach.medical.course.apply.bean.Course;
import com.szreach.medical.course.apply.bean.UserCourseApply;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-4-15
 * @Version: 1.0
 */
public interface CourseApplyService extends BaseService<Course> {
	public Course getByID(String id);
	public int apply(String courseId, String userId);
	public List<Course> queryUserApplyCourse(UserCourseApply query);
}
