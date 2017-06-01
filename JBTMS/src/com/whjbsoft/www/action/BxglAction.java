package com.whjbsoft.www.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.BxglForm;
import com.whjbsoft.www.po.Bxlc;
import com.whjbsoft.www.po.Bxxx;
import com.whjbsoft.www.service.BxglService;
import com.whjbsoft.www.servicei.BxglServicei;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.Pageinfo;
@SuppressWarnings("unchecked")
public class BxglAction extends DispatchAction {
	private BxglService service;

	public BxglService getService() {
		return service;
	}
	public void setService(BxglService service) {
		this.service = service;
	}
	public BxglAction() {
		service = new BxglServicei();
	}

	public ActionForward getList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			int sysz = (Integer) request.getSession().getAttribute("userSyszzj");
			int ssxs = (Integer) request.getSession().getAttribute("userPk");
			int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
			int ktzj = Contants_st.bx_query;
			String rmMsg = request.getParameter("rmMsg");
			String page = request.getParameter("page");
			String con = null;
			if ("".equals(page) || page == null) {
				page = "1";
			}
			if ("true".equals(rmMsg)) {
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
				request.getSession().removeAttribute("queryMsg");
			} else {
				con = (String) request.getSession().getAttribute("queryMsg");
			}
			Pageinfo pageinfo = null;
			StringBuffer sb = new StringBuffer();
			sb.append(" and (sssysz = ? and ssxs = ? or sssysz = 0 and ssxs = 0) ");
			if (con == null) {
				pageinfo = this.getService().getPageinfo(sb.toString(),
						Integer.parseInt(page),sysz, ssxs);
			} else {
				BxglForm bgdForm = (BxglForm) form;
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				bgdForm.setFieldName(fieldName);
				bgdForm.setFieldValue(fieldValue);
				sb.append(con);
				pageinfo = this.getService().getPageinfo1(sb.toString(),
							Integer.parseInt(page),djzj,ktzj, sysz, ssxs,"%" + fieldValue + "%");
			}
			request.setAttribute("pageinfo", pageinfo);
			this.saveToken(request);
			return mapping.findForward("listPage");
		}

	public ActionForward goSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			request.setAttribute("autoBh", FormateDate.formate("BX"));
			this.saveToken(request);
			return mapping.findForward("savePage");
		}

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)) {
				int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				int ktzj = Contants_st.bx_add;
				String[] tcdq = request.getParameterValues("diqu");
				String[] tccx = request.getParameterValues("tdcx");
				BxglForm bxglForm = (BxglForm) form;
				boolean flag = this.getService().save(bxglForm.getVo(),tcdq,tccx,djzj,ktzj);
				String msg = flag?"班线添加成功!":"班线添加失败!";
				request.setAttribute("msg", msg);
			}
			request.getSession().removeAttribute("queryMsg");
			this.resetToken(request);
			return mapping.findForward("getList");
		}

	public ActionForward goUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String pk = request.getParameter("pk");
			Bxxx bxgl = this.getService().getBxgl(Integer.parseInt(pk));
			BxglForm bxglForm = (BxglForm) form;
			bxglForm.setVo(bxgl);
			Set<Bxlc> set = bxgl.getBxlcs();
			List<Bxlc> list = new ArrayList<Bxlc>(set); 
			Collections.sort(list,new Comparator(){
				public int compare(Object obj1, Object obj2) {
					Bxlc bx1 = (Bxlc)obj1;
					Bxlc bx2 = (Bxlc)obj2;
					return bx1.getTksx()-bx2.getTksx();
				}
			});
			request.setAttribute("list", list);
			this.saveToken(request);
			return mapping.findForward("updatePage");
		}

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)) {
				int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				int ktzj = Contants_st.bx_upd;
				String[] tcdq = request.getParameterValues("diqu");
				String[] tccx = request.getParameterValues("tdcx");
				BxglForm bxglForm = (BxglForm) form;
				boolean flag = this.getService().update(bxglForm.getVo(),tcdq,tccx,djzj,ktzj);
				String msg = flag?"班线修改成功!":"班线修改失败!";
				request.setAttribute("msg", msg);
			}
			request.getSession().removeAttribute("queryMsg");
			this.resetToken(request);
			return mapping.findForward("getList");
		}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)) {
				int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				int ktzj = Contants_st.bx_del;
				String[] pks = request.getParameterValues("pk");
				boolean flag = this.getService().delete(pks,djzj,ktzj);
				String msg = flag?"班线删除成功!":"班线删除失败!";
				request.setAttribute("msg", msg);
			}
			request.getSession().removeAttribute("queryMsg");
			this.resetToken(request);
			return mapping.findForward("getList");
		}
	
	public ActionForward view(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) {
		
			String pk = request.getParameter("pk");
			Bxxx bxgl = this.getService().getBxgl(Integer.parseInt(pk));
			BxglForm bxglForm = (BxglForm) form;
			bxglForm.setVo(bxgl);
			Set<Bxlc> set = bxgl.getBxlcs();
			List<Bxlc> list = new ArrayList<Bxlc>(set); 
			Collections.sort(list,new Comparator(){
				public int compare(Object obj1, Object obj2) {
					Bxlc bx1 = (Bxlc)obj1;
					Bxlc bx2 = (Bxlc)obj2;
					return bx1.getTksx()-bx2.getTksx();
				}
			});
			request.setAttribute("list", list);
			return mapping.findForward("viewPage");
		}

	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if(fieldName != null && !"".equals(fieldName) && fieldValue != null && !"".equals(fieldValue)) {
				StringBuffer sb = new StringBuffer();
				sb.append(" and ").append(fieldName).append(" like ? ");
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