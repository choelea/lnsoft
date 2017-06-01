package com.whjbsoft.www.form;

import org.apache.struts.action.ActionForm;

import com.whjbsoft.www.po.Bxxx;

public class BxglForm extends ActionForm{
	private Bxxx vo = new Bxxx();
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
	public Bxxx getVo() {
		return vo;
	}
	public void setVo(Bxxx vo) {
		this.vo = vo;
	}
}
