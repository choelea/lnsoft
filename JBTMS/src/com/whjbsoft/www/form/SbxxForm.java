package com.whjbsoft.www.form;

import org.apache.struts.action.ActionForm;

import com.whjbsoft.www.po.Sbxx;

public class SbxxForm extends ActionForm{
	private Sbxx vo = new Sbxx();
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
	public Sbxx getVo() {
		return vo;
	}
	public void setVo(Sbxx vo) {
		this.vo = vo;
	}
}