/**
 * Copyright (c) @2015-4-24. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-4-24
 * @Version: 1.0
 */
public class GlobalExacetionHandler implements HandlerExceptionResolver {
	Logger log = LoggerFactory.getLogger(getClass());
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception ex) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ex", ex);
		log.debug(ex.getMessage());
		if(ex instanceof BusinessException) {
			return new ModelAndView("error-business", model);
		} else if (ex instanceof ParameterException) {
			return new ModelAndView("error-parameter", model);
		} else {
			return new ModelAndView("error", model);
		}
	}
}
