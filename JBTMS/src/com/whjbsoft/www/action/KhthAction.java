package com.whjbsoft.www.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.KhthForm;
import com.whjbsoft.www.po.Khth;
import com.whjbsoft.www.po.Yspsd;
import com.whjbsoft.www.service.KhthService;
import com.whjbsoft.www.servicei.KhthServicei;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.Pageinfo;

public class KhthAction extends DispatchAction{
	private KhthService service;
	public KhthService getService() {
		return service;
	}
	public void setService(KhthService service) {
		this.service = service;
	}
	public KhthAction() {
		service = new KhthServicei();
	}
	public ActionForward getList(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			int ssxs = (Integer)request.getSession().getAttribute("userPk");
			int sysz = (Integer)request.getSession().getAttribute("userSyszzj");
			String rmMsg = request.getParameter("rmMsg");
			String page = request.getParameter("page");
			String con = null;
			if(page==null) {
				page = "1";
			}
			if("true".equals(rmMsg)) {
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
				request.getSession().removeAttribute("queryMsg");
			}else {
				con = (String) request.getSession().getAttribute("queryMsg");
			}
			StringBuffer sb = new StringBuffer();
			sb.append(" and (A.ssxs = ? and A.sssysz = ? or A.ssxs = 0 and A.sssysz = 0) ");
			Pageinfo pageinfo = null;
			if(con == null) {
				pageinfo = this.getService().getPageinfo(sb.toString(), 
						Integer.parseInt(page), ssxs,sysz);
			}else {
				sb.append(con);
				KhthForm khthForm = (KhthForm) form;
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				khthForm.setFieldName(fieldName);
				khthForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPageinfo(sb.toString(), 
						Integer.parseInt(page), ssxs,sysz,"%" + fieldValue + "%");
			}
			request.setAttribute("pageinfo", pageinfo);
			return mapping.findForward("listPage");
	}
	
	public ActionForward goSave(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			KhthForm khthForm = (KhthForm) form;
			khthForm.getVo().setThdh(FormateDate.formate("TH"));
			khthForm.getVo().setThrq(FormateDate.formate());
			this.saveToken(request);
			return mapping.findForward("savePage");
	}
	
	public ActionForward save(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			if (this.isTokenValid(request)) {
				KhthForm khthForm = (KhthForm) form;
				Khth khth = khthForm.getVo();
				Yspsd yspsd = khthForm.getYspsd();
				khth.setYspsd(yspsd);
				boolean flag = this.getService().save(khth);
				String msg = flag ? "客户退货添加成功！" : "客户退货添加失败！";
				request.setAttribute("msg", msg);
				this.resetToken(request);
			}			
			return mapping.findForward("getList");
	}
	
	public ActionForward goUpdate(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			KhthForm khthForm = (KhthForm) form;
			String pk = request.getParameter("pk");
			Khth khth = this.getService().getKhth(Integer.parseInt(pk));
			khthForm.setVo(khth);
			khthForm.setYspsd(khth.getYspsd());
			this.saveToken(request);
			return mapping.findForward("updatePage");
	}
	
	public ActionForward update(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			if (this.isTokenValid(request)) {
				KhthForm khthForm = (KhthForm) form;
				Khth khth = khthForm.getVo();
				Yspsd yspsd = khthForm.getYspsd();
				khth.setYspsd(yspsd);
				boolean flag = this.getService().update(khth);
				String msg = flag ? "客户退货修改成功！" : "客户退货修改失败！";
				request.setAttribute("msg", msg);
				this.resetToken(request);
			}			
			return mapping.findForward("getList");
	}
	
	public ActionForward delete(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			String[] pks = request.getParameterValues("pk");
			boolean flag = this.getService().delete(pks);
			String msg = flag?"客户退货删除成功！":"客户退货删除失败！";
			request.setAttribute("msg", msg);
			return mapping.findForward("getList");
	}
	
	public ActionForward view(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			KhthForm khthForm = (KhthForm) form;
			String pk = request.getParameter("pk");
			Khth khth = this.getService().getKhth(Integer.parseInt(pk));
			khthForm.setVo(khth);
			khthForm.setYspsd(khth.getYspsd());
			this.saveToken(request);
			return mapping.findForward("viewPage");
	}
	
	public ActionForward query(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if(fieldName!=null&&!"".equals(fieldName)&&fieldValue!=null&&!"".equals(fieldValue)) {
				StringBuffer sb = new StringBuffer();
				sb.append(" and A.").append(fieldName).append(" like ?");
				request.getSession().setAttribute("fieldName", fieldName);
				request.getSession().setAttribute("fieldValue", fieldValue);
				request.getSession().setAttribute("queryMsg", sb.toString());
			}else {
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
				request.getSession().removeAttribute("queryMsg");
			}
			return mapping.findForward("getList");
	}
}
