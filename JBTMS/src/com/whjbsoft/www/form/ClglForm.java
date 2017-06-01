package com.whjbsoft.www.form;

import org.apache.struts.action.ActionForm;

import com.whjbsoft.www.po.Ylxx;

public class ClglForm extends ActionForm {
	private Ylxx vo = new Ylxx();
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
	public Ylxx getVo() {
		return vo;
	}
	public void setVo(Ylxx vo) {
		this.vo = vo;
	}
}
