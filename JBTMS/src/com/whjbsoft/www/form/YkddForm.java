package com.whjbsoft.www.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.whjbsoft.www.po.Ykdd;
import com.whjbsoft.www.util.ListBean;
import com.whjbsoft.www.vo.YkmxVo;
public class YkddForm extends ActionForm {
	private Ykdd vo = new Ykdd();
	private String fieldName;
	private String fieldValue;
	private List<YkmxVo> list = new ListBean<YkmxVo>(YkmxVo.class);
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
	public List<YkmxVo> getList() {
		return list;
	}
	public void setList(List<YkmxVo> list) {
		this.list = list;
	}
	public Ykdd getVo() {
		return vo;
	}
	public void setVo(Ykdd vo) {
		this.vo = vo;
	}
}