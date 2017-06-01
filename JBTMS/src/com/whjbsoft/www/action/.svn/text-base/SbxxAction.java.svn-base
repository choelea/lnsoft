package com.whjbsoft.www.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.SbxxForm;
import com.whjbsoft.www.service.SbxxService;
import com.whjbsoft.www.servicei.SbxxServicei;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.Pageinfo;

public class SbxxAction extends DispatchAction {
	private SbxxService service;
	public SbxxService getService() {
		return service;
	}

	public void setService(SbxxService service) {
		this.service = service;
	}
	public SbxxAction() {
		service = new SbxxServicei();
	}

	public ActionForward getList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			int sysz = (Integer) request.getSession().getAttribute("userSyszzj");
			int ssxs = (Integer) request.getSession().getAttribute("userPk");
			int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
			int ktzj = Contants_st.sb_query;
			String rmMsg = request.getParameter("rmMsg");
			String page = request.getParameter("page");
			String con = null;
			if(page == null || "".equals(page)) {
				page = "1";
			}
			if("true".equals(rmMsg)) {
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
				request.getSession().removeAttribute("queryMsg");
			}else {
				con = (String) request.getSession().getAttribute("queryMsg");
			}
			Pageinfo pageinfo = null;
			StringBuffer sb = new StringBuffer();
			sb.append(" and (A.ssxs = ? and A.sssysz = ? or A.ssxs = 0 and A.sssysz = 0)");
			if(con == null) {
				pageinfo = this.getService().getPageinfo(sb.toString(), Integer.parseInt(page),ssxs, sysz);
			}else {
				sb.append(con);
				SbxxForm sbxxForm = (SbxxForm) form;
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				sbxxForm.setFieldName(fieldName);
				sbxxForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPageinfo(djzj, ktzj, sb.toString(), 
						Integer.parseInt(page), ssxs,sysz,"%" + fieldValue + "%");
			}
			request.setAttribute("pageinfo", pageinfo);
			this.saveToken(request);
			return mapping.findForward("listPage");
	}
	
	public ActionForward goSave(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			SbxxForm sbxxForm = (SbxxForm) form;
			sbxxForm.getVo().setSbbh(FormateDate.formate("SB"));
			this.saveToken(request);
			return mapping.findForward("savePage");
	}
	
	public ActionForward save(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			if(this.isTokenValid(request)) {
				SbxxForm sbxxForm = (SbxxForm) form;
				int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				int ktzj = Contants_st.sb_add;
				String kfzj = request.getParameter("kfzj");
				boolean flag = this.getService().save(sbxxForm.getVo(),Integer.parseInt(kfzj), djzj, ktzj);
				request.setAttribute("msg", flag?"设备添加成功!":"设备添加失败!");
				this.resetToken(request);
			}
			return mapping.findForward("getList");
	}
	
	public ActionForward goUpdate(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response ) {
			String pk = request.getParameter("pk");
			SbxxForm sbxxForm = (SbxxForm) form;
			sbxxForm.setVo(this.getService().getSbxx(Integer.parseInt(pk)));
			request.setAttribute("kfbh", sbxxForm.getVo().getKfxx().getKfmc());
			request.setAttribute("kfzj", sbxxForm.getVo().getKfxx().getKfzj());
			this.saveToken(request);
			return mapping.findForward("updatePage");
	}
	
	public ActionForward update(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			if (this.isTokenValid(request)) {
				SbxxForm sbxxForm = (SbxxForm) form;
				int djzj = (Integer) request.getSession().getAttribute(
						"userDjxxzj");
				int ktzj = Contants_st.sb_upd;
				String kfzj = request.getParameter("kfzj");
				boolean flag = this.getService().update(sbxxForm.getVo(),
						Integer.parseInt(kfzj), djzj, ktzj);
				request.setAttribute("msg", flag ? "设备修改成功!" : "设备修改失败!");
				this.resetToken(request);
			}			
			return mapping.findForward("getList");
	}
	
	public ActionForward view(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			String pk = request.getParameter("pk");
			SbxxForm sbxxForm = (SbxxForm) form;
			sbxxForm.setVo(this.getService().getSbxx(Integer.parseInt(pk)));
			request.setAttribute("kfbh", sbxxForm.getVo().getKfxx().getKfmc());
			return mapping.findForward("viewPage");
	}
	
	public ActionForward delete(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			String[] pks = request.getParameterValues("pk");
			int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
			int ktzj = Contants_st.sb_upd;
			boolean flag = this.getService().delete(pks, djzj, ktzj);
			request.setAttribute("msg", flag?"设备删除成功!":"设备删除失败!");
			return mapping.findForward("getList");
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,HttpServletResponse response ) {
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
