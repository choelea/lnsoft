package com.whjbsoft.www.exam.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.exam.form.SjxxForm;
import com.whjbsoft.www.exam.po.Sjkts;
import com.whjbsoft.www.exam.po.SjktsId;
import com.whjbsoft.www.exam.po.Sjtxs;
import com.whjbsoft.www.exam.po.Sjxxs;
import com.whjbsoft.www.exam.po.Stgls;
import com.whjbsoft.www.exam.service.SjxxService;
import com.whjbsoft.www.exam.servicei.SjxxServicei;
import com.whjbsoft.www.exam.vo.SjxxVo;
import com.whjbsoft.www.util.Pageinfo;

public class SjxxAction extends DispatchAction {
	private SjxxService service;

	public SjxxAction() {
		this.setService(new SjxxServicei());
	}

	public SjxxService getService() {
		return service;
	}

	public void setService(SjxxService service) {
		this.service = service;
	}

	public ActionForward objList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SjxxForm sjxxForm = (SjxxForm) form;
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
		StringBuffer sb = new StringBuffer();
		String con = (String) request.getSession().getAttribute("queryMsg");
		Object[] params = null;
		if (con != null) {
			sb.append(con);
			String fieldName = (String) request.getSession().getAttribute(
					"fieldName");
			String fieldValue = (String) request.getSession().getAttribute(
					"fieldValue");
			sjxxForm.setFieldName(fieldName);
			sjxxForm.setFieldValue(fieldValue);
			params = new Object[1];
			params[0] = "%" + fieldValue + "%";
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
		SjxxForm sjxxForm = (SjxxForm) form;
		String userName = (String) request.getSession()
				.getAttribute("userName");
		sjxxForm.getVo().setCjr(userName);
		sjxxForm.getVo().setSjzt(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sjxxForm.getVo().setCjsj(sdf.format(new Date()));
		List list = this.getService().getObjects("from Tkgls A");
		request.setAttribute("tklist", list);
		// this.saveToken(request);
		return mapping.findForward("gotoAdd");
	}

	public ActionForward nextsave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SjxxForm sjxxForm = (SjxxForm) form;
		List<Sjtxs> list = sjxxForm.getTxlist();
		String[] tmlx = request.getParameterValues("tmlx");
		int size = list.size();
		List<Sjtxs> clist = new ArrayList<Sjtxs>();
		for (int i = 0; i < tmlx.length; i++) {
			for (int j = 0; j < size; j++) {
				Sjtxs o = (Sjtxs) list.get(j);
				if (o.getPlsx().intValue() == Integer.valueOf(tmlx[i])) {
					clist.add(o);
					break;
				}
			}
		}
		request.setAttribute("tklist", clist);
		this.saveToken(request);
		return mapping.findForward("nextAdd");
	}

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (this.isTokenValid(request)) {
			SjxxForm sjxxForm = (SjxxForm) form;
			Sjxxs vo = sjxxForm.getVo();
			Set<Sjtxs> set = vo.getSjtxes();
			List<Sjtxs> list = sjxxForm.getTxlist();
			List<Stgls> stlist = sjxxForm.getKtlist();
			for (Sjtxs sjtx : list) {
				sjtx.setSjxx(vo);
				set.add(sjtx);
				for (Stgls stgl : stlist) {
					Sjkts sjkt = new Sjkts(new SjktsId(stgl, sjtx));
					if (sjtx.getSjtxmc().equals(stgl.getStlx())) {
						sjtx.getSjkts().add(sjkt);
					}
				}
			}
			String hql = "from Sjxxs A where A.sjbh=?";
			boolean flag = this.getService().isExist(hql, vo.getSjbh());
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
		SjxxForm sjxxForm = (SjxxForm) form;
		Sjxxs sjxx = this.getService().get(sjxxForm.getVo().getSjzj());
		sjxxForm.setVo(sjxx);
		List<SjxxVo> kt = this.getService().getSjst(sjxxForm.getVo().getSjzj());
		request.setAttribute("kt", kt);
		return mapping.findForward("gotoUpd");
	}

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		if (this.isTokenValid(request)) {
			SjxxForm sjxxForm = (SjxxForm) form;

			this.resetToken(request);
		}
		return mapping.findForward("success");
	}

	public ActionForward preview(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SjxxForm sjxxForm = (SjxxForm) form;
		Sjxxs sjxx = this.getService().get(sjxxForm.getVo().getSjzj());
		sjxxForm.setVo(sjxx);
		List<SjxxVo> kt = this.getService().getSjst(sjxxForm.getVo().getSjzj());
		request.setAttribute("kt", kt);
		return mapping.findForward("gotoView");
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String[] ids = request.getParameterValues("pk");
		boolean flag = this.getService().delete(ids);
		request.setAttribute("msg", flag ? "删除成功!" : "删除失败!");
		return mapping.findForward("success");
	}

	public ActionForward updState(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SjxxForm sjxxForm = (SjxxForm) form;
		Sjxxs vo = sjxxForm.getVo();
		this.getService().sjState(vo.getSjzj(), vo.getSjzt());
		return mapping.findForward("success");
	}
}