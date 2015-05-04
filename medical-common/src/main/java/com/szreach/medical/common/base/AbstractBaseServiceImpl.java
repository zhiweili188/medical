/**
 * Copyright (c) @2015-2-5. All Rights Reserved.
 * AUTHOR: LIZHIWEI</a>
 */
package com.szreach.medical.common.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author lizhiwei
 * @Date: 2015-2-5
 * @Version: 1.0
 */
public abstract class AbstractBaseServiceImpl<T extends Persistentable> implements BaseService<T> {

	public  BaseDao<T> getBaseDao() {
		// TODO sub class need to override this method
		return null;
	}
	
	@Override
	public void insert(T t) {
		getBaseDao().insert(t);
		
	}

	@Override
	public T getByID(Integer id) {
		return getBaseDao().get(id);
	}

	@Override
	public void update(T t) {
		getBaseDao().update(t);
		
	}

	@Override
	public int count(T query) {
		return getBaseDao().countAll(query);
	}

	@Override
	public List<T> query(T query, PageBean page) {
		if(page != null) {
			
			int total = getBaseDao().countAll(query);
			page.setTotal(total);
		}
		List<T> list = getBaseDao().query(query, page);
		return list;
	}

	@Override
	public List<T> getAll(T query) {
		return getBaseDao().query(query);
	}

	@Override
	public void delete(Integer id) {
		getBaseDao().delete(id);
		
	}
	
	public void deleteMore(String toDeleteIds){
		String[] ids = toDeleteIds.split(",");
		if(ids.length == 1) {
			getBaseDao().delete(Integer.valueOf(ids[0]));
		} else {
			List<Integer> list = new ArrayList<Integer>(ids.length);
			for(String id : ids) {
				list.add(Integer.valueOf(id));
			}
			getBaseDao().batchDel(list);
		}
	}
	
	public void updateStatus(String tids, int status){
		String[] ids = tids.split(",");
		if(ids.length == 1) {
			getBaseDao().updateStatus(Integer.valueOf(ids[0]), status);
		} else {
			List<Integer> list = new ArrayList<Integer>(ids.length);
			for(String id : ids) {
				list.add(Integer.valueOf(id));
			}
			getBaseDao().batchUpdateStatus(list, status);
		}
	}

	public int validate(T t) {
		return 1;
	}
}
