package com.whjbsoft.www.vo;

import com.whjbsoft.www.po.Bjxx;

public class XsxxLogin {
	private Integer xszj;//学生主键
    private Bjxx bjxx;//所在班级
    private String xsxh;//学生学号
    private String xsxm;//学生姓名
    private String xsmm;//学生登陆密码
    private Integer yxbj;//学生有效标记
    private String bzxx;//学生备注信息
    private Integer sfdl;//学生登陆状态
    private String zhdlsj;//最后登陆时间
    private Integer syszzj;//试验设置主键
    private Integer Djxxzj;//答卷信息主键
    private Integer Sjxxzj;//答卷信息主键
    private Boolean loginState;//登陆状态（成功与否）
    private String returnValue;//登陆返回信息
    private String zhsyrwmc;//最后任务名称
    
	public XsxxLogin() {		
	}
	public Bjxx getBjxx() {
		return bjxx;
	}
	public void setBjxx(Bjxx bjxx) {
		this.bjxx = bjxx;
	}
	public String getBzxx() {
		return bzxx;
	}
	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
	}
	public Boolean getLoginState() {
		return loginState;
	}
	public void setLoginState(Boolean loginState) {
		this.loginState = loginState;
	}
	public String getReturnValue() {
		return returnValue;
	}
	public void setReturnValue(String returnValue) {
		this.returnValue = returnValue;
	}
	public Integer getSfdl() {
		return sfdl;
	}
	public void setSfdl(Integer sfdl) {
		this.sfdl = sfdl;
	}
	public String getXsmm() {
		return xsmm;
	}
	public void setXsmm(String xsmm) {
		this.xsmm = xsmm;
	}
	public String getXsxh() {
		return xsxh;
	}
	public void setXsxh(String xsxh) {
		this.xsxh = xsxh;
	}
	public String getXsxm() {
		return xsxm;
	}
	public void setXsxm(String xsxm) {
		this.xsxm = xsxm;
	}
	public Integer getXszj() {
		return xszj;
	}
	public void setXszj(Integer xszj) {
		this.xszj = xszj;
	}
	public Integer getYxbj() {
		return yxbj;
	}
	public void setYxbj(Integer yxbj) {
		this.yxbj = yxbj;
	}
	public Integer getSyszzj() {
		return syszzj;
	}
	public void setSyszzj(Integer syszzj) {
		this.syszzj = syszzj;
	}
	public Integer getDjxxzj() {
		return Djxxzj;
	}
	public void setDjxxzj(Integer djxxzj) {
		Djxxzj = djxxzj;
	}
	public String getZhdlsj() {
		return zhdlsj;
	}
	public void setZhdlsj(String zhdlsj) {
		this.zhdlsj = zhdlsj;
	}
	public Integer getSjxxzj() {
		return Sjxxzj;
	}
	public void setSjxxzj(Integer sjxxzj) {
		Sjxxzj = sjxxzj;
	}
	public String getZhsyrwmc() {
		return zhsyrwmc;
	}
	public void setZhsyrwmc(String zhsyrwmc) {
		this.zhsyrwmc = zhsyrwmc;
	}
	
}
