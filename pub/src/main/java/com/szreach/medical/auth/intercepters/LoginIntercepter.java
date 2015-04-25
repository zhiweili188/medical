/**
 * Copyright (c) @2015-3-11. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.auth.intercepters;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.szreach.medical.common.annotation.SkipLogin;
import com.szreach.medical.st.Key;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-3-11
 * @Version: 1.0
 */
public class LoginIntercepter implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestUri = request.getServletPath();
		logger.debug("----------------preHandle----------------"+requestUri);
		HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        SkipLogin annotation = method.getAnnotation(SkipLogin.class);
        if (annotation != null && annotation.value() == true) {
        	logger.debug("----------------skip login----------------"+requestUri);
        	return true;
        }

		boolean isLogin = false;
		if(request.getSession(false) !=null && request.getSession(false).getAttribute(Key.SESSION_LOGIN_USER) != null) {
			isLogin = true;
		} else {
			 response.sendRedirect("/pub/redict2login.jsp");
		}
		logger.debug("user logined: " + isLogin);
		
		return isLogin;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.debug("==============执行顺序: 2、postHandle================");  

	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.debug("==============执行顺序: 3、afterCompletion================");  

	}

}
