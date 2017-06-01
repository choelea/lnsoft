package com.whjbsoft.www.vo;

import java.util.ArrayList;
import java.util.List;

public class SjxxVo {
	private Integer sjzj;
    private String sjbh;
    private String sjmc;
    private Integer cjrzj;
    private String cjsj;
    private Integer sjzt;
    private List<KtxxVo> list = new ArrayList<KtxxVo>();
    private List<SjhpVo> sjhp = new ArrayList<SjhpVo>();

	public List<SjhpVo> getSjhp() {
		return sjhp;
	}

	public void setSjhp(List<SjhpVo> sjhp) {
		this.sjhp = sjhp;
	}

	public SjxxVo() {
	}
	
	public SjxxVo(Integer sjzj, String sjbh, String sjmc, Integer cjrzj, String cjsj, Integer sjzt) {
		super();
		this.sjzj = sjzj;
		this.sjbh = sjbh;
		this.sjmc = sjmc;
		this.cjrzj = cjrzj;
		this.cjsj = cjsj;
		this.sjzt = sjzt;
	}

	public Integer getCjrzj() {
		return cjrzj;
	}
	public void setCjrzj(Integer cjrzj) {
		this.cjrzj = cjrzj;
	}
	public String getCjsj() {
		return cjsj;
	}
	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}
	public List<KtxxVo> getList() {
		return list;
	}
	public void setList(List<KtxxVo> list) {
		this.list = list;
	}
	public String getSjbh() {
		return sjbh;
	}
	public void setSjbh(String sjbh) {
		this.sjbh = sjbh;
	}
	public String getSjmc() {
		return sjmc;
	}
	public void setSjmc(String sjmc) {
		this.sjmc = sjmc;
	}
	public Integer getSjzj() {
		return sjzj;
	}
	public void setSjzj(Integer sjzj) {
		this.sjzj = sjzj;
	}
	public Integer getSjzt() {
		return sjzt;
	}
	public void setSjzt(Integer sjzt) {
		this.sjzt = sjzt;
	}
	
}
