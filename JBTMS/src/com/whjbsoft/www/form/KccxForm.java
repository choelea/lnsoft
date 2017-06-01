package com.whjbsoft.www.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.whjbsoft.www.po.Kfxx;
import com.whjbsoft.www.po.Qwxx;
public class KccxForm extends ActionForm {
	private Kfxx kfxx = new Kfxx();
	private Qwxx qwxx = new Qwxx();
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		return null;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}
	public Kfxx getKfxx() {
		return kfxx;
	}
	public void setKfxx(Kfxx kfxx) {
		this.kfxx = kfxx;
	}
	public Qwxx getQwxx() {
		return qwxx;
	}
	public void setQwxx(Qwxx qwxx) {
		this.qwxx = qwxx;
	}
}