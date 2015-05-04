/**
 * Copyright (c) @2014-3-7. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.auth.menu.service;

import java.util.List;

import com.szreach.medical.auth.menu.bean.MenuBean;
import com.szreach.medical.common.base.BaseService;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2014-3-7
 * @Version: 1.0
 */
public interface MenuService  extends BaseService<MenuBean> {

	//public int count(MenuBean query);
	//public void insertMenu(MenuBean menu);
	//public void updateMenu(MenuBean menu);
	//public void delete(Integer menuId);
	//public MenuBean getMenuByID(Integer menuId);
	
	//public List<MenuBean> queryMenu(MenuBean query,  PageBean page);
	
	public List<MenuBean> queryTree(int systemId);
}
