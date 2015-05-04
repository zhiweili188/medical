/**
 * Copyright (c) @2015-4-30. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.szreach.medical.auth.st.ReturnCode;
import com.szreach.medical.common.base.AbstractBaseServiceImpl;
import com.szreach.medical.common.base.BaseDao;
import com.szreach.medical.course.bean.CourseSubject;
import com.szreach.medical.course.dao.CourseSubjectDao;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-4-30
 * @Version: 1.0
 */
@Service("courseSubjectService")
@Scope("prototype")
@Transactional
public class CourseSubjectServiceImpl extends AbstractBaseServiceImpl<CourseSubject> implements CourseSubjectService {
	
	@Autowired
	private CourseSubjectDao courseSubjectDao;
	
	@Override
	public BaseDao<CourseSubject> getBaseDao() {
		return courseSubjectDao;
	}
	
	public int validate(CourseSubject entity) {
		int result = ReturnCode.SUCCESS;
		if(entity.getId() == null) {
			CourseSubject subject = courseSubjectDao.getByName(entity.getSubjectName());
			if(subject != null) {
				result = ReturnCode.COURSE_SUBJECT_NAME_EXISTS_ERROR;
			}
		} else {
			CourseSubject oldSubject =courseSubjectDao.get(entity.getId());
			if(  !oldSubject.getSubjectName().equals(entity.getSubjectName().trim())) {
				CourseSubject subject = courseSubjectDao.getByName(entity.getSubjectName());
				if(subject != null) {
					result = ReturnCode.COURSE_SUBJECT_NAME_EXISTS_ERROR;
				}
			}
		}
	
		
		return result;
	}

	@Override
	public void insert(CourseSubject subject) {
		//生成编码，用于树查询
		String code = this.createCode(subject);
		subject.setSubjectCode(code);
		subject.setTreeLevel(code.length()/2);
		
		courseSubjectDao.insert(subject);
	}

	@Override
	public void update(CourseSubject model) {
		courseSubjectDao.update(model);
	}



	public List<CourseSubject> queryTree() {
		List<CourseSubject> list = courseSubjectDao.queryTree();
		if(list == null || list.size()==0) return null;
		
		List<CourseSubject> treeList = new ArrayList<CourseSubject>();
		
		return treeList;
		
	}
	
	/**
	 * 生成编码，第一级是00-99，第二级是0000-9999，最多5级，已经足够多了
	 * @param subject
	 * @param con
	 * @return
	 */
	private String createCode(CourseSubject subject) {
		String code = null;
		//如果没有选上级学科，把该学科当作是第一级学科
		//code从00--99中选择最小的，并且没有被占用的
		if(subject.getParentId() == null || subject.getParentId() == -1) {
			
			CourseSubject subjectQuery = new CourseSubject();
			subjectQuery.setTreeLevel(1);
			
			 List<CourseSubject> list = courseSubjectDao.query(subjectQuery, null);
			 if(list ==null || list.size()==0) {
				 code = "00";//第一个添加的学科
			 } else {
				 int tmpCode =Integer.parseInt( list.get(0).getSubjectCode());
				 int nextCode = 0;;
				 for(int i=1; i<list.size(); i++) {
					 nextCode = Integer.parseInt(list.get(i).getSubjectCode());
					 if( nextCode > tmpCode) {
						 tmpCode = nextCode;
					 }
				 }
				 tmpCode++;
				 
				 if(tmpCode < 10) {
					 code = "0"+tmpCode;
				 } else {
					 code = ""+tmpCode;
				 }
			 }
		} else {
			//如果选择了上级学科，则code是上级学科的code+从00--99中选择最小的，并且没有被占用的
			//先查询上级学科
			
			CourseSubject parentSubject = courseSubjectDao.get(subject.getParentId());
			if(parentSubject != null) {
				CourseSubject subjectQuery = new CourseSubject();
				subjectQuery.setParentId(parentSubject.getId());
				subjectQuery.setTreeLevel(parentSubject.getTreeLevel() + 1);//查询同一级的学科
				
				 List<CourseSubject> list = courseSubjectDao.query(subjectQuery, null);
				 if(list ==null || list.size()==0) {
					 code = parentSubject.getSubjectCode();//该上级学科下面的第一个添加的学科
					// for(int i=0; i<parentSubject.getTreeLevel(); i++) {
						 code += "00";
					// }
				 } else {
					 int codeLength = parentSubject.getTreeLevel() * 2;
					 int tmpCode =Integer.parseInt( list.get(0).getSubjectCode());
					 int nextCode = 0;;
					 boolean found = false;
					 int i=0;
					 for(int k=0; k<100; k++) {
						 for(i=0; i<list.size(); i++) {
							 nextCode = Integer.parseInt(list.get(i).getSubjectCode().substring(codeLength));
							 if( k == nextCode) {//k已经被用了
								 if( nextCode > tmpCode) {
									 tmpCode = nextCode;
								 }
								break;
							 }
							 if(i == list.size()-1) {
								 found = true;
								 break;
							 }
						 }
						 
						 if(found) {
							 tmpCode = k;
							 break;
						 }
					 }
					 
					 if(found) {
						 code = parentSubject.getSubjectCode();
					 }
					
					 if(tmpCode < 10) {
						 code += "0"+tmpCode;
					 } else {
						 code += ""+tmpCode;
					 }
				 }
			}
		}
		
		return code;
	}
}
