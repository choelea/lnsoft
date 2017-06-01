package com.whjbsoft.www.service;

import com.whjbsoft.www.form.LoginForm;
import com.whjbsoft.www.po.Jsgl;
import com.whjbsoft.www.po.Xsxx;
import com.whjbsoft.www.vo.XsxxLogin;

public interface LoginService {
	Jsgl getJsgl(String username,String paw,int type);
	Xsxx getXsxx(String username,String paw);
	
	/**
	 * 学生登陆信息验证
	 * @param loginForm
	 * 	登陆信息Form
	 * @return
	 */
	public Xsxx stuLogin(LoginForm loginForm);
}
