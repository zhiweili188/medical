/**
 * Copyright (c) @2015-3-11. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.auth.user.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.szreach.medical.auth.user.bean.LoginUser;
import com.szreach.medical.auth.user.service.LoginUserService;
import com.szreach.medical.common.base.BaseAction;
import com.szreach.medical.common.base.BaseService;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-3-11
 * @Version: 1.0
 */
@Controller
@RequestMapping("/user")
@Scope("prototype")
public class UserAction  extends BaseAction<LoginUser> {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private LoginUserService loginUserService;
	
	/*@RequestMapping(value="/index.do")
	public ModelAndView index() {
		return new ModelAndView("/user/index");
	}*/
	
	/*@RequestMapping(value="/list.do", produces={"application/json;charset=utf-8"})
	@ResponseBody
	public String  list(LoginUser query,  @RequestParam("page") int pageNumber,  @RequestParam("rows") int pageSize, Model model) {
		PageBean page = new PageBean();
		page.setCurrPage(pageNumber);
		page.setPageSize(pageSize);
		
		List<LoginUser> list = loginUserService.query(query, page);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		json = "{\"rows\":"+json+",\"total\":"+page.getTotal()+"}";
		return json;
	}*/
	
	/*@RequestMapping(value="/id{id}.do", produces={"application/json;charset=utf-8"})
	@ResponseBody
	public LoginUser getLoginUserById(@PathVariable("id") int id) {
		LoginUser user = loginUserService.getLoginUserByID(id);
		return user;
	}*/
	
	/*@RequestMapping("/save.do")
	@ResponseBody
	public String save(LoginUser model) throws Exception {
		if(model.getId() == null){
			loginUserService.insertLoginUser(model);
		} else {
			loginUserService.updateLoginUser(model);
		}
		return "success";
	}*/
	
	@RequestMapping("/updatePwd.do")
	@ResponseBody
	public String updatePwd(LoginUser model) throws Exception {
		loginUserService.updatePwd(model);
		return "success";
	}
	@RequestMapping("/updateStatus.do")
	@ResponseBody
	public String updateStatus(@RequestParam("ids") String ids, @RequestParam("status") int status) throws Exception {
		loginUserService.updateStatus(ids, status);
		return "success";
	}
	@RequestMapping("/deleteMore.do")
	@ResponseBody
	public String delete(@RequestParam("ids") String ids) throws Exception {
		loginUserService.deleteMore(ids);
		return "success";
	}
	
	 @RequestMapping(value = "/upload.do")  
	    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {  
	  
	        String path = request.getSession().getServletContext().getRealPath("upload");  
	        String fileName = file.getOriginalFilename();  
//	        String fileName = new Date().getTime()+".jpg";  
	        System.out.println(path);  
	        File targetFile = new File(path, fileName);  
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
	  
	        //保存  
	        try {  
	            file.transferTo(targetFile);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);  
	  
	        return "result";  
	    }

	@Override
	public BaseService getService() {
		return loginUserService;
	}

	@Override
	protected String getPrefix() {
		return "/user";
	}  
	  
}
