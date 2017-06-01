package com.whjbsoft.www.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.GgxxForm;
import com.whjbsoft.www.po.Ggxx;
import com.whjbsoft.www.service.GgxxService;
import com.whjbsoft.www.servicei.GgxxServicei;
import com.whjbsoft.www.util.Pageinfo;

public class GgxxAction extends DispatchAction {
	private GgxxService servicei;

	public GgxxAction() {
		this.setServicei(new GgxxServicei());
	}

	public GgxxService getServicei() {
		return servicei;
	}

	public void setServicei(GgxxService servicei) {
		this.servicei = servicei;
	}

	/**
	 * 公告信息分页列表
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward getList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			String page = request.getParameter("page");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			int jszj = (Integer) request.getSession().getAttribute("userPk");
			Pageinfo pageinfo = this.getServicei().getPagedata("",
					Integer.parseInt(page),jszj);
			request.setAttribute("pageinfo", pageinfo);
			this.saveToken(request);
			return mapping.findForward("objList");
	}

	/**
	 * 添加前方法
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward gotoAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			GgxxForm ggxxForm = (GgxxForm) form;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ggxxForm.setFbsj(sdf.format(new Date()));
			String ggzz = (String) request.getSession()
					.getAttribute("userName");
			ggxxForm.setGgzz(ggzz);
			int userPk = (Integer)request.getSession().getAttribute("userPk");
			Pageinfo pageinfo = this.getServicei().getClaPagedata(" and C.id = "+ userPk, 1);
			request.setAttribute("pageinfo", pageinfo);
			this.saveToken(request);
			return mapping.findForward("gotoAdd");
	}

	/**
	 * 添加公告信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward addObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			GgxxForm ggxxForm = (GgxxForm) form;
			if (this.isTokenValid(request)) {
				try {
					Ggxx ggxx = new Ggxx();
					BeanUtils.copyProperties(ggxx, ggxxForm);
					boolean flag = this.getServicei().save(ggxx);
					request.setAttribute("msg", flag ? "公告信息添加成功!"
							: "公告信息添加失败!");
				} catch (Exception e) {
					e.printStackTrace();
				}
				this.resetToken(request);
			}
			return mapping.findForward("success");
	}

	/**
	 * 修改前方法
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward gotoUpd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			GgxxForm ggxxForm = (GgxxForm) form;
			String pk = request.getParameter("pk");
			Ggxx ggxx = this.getServicei().getGgxx(Integer.parseInt(pk));
			try {
				BeanUtils.copyProperties(ggxxForm, ggxx);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Pageinfo pageinfo = this.getServicei().getClaPagedata("", 1);
			request.setAttribute("pageinfo", pageinfo);
			this.saveToken(request);
			return mapping.findForward("gotoUpd");
	}

	/**
	 * 修改公告信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward updObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			GgxxForm ggxxForm = (GgxxForm) form;
			if (this.isTokenValid(request)) {
				try {
					Ggxx ggxx = new Ggxx();
					BeanUtils.copyProperties(ggxx, ggxxForm);
					boolean flag = this.getServicei().update(ggxx);
					request.setAttribute("msg", flag ? "公告信息修改成功!"
							: "公告信息修改失败!");
				} catch (Exception e) {
					e.printStackTrace();
				}
				this.resetToken(request);
			}
			return mapping.findForward("success");
	}

	/**
	 * 删除公告信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward delObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			if (this.isTokenValid(request)) {
				String[] ids = request.getParameterValues("pk");
				boolean flag = this.getServicei().delete(ids);
				request.setAttribute("msg", flag ? "公告信息删除成功!" : "公告信息删除失败!");
			}			
			return mapping.findForward("success");
	}

	/**
	 * 查看公告信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward viewObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			GgxxForm ggxxForm = (GgxxForm) form;
			String pk = request.getParameter("pk");
			Ggxx ggxx = this.getServicei().getGgxx(Integer.parseInt(pk));
			try {
				BeanUtils.copyProperties(ggxxForm, ggxx);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mapping.findForward("gotoView");
		}

	/**
	 * 学生登陆后查看公告信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward listForStu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			String page = request.getParameter("page");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			Integer claPk = (Integer) request.getSession().getAttribute(
					"userBjzj");
			Pageinfo pageinfo = this.getServicei().getPagedata(
					" and A.bjxx.bjzj = ?", Integer.parseInt(page), claPk);
			request.setAttribute("pageinfo", pageinfo);
			return mapping.findForward("listStuPage");
	}

	/**
	 * 学生登陆后查看公告信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward viewFroStu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			GgxxForm ggxxForm = (GgxxForm) form;
			String pk = request.getParameter("pk");
			Ggxx ggxx = this.getServicei().getGgxx(Integer.parseInt(pk));
			try {
				BeanUtils.copyProperties(ggxxForm, ggxx);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mapping.findForward("viewForStu");
	}
}