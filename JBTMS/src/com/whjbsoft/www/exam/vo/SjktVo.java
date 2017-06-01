package com.whjbsoft.www.exam.vo;

import com.whjbsoft.www.exam.po.Stgls;

public class SjktVo {
	private Stgls stgl = new Stgls();
	private String stda;
    private Integer dtdf;
	public SjktVo() {
		
	}
	public Stgls getStgl() {
		return stgl;
	}
	public void setStgl(Stgls stgl) {
		this.stgl = stgl;
	}
	public Integer getDtdf() {
		return dtdf;
	}
	public void setDtdf(Integer dtdf) {
		this.dtdf = dtdf;
	}
	public String getStda() {
		return stda;
	}
	public void setStda(String stda) {
		this.stda = stda;
	}

}
