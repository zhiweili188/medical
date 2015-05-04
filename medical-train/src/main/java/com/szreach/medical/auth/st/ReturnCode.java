/**
 * Copyright (c) @2015-3-31. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.auth.st;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-3-31
 * @Version: 1.0
 */
public interface ReturnCode {
	/**可通用*/
	public static final int SUCCESS = 0;
	/**登录*/
	public static final int USERNAME_PASSW_ERROR = 1;//用户名或密码错误
	
	/**学科管理*/
	public static final int COURSE_SUBJECT_NAME_EXISTS_ERROR = 1;//学科名称已存在
}
