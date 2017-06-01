package com.whjbsoft.www.form;

import org.apache.struts.action.ActionForm;

import com.whjbsoft.www.po.Khth;
import com.whjbsoft.www.po.Yspsd;

public class KhthForm extends ActionForm{
	private Khth vo = new Khth();
	private Yspsd yspsd = new Yspsd();
	private String fieldName;
	private String fieldValue;
	public KhthForm() {
	}
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
	public Khth getVo() {
		return vo;
	}
	public void setVo(Khth vo) {
		this.vo = vo;
	}
	public Yspsd getYspsd() {
		return yspsd;
	}
	public void setYspsd(Yspsd yspsd) {
		this.yspsd = yspsd;
	}
}
