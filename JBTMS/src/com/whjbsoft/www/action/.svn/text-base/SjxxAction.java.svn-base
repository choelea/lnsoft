package com.whjbsoft.www.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.SjxxForm;
import com.whjbsoft.www.po.Ktxx;
import com.whjbsoft.www.po.Sjhp;
import com.whjbsoft.www.po.Sjxx;
import com.whjbsoft.www.po.Stgl;
import com.whjbsoft.www.service.SjxxService;
import com.whjbsoft.www.servicei.SjxxServicei;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.Pageinfo;

public class SjxxAction extends DispatchAction {
	private SjxxService servicei;

	public SjxxAction() {
		this.setServicei(new SjxxServicei());
	}

	public SjxxService getServicei() {
		return servicei;
	}

	public void setServicei(SjxxService servicei) {
		this.servicei = servicei;
	}

	/**
	 * 试卷分页列表
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward objList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");
		if (page == null || "".equals(page)) {
			page = "1";
		}
		String con = "";
		// Integer userType = (Integer) request.getSession().getAttribute(
		// "userType");
		// if (userType == 1) {
		// Integer userPk = (Integer) request.getSession().getAttribute(
		// "userPk");
		// con = " and A.cjrzj = " + userPk;
		// }
		Pageinfo pageinfo = this.getServicei().getPagedata(con,
				Integer.parseInt(page));
		request.setAttribute("pageinfo", pageinfo);
		this.saveToken(request);
		return mapping.findForward("objList");
	}

	/**
	 * 添加试卷前方法
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward gotoAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SjxxForm sjxxForm = (SjxxForm) form;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sjxxForm.setCjsj(sdf.format(new Date()));
		List list = this.getServicei().getStglList("");
		request.setAttribute("list", list);
		request.setAttribute("tjhpst", Contants_st.khdd_add);
		this.saveToken(request);
		return mapping.findForward("gotoAdd");
	}

	/**
	 * 添加试卷方法
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward addObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SjxxForm sjxxForm = (SjxxForm) form;
		if (this.isTokenValid(request)) {
			String con = " and A.sjbh = ?";
			if (!this.getServicei().nameExist(con, sjxxForm.getSjbh())) {
				Sjxx sjxx = new Sjxx();
				try {
					BeanUtils.copyProperties(sjxx, sjxxForm);
				} catch (Exception e) {
					e.printStackTrace();
				}
				String[] stPk = request.getParameterValues("stPk");
				Set sjhps = new HashSet();
				String[] hpbm = request.getParameterValues("hpbm");
				String[] hpsl = request.getParameterValues("hpsl");
				if (hpsl != null) {
					for (int i = 0; i < hpsl.length; i++) {
						Sjhp sjhp = new Sjhp();
						sjhp.setHpbm(hpbm[i]);
						sjhp.setHpsl(Double.valueOf(hpsl[i]));
						sjhp.setSjxx(sjxx);
						sjhps.add(sjhp);
						sjxx.setSjhps(sjhps);
					}
				}
				List<Ktxx> list = sjxxForm.getList();
				for (int i = 0; i < list.size(); i++) {
					Ktxx ktxx = (Ktxx) list.get(i);
					Stgl stgl = new Stgl();
					stgl.setStzj(Integer.parseInt(stPk[i]));
					ktxx.setStgl(stgl);
					ktxx.setSjxx(sjxx);
					sjxx.getKtxxes().add(ktxx);
				}
				// sjxx.setStmc(sjxx.getSjmc());
				boolean flag = this.getServicei().save(sjxx, sjhps);
				request.setAttribute("msg", flag ? "任务添加成功!" : "任务添加失败!");
			} else {
				request.setAttribute("msg", "该任务已存在于数据库!");
			}
			this.resetToken(request);
		}
		return mapping.findForward("success");
	}

	/**
	 * 修改试卷前方法
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward gotoUpd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SjxxForm sjxxForm = (SjxxForm) form;
		String sjPk = request.getParameter("pk");
		List sjhplist = this.getServicei().getSjhp(Integer.parseInt(sjPk));
		Sjxx sjxx = (Sjxx) sjhplist.get(0);
		List sjhp = (List) sjhplist.get(1);
		List hpxx = (List) sjhplist.get(2);
		try {
			BeanUtils.copyProperties(sjxxForm, sjxx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String con = " and A.sjxx.sjzj = ?";
		List list = this.getServicei().getKtxxListFroAction(con, sjPk);
		request.setAttribute("ktlist", list);
		List stlist = this.getServicei().getStglList("");
		request.setAttribute("list", stlist);
		request.setAttribute("hplist", sjhp);
		request.setAttribute("hpxxlist", hpxx);
		request.setAttribute("tjhpst", Contants_st.khdd_add);
		this.saveToken(request);
		return mapping.findForward("gotoUpd");
	}

	/**
	 * 修改试卷方法
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward updObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SjxxForm sjxxForm = (SjxxForm) form;
		if (this.isTokenValid(request)) {
			Sjxx sjxx = new Sjxx();
			try {
				BeanUtils.copyProperties(sjxx, sjxxForm);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String[] stPk = request.getParameterValues("stPk");
			Set sjhps = new HashSet();
			String[] hpbm = request.getParameterValues("hpbm");
			String[] hpsl = request.getParameterValues("hpsl");
			if (hpsl != null) {
				for (int i = 0; i < hpsl.length; i++) {
					Sjhp sjhp = new Sjhp();
					sjhp.setHpbm(hpbm[i]);
					sjhp.setHpsl(Double.valueOf(hpsl[i]));
					sjhp.setSjxx(sjxx);
					sjhps.add(sjhp);
					sjxx.setSjhps(sjhps);
				}
			}
			List<Ktxx> list = sjxxForm.getList();
			for (int i = 0; i < list.size(); i++) {
				Ktxx ktxx = (Ktxx) list.get(i);
				Stgl stgl = new Stgl();
				stgl.setStzj(Integer.parseInt(stPk[i]));
				ktxx.setStgl(stgl);
				ktxx.setSjxx(sjxx);
				sjxx.getKtxxes().add(ktxx);
			}
			boolean flag = this.getServicei().update(sjxx);
			request.setAttribute("msg", flag ? "任务修改成功!" : "任务修改失败!");
			this.resetToken(request);
		}
		return mapping.findForward("success");
	}

	/**
	 * 删除试卷信息方法
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward delObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (isTokenValid(request)) {
			String[] ids = request.getParameterValues("pk");
			boolean flag = this.getServicei().delete(ids);
			request.setAttribute("msg", flag ? "任务删除成功!" : "任务删除失败!");
		}
		return mapping.findForward("success");
	}

	/**
	 * 查看试卷详细信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward viewObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SjxxForm sjxxForm = (SjxxForm) form;
		String sjPk = request.getParameter("pk");

		List sjhplist = this.getServicei().getSjhp(Integer.parseInt(sjPk));
		Sjxx sjxx = (Sjxx) sjhplist.get(0);
		List sjhp = (List) sjhplist.get(1);
		List hpxx = (List) sjhplist.get(2);
		try {
			BeanUtils.copyProperties(sjxxForm, sjxx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String con = " and A.sjxx.sjzj = ?";
		List list = this.getServicei().getKtxxListFroAction(con, sjPk);
		request.setAttribute("hplist", sjhp);
		request.setAttribute("ktlist", list);
		request.setAttribute("hpxxlist", hpxx);
		request.setAttribute("tjhpst", Contants_st.khdd_add);
		return mapping.findForward("gotoView");
	}

	/**
	 * 修改试卷状态
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward updSjzt(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String pk = request.getParameter("pk");
		String state = request.getParameter("state");
		this.getServicei().updateSjzt(Integer.parseInt(pk),
				Integer.parseInt(state));
		return mapping.findForward("success");
	}

	/**
	 * 查看试卷详细信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward stuViewObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SjxxForm sjxxForm = (SjxxForm) form;
		Integer sjPk = (Integer) request.getSession()
				.getAttribute("userSjxxzj");
		Sjxx sjxx = this.getServicei().getSjxx(sjPk);
		try {
			BeanUtils.copyProperties(sjxxForm, sjxx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String con = " and A.sjxx.sjzj = ?";
		List list = this.getServicei().getKtxxListFroAction(con, sjPk);
		request.setAttribute("ktlist", list);
		return mapping.findForward("gotoStuView");
	}

}