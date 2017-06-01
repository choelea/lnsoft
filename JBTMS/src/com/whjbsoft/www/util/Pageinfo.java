package com.whjbsoft.www.util;

import java.util.List;

public class Pageinfo{
	
    private int curpage=1;
    private int allpage;
    private int allrecord;
    private int pagerecord;
    
    private int nextpage;
    private int previouspage;
    
    private List pagedata;
    
	public Pageinfo()
	{
	}
	public Pageinfo(int allrecord,int pagerecord,List pagedata)
	{
	   this.allrecord=allrecord;
	   this.pagerecord=pagerecord;
	   this.pagedata=pagedata;	   
	   this.allpage=allrecord%pagerecord==0?allrecord/pagerecord:(allrecord/pagerecord)+1;	   
	}

	public int getAllpage() {
		if(allpage<=0){
			this.setAllpage(1);
		}
		return allpage;
	}

	public void setAllpage(int allpage) {
		this.allpage = allpage;
	}

	public int getAllrecord() {
		return allrecord;
	}

	public void setAllrecord(int allrecord) {
		this.allrecord = allrecord;
	}

	public int getCurpage() {
		return curpage;
	}

	public void setCurpage(int curpage) {
		if(curpage<=0){
			curpage=1;
		}else if(curpage>this.getAllpage()){
			curpage=this.allpage;
		}
		this.curpage = curpage;
	}

	public int getNextpage() {
		this.setNextpage(curpage+1);
		return nextpage;
	}

	public void setNextpage(int nextpage) {
		if(nextpage>getAllpage()){
			nextpage=allpage;
		}
		this.nextpage = nextpage;
	}

	public List getPagedata() {
		return pagedata;
	}

	public void setPagedata(List pagedata) {
		this.pagedata = pagedata;
	}

	public int getPagerecord() {
		return pagerecord;
	}

	public void setPagerecord(int pagerecord) {
		this.pagerecord = pagerecord;
	}

	public int getPreviouspage() {
		this.setPreviouspage(curpage-1);
		return previouspage;
	}

	public void setPreviouspage(int previouspage) {
		if(previouspage<=0){
			previouspage=1;
		}
		this.previouspage = previouspage;
	}
    
}
