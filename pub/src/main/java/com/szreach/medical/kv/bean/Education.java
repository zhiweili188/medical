/**
 * Copyright (c) @2015-4-16. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.kv.bean;

import com.szreach.medical.common.base.Persistentable;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-4-16
 * @Version: 1.0
 */
public class Education extends Persistentable {
	private Integer key;
	private String value;
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
