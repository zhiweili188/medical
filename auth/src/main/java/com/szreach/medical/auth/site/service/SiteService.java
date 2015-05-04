/**
 * Copyright (c) @2015-2-4. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.auth.site.service;

import com.szreach.medical.auth.site.bean.SiteBean;
import com.szreach.medical.common.base.BaseService;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-2-4
 * @Version: 1.0
 */
public interface SiteService extends BaseService<SiteBean> {
	
	public SiteBean getByUrl(String url);
}
