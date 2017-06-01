
package com.whjbsoft.www.exam.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.whjbsoft.www.exam.po.Kssz;
import com.whjbsoft.www.exam.po.Sjxxs;
import com.whjbsoft.www.po.Bjxx;

public class KsszForm extends ActionForm {
	private Kssz vo = new Kssz();
	private Bjxx bjxx = new Bjxx();
	private Sjxxs sjxx = new Sjxxs();
	private String fieldName;
	private String fieldValue;
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		return null;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}
	public Bjxx getBjxx() {
		return bjxx;
	}
	public void setBjxx(Bjxx bjxx) {
		this.bjxx = bjxx;
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
	public Sjxxs getSjxx() {
		return sjxx;
	}
	public void setSjxx(Sjxxs sjxx) {
		this.sjxx = sjxx;
	}
	public Kssz getVo() {
		return vo;
	}
	public void setVo(Kssz vo) {
		this.vo = vo;
	}
}