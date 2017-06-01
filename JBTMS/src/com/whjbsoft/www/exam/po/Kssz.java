package com.whjbsoft.www.exam.po;

import com.whjbsoft.www.po.Bjxx;

public class Kssz implements java.io.Serializable {
	// Fields

	private Integer ksszzj;
	private Sjxxs sjxx;
	private Bjxx bjxx;
	private Integer ksszzt;

	// Constructors

	/** default constructor */
	public Kssz() {
	}

	public Kssz(Sjxxs sjxx, Bjxx bjxx, Integer ksszzt) {
		this.sjxx = sjxx;
		this.bjxx = bjxx;
		this.ksszzt = ksszzt;
	}

	public Integer getKsszzj() {
		return this.ksszzj;
	}

	public void setKsszzj(Integer ksszzj) {
		this.ksszzj = ksszzj;
	}

	public Sjxxs getSjxx() {
		return sjxx;
	}

	public void setSjxx(Sjxxs sjxx) {
		this.sjxx = sjxx;
	}

	public Bjxx getBjxx() {
		return bjxx;
	}

	public void setBjxx(Bjxx bjxx) {
		this.bjxx = bjxx;
	}

	public Integer getKsszzt() {
		return ksszzt;
	}

	public void setKsszzt(Integer ksszzt) {
		this.ksszzt = ksszzt;
	}

}