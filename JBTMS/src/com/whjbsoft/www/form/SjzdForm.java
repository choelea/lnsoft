package com.whjbsoft.www.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import com.whjbsoft.www.po.Hpxx;
import com.whjbsoft.www.po.Sjzd;
import com.whjbsoft.www.po.Sjzdmx;

public class SjzdForm extends ActionForm {
	private Sjzd sjzd = new Sjzd();
	private Sjzdmx vo = new Sjzdmx();
	private Hpxx hpxx = new Hpxx();
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		return null;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}
	public Sjzd getSjzd() {
		return sjzd;
	}
	public void setSjzd(Sjzd sjzd) {
		this.sjzd = sjzd;
	}
	public Sjzdmx getVo() {
		return vo;
	}
	public void setVo(Sjzdmx vo) {
		this.vo = vo;
	}
	public Hpxx getHpxx() {
		return hpxx;
	}
	public void setHpxx(Hpxx hpxx) {
		this.hpxx = hpxx;
	}	
}