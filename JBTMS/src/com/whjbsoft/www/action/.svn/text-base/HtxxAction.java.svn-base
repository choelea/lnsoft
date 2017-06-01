package com.whjbsoft.www.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.HtxxForm;
import com.whjbsoft.www.po.Khdd;
import com.whjbsoft.www.po.Khht;
import com.whjbsoft.www.service.HtxxService;
import com.whjbsoft.www.servicei.HtxxServicei;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.Pageinfo;

public class HtxxAction extends DispatchAction {
	private HtxxService service;
	public HtxxService getService() {
		return service;
	}
	public void setService(HtxxService service) {
		this.service = service;
	}
	public HtxxAction() {
		service = new HtxxServicei();
	}
	
	public ActionForward getList(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			HtxxForm htxxForm = (HtxxForm) form;
			String rmMsg = request.getParameter("rmMsg");
			Integer ssxs = (Integer) request.getSession().getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
			Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
			int stzj = Contants_st.ht_query;
			String page = request.getParameter("page");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			if ("true".equals(rmMsg)) {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			StringBuffer sb = new StringBuffer(
					" and (A.ssxs = ? and A.sssysz = ? or A.ssxs = 0 and A.sssysz = 0)");
			String con = (String) request.getSession().getAttribute("queryMsg");
			if (con != null) {
				sb.append(con);
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				htxxForm.setFieldName(fieldName);
				htxxForm.setFieldValue(fieldValue);
				Pageinfo pageinfo = this.getService().getPagedata(djzj, stzj,
						sb.toString(), Integer.parseInt(page), ssxs, sssysz,
						"%" + fieldValue + "%");
				request.setAttribute("pageinfo", pageinfo);
			} else {
				Pageinfo pageinfo = this.getService().getPagedata(
						sb.toString(), Integer.parseInt(page), ssxs, sssysz);
				request.setAttribute("pageinfo", pageinfo);
			}
			this.saveToken(request);
			return mapping.findForward("listPage");
		}
	
	public ActionForward goSave(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			HtxxForm htxxForm = (HtxxForm) form;
			Khht vo = htxxForm.getVo();
			vo.setHtbh(FormateDate.formate("HT"));
			vo.setTdsj(FormateDate.formate());
			this.saveToken(request);
			return mapping.findForward("savePage");
	}
	
	public ActionForward save(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			if (this.isTokenValid(request)) {
				HtxxForm htxxForm = (HtxxForm) form;
				int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				int stzj = Contants_st.ht_add;
				Khht khht = htxxForm.getVo();
				Khdd khdd = htxxForm.getKhdd();
				khht.setKhdd(khdd);
				boolean flag = this.getService().save(djzj, stzj, khht);
				request.setAttribute("msg", flag ? "客户合同添加成功!" : "客户合同添加失败!");
				this.resetToken(request);
			}			
			return mapping.findForward("getList");
	}
	
	public ActionForward goUpdate(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			HtxxForm htxxForm = (HtxxForm) form;
			String pk = request.getParameter("pk");
			Khht khht = this.getService().getHtxx(Integer.parseInt(pk));
			Khdd khdd = khht.getKhdd();
			htxxForm.setVo(khht);
			htxxForm.setKhdd(khdd);
			request.setAttribute("ddzj", khdd.getDdzj());
			this.saveToken(request);
			return mapping.findForward("updatePage");
		}
	
	public ActionForward update(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			if (this.isTokenValid(request)) {
				HtxxForm htxxForm = (HtxxForm) form;
				int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				int ktzj = Contants_st.ht_upd;
				Khht vo = htxxForm.getVo();
				Khdd khdd = htxxForm.getKhdd();
				vo.setKhdd(khdd);
				boolean flag = this.getService().update(djzj, ktzj, vo);
				request.setAttribute("msg", flag ? "客户合同修改成功!" : "客户合同修改失败!");
				this.resetToken(request);
			}			
			return mapping.findForward("getList");
	}
	
	public ActionForward delete(ActionMapping mapping ,ActionForm form,
			HttpServletRequest request ,HttpServletResponse response ) {
			if (this.isTokenValid(request)) {
				String[] pks = request.getParameterValues("pk");
				int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				int ktzj = Contants_st.ht_del;
				boolean flag = this.getService().delete(djzj, ktzj, pks);
				request.setAttribute("msg", flag ? "客户合同删除成功!" : "客户合同删除失败!");
				this.resetToken(request);
			}			
			return mapping.findForward("getList");
	}
	
	public ActionForward view(ActionMapping mapping ,ActionForm form,HttpServletRequest request,HttpServletResponse response) {
			HtxxForm htxxForm = (HtxxForm) form;
			String pk = request.getParameter("pk");
			Khht vo = this.getService().getHtxx(Integer.parseInt(pk));
			Khdd khdd = vo.getKhdd();
			htxxForm.setVo(vo);
			htxxForm.setKhdd(khdd);
			request.setAttribute("ddzj", khdd.getDdzj());
			return mapping.findForward("viewPage");
		}
	
	public ActionForward query(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if(fieldName != null && !"".equals(fieldName) && fieldValue != null && !"".equals(fieldValue)) {
				StringBuffer sb = new StringBuffer();
				sb.append(" and A.").append(fieldName).append(" like ?");
				request.getSession().setAttribute("fieldName", fieldName);
				request.getSession().setAttribute("fieldValue", fieldValue);
				request.getSession().setAttribute("queryMsg", sb.toString());
			}else {
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
				request.getSession().removeAttribute("queryMsg");
			}
			return mapping.findForward("getList");
	}
	
}