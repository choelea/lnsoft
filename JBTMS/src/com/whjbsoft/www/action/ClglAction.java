package com.whjbsoft.www.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.ClglForm;
import com.whjbsoft.www.po.Ylxx;
import com.whjbsoft.www.service.ClglService;
import com.whjbsoft.www.servicei.ClglServicei;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.Pageinfo;

public class ClglAction extends DispatchAction{
	private ClglService service;

	public ClglService getService() {
		return service;
	}

	public void setService(ClglService service) {
		this.service = service;
	}
	public ClglAction() {
		service = new ClglServicei();
	}
	
	public ActionForward getList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			int sysz = (Integer) request.getSession().getAttribute("userSyszzj");
			int ssxs = (Integer) request.getSession().getAttribute("userPk");
			int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
			int ktzj = Contants_st.cl_query;
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
			sb.append(" and (sssysz = ? and ssxs = ? or sssysz = 0 and ssxs = 0) ");
			if (con == null) {
				pageinfo = this.getService().getPageinfo(sb.toString(),
						Integer.parseInt(page),sysz, ssxs);
			} else {
				ClglForm clglForm = (ClglForm) form;
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				clglForm.setFieldName(fieldName);
				clglForm.setFieldValue(fieldValue);
				sb.append(con);
				pageinfo = this.getService().getPageinfo1(sb.toString(),
							Integer.parseInt(page),djzj,ktzj, sysz, ssxs,"%" + fieldValue + "%");
			}
			request.setAttribute("pageinfo", pageinfo);
			this.saveToken(request);
			return mapping.findForward("listPage");
		}
	
	public ActionForward goSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			request.setAttribute("autoBh", FormateDate.formate("CL"));
			this.saveToken(request);
			return mapping.findForward("savePage");
		}
	
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)) {
				int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				int ktzj = Contants_st.cl_add;
				ClglForm bxglForm = (ClglForm) form;
				boolean flag = this.getService().save(bxglForm.getVo(),djzj,ktzj);
				String msg = flag?"车辆添加成功!":"车辆添加失败!";
				request.setAttribute("msg", msg);
			}
			request.getSession().removeAttribute("queryMsg");
			this.resetToken(request);
			return mapping.findForward("getList");
		}
		
	
	public ActionForward goUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String pk = request.getParameter("pk");
			Ylxx ylxx = this.getService().getYlxx(Integer.parseInt(pk));
			ClglForm clglForm = (ClglForm) form;
			clglForm.setVo(ylxx);
			this.saveToken(request);
			return mapping.findForward("updatePage");
		}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)) {
				int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				int ktzj = Contants_st.cl_upd;
				ClglForm bxglForm = (ClglForm) form;
				boolean flag = this.getService().update(bxglForm.getVo(),djzj,ktzj);
				String msg = flag?"车辆修改成功!":"车辆修改失败!";
				request.setAttribute("msg", msg);
			}
			request.getSession().removeAttribute("queryMsg");
			this.resetToken(request);
			return mapping.findForward("getList");
		}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)) {
				int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				int ktzj = Contants_st.cl_del;
				String[] pks = request.getParameterValues("pk");
				boolean flag = this.getService().delete(pks,djzj,ktzj);
				String msg = flag?"车辆删除成功!":"车辆删除失败!";
				request.setAttribute("msg", msg);
			}
			request.getSession().removeAttribute("queryMsg");
			this.resetToken(request);
			return mapping.findForward("getList");
		}
	
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String pk = request.getParameter("pk");
			Ylxx ylxx = this.getService().getYlxx(Integer.parseInt(pk));
			ClglForm clglForm = (ClglForm) form;
			clglForm.setVo(ylxx);
			return mapping.findForward("viewPage");
		}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if(fieldName != null && !"".equals(fieldName) && fieldValue != null && !"".equals(fieldValue)) {
				StringBuffer sb = new StringBuffer();
				sb.append(" and ").append(fieldName).append(" like ? ");
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
	
