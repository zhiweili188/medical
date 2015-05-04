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
	public static final int ERROR = 1;
	/**登录*/
	public static final int USERNAME_PASSW_ERROR = 1;//用户名或密码错误
	public static final int USER_STATUS_9_ERROR = 2;//用户已停用
}
