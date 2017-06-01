package com.whjbsoft.www.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.BmxxForm;
import com.whjbsoft.www.po.Bmxx;
import com.whjbsoft.www.service.BmxxService;
import com.whjbsoft.www.servicei.BmxxServicei;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.Pageinfo;

public class BmxxAction extends DispatchAction {
	private BmxxService service;
	public BmxxAction(){
		this.setService(new BmxxServicei());
	}
	
	public BmxxService getService() {
		return service;
	}

	public void setService(BmxxService service) {
		this.service = service;
	}

	public ActionForward objList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			BmxxForm bmxxForm = (BmxxForm) form;
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
			StringBuffer sb = new StringBuffer(" and (A.ssxs = ? and A.sssysz = ? or A.ssxs = 0 and A.sssysz = 0)");
			String con = (String) request.getSession().getAttribute("queryMsg");
			Pageinfo pageinfo = null;
			if (con != null) {
				sb.append(con);
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				bmxxForm.setFieldName(fieldName);
				bmxxForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPageinfo(sb.toString(), Integer.parseInt(page),ssxs,sssysz, "%" + fieldValue + "%");
				request.setAttribute("pageinfo", pageinfo);
			} else {
				pageinfo = this.getService().getPageinfo(sb.toString(), Integer.parseInt(page),ssxs,sssysz);				
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
		
			BmxxForm bmxxForm = (BmxxForm) form;
			Bmxx vo = bmxxForm.getVo();
			vo.setBmbh(FormateDate.formate("BM"));
			this.saveToken(request);
			return mapping.findForward("gotoAdd");
	}
	public ActionForward addObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)){
				BmxxForm bmxxForm = (BmxxForm) form;
				Bmxx vo = bmxxForm.getVo();
				boolean flag = this.getService().isExist(" and A.bmmc=? and A.ssjg=? and (A.ssxs=? and A.sssysz=? or A.ssxs=0 and A.sssysz=0)", vo.getBmmc(),vo.getSsjg(),vo.getSsxs(),vo.getSssysz());
				if(!flag){
					flag = this.getService().save(vo);
					request.setAttribute("msg",flag?"信息设置成功!":"信息设置失败!");
				}else{
					request.setAttribute("msg","该记录已存在于数据库!");
				}				
				this.resetToken(request);
			}
			return mapping.findForward("success");
	}
	public ActionForward gotoUpd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			BmxxForm bmxxForm = (BmxxForm) form;
			Bmxx bmxx = this.getService().getBmxx(bmxxForm.getVo().getBmzj());
			bmxxForm.setVo(bmxx);
			this.saveToken(request);
			return mapping.findForward("gotoUpd");
	}
	public ActionForward updObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)){
				BmxxForm bmxxForm = (BmxxForm) form;
				Bmxx vo = bmxxForm.getVo();
				String oldName = request.getParameter("oldName");
				if(vo.getBmmc().equals(oldName)){
					boolean flag = this.getService().update(vo);
					request.setAttribute("msg", flag?"信息修改成功!":"信息修改失败!");
				}else{
					boolean flag = this.getService().isExist(" and A.bmmc=? and A.ssjg=? and (A.ssxs=? and A.sssysz=? or A.ssxs=0 and A.sssysz=0)", vo.getBmmc(),vo.getSsjg(),vo.getSsxs(),vo.getSssysz());
					if(!flag){
						flag = this.getService().update(vo);
						request.setAttribute("msg", flag?"信息修改成功!":"信息修改失败!");
					}else{
						request.setAttribute("msg","该记录已存在于数据库!");
					}
				}				
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
		
			BmxxForm bmxxForm = (BmxxForm) form;
			Bmxx bmxx = this.getService().getBmxx(bmxxForm.getVo().getBmzj());
			bmxxForm.setVo(bmxx);
			return mapping.findForward("gotoView");
	}
}