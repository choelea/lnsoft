
package com.whjbsoft.www.action;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.LoginForm;
import com.whjbsoft.www.po.Jsgl;
import com.whjbsoft.www.po.Xsgwxx;
import com.whjbsoft.www.po.Xsxx;
import com.whjbsoft.www.service.LoginService;
import com.whjbsoft.www.servicei.LoginServicei;
import com.whjbsoft.www.util.CheckDate;

public class LoginAction extends DispatchAction {
	private LoginService service;

	public LoginService getService() {
		return service;
	}

	public void setService(LoginService service) {
		this.service = service;
	}

	public LoginAction() {
		service = new LoginServicei();
	}

	/**
	 * ������
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LoginForm loginForm = (LoginForm) form;
		try {
			//String miCode   =   request.getSession().getServletContext().getRealPath( "")+ "/WEB-INF/miCode.txt ";
			// String jiaFlie   =   request.getSession().getServletContext().getRealPath( "")+ "/WEB-INF/jiaFlie.txt ";
			//boolean flag=CheckDate.checkTime(miCode,jiaFlie);
			boolean flag=true;
			if(flag){
			Class c = this.getClass();
			Method m = c.getDeclaredMethod(loginForm.getLoginType(),
					ActionMapping.class, ActionForm.class,
					HttpServletRequest.class, HttpServletResponse.class);
			return (ActionForward) m.invoke(this, mapping, form, request,response);
			}else{
				request.setAttribute("msg", "�Բ�������ϵͳ�ѹ��ڣ��빺�����ʹ�ã�лл!");
				return mapping.findForward("error");
			}
			} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("error");
		}
	}

	/**
	 * ����Ա��½
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward adminLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			LoginForm loginForm = (LoginForm) form;
			String username = loginForm.getUserName();
			String userpaw = loginForm.getPassword();
			Jsgl jsgl = this.getService().getJsgl(username, userpaw, 0);
			if (jsgl != null) {
				if (username.equals(jsgl.getJsbh())
						&& userpaw.equals(jsgl.getJsmm())) {
					request.getSession().setAttribute("userPk", jsgl.getJxzj());
					request.getSession().setAttribute("userName",
							jsgl.getJsbh());
					request.getSession().setAttribute("userType",
							jsgl.getJslx());
					request.getSession().setAttribute("userTName",
							jsgl.getJsmc());
					return mapping.findForward("success2");
				} else {
					request.setAttribute("msg", "�û�����������������!");
					return mapping.findForward("error");
				}
			} else {
				request.setAttribute("msg", "�û�����������������!");
				return mapping.findForward("error");
			}
		}

	/**
	 * ��ʦ��½
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward teaLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			LoginForm loginForm = (LoginForm) form;
			String username = loginForm.getUserName();
			String userpaw = loginForm.getPassword();
			Jsgl jsgl = this.getService().getJsgl(username, userpaw, 1);
			if (jsgl != null) {
				if (username.equals(jsgl.getJsbh())
						&& userpaw.equals(jsgl.getJsmm())) {
					request.getSession().setAttribute("userPk", jsgl.getJxzj());
					request.getSession().setAttribute("userName",
							jsgl.getJsbh());
					request.getSession().setAttribute("userType",
							jsgl.getJslx());
					return mapping.findForward("success2");
				} else {
					request.setAttribute("msg", "�û�����������������!");
					return mapping.findForward("error");
				}
			} else {
				request.setAttribute("msg", "�û�����������������!");
				return mapping.findForward("error");
			}
		}

	/**
	 * ѧ����½
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward stuLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			LoginForm loginForm = (LoginForm) form;
			Xsxx xsxx = this.getService().stuLogin(loginForm);
			if(xsxx!=null && loginForm.getUserName().equals(xsxx.getXsxh()) && loginForm.getPassword().equals(xsxx.getXsmm())){
				if(xsxx.getSssyz()!=null && xsxx.getSssysz()!=null){					
					Set<Xsgwxx> set = xsxx.getXsgwxxes();
					if(set!=null && set.size()>0){
						request.getSession().setAttribute("userStuPk",xsxx.getXszj());//��½���������˴���Ϊ�Ǵ�����ϵͳ�İ���ɵĴ�ϵͳ�����Ը�����Ҫ��ԭ�е�userPk�ֶδ洢��������ţ���ΪuserStuPk�洢��½������
						request.getSession().setAttribute("userPk", xsxx.getSssyz());//��½�������
						request.getSession().setAttribute("userName", xsxx.getXsxh());//��¼��ѧ��
						request.getSession().setAttribute("userTName", xsxx.getXsxm());//��½������
						request.getSession().setAttribute("userPaw", xsxx.getXsmm());//��½������
						request.getSession().setAttribute("userSyszzj", xsxx.getSssysz());//ʵ����������
						request.getSession().setAttribute("userDjxxzj", 0);//�������
						request.getSession().setAttribute("userSjxxzj", 0);//�Ծ�����
						request.getSession().setAttribute("userBjzj",xsxx.getBjxx().getBjzj());//�༶����
						List<Xsgwxx> ruleList = new ArrayList(set);
						int curRule = 0;
						for(Xsgwxx xsgw : ruleList){
							int gwzj = xsgw.getId().getGwxx().getGwzj();
							if(curRule==0){
								curRule=gwzj;
							}else{
								if(curRule>gwzj){
									curRule=gwzj;
								}
							}
						}
						request.getSession().setAttribute("curGwzj", curRule);
						ruleList=null;
						return mapping.findForward("success1");
					}else{
						request.setAttribute("msg", "�ȴ���ʦ����Ȩ�ޣ������˳�ϵͳ������!");
						return mapping.findForward("error");
					}					
				}else{
					request.setAttribute("msg", "�ȴ���ʦ����Ȩ�ޣ������˳�ϵͳ������!");
					return mapping.findForward("error");
				}				
			}else{
				request.setAttribute("msg", "�û�����������������!");
				return mapping.findForward("error");
			}
		}
}