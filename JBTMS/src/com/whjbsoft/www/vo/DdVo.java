package com.whjbsoft.www.vo;

import java.util.ArrayList;
import java.util.List;

import com.whjbsoft.www.po.Crkdd;

public class DdVo {
	private Crkdd crkdd  = new Crkdd();
	private List ygList = new ArrayList();
	private List sbList = new ArrayList(); 
	/**
	 * @return the ygList
	 */
	public List getYgList() {
		return ygList;
	}
	/**
	 * @param ygList the ygList to set
	 */
	public void setYgList(List ygList) {
		this.ygList = ygList;
	}
	/**
	 * @return the crkdd
	 */
	public Crkdd getCrkdd() {
		return crkdd;
	}
	/**
	 * @param crkdd the crkdd to set
	 */
	public void setCrkdd(Crkdd crkdd) {
		this.crkdd = crkdd;
	}
	/**
	 * @return the sbList
	 */
	public List getSbList() {
		return sbList;
	}
	/**
	 * @param sbList the sbList to set
	 */
	public void setSbList(List sbList) {
		this.sbList = sbList;
	}
}
