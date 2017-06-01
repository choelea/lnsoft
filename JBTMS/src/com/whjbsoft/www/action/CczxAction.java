/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.whjbsoft.www.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.CrkddForm;
import com.whjbsoft.www.po.Crkdd;
import com.whjbsoft.www.po.Crkhp;
import com.whjbsoft.www.service.CczxService;
import com.whjbsoft.www.service.CrkddService;
import com.whjbsoft.www.servicei.CczxServicei;
import com.whjbsoft.www.servicei.CrkddServicei;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.Pageinfo;
import com.whjbsoft.www.vo.Szcw;

/** 
 * MyEclipse Struts
 * Creation date: 12-09-2009
 * 
 * XDoclet definition:
 * @struts.action path="/cczx" name="cczxForm" parameter="method" scope="request"
 */
public class CczxAction extends DispatchAction {
	
	private CczxService service;
	private CrkddService crkService;
	
	
	/*
	 * Generated Methods
	 */

	/**
	 * @return the crkService
	 */
	public CrkddService getCrkService() {
		return crkService;
	}


	/**
	 * @param crkService the crkService to set
	 */
	public void setCrkService(CrkddService crkService) {
		this.crkService = crkService;
	}


	/**
	 * 
	 */
	public CczxAction() {
		super();
		this.setService(new CczxServicei());
		this.setCrkService(new CrkddServicei());
	}


	/**
	 * @return the service
	 */
	public CczxService getService() {
		return service;
	}


	/**
	 * @param service the service to set
	 */
	public void setService(CczxService service) {
		this.service = service;
	}


	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward getJsList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String page = request.getParameter("page");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			Integer userPk = (Integer) request.getSession().getAttribute(
					"userPk");
			Integer userSyszzj = (Integer) request.getSession().getAttribute(
					"userSyszzj");
			String rmMsg = request.getParameter("rmMsg");
			if ("true".equals(rmMsg)) {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			String con = (String) request.getSession().getAttribute("queryMsg");
			if (con != null) {
				String fieldValue = (String) request.getSession().getAttribute(
						"fieldValue");
				String fieldName = (String) request.getSession().getAttribute(
						"fieldName");
				CrkddForm crkddForm = (CrkddForm) form;
				crkddForm.setFieldName(fieldName);
				crkddForm.setFieldValue(fieldValue);
				Pageinfo pageinfo = this.getService().getPagedata(
						con+" and ddzt>? ", Integer.parseInt(page),
						userPk, userSyszzj,"%" + fieldValue + "%", 1);
				request.setAttribute("pageinfo", pageinfo);
			} else {
				Pageinfo pageinfo = this.getService().getPagedata(
						" and ddzt>? ", Integer.parseInt(page),
						userPk, userSyszzj, 1);
				request.setAttribute("pageinfo", pageinfo);
			}
			this.saveToken(request);
			return mapping.findForward("listJsPage");
		}
	
