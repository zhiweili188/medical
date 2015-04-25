/**
 * Copyright (c) @2015-2-3. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.auth.site.dao;

import java.util.List;

import com.szreach.medical.auth.site.bean.SiteBean;
import com.szreach.medical.common.base.BaseDao;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-2-3
 * @Version: 1.0
 */
public interface SiteDao extends BaseDao<SiteBean> {
	public void insertSite(SiteBean site);
	public SiteBean getSiteByID(Integer siteId);
	public void updateSite(SiteBean site);
	
	public int count();
	
	public List<SiteBean> query(SiteBean query);
	
	public void delete(Integer siteId);
}
