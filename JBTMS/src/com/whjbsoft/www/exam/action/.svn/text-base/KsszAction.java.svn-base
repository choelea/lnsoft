package com.whjbsoft.www.exam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.exam.form.KsszForm;
import com.whjbsoft.www.exam.po.Kssz;
import com.whjbsoft.www.exam.service.KsszService;
import com.whjbsoft.www.exam.servicei.KsszServicei;
import com.whjbsoft.www.util.Pageinfo;

public class KsszAction extends DispatchAction {
	private KsszService service;

	public KsszAction() {
		this.setService(new KsszServicei());
	}

	public KsszService getService() {
		return service;
	}

	public void setService(KsszService service) {
		this.service = service;
	}

	public ActionForward objList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String page = request.getParameter("page");
		if (page == null || "".equals(page)) {
			page = "1";
		}
		Pageinfo pageinfo = this.getService().getPageinfo("",
				Integer.valueOf(page));
		request.setAttribute("pageinfo", pageinfo);
		return mapping.findForward("objList");
	}

	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("success");
	}

	public ActionForward presave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		KsszForm ksszForm = (KsszForm) form;
		this.saveToken(request);
		return mapping.findForward("gotoAdd");

	}

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		if (this.isTokenValid(request)) {
			KsszForm ksszForm = (KsszForm) form;
			Kssz vo = ksszForm.getVo();
			vo.setBjxx(ksszForm.getBjxx());
			vo.setSjxx(ksszForm.getSjxx());
			boolean flag = this.getService().save(vo);
			request.setAttribute("msg", flag ? "信息录入成功!" : "信息录入失败!");
			this.resetToken(request);
		}
		return mapping.findForward("success");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String[] ids = request.getParameterValues("pk");
		boolean flag = this.getService().delete(ids);
		request.setAttribute("msg", flag ? "删除成功!" : "删除失败!");
		return mapping.findForward("success");
	}

	public ActionForward szState(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		KsszForm ksszForm = (KsszForm) form;
		Kssz vo = ksszForm.getVo();
		this.getService().szState(vo.getKsszzj(), vo.getKsszzt());
		return mapping.findForward("success");
	}
}