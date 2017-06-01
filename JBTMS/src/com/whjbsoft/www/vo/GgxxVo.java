package com.whjbsoft.www.vo;


public class GgxxVo {
	private Integer ggzj;
    private Integer bjxx;
    private String ggbt;
    private String ggzz;
    private String ggnr;
    private String fbsj;
	public GgxxVo() {
	}
	public GgxxVo(Integer ggzj, Integer bjxx, String ggbt, String ggzz, String ggnr, String fbsj) {
		super();
		this.ggzj = ggzj;
		this.bjxx = bjxx;
		this.ggbt = ggbt;
		this.ggzz = ggzz;
		this.ggnr = ggnr;
		this.fbsj = fbsj;
	}
	public Integer getBjxx() {
		return bjxx;
	}
	public void setBjxx(Integer bjxx) {
		this.bjxx = bjxx;
	}
	public String getFbsj() {
		return fbsj;
	}
	public void setFbsj(String fbsj) {
		this.fbsj = fbsj;
	}
	public String getGgbt() {
		return ggbt;
	}
	public void setGgbt(String ggbt) {
		this.ggbt = ggbt;
	}
	public String getGgnr() {
		return ggnr;
	}
	public void setGgnr(String ggnr) {
		this.ggnr = ggnr;
	}
	public Integer getGgzj() {
		return ggzj;
	}
	public void setGgzj(Integer ggzj) {
		this.ggzj = ggzj;
	}
	public String getGgzz() {
		return ggzz;
	}
	public void setGgzz(String ggzz) {
		this.ggzz = ggzz;
	}
	
}
