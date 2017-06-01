package com.whjbsoft.www.vo;

public class DjInfo {
	private Integer djzj;
	private Integer sjzj;
	private String sjmc;
	private String xsxh;
	private String xsxm;
	private String djsj;
	public DjInfo() {		
	}
	public DjInfo(Integer djzj,Integer sjzj, String sjmc, String xsxh, String xsxm, String djsj) {
		this.djzj = djzj;
		this.sjzj = sjzj;
		this.sjmc = sjmc;
		this.xsxh = xsxh;
		this.xsxm = xsxm;
		this.djsj = djsj;
	}
	public String getDjsj() {
		return djsj;
	}
	public void setDjsj(String djsj) {
		this.djsj = djsj;
	}
	public Integer getDjzj() {
		return djzj;
	}
	public void setDjzj(Integer djzj) {
		this.djzj = djzj;
	}
	public String getSjmc() {
		return sjmc;
	}
	public void setSjmc(String sjmc) {
		this.sjmc = sjmc;
	}
	public String getXsxm() {
		return xsxm;
	}
	public void setXsxm(String xsxm) {
		this.xsxm = xsxm;
	}
	
	/**
	 * @return the xsxh
	 */
	public String getXsxh() {
		return xsxh;
	}
	/**
	 * @param xsxh the xsxh to set
	 */
	public void setXsxh(String xsxh) {
		this.xsxh = xsxh;
	}
	public Integer getSjzj() {
		return sjzj;
	}
	public void setSjzj(Integer sjzj) {
		this.sjzj = sjzj;
	}

}
