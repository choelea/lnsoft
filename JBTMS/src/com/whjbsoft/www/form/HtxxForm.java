package com.whjbsoft.www.form;

import org.apache.struts.action.ActionForm;

import com.whjbsoft.www.po.Khdd;
import com.whjbsoft.www.po.Khht;

public class HtxxForm extends ActionForm{
	private Khht vo = new Khht();
	private Khdd khdd = new Khdd();
	private String fieldName;
	private String fieldValue;
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	public Khht getVo() {
		return vo;
	}
	public void setVo(Khht vo) {
		this.vo = vo;
	}
	public Khdd getKhdd() {
		return khdd;
	}
	public void setKhdd(Khdd khdd) {
		this.khdd = khdd;
	}
}
