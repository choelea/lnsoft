package com.whjbsoft.www.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.HzgxxxForm;
import com.whjbsoft.www.po.Hzgxxx;
import com.whjbsoft.www.service.HzgxxxService;
import com.whjbsoft.www.servicei.HzgxxxServicei;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.Pageinfo;

public class HzgxxxAction extends DispatchAction{
	private HzgxxxService service;

	public HzgxxxService getService() {
		return service;
	}

	public void setService(HzgxxxService service) {
		this.service = service;
	}
	public HzgxxxAction() {
		service = new HzgxxxServicei();
	}
	
	public ActionForward getList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			HzgxxxForm hzgxxxForm = (HzgxxxForm) form;
			String rmMsg = request.getParameter("rmMsg");
			Integer ssxs = (Integer) request.getSession()
					.getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
			Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
			int stzj = Contants_st.hzgx_query;
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
					" and (A.ssxs = ? and A.sssysz = ? or A.ssxs = 0 and A.sssysz = 0)");
			String con = (String) request.getSession().getAttribute("queryMsg");
			if (con != null) {
				sb.append(con);
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				hzgxxxForm.setFieldName(fieldName);
				hzgxxxForm.setFieldValue(fieldValue);
				Pageinfo pageinfo = this.getService().getPagedata(djzj, stzj,
						sb.toString(), Integer.parseInt(page), ssxs, sssysz,
						"%" + fieldValue + "%");
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
		
			this.saveToken(request);
			String bh = FormateDate.formate("HZ");
			request.setAttribute("autobh", bh);
			return mapping.findForward("savePage");
		}
	
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			HzgxxxForm hzgxxxForm = (HzgxxxForm) form;
			if (this.isTokenValid(request)) {
				Integer djzj = (Integer) request.getSession().getAttribute(
						"userDjxxzj");
				int stzj = Contants_st.hzgx_add;
				boolean flag = this.getService().save(djzj,stzj,hzgxxxForm.getVo());
				request.setAttribute("msg", flag ? "信息录入成功!" : "信息录入失败!");
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
		
			HzgxxxForm hzgxxxForm = (HzgxxxForm) form;
			String pk = request.getParameter("pk");
			Hzgxxx hzgxxx = this.getService().getHzgxxx(Integer.parseInt(pk));
			hzgxxxForm.setVo(hzgxxx);
			this.saveToken(request);
			return mapping.findForward("updatePage");
		}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			HzgxxxForm hzgxxxForm = (HzgxxxForm) form;
			if (this.isTokenValid(request)) {
				Integer djzj = (Integer) request.getSession().getAttribute(
						"userDjxxzj");
				int stzj = Contants_st.hzgx_upd;
				boolean flag = this.getService().update(djzj,stzj, hzgxxxForm.getVo());
				request.setAttribute("msg", flag ? "信息修改成功!" : "信息修改失败!");
				this.resetToken(request);
			}
			return mapping.findForward("getList");
		}
	
	public ActionForward delObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			Integer djzj = (Integer) request.getSession().getAttribute(
					"userDjxxzj");
			int stzj = Contants_st.hzgx_del;
			String[] ids = request.getParameterValues("pk");
			boolean flag = this.getService().delete(djzj,stzj, ids);
			request.setAttribute("msg", flag ? "信息删除成功!" : "信息删除失败!");
//			防止搜索栏填入了信息而返回页面无法显示刚刚添加的信息
			request.getSession().removeAttribute("queryMsg");
			request.getSession().removeAttribute("fieldName");
			request.getSession().removeAttribute("fieldValue");
			return mapping.findForward("getList");
		}
	
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			HzgxxxForm hzgxxxForm = (HzgxxxForm) form;
			String pk = request.getParameter("pk");
			Hzgxxx hzgxxx = this.getService().getHzgxxx(Integer.parseInt(pk));
			hzgxxxForm.setVo(hzgxxx);
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
