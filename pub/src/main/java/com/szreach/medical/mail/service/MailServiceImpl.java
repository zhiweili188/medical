/**
 * Copyright (c) @2015-4-24. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.mail.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-4-24
 * @Version: 1.0
 */
public class MailServiceImpl implements MailService {
	protected static final Logger log = LoggerFactory.getLogger(MailServiceImpl.class);

	private FreeMarkerConfigurer freeMarkerConfigurer;
	private MailSender mailSender;
	private String emailFrom;
	private String fromDisplayName;
	private String replyTo;
	private TaskExecutor taskExecutor;

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	public FreeMarkerConfigurer getFreeMarkerConfigurer() {

		return freeMarkerConfigurer;
	}

	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {

		this.freeMarkerConfigurer = freeMarkerConfigurer;
	}

	public MailSender getMailSender() {

		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {

		this.mailSender = mailSender;
	}

	public String getEmailFrom() {

		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {

		this.emailFrom = emailFrom;
	}

	public String getFromDisplayName() {

		return fromDisplayName;
	}

	public void setFromDisplayName(String fromDisplayName) {

		this.fromDisplayName = fromDisplayName;
	}

	public TaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public void send(final SimpleMailMessage msg) {

		try {
			((JavaMailSenderImpl) mailSender).send(msg);
		}
		catch (MailException ex) {
			log.error(ex.getMessage());
		}
	}
	
	public void send(String to, String subject, String templateName, Map<String, Object> model) {
		String content = generateEmailContentByFreeMarker(templateName, model);
		taskExecutor.execute(new MailTask(to, subject, content));
	}

	/**
	 * send the email with the email template.
	 */
	public void send(SimpleMailMessage msg, String content) {

		
		MimeMessage mimeMsg = null;
		try {
			mimeMsg = ((JavaMailSenderImpl) mailSender).createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true, "utf-8");
			helper.setTo(msg.getTo());
			helper.setFrom(emailFrom, fromDisplayName);
			//helper.setReplyTo(replyTo);
			if (msg.getSubject() != null)
				helper.setSubject(msg.getSubject());

			if (msg.getFrom() != null)
				helper.setFrom(msg.getFrom());

			helper.setText(content, true);

			((JavaMailSenderImpl) mailSender).send(mimeMsg);
		}
		catch (MessagingException ex) {
			ex.printStackTrace();
			log.error(ex.getMessage(), ex);
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}
		catch (MailException ex) {
			ex.printStackTrace();
			log.error(ex.getMessage(), ex);
		}
	}


	private String generateEmailContentByFreeMarker(String templateName, Map<String, Object> map) {

		try {
			Configuration configuration = freeMarkerConfigurer.getConfiguration();
			Template t = configuration.getTemplate(templateName);
			t.setEncoding("utf-8");
			return FreeMarkerTemplateUtils.processTemplateIntoString(t, map);
		}
		catch (TemplateException e) {
			log.error("Error while processing FreeMarker template ", e);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			log.error("Error while generate Email Content ", e);
		}

		return null;
	}

	private class MailTask implements Runnable {
		  private String to;
		  private String subject;
		  private String content;
		public MailTask(String to, String subject, String content) {
			this.to = to;
            this.subject = subject;
            this.content = content;
		}
		@Override
		public void run() {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(to);
			mailMessage.setSubject(subject);
			//这里的model是给模板页面传送数据用的，在模板页面中要用freemarker的脚本语言解析这些数据
			send(mailMessage, content);
			
		}
		
	}
}
