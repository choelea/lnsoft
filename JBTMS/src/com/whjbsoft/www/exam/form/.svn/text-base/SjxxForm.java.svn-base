package com.whjbsoft.www.exam.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.whjbsoft.www.exam.po.Sjtxs;
import com.whjbsoft.www.exam.po.Sjxxs;
import com.whjbsoft.www.exam.po.Stgls;
import com.whjbsoft.www.util.ListBean;
public class SjxxForm extends ActionForm {
	private Sjxxs vo = new Sjxxs();
	private List<Sjtxs> txlist = new ListBean<Sjtxs>(Sjtxs.class);
	private List<Stgls> ktlist = new ListBean<Stgls>(Stgls.class);
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

	public Sjxxs getVo() {
		return vo;
	}

	public void setVo(Sjxxs vo) {
		this.vo = vo;
	}

	public List<Stgls> getKtlist() {
		return ktlist;
	}

	public void setKtlist(List<Stgls> ktlist) {
		this.ktlist = ktlist;
	}

	public List<Sjtxs> getTxlist() {
		return txlist;
	}

	public void setTxlist(List<Sjtxs> txlist) {
		this.txlist = txlist;
	}
}