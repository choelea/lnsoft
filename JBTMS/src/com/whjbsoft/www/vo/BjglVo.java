package com.whjbsoft.www.vo;

public class BjglVo {
	private Integer bjzj;
    private String bjbh;
    private String bjmc;
    private Integer jszj;
    private String jsmc;
    
	/**
	 * @param bjzj
	 * @param bjbh
	 * @param bjmc
	 * @param jszj
	 * @param jsmc
	 */
	public BjglVo(Integer bjzj, String bjbh, String bjmc, Integer jszj, String jsmc) {
		super();
		this.bjzj = bjzj;
		this.bjbh = bjbh;
		this.bjmc = bjmc;
		this.jszj = jszj;
		this.jsmc = jsmc;
	}
	
	public BjglVo(Integer bjzj, String bjbh, String bjmc) {
		super();
		this.bjzj = bjzj;
		this.bjbh = bjbh;
		this.bjmc = bjmc;
	}

	/**
	 * @return the bjbh
	 */
	public String getBjbh() {
		return bjbh;
	}
	/**
	 * @param bjbh the bjbh to set
	 */
	public void setBjbh(String bjbh) {
		this.bjbh = bjbh;
	}
	/**
	 * @return the bjmc
	 */
	public String getBjmc() {
		return bjmc;
	}
	/**
	 * @param bjmc the bjmc to set
	 */
	public void setBjmc(String bjmc) {
		this.bjmc = bjmc;
	}
	/**
	 * @return the bjzj
	 */
	public Integer getBjzj() {
		return bjzj;
	}
	/**
	 * @param bjzj the bjzj to set
	 */
	public void setBjzj(Integer bjzj) {
		this.bjzj = bjzj;
	}
	/**
	 * @return the jsmc
	 */
	public String getJsmc() {
		return jsmc;
	}
	/**
	 * @param jsmc the jsmc to set
	 */
	public void setJsmc(String jsmc) {
		this.jsmc = jsmc;
	}
	/**
	 * @return the jszj
	 */
	public Integer getJszj() {
		return jszj;
	}
	/**
	 * @param jszj the jszj to set
	 */
	public void setJszj(Integer jszj) {
		this.jszj = jszj;
	}
}
