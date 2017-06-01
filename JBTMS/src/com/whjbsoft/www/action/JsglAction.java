/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.whjbsoft.www.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.JsglForm;
import com.whjbsoft.www.po.Jsgl;
import com.whjbsoft.www.service.JsglService;
import com.whjbsoft.www.servicei.JsglServicei;
import com.whjbsoft.www.util.Pageinfo;

/**
 * MyEclipse Struts Creation date: 11-25-2009
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/jsgl" name="jsglForm" input="jsp/teacher/jsgl_add.jsp"
 *                parameter="method" scope="request"
 * @struts.action-forward name="updatePage" path="/jsp/teacher/jsgl_update"
 * @struts.action-forward name="listPage" path="/jsp/teacher/jsgl_list.jsp"
 * @struts.action-forward name="viewPage" path="/jsp/teacher/jsgl_view.jsp"
 * @struts.action-forward name="getList" path="jsgl.do?method=getList"
 * @struts.action-forward name="addPage" path="/jsp/teacher/jsgl_add.jsp"
 */
public class JsglAction extends DispatchAction {
	private JsglService service;

	public JsglAction() {
		service = new JsglServicei();
	}

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward getList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String curpage = request.getParameter("page");
			if (curpage == null || "".equals(curpage)) {
				curpage = "1";
			}
			String con = "";
			Integer userType = (Integer) request.getSession().getAttribute(
					"userType");
			if (userType == 1) {
				Integer userPk = (Integer) request.getSession().getAttribute(
						"userPk");
				con = " and jxzj = " + userPk;
			}
			Pageinfo pageinfo = this.getService().getPagedata(con,
					Integer.parseInt(curpage));
			request.setAttribute("pageinfo", pageinfo);
			this.saveToken(request);
			return mapping.findForward("listPage");
	}

	public ActionForward goAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			JsglForm jsglForm = (JsglForm) form;
			jsglForm.getVo().setJslx(1);
			this.saveToken(request);
			return mapping.findForward("addPage");
	}

	public ActionForward saveObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if (isTokenValid(request)) {
				JsglForm jsglForm = (JsglForm) form;
				Jsgl jsgl = jsglForm.getVo();
				boolean flag = this.getService().save(jsgl);
				request.setAttribute("msg", flag?"���ӽ�ʦ�ɹ���":"���ӽ�ʦʧ�ܣ�");
			}
			return mapping.findForward("getList");
	}
	
	public ActionForward goUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			JsglForm jsglForm = (JsglForm) form;
			String pk = request.getParameter("pk");
			Jsgl jsgl = this.getService().getJsgl(Integer.parseInt(pk));
			jsglForm.setVo(jsgl);
			this.saveToken(request);
			return mapping.findForward("updatePage");
	}
	
	public ActionForward updateObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if (isTokenValid(request)) {
				JsglForm jsglForm = (JsglForm) form;
				Jsgl jsgl = jsglForm.getVo();
				boolean flag = this.getService().update(jsgl);
				request.setAttribute("msg", flag?"��ʦ��Ϣ�޸ĳɹ���":"��ʦ��Ϣ�޸�ʧ�ܣ�");
			}
			return mapping.findForward("getList");
	}
	
	
	public ActionForward viewObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			JsglForm jsglForm = (JsglForm) form;
			String pk = request.getParameter("pk");
			Jsgl jsgl = this.getService().getJsgl(Integer.parseInt(pk));
			jsglForm.setVo(jsgl);
			return mapping.findForward("viewPage");
	}
	
	public ActionForward delObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if (isTokenValid(request)) {
				String pk[] = request.getParameterValues("pk");
				boolean flag = this.getService().delJsgl(pk);
				request.setAttribute("msg", flag?"��ʦ��Ϣɾ���ɹ���":"��ʦ��Ϣɾ��ʧ�ܣ�");
			}
			return mapping.findForward("getList");
	}
	
	
	public ActionForward gotoUpdPaw(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			JsglForm jsglForm = (JsglForm) form;
			String pk = request.getParameter("pk");
			if(pk==null){
				pk = jsglForm.getVo().getJxzj().toString();
			}
			Jsgl jsgl = this.getService().getJsgl(Integer.parseInt(pk));
			jsglForm.setVo(jsgl);
			this.saveToken(request);
			return mapping.findForward("updatePawPage");
		}
	public ActionForward updPaw(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			JsglForm teacherForm = (JsglForm) form;
			if (this.isTokenValid(request)) {
				boolean flag = this.getService().update(
						teacherForm.getVo());
				request.setAttribute("msg", flag ? "��ʦ��Ϣ�޸ĳɹ�!"
						: "��ʦ��Ϣ�޸�ʧ��!");
				resetToken(request);
			}
			return this.gotoUpdPaw(mapping, form, request, response);
		}
	
	/**
	 * @return the service
	 */
	public JsglService getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(JsglService service) {
		this.service = service;
	}
}