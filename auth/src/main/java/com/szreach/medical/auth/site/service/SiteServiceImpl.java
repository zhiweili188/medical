/**
 * Copyright (c) @2015-2-4. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.auth.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.szreach.medical.auth.role.bean.Role;
import com.szreach.medical.auth.site.bean.SiteBean;
import com.szreach.medical.auth.site.dao.SiteDao;
import com.szreach.medical.common.base.AbstractBaseServiceImpl;
import com.szreach.medical.common.base.BaseDao;
import com.szreach.medical.common.base.PageBean;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-2-4
 * @Version: 1.0
 */
@Service("siteService")
@Scope("prototype")
@Transactional
public class SiteServiceImpl extends AbstractBaseServiceImpl<SiteBean> implements SiteService {

	@Autowired
	private SiteDao siteDao;
	
	
	@Override
	public BaseDao<SiteBean> getBaseDao() {
		return siteDao;
	}

	@Override
	public List<SiteBean> getAll(SiteBean query) {
		return siteDao.query(query, null);
	}
	
	public SiteBean getByUrl(String url) {
		return siteDao.getByUrl(url);
	}
}
