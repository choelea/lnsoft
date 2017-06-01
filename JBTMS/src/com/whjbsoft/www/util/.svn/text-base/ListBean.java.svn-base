package com.whjbsoft.www.util;

import java.util.ArrayList;

public class ListBean<T> extends ArrayList{
	private Class proClass;
	public ListBean(Class proClass){
		this.setProClass(proClass);
	}
	public Object get(int index){
		try {
			while(index>=size()){
				add(this.getProClass().newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.get(index);
	}
	public Class getProClass() {
		return proClass;
	}
	public void setProClass(Class proClass) {
		this.proClass = proClass;
	}
}
