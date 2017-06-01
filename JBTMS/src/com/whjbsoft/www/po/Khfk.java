package com.whjbsoft.www.po;

import java.io.Serializable;

public class Khfk implements Serializable{
	private int khfkzj;
	private String fkbh;
	private Yspsd yspsd;
	private String fkr;
	private String fhr;
	private String fksj;
	private int fkzt;
	private String fkbz;
	private String zdr;
	private String sfz;
	private String mdz;
	private int ssxs;
	private int sssysz;
	public Khfk() {
	}
	
	public Khfk(int khfkzj, String fkbh, Yspsd yspsd, String fkr, String fhr, String fksj, int fkzt, String fkbz, String zdr, String sfz, String mdz, int ssxs, int sssysz) {
		super();
		this.khfkzj = khfkzj;
		this.fkbh = fkbh;
		this.yspsd = yspsd;
		this.fkr = fkr;
		this.fhr = fhr;
		this.fksj = fksj;
		this.fkzt = fkzt;
		this.fkbz = fkbz;
		this.zdr = zdr;
		this.sfz = sfz;
		this.mdz = mdz;
		this.ssxs = ssxs;
		this.sssysz = sssysz;
	}

	public String getZdr() {
		return zdr;
	}
	public void setZdr(String zdr) {
		this.zdr = zdr;
	}
	public String getFkbz() {
		return fkbz;
	}
	public void setFkbz(String fkbz) {
		this.fkbz = fkbz;
	}
	public int getFkzt() {
		return fkzt;
	}
	public void setFkzt(int fkzt) {
		this.fkzt = fkzt;
	}
	public String getFkbh() {
		return fkbh;
	}
	public void setFkbh(String fkbh) {
		this.fkbh = fkbh;
	}

	public String getFhr() {
		return fhr;
	}
	public void setFhr(String fhr) {
		this.fhr = fhr;
	}
	public String getFkr() {
		return fkr;
	}
	public void setFkr(String fkr) {
		this.fkr = fkr;
	}
	public String getFksj() {
		return fksj;
	}
	public void setFksj(String fksj) {
		this.fksj = fksj;
	}
	public int getKhfkzj() {
		return khfkzj;
	}
	public void setKhfkzj(int khfkzj) {
		this.khfkzj = khfkzj;
	}
	public int getSssysz() {
		return sssysz;
	}
	public void setSssysz(int sssysz) {
		this.sssysz = sssysz;
	}
	public int getSsxs() {
		return ssxs;
	}
	public void setSsxs(int ssxs) {
		this.ssxs = ssxs;
	}
	public Yspsd getYspsd() {
		return yspsd;
	}
	public void setYspsd(Yspsd yspsd) {
		this.yspsd = yspsd;
	}
	public String getMdz() {
		return mdz;
	}
	public void setMdz(String mdz) {
		this.mdz = mdz;
	}
	public String getSfz() {
		return sfz;
	}
	public void setSfz(String sfz) {
		this.sfz = sfz;
	}
}
