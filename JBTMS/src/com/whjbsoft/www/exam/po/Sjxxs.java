package com.whjbsoft.www.exam.po;

import java.util.HashSet;
import java.util.Set;

public class Sjxxs implements java.io.Serializable {

	// Fields    

	private Integer sjzj;
	private String sjbh;
	private String sjmc;
	private Integer kssc;
	private String sjnyd;
	private Integer sjzt;
	private String cjsj;
	private String cjr;
	private Set ksszs = new HashSet(0);
	private Set sjtxes = new HashSet(0);
	private Set djxxess = new HashSet(0);

	// Constructors

	/** default constructor */
	public Sjxxs() {
	}

	/** full constructor */
	public Sjxxs(String sjbh, String sjmc, Integer kssc, String sjnyd,
			Integer sjzt, String cjsj, String cjr, Set ksszs, Set sjtxes,
			Set djxxess) {
		this.sjbh = sjbh;
		this.sjmc = sjmc;
		this.kssc = kssc;
		this.sjnyd = sjnyd;
		this.sjzt = sjzt;
		this.cjsj = cjsj;
		this.cjr = cjr;
		this.ksszs = ksszs;
		this.sjtxes = sjtxes;
		this.djxxess = djxxess;
	}


	public Integer getSjzj() {
		return this.sjzj;
	}

	public void setSjzj(Integer sjzj) {
		this.sjzj = sjzj;
	}

	public String getSjbh() {
		return this.sjbh;
	}

	public void setSjbh(String sjbh) {
		this.sjbh = sjbh;
	}

	public String getSjmc() {
		return this.sjmc;
	}

	public void setSjmc(String sjmc) {
		this.sjmc = sjmc;
	}

	public Integer getKssc() {
		return this.kssc;
	}

	public void setKssc(Integer kssc) {
		this.kssc = kssc;
	}

	public String getSjnyd() {
		return this.sjnyd;
	}

	public void setSjnyd(String sjnyd) {
		this.sjnyd = sjnyd;
	}

	public Integer getSjzt() {
		return this.sjzt;
	}

	public void setSjzt(Integer sjzt) {
		this.sjzt = sjzt;
	}

	public String getCjsj() {
		return this.cjsj;
	}

	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}

	public String getCjr() {
		return this.cjr;
	}

	public void setCjr(String cjr) {
		this.cjr = cjr;
	}

	public Set getKsszs() {
		return this.ksszs;
	}

	public void setKsszs(Set ksszs) {
		this.ksszs = ksszs;
	}

	public Set getSjtxes() {
		return this.sjtxes;
	}

	public void setSjtxes(Set sjtxes) {
		this.sjtxes = sjtxes;
	}

	public Set getDjxxess() {
		return this.djxxess;
	}

	public void setDjxxess(Set djxxess) {
		this.djxxess = djxxess;
	}

}