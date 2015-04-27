/**
 * Copyright (c) @2015-4-2. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.auth.room.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szreach.medical.auth.room.bean.Room;
import com.szreach.medical.auth.room.service.RoomService;
import com.szreach.medical.common.base.BaseAction;
import com.szreach.medical.common.base.BaseService;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-4-2
 * @Version: 1.0
 */
@Controller
@RequestMapping("/room")
@Scope("prototype")
public class RoomAction extends BaseAction<Room> {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private RoomService roomService;
	
	@Override
	public BaseService getService() {
		return roomService;
	}

	@Override
	protected String getPrefix() {
		return "/room";
	}
	
}
