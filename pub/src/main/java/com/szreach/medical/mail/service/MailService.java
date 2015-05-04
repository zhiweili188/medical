/**
 * Copyright (c) @2015-4-24. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.mail.service;

import java.util.Map;

import org.springframework.mail.SimpleMailMessage;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-4-24
 * @Version: 1.0
 */
public interface MailService {
	public void send(String to, String subject, String templateName, Map<String, Object> model);
}
