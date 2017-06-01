package com.whjbsoft.www.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.KhxxForm;
import com.whjbsoft.www.po.Khxx;
import com.whjbsoft.www.service.KhxxService;
import com.whjbsoft.www.servicei.KhxxServicei;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.Pageinfo;

public class KhxxAction extends DispatchAction{
	private KhxxService service;
	public KhxxService getService() {
		return service;
	}

	public void setService(KhxxService service) {
		this.service = service;
	}
	public KhxxAction() {
		service = new KhxxServicei();
	}
	
	public ActionForward getList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			KhxxForm khxxForm = (KhxxForm) form;
			String rmMsg = request.getParameter("rmMsg");
			Integer ssxs = (Integer) request.getSession().getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
			Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
			int stzj = Contants_st.kh_query;
			String page = request.getParameter("page");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			if ("true".equals(rmMsg)) {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			StringBuffer sb = new StringBuffer(
					" and (A.ssxs = ? or A.ssxs = 0) and (A.sssysz = ? or A.sssysz = 0)");
			String con = (String) request.getSession().getAttribute("queryMsg");
			if (con != null) {
				sb.append(con);
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				khxxForm.setFieldName(fieldName);
				khxxForm.setFieldValue(fieldValue);
				Pageinfo pageinfo = this.getService().getPagedata(djzj, stzj,sb.toString(), 
						Integer.parseInt(page), ssxs, sssysz,"%" + fieldValue + "%");
				request.setAttribute("pageinfo", pageinfo);
			} else {
				Pageinfo pageinfo = this.getService().getPagedata(
						sb.toString(), Integer.parseInt(page), ssxs, sssysz);
				request.setAttribute("pageinfo", pageinfo);
			}
			return mapping.findForward("listPage");
		}
	
	public ActionForward goSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			KhxxForm khxxForm = (KhxxForm) form;
			khxxForm.getVo().setZdsj(FormateDate.formateTime());
			this.saveToken(request);
			String bh = FormateDate.formate("KH");
			request.setAttribute("autobh", bh);
			return mapping.findForward("savePage");
		}
	
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			KhxxForm khxxForm = (KhxxForm) form;
			if (this.isTokenValid(request)) {
				Integer djzj = (Integer) request.getSession().getAttribute(
						"userDjxxzj");
				int stzj = Contants_st.kh_add;
				boolean flag = this.getService().save(djzj,stzj,khxxForm.getVo());
				request.setAttribute("msg", flag ? "客户信息录入成功!" : "客户信息录入失败!");
				this.resetToken(request);
			}
//			防止搜索栏填入了信息而返回页面无法显示刚刚添加的信息
			request.getSession().removeAttribute("queryMsg");
			request.getSession().removeAttribute("fieldName");
			request.getSession().removeAttribute("fieldValue");
			return mapping.findForward("getList");
	}
	
	public ActionForward goUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			KhxxForm khxxForm = (KhxxForm) form;
			String pk = request.getParameter("pk");
			Khxx khxx = this.getService().getKhxx(Integer.parseInt(pk));
			khxxForm.setVo(khxx);
			this.saveToken(request);
			return mapping.findForward("updatePage");
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			KhxxForm khxxForm = (KhxxForm) form;
			if (this.isTokenValid(request)) {
				Integer djzj = (Integer) request.getSession().getAttribute(
						"userDjxxzj");
				int stzj = Contants_st.kh_upd;
				boolean flag = this.getService().update(djzj,stzj,khxxForm.getVo());
				request.setAttribute("msg", flag ? "信息修改成功!" : "信息修改失败!");
				this.resetToken(request);
			}
			return mapping.findForward("getList");
		}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			Integer djzj = (Integer) request.getSession().getAttribute(
					"userDjxxzj");
			int stzj = Contants_st.kh_del;
			String[] ids = request.getParameterValues("pk");
			boolean flag = this.getService().delete(djzj,stzj, ids);
			request.setAttribute("msg", flag ? "信息删除成功!" : "信息删除失败!");
			return mapping.findForward("getList");
	}
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			KhxxForm khxxForm = (KhxxForm) form;
			String pk = request.getParameter("pk");
			Khxx khxx = this.getService().getKhxx(Integer.parseInt(pk));
			khxxForm.setVo(khxx);
			return mapping.findForward("viewPage");
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			StringBuffer sb = new StringBuffer();
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if (fieldName != null && !"".equals(fieldName)
					&& fieldValue != null && !"".equals(fieldValue)) {
				sb.append(" and A.").append(fieldName).append(" like ?");
				request.getSession().setAttribute("fieldName", fieldName);
				request.getSession().setAttribute("fieldValue", fieldValue);
				request.getSession().setAttribute("queryMsg", sb.toString());
			} else {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			return mapping.findForward("getList");
	}
	
}