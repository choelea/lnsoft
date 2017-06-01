package com.whjbsoft.www.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.service.TestSetupService;
import com.whjbsoft.www.servicei.TestSetupServicei;
import com.whjbsoft.www.util.Pageinfo;

public class TestSetupAction extends DispatchAction {

	private TestSetupService service;

	public TestSetupAction() {
		this.setService(new TestSetupServicei());
	}

	public ActionForward setup(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String classPk = request.getParameter("classInfo");
		String classInfoName = request.getParameter("classInfoName");
		String flowInfo = request.getParameter("flowInfo");
		String flowId = request.getParameter("flowId");
		String curpage = request.getParameter("curpage");
		String pagesize = request.getParameter("pagesize");
		String[] stuPks = request.getParameterValues("usersel");
		boolean flag = this.getService().setup(Integer.valueOf(classPk),
				stuPks, Integer.valueOf(flowId), flowInfo);
		if (flag) {
			request.setAttribute("classInfo", classPk);
			request.setAttribute("classInfoName", classInfoName);
			request.setAttribute("flowInfo", flowInfo);
			request.setAttribute("flowId", flowId);
			request.setAttribute("curpage", curpage);
			request.setAttribute("pagesize", pagesize);
			request.setAttribute("msg", "权限设置成功！");
		} else {
			request.setAttribute("msg", "权限设置失败！");
		}

		return this.setupList(mapping, form, request, response);
	}

	public ActionForward setupList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String curpage = (String) request.getAttribute("curpage");
		String pagesize = (String) request.getAttribute("pagesize");
		String classInfo = (String) request.getAttribute("classInfo");
		String countHql = "select count(A) from Xsxx A where A.bjxx.bjzj=?";
		String hql = "from Xsxx A where A.bjxx.bjzj=?";
		Pageinfo pageinfo = null;
		if (curpage == null || pagesize == null || classInfo == null) {
			pageinfo = this.getService().getPageinfo(countHql, hql, 1, 10, -1);
			request.setAttribute("classInfo", "-1");
		} else {
			pageinfo = this.getService().getPageinfo(countHql, hql,
					Integer.valueOf(curpage), Integer.valueOf(pagesize),
					Integer.valueOf(classInfo));
		}
		request.setAttribute("data", pageinfo);
		return mapping.findForward("setupList");
	}

	/**
	 * 班级信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward bjxxList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String curpage = request.getParameter("page");
		if (curpage == null || "".equals(curpage)) {
			curpage = "1";
		}
		request.getSession().removeAttribute("curClassPk");// 当前实验组所属班级
		String con = "";
		Integer userType = (Integer) request.getSession().getAttribute(
				"userType");
		if (userType == 1) {
			Integer userPk = (Integer) request.getSession().getAttribute(
					"userPk");
			con = " and C.jxzj = " + userPk;
		}
		Pageinfo pageinfo = this.getService().getClaPageinfo(con,
				Integer.parseInt(curpage));
		request.setAttribute("pageinfo", pageinfo);
		return mapping.findForward("bjxxList");
	}

	/**
	 * 实验组信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward groupList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		// 当前所处班级标识符
		String classPk = request.getParameter("classPk");
		if (classPk == null) {
			classPk = (String) request.getSession().getAttribute("curClassPk");
		} else {
			request.getSession().setAttribute("curClassPk", classPk);
		}
		String curpage = request.getParameter("page");
		if (curpage == null || "".equals(curpage)) {
			curpage = "1";
		}
		Pageinfo pageinfo = this.getService().getGroupPageinfo(
				" and A.sssyz is not null and A.bjxx.bjzj=?",
				Integer.valueOf(curpage), classPk);
		request.setAttribute("pageinfo", pageinfo);
		request.getSession().removeAttribute("curGroupPk");
		return mapping.findForward("groupList");
	}

	/**
	 * 组员信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward xsxxList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String groupPk = request.getParameter("groupPk");
		if (groupPk == null) {
			groupPk = (String) request.getSession().getAttribute("curGroupPk");
		} else {
			request.getSession().setAttribute("curGroupPk", groupPk);
		}
		String classPk = (String) request.getSession().getAttribute(
				"curClassPk");
		List list = this.getService().getXsxxList(
				" and A.bjxx.bjzj=? and A.sssyz = ?", classPk, groupPk);
		request.setAttribute("list", list);
		List rlist = this.getService().getRuleList();
		request.setAttribute("rlist", rlist);
		return mapping.findForward("xsxxList");
	}

	/**
	 * 剩余学生信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward xsxxLeaveList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String classPk = (String) request.getSession().getAttribute(
				"curClassPk");
		String curpage = request.getParameter("page");
		if (curpage == null || "".equals(curpage)) {
			curpage = "1";
		}
		Pageinfo pageinfo = this.getService().getXsxxPageinfo(
				" and A.sssyz is null and A.bjxx.bjzj=?",
				Integer.valueOf(curpage), classPk);
		request.setAttribute("pageinfo", pageinfo);
		return mapping.findForward("xsxxLeaveList");
	}

	/**
	 * 自动分配
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward autoSetup(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String manNum = request.getParameter("manNum");
		String classPk = (String) request.getSession().getAttribute(
				"curClassPk");
		this.getService().assignRule(Integer.valueOf(classPk),
				Integer.valueOf(manNum));
		return mapping.findForward("success");
	}

	/**
	 * 交换权限
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward changeSetup(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String[] gIds = request.getParameterValues("pk");
		String classPk = (String) request.getSession().getAttribute(
				"curClassPk");
		this.getService().exchangeRule(Integer.valueOf(classPk), gIds);
		return mapping.findForward("success");
	}

	/**
	 * 手动分配权限
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward handSetup(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String[] stuIds = request.getParameterValues("pk");
		String classPk = (String) request.getSession().getAttribute(
				"curClassPk");
		this.getService().handSetRule(Integer.valueOf(classPk), stuIds);
		return mapping.findForward("success2");
	}

	/**
	 * 组内权限重置
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward groupSetup(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String spk = request.getParameter("spk");
		String[] ruleIds = request.getParameterValues("rpks");
		this.getService().resetRule(Integer.valueOf(spk), ruleIds);
		return mapping.findForward("success1");
	}

	public TestSetupService getService() {
		return service;
	}

	public void setService(TestSetupService service) {
		this.service = service;
	}
}