package com.whjbsoft.www.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.whjbsoft.www.po.Bmxx;
public class BmxxForm extends ActionForm {
	private Bmxx vo = new Bmxx();
	private String fieldName;
	private String fieldValue;
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		return null;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
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
	public Bmxx getVo() {
		return vo;
	}
	public void setVo(Bmxx vo) {
		this.vo = vo;
	}
}