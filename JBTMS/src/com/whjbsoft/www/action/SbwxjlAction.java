package com.whjbsoft.www.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.SbwxjlForm;
import com.whjbsoft.www.po.Sbwxjlb;
import com.whjbsoft.www.service.SbwxjlService;
import com.whjbsoft.www.servicei.SbwxjlServicei;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.Pageinfo;
public class SbwxjlAction extends DispatchAction {
	private SbwxjlService service;
	public SbwxjlAction(){
		this.setService(new SbwxjlServicei());
	}
	public SbwxjlService getService() {
		return service;
	}
	public void setService(SbwxjlService service) {
		this.service = service;
	}
	public ActionForward objList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			SbwxjlForm sbwxjlForm = (SbwxjlForm) form;
			String rmMsg = request.getParameter("rmMsg");
			String page = request.getParameter("page");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			if ("true".equals(rmMsg)) {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			Integer ssxs = (Integer) request.getSession().getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
			Integer curGwzj = (Integer)request.getSession().getAttribute("curGwzj");
			StringBuffer sb = new StringBuffer(" and (A.ssxs = ? and A.sssysz = ? or A.ssxs = 0 and A.sssysz = 0) and A.ssxtmk = ?");
			String con = (String) request.getSession().getAttribute("queryMsg");
			Pageinfo pageinfo = null;
			if (con != null) {
				sb.append(con);
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				sbwxjlForm.setFieldName(fieldName);
				sbwxjlForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPageinfo(sb.toString(), Integer.parseInt(page),ssxs,sssysz,curGwzj, "%" + fieldValue + "%");
				request.setAttribute("pageinfo", pageinfo);
			} else {
				pageinfo = this.getService().getPageinfo(sb.toString(), Integer.parseInt(page),ssxs,sssysz,curGwzj);				
			}
			request.setAttribute("pageinfo", pageinfo);
			return mapping.findForward("objList");
	}
	public ActionForward queryList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			StringBuffer sb = new StringBuffer();
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if (fieldName != null && !"".equals(fieldName) && fieldValue != null && !"".equals(fieldValue)) {
				sb.append(" and A.").append(fieldName).append(" like ?");
				request.getSession().setAttribute("fieldName", fieldName);
				request.getSession().setAttribute("fieldValue", fieldValue);
				request.getSession().setAttribute("queryMsg", sb.toString());
			} else {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			return mapping.findForward("success");
	}
	public ActionForward gotoAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			SbwxjlForm sbwxjlForm = (SbwxjlForm) form;
			Sbwxjlb vo = sbwxjlForm.getVo();
			vo.setSbwxjlbh(FormateDate.formate("WX"));
			this.saveToken(request);
			return mapping.findForward("gotoAdd");
	}
	public ActionForward addObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)){
				SbwxjlForm sbwxjlForm = (SbwxjlForm) form;
				Sbwxjlb vo = sbwxjlForm.getVo();
				boolean flag = this.getService().save(vo);
				request.setAttribute("msg",flag?"信息设置成功!":"信息设置失败!");
				this.resetToken(request);
			}
			return mapping.findForward("success");
	}
	public ActionForward gotoUpd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			SbwxjlForm sbwxjlForm = (SbwxjlForm) form;
			Sbwxjlb vo = this.getService().getSbwxjlb(sbwxjlForm.getVo().getSbwxjlzj());
			sbwxjlForm.setVo(vo);
			this.saveToken(request);
			return mapping.findForward("gotoUpd");
	}
	public ActionForward updObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)){
				SbwxjlForm sbwxjlForm = (SbwxjlForm) form;
				Sbwxjlb vo = sbwxjlForm.getVo();
				boolean flag = this.getService().update(vo);
				request.setAttribute("msg", flag?"信息修改成功!":"信息修改失败!");
				this.resetToken(request);
			}
			return mapping.findForward("success");
	}
	public ActionForward delObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String[] ids = request.getParameterValues("pk");
			boolean flag = this.getService().delete(ids);
			request.setAttribute("msg",flag?"删除成功!":"删除失败!");
			return mapping.findForward("success");
	}
	public ActionForward viewObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			SbwxjlForm sbwxjlForm = (SbwxjlForm) form;
			Sbwxjlb vo = this.getService().getSbwxjlb(sbwxjlForm.getVo().getSbwxjlzj());
			sbwxjlForm.setVo(vo);
			return mapping.findForward("gotoView");
	}
}