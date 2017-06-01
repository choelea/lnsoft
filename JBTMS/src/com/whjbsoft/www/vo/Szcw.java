package com.whjbsoft.www.vo;

public class Szcw {
	private String crkhpzj;
	private String[] cwzj;
	private String[] hgsl;
	private String[] shsl;
	
	
	
	/**
	 * 
	 */
	public Szcw() {
		super();
	}
	
	
	/**
	 * @param cwzj
	 * @param hgsl
	 * @param shsl
	 */
	public Szcw(String crkhpzj,String[] cwzj, String[] hgsl, String[] shsl) {
		super();
		this.crkhpzj = crkhpzj;
		this.cwzj = cwzj;
		this.hgsl = hgsl;
		this.shsl = shsl;
	}


	/**
	 * @return the cwzj
	 */
	public String[] getCwzj() {
		return cwzj;
	}
	/**
	 * @param cwzj the cwzj to set
	 */
	public void setCwzj(String[] cwzj) {
		this.cwzj = cwzj;
	}
	/**
	 * @return the hgsl
	 */
	public String[] getHgsl() {
		return hgsl;
	}
	/**
	 * @param hgsl the hgsl to set
	 */
	public void setHgsl(String[] hgsl) {
		this.hgsl = hgsl;
	}
	/**
	 * @return the shsl
	 */
	public String[] getShsl() {
		return shsl;
	}
	/**
	 * @param shsl the shsl to set
	 */
	public void setShsl(String[] shsl) {
		this.shsl = shsl;
	}


	/**
	 * @return the crkhpzj
	 */
	public String getCrkhpzj() {
		return crkhpzj;
	}


	/**
	 * @param crkhpzj the crkhpzj to set
	 */
	public void setCrkhpzj(String crkhpzj) {
		this.crkhpzj = crkhpzj;
	}
}
