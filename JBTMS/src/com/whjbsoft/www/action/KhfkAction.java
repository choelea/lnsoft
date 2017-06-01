package com.whjbsoft.www.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.KhfkForm;
import com.whjbsoft.www.po.Khfk;
import com.whjbsoft.www.po.Yspsd;
import com.whjbsoft.www.service.KhfkService;
import com.whjbsoft.www.servicei.KhfkServicei;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.Pageinfo;

public class KhfkAction extends DispatchAction {
	private KhfkService service;
	public KhfkService getService() {
		return service;
	}
	public void setService(KhfkService service) {
		this.service = service;
	}
	public KhfkAction() {
		service = new KhfkServicei();
	}
	public ActionForward getList(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			int sysz = (Integer) request.getSession().getAttribute("userSyszzj");
			int ssxs = (Integer) request.getSession().getAttribute("userPk");
			String rmMsg = request.getParameter("rmMsg");
			String page = request.getParameter("page");
			String con = null;
			if ("".equals(page) || page == null) {
				page = "1";
			}
			if ("true".equals(rmMsg)) {
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
				request.getSession().removeAttribute("queryMsg");
			} else {
				con = (String) request.getSession().getAttribute("queryMsg");
			}
			Pageinfo pageinfo = null;
			StringBuffer sb = new StringBuffer();
			sb.append(" and (A.sssysz = ? and A.ssxs = ? or A.sssysz = 0 and A.ssxs = 0) ");
			if (con == null) {
				pageinfo = this.getService().getPageinfo(sb.toString(),
						Integer.parseInt(page),sysz, ssxs);
			} else {
				KhfkForm khfkForm = (KhfkForm) form;
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				khfkForm.setFieldName(fieldName);
				khfkForm.setFieldValue(fieldValue);
				sb.append(con);
				pageinfo = this.getService().getPageinfo(sb.toString(),
							Integer.parseInt(page),sysz, ssxs,"%" + fieldValue + "%");
			}
			request.setAttribute("pageinfo", pageinfo);
			this.saveToken(request);
			return mapping.findForward("listPage");
	}
	
	public ActionForward goSave(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			KhfkForm khfkForm = (KhfkForm) form;
			khfkForm.getVo().setFksj(FormateDate.formate());
			khfkForm.getVo().setFkbh(FormateDate.formate("FD"));
			this.saveToken(request);
			return mapping.findForward("savePage");
	}
	
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			if(this.isTokenValid(request)) {
				KhfkForm khfkForm = (KhfkForm) form;
				Yspsd yspsd = khfkForm.getYspsd();
				Khfk khfk = khfkForm.getVo();
				khfk.setYspsd(yspsd);
				boolean flag = this.getService().save(khfk);
				String msg = flag?"客户返单添加成功！":"客户返单添加失败！";
				request.setAttribute("msg", msg);
				this.resetToken(request);
			}
			return mapping.findForward("getList");
	}
	
	public ActionForward goUpdate(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			KhfkForm khfkForm = (KhfkForm) form;
			String fkzj = request.getParameter("pk");
			Khfk khfk = this.getService().getKhfk(Integer.parseInt(fkzj));
			khfkForm.setVo(khfk);
			khfkForm.setYspsd(khfk.getYspsd());
			this.saveToken(request);
			return mapping.findForward("updatePage");
	}
	
	public ActionForward update(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			if(this.isTokenValid(request)) {
				KhfkForm khfkForm = (KhfkForm) form;
				Yspsd yspsd = khfkForm.getYspsd();
				Khfk khfk = khfkForm.getVo();
				khfk.setYspsd(yspsd);
				boolean flag = this.getService().update(khfk);
				String msg = flag?"客户返单修改成功！":"客户返单修改失败！";
				request.setAttribute("msg", msg);
				this.resetToken(request);
			}
			return mapping.findForward("getList");
	}
	public ActionForward khfd(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			String fkzj = request.getParameter("pk");
			Khfk khfk = this.getService().getKhfk(Integer.parseInt(fkzj));
			khfk.setFkzt(1);
			boolean flag = this.getService().update(khfk);
			String msg = flag?"客户返单成功！":"客户返单失败！";
			request.setAttribute("msg", msg);
			return mapping.findForward("getList");
	}
	
	public ActionForward delete(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			String[] pks = request.getParameterValues("pk");
			boolean flag = this.getService().delete(pks);
			String msg = flag?"客户返单删除成功！":"客户返单删除失败！";
			request.setAttribute("msg", msg);
			return mapping.findForward("getList");
	}
	
	public ActionForward view(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			KhfkForm khfkForm = (KhfkForm) form;
			String fkzj = request.getParameter("pk");
			Khfk khfk = this.getService().getKhfk(Integer.parseInt(fkzj));
			khfkForm.setVo(khfk);
			khfkForm.setYspsd(khfk.getYspsd());
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