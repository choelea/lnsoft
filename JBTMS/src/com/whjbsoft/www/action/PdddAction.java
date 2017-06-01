package com.whjbsoft.www.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.PdddForm;
import com.whjbsoft.www.po.Pddd;
import com.whjbsoft.www.service.KfpdService;
import com.whjbsoft.www.servicei.KfpdServicei;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.Pageinfo;

public class PdddAction extends DispatchAction {
	private KfpdService service;
	public PdddAction(){
		this.setService(new KfpdServicei());
	}
	public KfpdService getService() {
		return service;
	}
	public void setService(KfpdService service) {
		this.service = service;
	}
	public ActionForward objList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			PdddForm pdddForm = (PdddForm) form;
			String rmMsg = request.getParameter("rmMsg");
			Integer ssxs = (Integer) request.getSession().getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
			Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
			String page = request.getParameter("page");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			if ("true".equals(rmMsg)) {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			StringBuffer sb = new StringBuffer(" and A.ssxs = ? and A.sssysz = ?");
			String con = (String) request.getSession().getAttribute("queryMsg");
			Pageinfo pageinfo = null;
			if (con != null) {
				sb.append(con);
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				pdddForm.setFieldName(fieldName);
				pdddForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPageinfo(djzj, Contants_st.pdd_query,sb.toString(), Integer.parseInt(page), ssxs, sssysz,"%" + fieldValue + "%");
			} else {
				pageinfo = this.getService().getPageinfo(sb.toString(), Integer.parseInt(page), ssxs, sssysz);				
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
		
			PdddForm pdddForm = (PdddForm) form;
			Integer ssxs = (Integer) request.getSession().getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
			Pddd vo = pdddForm.getVo();
			vo.setPdbh(FormateDate.formate("PD"));
			vo.setSsxs(ssxs);
			vo.setSssysz(sssysz);
			vo.setPdzt(0);
			this.saveToken(request);
			return mapping.findForward("gotoAdd");
		}
	public ActionForward addObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)){
				PdddForm pdddForm = (PdddForm) form;
				Pddd vo = pdddForm.getVo();
				Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				boolean flag = this.getService().save(djzj, Contants_st.pdd_add, vo);
				request.setAttribute("msg", flag?"信息录入成功!":"信息录入失败!");
				this.resetToken(request);
			}
			return mapping.findForward("success");
		}
	public ActionForward gotoUpd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			PdddForm pdddForm = (PdddForm) form;
			Pddd vo = this.getService().getPddd(pdddForm.getVo().getPdzj());
			pdddForm.setVo(vo);
			this.saveToken(request);
			return mapping.findForward("gotoUpd");
		}
	public ActionForward updObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)){
				PdddForm pdddForm = (PdddForm) form;
				Pddd vo = pdddForm.getVo();				
				Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				boolean flag = this.getService().update(djzj, Contants_st.pdd_upd, vo);
				request.setAttribute("msg", flag?"信息修改成功!":"信息修改失败!");
				this.resetToken(request);
			}
			return mapping.findForward("success");
		}
	public ActionForward delObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String[] ids = request.getParameterValues("pk");
			Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
			boolean flag = this.getService().delete(djzj, Contants_st.pdd_del, ids);
			request.setAttribute("msg",flag?"删除成功!":"删除失败!");
			return mapping.findForward("success");
		}
	public ActionForward viewObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			PdddForm pdddForm = (PdddForm) form;
			Pddd vo = this.getService().getPddd(pdddForm.getVo().getPdzj());
			pdddForm.setVo(vo);
			return mapping.findForward("gotoView");
		}
	public ActionForward valiList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			PdddForm pdddForm = (PdddForm) form;
			String rmMsg = request.getParameter("rmMsg");
			Integer ssxs = (Integer) request.getSession().getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
			String page = request.getParameter("page");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			if ("true".equals(rmMsg)) {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			StringBuffer sb = new StringBuffer(" and A.ssxs = ? and A.sssysz = ?");
			String con = (String) request.getSession().getAttribute("queryMsg");
			Pageinfo pageinfo = null;
			if (con != null) {
				sb.append(con);
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				pdddForm.setFieldName(fieldName);
				pdddForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPageinfo(sb.toString(), Integer.parseInt(page), ssxs, sssysz,"%" + fieldValue + "%");
			} else {
				pageinfo = this.getService().getPageinfo(sb.toString(), Integer.parseInt(page), ssxs, sssysz);				
			}
			request.setAttribute("pageinfo", pageinfo);
			return mapping.findForward("valiList");
	}
	public ActionForward queryList1(ActionMapping mapping, ActionForm form,
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
			return mapping.findForward("success1");
	}
	public ActionForward gotoVali(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			PdddForm pdddForm = (PdddForm) form;
			Pddd vo = this.getService().getPddd(pdddForm.getVo().getPdzj());
			pdddForm.setVo(vo);
			this.saveToken(request);
			return mapping.findForward("gotoVali");
	}
	public ActionForward valiObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)){
				PdddForm pdddForm = (PdddForm) form;
				Pddd vo =pdddForm.getVo();
				Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				boolean flag = this.getService().pdczState(djzj, Contants_st.pdd_zy, vo.getPdzj());
				request.setAttribute("msg", flag?"盘点成功!":"盘点失败!");
				this.resetToken(request);
			}
			return mapping.findForward("success1");
	}
	public ActionForward viewObject1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			PdddForm pdddForm = (PdddForm) form;
			Pddd vo = this.getService().getPddd(pdddForm.getVo().getPdzj());
			pdddForm.setVo(vo);
			return mapping.findForward("gotoView1");
	}
	public ActionForward viewObject2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			PdddForm pdddForm = (PdddForm) form;
			Pddd vo = this.getService().getPddd(pdddForm.getVo().getPdzj());
			pdddForm.setVo(vo);
			String hql = "from Kfcppdb A where A.pddd.pdzj=?";
			List list = this.getService().getObjects(hql,vo.getPdzj());
			request.setAttribute("list",list);
			return mapping.findForward("gotoView2");
	}
}