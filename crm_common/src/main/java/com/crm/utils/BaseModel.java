package com.crm.utils;

import com.crm.utils.BaseQuery;

public class BaseModel extends BaseQuery{
	
	//数据库排序字段
	private String orderByStr = "create_date";
	
	public String getOrderByStr(){
		return orderByStr;
	}
	
	private boolean lock = false;
	
	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}

	public void setOrderByStr(String orderByStr) {
		this.orderByStr = orderByStr;
	}

}
