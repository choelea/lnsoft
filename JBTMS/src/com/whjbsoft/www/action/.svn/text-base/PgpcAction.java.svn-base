package com.whjbsoft.www.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.YsddForm;
import com.whjbsoft.www.po.Bxxx;
import com.whjbsoft.www.po.Ygxx;
import com.whjbsoft.www.po.Ylxx;
import com.whjbsoft.www.po.Ysddxx;
import com.whjbsoft.www.service.YsddService;
import com.whjbsoft.www.servicei.YsddServicei;
import com.whjbsoft.www.util.Pageinfo;

public class PgpcAction extends DispatchAction {
	private YsddService service;

	public YsddService getService() {
		return service;
	}

	public void setService(YsddService service) {
		this.service = service;
	}
	public PgpcAction() {
		service = new YsddServicei();
	}

	public ActionForward getList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			int sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
			int ssxs = (Integer) request.getSession().getAttribute("userPk");
			String page = request.getParameter("page");
			if(page == null || "".equals(page)) {
				page = "1";
			}
			String rmMsg = request.getParameter("rmMsg");
			String con = null;
			if("true".equals(rmMsg)) {
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
				request.getSession().removeAttribute("queryMsg");
			}else {
				con = (String) request.getSession().getAttribute("queryMsg");
			}
			StringBuffer sb = new StringBuffer();
			sb.append(" and (A.ssxs = ? and A.sssysz = ? or A.ssxs = 0 and A.sssysz = 0) and A.ysddzt >= ?");
			Pageinfo pageinfo = null;
			if(con == null) {
				pageinfo = this.getService().getPageinfo(sb.toString(), Integer.parseInt(page), ssxs,sssysz,0);
			}else {
				sb.append(con);
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				YsddForm ysddForm = (YsddForm) form;
				ysddForm.setFieldName(fieldName);
				ysddForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPageinfo(sb.toString(), 
						Integer.parseInt(page), ssxs,sssysz,0,"%" + fieldValue + "%");
			}
			request.setAttribute("pageinfo", pageinfo);
			this.saveToken(request);
			return mapping.findForward("listPage");
	}
	
	public ActionForward view(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse respones) {
			YsddForm ysddForm = (YsddForm) form;
			Map<String, Object> map = this.getService().getMap(ysddForm.getVo().getYsddzj());
			List yspsdVo = (List) map.get("yspsd");
			Ysddxx vo = (Ysddxx) map.get("ysddxx");
			ysddForm.setYdcl((List<Ylxx>) map.get("clxx"));
			ysddForm.setYdry((List<Ygxx>) map.get("ygxx"));
			ysddForm.setVo(vo);
			ysddForm.setBxxx((Bxxx) map.get("bxxx"));
			request.setAttribute("tddq", map.get("tddq"));
			request.setAttribute("yspsd", yspsdVo);
			request.setAttribute("type", request.getParameter("type"));
			return mapping.findForward("viewPage");
	}
	
	public ActionForward query(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if(fieldName != null && !"".equals(fieldName)
					&& fieldValue != null && !"".equals(fieldValue)) {
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
	public ActionForward ddfc(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			YsddForm ysddForm = (YsddForm) form;
			int djzj = (Integer)request.getSession().getAttribute("userDjxxzj");
			boolean flag = this.getService().fc(ysddForm.getVo().getYsddzj(), djzj, 0);
			request.setAttribute("msg", flag?"发车成功!":"发车失败!");
			return this.getFcList(mapping, form, request, response);
	}
	
	public ActionForward getZcList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			int sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
			int ssxs = (Integer) request.getSession().getAttribute("userPk");
			String page = request.getParameter("page");
			if(page == null || "".equals(page)) {
				page = "1";
			}
			String rmMsg = request.getParameter("rmMsg");
			String con = null;
			if("true".equals(rmMsg)) {
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
				request.getSession().removeAttribute("queryMsg");
			}else {
				con = (String) request.getSession().getAttribute("queryMsg");
			}
			StringBuffer sb = new StringBuffer();
			sb.append(" and (A.ssxs = ? and A.sssysz = ? or A.ssxs = 0 and A.sssysz = 0) and A.ysddzt >= ? and sfpg=1 and sfpc=1");
			Pageinfo pageinfo = null;
			if(con == null) {
				pageinfo = this.getService().getPageinfo(sb.toString(), Integer.parseInt(page), ssxs,sssysz,0);
			}else {
				sb.append(con);
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				YsddForm ysddForm = (YsddForm) form;
				ysddForm.setFieldName(fieldName);
				ysddForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPageinfo(sb.toString(), 
						Integer.parseInt(page), ssxs,sssysz,0,"%" + fieldValue + "%");
			}
			request.setAttribute("pageinfo", pageinfo);
			this.saveToken(request);
			return mapping.findForward("listZcPage");
	}
	
	public ActionForward queryZc(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if(fieldName != null && !"".equals(fieldName)
					&& fieldValue != null && !"".equals(fieldValue)) {
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
			return this.getZcList(mapping, form, request, response);
	}
	
	public ActionForward ysdZc(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			YsddForm ysddForm = (YsddForm) form;
			int djzj = (Integer)request.getSession().getAttribute("userDjxxzj");
			boolean flag = this.getService().ysdZc(ysddForm.getVo().getYsddzj(), djzj, 0);
			request.setAttribute("msg", flag?"装车成功!":"装车失败!");
			return this.getZcList(mapping, form, request, response);
	}
	
	
	public ActionForward getFcList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			int sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
			int ssxs = (Integer) request.getSession().getAttribute("userPk");
			String page = request.getParameter("page");
			if(page == null || "".equals(page)) {
				page = "1";
			}
			String rmMsg = request.getParameter("rmMsg");
			String con = null;
			if("true".equals(rmMsg)) {
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
				request.getSession().removeAttribute("queryMsg");
			}else {
				con = (String) request.getSession().getAttribute("queryMsg");
			}
			StringBuffer sb = new StringBuffer();
			sb.append(" and (A.ssxs = ? and A.sssysz = ? or A.ssxs = 0 and A.sssysz = 0) and A.ysddzt > ?");
			Pageinfo pageinfo = null;
			if(con == null) {
				pageinfo = this.getService().getPageinfo(sb.toString(), Integer.parseInt(page), ssxs,sssysz,0);
			}else {
				sb.append(con);
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				YsddForm ysddForm = (YsddForm) form;
				ysddForm.setFieldName(fieldName);
				ysddForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPageinfo(sb.toString(), 
						Integer.parseInt(page), ssxs,sssysz,0,"%" + fieldValue + "%");
			}
			request.setAttribute("pageinfo", pageinfo);
			this.saveToken(request);
			return mapping.findForward("listFcPage");
	}
	public ActionForward queryFc(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if(fieldName != null && !"".equals(fieldName)
					&& fieldValue != null && !"".equals(fieldValue)) {
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
			return this.getFcList(mapping, form, request, response);
	}
}