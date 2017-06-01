/**
 * 
 */
package com.whjbsoft.www.form;

import org.apache.struts.action.ActionForm;

import com.whjbsoft.www.po.Bjxx;

/**
 * @author whjb
 * @Date 2009-9-25 ионГ09:54:06
 */
public class ClassForm extends ActionForm {

	private Bjxx vo = new Bjxx();

	/**
	 * @return the vo
	 */
	public Bjxx getVo() {
		return vo;
	}

	/**
	 * @param vo the vo to set
	 */
	public void setVo(Bjxx vo) {
		this.vo = vo;
	}
}
