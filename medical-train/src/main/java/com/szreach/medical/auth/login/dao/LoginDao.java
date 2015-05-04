/**
 * Copyright (c) @2015-3-25. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.auth.login.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.szreach.medical.auth.menu.bean.MenuBean;
import com.szreach.medical.common.base.BaseDao;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-3-25
 * @Version: 1.0
 */
public interface LoginDao   extends BaseDao{
	public List<MenuBean> queryMenuTree(@Param("userId")int userId, @Param("systemId")int systemId);
}
