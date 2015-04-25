/**
 * Copyright (c) @2015-2-4. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.auth.site.service;

import java.util.List;

import com.szreach.medical.auth.site.bean.SiteBean;
import com.szreach.medical.common.base.BaseService;
import com.szreach.medical.common.base.PageBean;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-2-4
 * @Version: 1.0
 */
public interface SiteService extends BaseService {
	public void insertSite(SiteBean site);
	public SiteBean getSiteByID(Integer siteId);
	public void updateSite(SiteBean site);
	
	public int count();
	
	public List<SiteBean> query(SiteBean query);
	public List<SiteBean> query(SiteBean query, PageBean page);
	
	public void delete(Integer siteId);
}
