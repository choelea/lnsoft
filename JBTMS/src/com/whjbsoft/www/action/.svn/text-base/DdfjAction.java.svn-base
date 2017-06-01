package com.whjbsoft.www.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.YsddForm;
import com.whjbsoft.www.po.Bxxx;
import com.whjbsoft.www.po.Ysddxx;
import com.whjbsoft.www.po.Yspsd;
import com.whjbsoft.www.service.YsddService;
import com.whjbsoft.www.servicei.YsddServicei;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.Pageinfo;

public class DdfjAction extends DispatchAction {
	private YsddService service;

	public YsddService getService() {
		return service;
	}

	public void setService(YsddService service) {
		this.service = service;
	}
	public DdfjAction() {
		service = new YsddServicei();
	}
	
	public ActionForward getList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			YsddForm ysddForm = (YsddForm) form;
			String page = request.getParameter("page");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			Integer userPk = (Integer) request.getSession().getAttribute(
					"userPk");
			Integer userSyszzj = (Integer) request.getSession().getAttribute(
					"userSyszzj");
			String rmMsg = request.getParameter("rmMsg");
			String con = null;
			if ("true".equals(rmMsg)) {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}else {
				con = (String) request.getSession().getAttribute("queryMsg");
			}
			StringBuffer sb = new StringBuffer();
			sb.append(" and (A.ssxs = ? and A.sssysz = ? or A.ssxs = 0 and A.sssysz = 0) ");
			if(con == null) {
				Pageinfo pageinfo = this.getService().getPageinfo(sb.toString(),
						Integer.parseInt(page), userPk, userSyszzj);
				request.setAttribute("pageinfo", pageinfo);
			}else {
				sb.append(con);
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				ysddForm.setFieldName(fieldName);
				ysddForm.setFieldValue(fieldValue);
				Pageinfo pageinfo = this.getService().getPageinfo(sb.toString(),
						Integer.parseInt(page), userPk, userSyszzj,"%" + fieldValue + "%");
				request.setAttribute("pageinfo", pageinfo);
			}
			this.saveToken(request);
			return mapping.findForward("listPage");
		}
	
	public ActionForward goSave(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response ) {
		
			YsddForm ysddForm = (YsddForm) form;
			ysddForm.getVo().setYsddbh(FormateDate.formate("FD"));
			this.saveToken(request);
			return mapping.findForward("savePage");
		}
	
	public ActionForward save(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response ) {
		
			if (this.isTokenValid(request)) {
				YsddForm ysddForm = (YsddForm) form;
				int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				int ktzj = 0;
				Ysddxx vo = ysddForm.getVo();
				if("运输".equals(vo.getYsddlx())) {
					ktzj = Contants_st.ysdd_add;
				}else {
					ktzj = Contants_st.psdd_add;
				}
				Bxxx bxxx = ysddForm.getBxxx();
				List<Yspsd> ysdList = ysddForm.getYddd();
				boolean flag = this.getService().save(vo, djzj, ktzj,ysdList,bxxx.getBxzj());
				request.setAttribute("msg", flag?"调度单添加成功!":"调度单添加失败!");
				this.resetToken(request);
			}			
			return mapping.findForward("getList");
		}
	
	public ActionForward ddfc(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			YsddForm ysddForm = (YsddForm) form;
			int djzj = (Integer)request.getSession().getAttribute("userDjxxzj");
			int ktzj = Contants_st.ysdd_fc;
			boolean flag = this.getService().fc(ysddForm.getVo().getYsddzj(), djzj, ktzj);
			request.setAttribute("msg", flag?"发车成功!":"发车失败!");
			return mapping.findForward("getList");
		}
	
	public ActionForward view(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response ) {
		
			YsddForm ysddForm = (YsddForm) form;
			List list = this.getService().getList(ysddForm.getVo().getYsddzj());
			List yspsdVo = (List) list.get(2);
			Ysddxx vo = (Ysddxx) list.get(3);
			ysddForm.setVo(vo);
			ysddForm.setBxxx((Bxxx) list.get(0));
			request.setAttribute("tddq", list.get(1));
			request.setAttribute("yspsd", yspsdVo);
			request.setAttribute("ysddzj", vo.getYsddzj());
			return mapping.findForward("viewPage");
		}
	
	public ActionForward delete(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response ) {
		
			if (this.isTokenValid(request)) {
				String[] pks = request.getParameterValues("pk");
				boolean flag = this.getService().delete(pks, 0, 0);
				request.setAttribute("msg", flag ? "调度单删除成功!" : "调度单删除失败!");
				this.resetToken(request);
			}			
			return mapping.findForward("getList");
		}
	
	public ActionForward query(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if(fieldName != null && !"".equals(fieldName) && 
					fieldValue != null && !"".equals(fieldValue)) {
				StringBuffer sb = new StringBuffer();
				sb.append(" and A.").append(fieldName).append(" like ? ");
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

