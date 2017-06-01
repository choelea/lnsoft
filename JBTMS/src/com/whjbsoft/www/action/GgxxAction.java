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
	 * ������Ϣ��ҳ�б�
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
	 * ���ǰ����
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
	 * ��ӹ�����Ϣ
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
					request.setAttribute("msg", flag ? "������Ϣ��ӳɹ�!"
							: "������Ϣ���ʧ��!");
				} catch (Exception e) {
					e.printStackTrace();
				}
				this.resetToken(request);
			}
			return mapping.findForward("success");
	}

	/**
	 * �޸�ǰ����
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
	 * �޸Ĺ�����Ϣ
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
					request.setAttribute("msg", flag ? "������Ϣ�޸ĳɹ�!"
							: "������Ϣ�޸�ʧ��!");
				} catch (Exception e) {
					e.printStackTrace();
				}
				this.resetToken(request);
			}
			return mapping.findForward("success");
	}

	/**
	 * ɾ��������Ϣ
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
				request.setAttribute("msg", flag ? "������Ϣɾ���ɹ�!" : "������Ϣɾ��ʧ��!");
			}			
			return mapping.findForward("success");
	}

	/**
	 * �鿴������Ϣ
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
	 * ѧ����½��鿴������Ϣ
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
	 * ѧ����½��鿴������Ϣ
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