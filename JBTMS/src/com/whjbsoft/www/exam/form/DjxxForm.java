
package com.whjbsoft.www.exam.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.whjbsoft.www.exam.po.Djxxs;
import com.whjbsoft.www.exam.po.Sjxxs;
import com.whjbsoft.www.exam.vo.SjktVo;
import com.whjbsoft.www.po.Xsxx;
import com.whjbsoft.www.util.ListBean;

public class DjxxForm extends ActionForm {
	private Djxxs vo = new Djxxs();
	private Xsxx xsxx = new Xsxx();
	private Sjxxs sjxx = new Sjxxs();
	private List<SjktVo> list = new ListBean<SjktVo>(SjktVo.class);
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		return null;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}
	public List<SjktVo> getList() {
		return list;
	}
	public void setList(List<SjktVo> list) {
		this.list = list;
	}
	public Sjxxs getSjxx() {
		return sjxx;
	}
	public void setSjxx(Sjxxs sjxx) {
		this.sjxx = sjxx;
	}
	public Djxxs getVo() {
		return vo;
	}
	public void setVo(Djxxs vo) {
		this.vo = vo;
	}
	public Xsxx getXsxx() {
		return xsxx;
	}
	public void setXsxx(Xsxx xsxx) {
		this.xsxx = xsxx;
	}
}