/**
 * Copyright (c) @2015-2-5. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.common.base;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-2-5
 * @Version: 1.0
 */
public abstract class Persistentable {
	private Integer id;
	private String token;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
