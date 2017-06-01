package com.whjbsoft.www.exam.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.exam.form.StglForm;
import com.whjbsoft.www.exam.po.Stgls;
import com.whjbsoft.www.exam.po.Tkgls;
import com.whjbsoft.www.exam.service.StglService;
import com.whjbsoft.www.exam.servicei.StglServicei;
import com.whjbsoft.www.util.DogCreate;
import com.whjbsoft.www.util.Pageinfo;

public class StglAction extends DispatchAction {
	private StglService service;

	public StglAction() {
		this.setService(new StglServicei());
	}

	public StglService getService() {
		return service;
	}

	public void setService(StglService service) {
		this.service = service;
	}

	public ActionForward tkList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String rmMsg = request.getParameter("rmMsg");
		if ("true".equals(rmMsg)) {
			request.getSession().removeAttribute("tkzj");
		}
		List list = this.getService().getTkgldata("");
		request.setAttribute("list", list);
		return mapping.findForward("tkList");
	}

	public ActionForward objList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		StglForm stglForm = (StglForm) form;
		String rmMsg = request.getParameter("rmMsg");
		String page = request.getParameter("page");
		if (page == null || "".equals(page)) {
			page = "1";
		}
		if ("true".equals(rmMsg)) {
			request.getSession().removeAttribute("queryMsg");
			request.getSession().removeAttribute("fieldName");
			request.getSession().removeAttribute("fieldValue");
			request.getSession().setAttribute("tkzj",
					stglForm.getTkgl().getTkzj());
		}
		StringBuffer sb = new StringBuffer(" and A.tkgl.tkzj=?");
		String con = (String) request.getSession().getAttribute("queryMsg");
		Integer tkzj = (Integer) request.getSession().getAttribute("tkzj");
		Object[] params = null;
		if (con != null) {
			sb.append(con);
			String fieldName = (String) request.getSession().getAttribute(
					"fieldName");
			String fieldValue = (String) request.getSession().getAttribute(
					"fieldValue");
			stglForm.setFieldName(fieldName);
			stglForm.setFieldValue(fieldValue);
			params = new Object[2];
			params[0] = tkzj;
			params[1] = "%" + fieldValue + "%";
		} else {
			params = new Object[1];
			params[0] = tkzj;
		}
		Pageinfo pageinfo = this.getService().getPageinfo(sb.toString(),
				Integer.valueOf(page), params);
		request.setAttribute("pageinfo", pageinfo);
		return mapping.findForward("objList");
	}

	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		StringBuffer sb = new StringBuffer();
		String fieldName = request.getParameter("fieldName");
		String fieldValue = request.getParameter("fieldValue");
		if (fieldName != null && !"".equals(fieldName) && fieldValue != null
				&& !"".equals(fieldValue)) {
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

	public ActionForward presave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		StglForm stglForm = (StglForm) form;
		Integer tkzj = (Integer) request.getSession().getAttribute("tkzj");
		Tkgls tkgl = this.getService().getTkgl(tkzj);
		stglForm.setTkgl(tkgl);
		request.setAttribute("tklx", tkgl.getTklx());
		this.saveToken(request);
		return mapping.findForward("gotoAdd");
	}

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		if (this.isTokenValid(request)) {
			StglForm stglForm = (StglForm) form;
			// 构造正确答案选项值
			String stxx = DogCreate.compageString(stglForm.getStxx());
			Stgls vo = stglForm.getVo();
			vo.setZqda(stxx);
			vo.setTkgl(stglForm.getTkgl());
			String hql = "from Stgls A where A.stmc like ? and A.stlx = ?";
			boolean flag = this.getService().isExist(hql, vo.getStmc(),
					vo.getStlx());
			if (!flag) {
				flag = this.getService().save(vo);
				request.setAttribute("msg", flag ? "信息录入成功!" : "信息录入失败!");
			} else {
				request.setAttribute("msg", "该记录已存在于数据库!");
			}
			this.resetToken(request);
		}
		return mapping.findForward("success");
	}

	public ActionForward preupdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		StglForm stglForm = (StglForm) form;
		Stgls stgl = this.getService().get(stglForm.getVo().getStzj());
		stglForm.setVo(stgl);
		stglForm.setTkgl(stgl.getTkgl());
		if (stgl.getZqda() != null) {
			String[] stxx = stgl.getZqda().split(",");
			stglForm.setStxx(stxx);
		}
		request.setAttribute("tklx", stgl.getStlx());
		this.saveToken(request);
		return mapping.findForward("gotoUpd");
	}

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		if (this.isTokenValid(request)) {
			StglForm stglForm = (StglForm) form;
			Stgls vo = stglForm.getVo();
			String oldmc = request.getParameter("oldmc");
			String stxx = DogCreate.compageString(stglForm.getStxx());
			vo.setZqda(stxx);
			vo.setTkgl(stglForm.getTkgl());
			if (oldmc != null && !oldmc.equals(vo.getStmc())) {
				String hql = "from Stgls A where A.stmc like ? and A.stlx = ? and A.stzj<>?";
				boolean flag = this.getService().isExist(hql, vo.getStmc(),
						vo.getStlx(),vo.getStzj());
				if (!flag) {
					flag = this.getService().update(vo);
					request.setAttribute("msg", flag ? "信息修改成功!" : "信息修改失败!");
				} else {
					request.setAttribute("msg", "该记录已存在于数据库!");
				}
			} else {
				boolean flag = this.getService().update(vo);
				request.setAttribute("msg", flag ? "信息修改成功!" : "信息修改失败!");
			}
		}
		return mapping.findForward("success");
	}

	public ActionForward preview(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		StglForm stglForm = (StglForm) form;
		Stgls stgl = this.getService().get(stglForm.getVo().getStzj());
		stglForm.setVo(stgl);
		stglForm.setTkgl(stgl.getTkgl());
		if (stgl.getZqda() != null) {
			String[] stxx = stgl.getZqda().split(",");
			stglForm.setStxx(stxx);
		}
		request.setAttribute("tklx", stgl.getStlx());
		return mapping.findForward("gotoView");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String[] ids = request.getParameterValues("pk");
		boolean flag = this.getService().delete(ids);
		request.setAttribute("msg", flag ? "删除成功!" : "删除失败!");
		return mapping.findForward("success");
	}
}