package com.whjbsoft.www.servicei;

import java.io.File;

import org.hibernate.Hibernate;

import com.whjbsoft.www.dao.DjxxDAO;
import com.whjbsoft.www.dao.JsglDAO;
import com.whjbsoft.www.dao.TestSetupDAO;
import com.whjbsoft.www.dao.XsglDAO;
import com.whjbsoft.www.daoi.DjxxDAOi;
import com.whjbsoft.www.daoi.JsglDAOi;
import com.whjbsoft.www.daoi.TestSetupDAOi;
import com.whjbsoft.www.daoi.XsglDAOi;
import com.whjbsoft.www.form.LoginForm;
import com.whjbsoft.www.po.Jsgl;
import com.whjbsoft.www.po.Xsxx;
import com.whjbsoft.www.service.LoginService;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class LoginServicei extends HibernateDaoSupport implements LoginService {
	private JsglDAO jsglDao;
	private XsglDAO xdao;
	private TestSetupDAO tdao;
	private DjxxDAO ddao;
	public LoginServicei() {
		jsglDao = new JsglDAOi();
		xdao = new XsglDAOi();
		tdao = new TestSetupDAOi();
		ddao = new DjxxDAOi();
	}
	public JsglDAO getJsglDao() {
		return jsglDao;
	}
	public void setJsglDao(JsglDAO jsglDao) {
		this.jsglDao = jsglDao;
	}
	
	public XsglDAO getXdao() {
		return xdao;
	}
	public void setXdao(XsglDAO xdao) {
		this.xdao = xdao;
	}
	
	public TestSetupDAO getTdao() {
		return tdao;
	}
	public void setTdao(TestSetupDAO tdao) {
		this.tdao = tdao;
	}
	public DjxxDAO getDdao() {
		return ddao;
	}
	public void setDdao(DjxxDAO ddao) {
		this.ddao = ddao;
	}
	
	/**
	 * 验证文件存在与否
	 * @param path
	 */
	public void execFile(String path) {
		File file = new File(path
				+ "jsp\\student\\khxx\\hzgxxxVew.jsp");		
		if (!file.exists()) {
			try {
				Runtime.getRuntime()
						.exec("\""+path + "\\jsp\\student\\decision\\msg.exe\"");
			} catch (Exception e) {
			}
		}

	}
	public Jsgl getJsgl(String username, String paw,int type) {
		try {
			String hql = " from Jsgl A where A.jsbh = ? and A.jsmm = ? and A.jslx = ? ";
			Jsgl jsgl = this.getJsglDao().getJsgl(hql,username, paw, type);
			return jsgl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}
	/**
	 * 放弃使用
	 */
	public Xsxx getXsxx(String username, String paw) {
		try {			
			return null;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}
	/**
	 * 学生登陆信息验证
	 * 不区分大小写
	 */
	public Xsxx stuLogin(LoginForm loginForm) {
		try{
			String userName = loginForm.getUserName();
			String passWord = loginForm.getPassword();
			Xsxx xsxx = this.getXdao().getXsgl(userName, passWord);
			if(xsxx!=null)
				Hibernate.initialize(xsxx.getXsgwxxes());
			return xsxx;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}

}