	public ActionForward queryJsList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			StringBuffer sb = new StringBuffer();
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if (fieldName != null && !"".equals(fieldName)
					&& fieldValue != null && !"".equals(fieldValue)) {
				sb.append(" and ").append(fieldName).append(" like ?");
				request.getSession().setAttribute("fieldName", fieldName);
				request.getSession().setAttribute("fieldValue", fieldValue);
				request.getSession().setAttribute("queryMsg", sb.toString());
			} else {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			return mapping.findForward("getJsList");
		}
	
	
	@SuppressWarnings("unchecked")
	public ActionForward goJs(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CrkddForm crkddForm = (CrkddForm) form;
		String pk = request.getParameter("pk");
		Crkdd crkdd = this.getCrkService().getCrkdd(Integer.parseInt(pk));
		if("入库".equals(crkdd.getDdlx())){
			if (crkdd.getKhht() != null) {
				request.setAttribute("htmc", crkdd.getKhht().getHtmc());
				request.setAttribute("htzj", crkdd.getKhht().getHtzj());
			}
			if (crkdd.getCrkhps() != null) {
				List<Crkhp> list = new ArrayList<Crkhp>(crkdd.getCrkhps());
				Collections.sort(list);
				request.setAttribute("list", list);
			}
			crkddForm.setVo(crkdd);
		} else {
			if (crkdd.getKhht() != null) {
				request.setAttribute("crkddbh", this.getCrkService().getRkddbh(
						crkdd.getKhht().getHtzj()));
			}
			if (crkdd.getCrkhps() != null) {
				List<Crkhp> list = new ArrayList<Crkhp>(crkdd.getCrkhps());
				Collections.sort(list);
				request.setAttribute("list", list);
			}
			crkddForm.setVo(crkdd);
		}
		request.setAttribute("orderKind", crkdd.getDdlx());
		return mapping.findForward("jsPage");
	}
	public ActionForward jsObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if (this.isTokenValid(request)) {
				CrkddForm crkddForm = (CrkddForm) form;
				int djzj = (Integer) request.getSession().getAttribute(
						"userDjxxzj");
				Crkdd crkdd = this.getCrkService().getCrkddNoLazy(crkddForm.getVo().getCrkzj());
				crkdd.setDdzt(3);
				int stzj=0;
				if("入库".equals(crkdd.getDdlx())){
					stzj=Contants_st.rkd_js;
				}else{
					stzj=Contants_st.ckd_js;
				}
				boolean flag = this.crkService.update(djzj, stzj, crkdd);
				request.setAttribute("msg", flag?"接受成功！":"接受失败！");
				this.resetToken(request);
			}
			return mapping.findForward("getJsList");
	}
	
	
	
	public ActionForward viewObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CrkddForm crkddForm = (CrkddForm) form;
		String pk = request.getParameter("pk");
		String kind = request.getParameter("kind");
		Crkdd rkdd = this.getCrkService().getCrkdd(Integer.parseInt(pk));
		
		if (rkdd.getCrkhps() != null) {
			List<Crkhp> list = new ArrayList<Crkhp>(rkdd.getCrkhps());
			Collections.sort(list);
			request.setAttribute("list", list);
		}
		crkddForm.setVo(rkdd);
		request.setAttribute("ddzt", rkdd.getDdzt());
		request.setAttribute("kind", kind);
		if("入库".equals(rkdd.getDdlx())){
			if (rkdd.getKhht() != null) {
				request.setAttribute("htmc", rkdd.getKhht().getHtmc());
				request.setAttribute("htzj", rkdd.getKhht().getHtzj());
			}
			return mapping.findForward("viewRcPage");
		}else{
			if (rkdd.getKhht() != null) {
				if (rkdd.getKhht() != null) {
					request.setAttribute("rkddbh", this.getCrkService().getRkddbh(
							rkdd.getKhht().getHtzj()));
				}
			}
			return mapping.findForward("viewCcPage");
	}
	}
	
	/**
	 * 质检信息列表
	 * Method getZjList
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * the ActionForward
	 */
	public ActionForward getZjList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String page = request.getParameter("page");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			Integer userPk = (Integer) request.getSession().getAttribute(
					"userPk");
			Integer userSyszzj = (Integer) request.getSession().getAttribute(
					"userSyszzj");
			String rmMsg = request.getParameter("rmMsg");
			if ("true".equals(rmMsg)) {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			String con = (String) request.getSession().getAttribute("queryMsg");
			if (con != null) {
				String fieldValue = (String) request.getSession().getAttribute(
						"fieldValue");
				String fieldName = (String) request.getSession().getAttribute(
						"fieldName");
				CrkddForm crkddForm = (CrkddForm) form;
				crkddForm.setFieldName(fieldName);
				crkddForm.setFieldValue(fieldValue);
				Pageinfo pageinfo = this.getService().getPagedata(
						con+" and (A.ddlx=? and A.ddzt>? or A.ddlx=? and A.ddzt>? ) ", Integer.parseInt(page),
						userPk, userSyszzj,"%" + fieldValue + "%", "入库",2,"出库",3);
				request.setAttribute("pageinfo", pageinfo);
			} else {
				Pageinfo pageinfo = this.getService().getPagedata(
						" and (A.ddlx=? and A.ddzt>? or A.ddlx=? and A.ddzt>? ) ", Integer.parseInt(page),
						userPk, userSyszzj, "入库",2,"出库",3);
				request.setAttribute("pageinfo", pageinfo);
			}
			this.saveToken(request);
			return mapping.findForward("listZjPage");
		}
	
	public ActionForward queryZjList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			StringBuffer sb = new StringBuffer();
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if (fieldName != null && !"".equals(fieldName)
					&& fieldValue != null && !"".equals(fieldValue)) {
				sb.append(" and ").append(fieldName).append(" like ?");
				request.getSession().setAttribute("fieldName", fieldName);
				request.getSession().setAttribute("fieldValue", fieldValue);
				request.getSession().setAttribute("queryMsg", sb.toString());
			} else {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			return mapping.findForward("getZjList");
		}
	
	/**
	 * 跳转到质检页面
	 * Method gozJ
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * the ActionForward
	 */
	@SuppressWarnings("unchecked")
	public ActionForward goZj(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CrkddForm crkddForm = (CrkddForm) form;
		String pk = request.getParameter("pk");
		Crkdd crkdd = this.getCrkService().getCrkdd(Integer.parseInt(pk));
		if("入库".equals(crkdd.getDdlx())){
			if (crkdd.getKhht() != null) {
				request.setAttribute("htmc", crkdd.getKhht().getHtmc());
				request.setAttribute("htzj", crkdd.getKhht().getHtzj());
			}
			if (crkdd.getCrkhps() != null) {
				List<Crkhp> list = new ArrayList<Crkhp>(crkdd.getCrkhps());
				Collections.sort(list);
				request.setAttribute("list", list);
			}
			crkddForm.setVo(crkdd);
		} else {
			if (crkdd.getKhht() != null) {
				if (crkdd.getKhht() != null) {
					request.setAttribute("crkddbh", this.getCrkService().getRkddbh(
							crkdd.getKhht().getHtzj()));
				}
			}
			if (crkdd.getCrkhps() != null) {
				List<Crkhp> list = new ArrayList<Crkhp>(crkdd.getCrkhps());
				Collections.sort(list);
				request.setAttribute("list", list);
			}
			crkddForm.setVo(crkdd);
		}
		crkddForm.getVo().setZjbh(FormateDate.formate("ZJ"));
		crkddForm.getVo().setZjsj(FormateDate.formate());
		request.setAttribute("orderKind", crkdd.getDdlx());
		return mapping.findForward("zjPage");
	}
	/**
	 * 质检
	 * Method zjObject
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * the ActionForward
	 */
	public ActionForward zjObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if (this.isTokenValid(request)) {
				CrkddForm crkddForm = (CrkddForm) form;
				int djzj = (Integer) request.getSession().getAttribute(
						"userDjxxzj");
				Crkdd crkdd = this.getCrkService().getCrkddNoLazy(crkddForm.getVo().getCrkzj());
				crkdd.setZjbh(crkddForm.getVo().getZjbh());
				crkdd.setZjsj(crkddForm.getVo().getZjsj());
				String[] hpzj = request.getParameterValues("hpzj");
				String[] hgsl = request.getParameterValues("hgsl");
				int stzj=0;
				if("入库".equals(crkdd.getDdlx())){
					stzj=Contants_st.rkd_zj;
					crkdd.setDdzt(4);
				}else{
					stzj=Contants_st.ckd_zj;
					crkdd.setDdzt(5);
				}
				boolean flag = this.getService().zhijian(djzj, stzj, crkdd, hpzj, hgsl);
				request.setAttribute("msg", flag?"质检成功！":"质检失败！");
				this.resetToken(request);
			}
			return mapping.findForward("getZjList");
		}
	
	public ActionForward getCrkList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String page = request.getParameter("page");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			Integer userPk = (Integer) request.getSession().getAttribute(
					"userPk");
			Integer userSyszzj = (Integer) request.getSession().getAttribute(
					"userSyszzj");
			String rmMsg = request.getParameter("rmMsg");
			if ("true".equals(rmMsg)) {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			String con = (String) request.getSession().getAttribute("queryMsg");
			if (con != null) {
				String fieldValue = (String) request.getSession().getAttribute(
						"fieldValue");
				String fieldName = (String) request.getSession().getAttribute(
						"fieldName");
				CrkddForm crkddForm = (CrkddForm) form;
				crkddForm.setFieldName(fieldName);
				crkddForm.setFieldValue(fieldValue);
				Pageinfo pageinfo = this.getService().getPagedata(
						con+" and (A.ddlx=? and A.ddzt>? or A.ddlx=? and A.ddzt>? ) ", Integer.parseInt(page),
						userPk, userSyszzj, "%" + fieldValue + "%","入库",3,"出库",2);
				request.setAttribute("pageinfo", pageinfo);
			} else {
				Pageinfo pageinfo = this.getService().getPagedata(
						" and (A.ddlx=? and A.ddzt>? or A.ddlx=? and A.ddzt>? ) ", Integer.parseInt(page),
						userPk, userSyszzj, "入库",3,"出库",2);
				request.setAttribute("pageinfo", pageinfo);
			}
			
			this.saveToken(request);
			return mapping.findForward("listCrkPage");
		}
	public ActionForward queryCrkList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			StringBuffer sb = new StringBuffer();
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if (fieldName != null && !"".equals(fieldName)
					&& fieldValue != null && !"".equals(fieldValue)) {
				sb.append(" and ").append(fieldName).append(" like ?");
				request.getSession().setAttribute("fieldName", fieldName);
				request.getSession().setAttribute("fieldValue", fieldValue);
				request.getSession().setAttribute("queryMsg", sb.toString());
			} else {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			return mapping.findForward("getCrkList");
		}
	@SuppressWarnings("unchecked")
	public ActionForward goCrk(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CrkddForm crkddForm = (CrkddForm) form;
		String pk = request.getParameter("pk");
		Crkdd crkdd = this.getCrkService().getCrkdd(Integer.parseInt(pk));
		if("入库".equals(crkdd.getDdlx())){
			if (crkdd.getKhht() != null) {
				request.setAttribute("htmc", crkdd.getKhht().getHtmc());
				request.setAttribute("htzj", crkdd.getKhht().getHtzj());
			}
			if (crkdd.getCrkhps() != null) {
				List<Crkhp> list = new ArrayList<Crkhp>(crkdd.getCrkhps());
				Collections.sort(list);
				request.setAttribute("list", list);
			}
			crkddForm.setVo(crkdd);
			return mapping.findForward("rkPage");
		} else {
			if (crkdd.getKhht() != null) {
				request.setAttribute("crkddbh", this.getCrkService().getRkddbh(
						crkdd.getKhht().getHtzj()));
			}
			if (crkdd.getCrkhps() != null) {
				List<Crkhp> list = new ArrayList<Crkhp>(crkdd.getCrkhps());
				Collections.sort(list);
				request.setAttribute("list", list);
			}
			crkddForm.setVo(crkdd);
			return mapping.findForward("ckPage");
		}
	}
	/**
	 * 入库操作
	 * Method rkObject
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * the ActionForward
	 */
	public ActionForward rkObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if (this.isTokenValid(request)) {
				CrkddForm crkddForm = (CrkddForm) form;
				int djzj = (Integer) request.getSession().getAttribute(
						"userDjxxzj");
				String [] crhpbh = request.getParameterValues("crhpbh");
				String [] crhpzj = request.getParameterValues("crhpzj");
				List<Szcw> list = new ArrayList<Szcw>();
				if(crhpbh!=null){
					for(int i=0;i<crhpbh.length;i++){
						String []cwzj = request.getParameterValues("cwzj"+crhpbh[i]);
						String []hgsl = request.getParameterValues("hgsl"+crhpbh[i]);
						String []shsl = request.getParameterValues("shsl"+crhpbh[i]);
						Szcw szcw = new Szcw(crhpzj[i],cwzj,hgsl,shsl);
						list.add(szcw);
					}
				}
				boolean flag = this.getService().rkcz(djzj, Contants_st.rkd_sj,crkddForm.getVo().getCrkzj(), list);
				request.setAttribute("msg", flag?"入库成功！":"入库失败！");
				this.resetToken(request);
			}
			return mapping.findForward("getCrkList");
		}
	/**
	 * 出库操作
	 * Method ckObject
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * the ActionForward
	 */
	public ActionForward ckObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if (this.isTokenValid(request)) {
				CrkddForm crkddForm = (CrkddForm) form;
				int djzj = (Integer) request.getSession().getAttribute(
						"userDjxxzj");
				String [] crhpbh = request.getParameterValues("crhpbh");
				String [] crhpzj = request.getParameterValues("crhpzj");
				List<Szcw> list = new ArrayList<Szcw>();
				if(crhpbh!=null){
					for(int i=0;i<crhpbh.length;i++){
						String []cwzj = request.getParameterValues("cwzj"+crhpbh[i]);
						String []hgsl = request.getParameterValues("hgsl"+crhpbh[i]);
						String []shsl = request.getParameterValues("shsl"+crhpbh[i]);
						Szcw szcw = new Szcw(crhpzj[i],cwzj,hgsl,shsl);
						list.add(szcw);
					}
				}
				boolean flag = this.getService().ckcz(djzj, Contants_st.ckd_xj,crkddForm.getVo().getCrkzj(), list);
				request.setAttribute("msg", flag?"出库成功！":"出库失败！");
				this.resetToken(request);
			}
			return mapping.findForward("getCrkList");
		}
	}
