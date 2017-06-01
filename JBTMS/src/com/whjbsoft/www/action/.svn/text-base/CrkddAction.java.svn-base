package com.whjbsoft.www.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.CrkddForm;
import com.whjbsoft.www.po.Crkdd;
import com.whjbsoft.www.po.Crkhp;
import com.whjbsoft.www.service.CrkddService;
import com.whjbsoft.www.servicei.CrkddServicei;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.Pageinfo;
import com.whjbsoft.www.vo.DdVo;
public class CrkddAction extends DispatchAction {

	private CrkddService service;

	/**
	 * 
	 */
	public CrkddAction() {
		this.setService(new CrkddServicei());
	}
	/**
	 * Method getList 得到出入库订单列表
	 * 
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return the ActionForward
	 */
	public ActionForward getList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			CrkddForm crkddForm = (CrkddForm) form;
			int djzj = (Integer) request.getSession()
					.getAttribute("userDjxxzj");
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
			String orderKind = request.getParameter("orderKind");
			if (orderKind == null) {
				orderKind = "";
			}
			String ork = orderKind;
			int stzj=0;
			if ("rkdd".equals(orderKind)) {
				stzj = Contants_st.rkd_query;
				orderKind = "入库";
			} else {
				stzj = Contants_st.ckd_query;
				orderKind = "出库";
			}
			String con = (String) request.getSession().getAttribute("queryMsg");
			if (con != null) {
				String fieldValue = (String) request.getSession().getAttribute(
						"fieldValue");
				String fieldName = (String) request.getSession().getAttribute(
						"fieldName");
				crkddForm.setFieldName(fieldName);
				Pageinfo pageinfo = this.getService().getPagedata(
						con + " and A.ddlx=?", djzj, stzj,
						Integer.parseInt(page), userPk, userSyszzj,
						"%" + fieldValue + "%", orderKind);
				request.setAttribute("pageinfo", pageinfo);
			} else {
				Pageinfo pageinfo = this.getService().getPagedata(
						"and A.ddlx=?", djzj, 0, Integer.parseInt(page),
						userPk, userSyszzj, orderKind);
				request.setAttribute("pageinfo", pageinfo);
			}
			this.saveToken(request);
			request.setAttribute("orderKind", ork);
			return mapping.findForward("listPage");
		}
	/**
	 * Method queryList 按条件查询
	 * 
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return the ActionForward
	 */
	public ActionForward queryList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			StringBuffer sb = new StringBuffer();
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if (fieldName != null && !"".equals(fieldName)
					&& fieldValue != null && !"".equals(fieldValue)) {
				sb.append(" and A.").append(fieldName).append(" like ?");
				request.getSession().setAttribute("fieldName", fieldName);
				request.getSession().setAttribute("fieldValue", fieldValue);
				request.getSession().setAttribute("queryMsg", sb.toString());
			} else {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			return mapping.findForward("getList");
		}
	
	/**
	 * Method goAdd 跳转到添加页面
	 * 
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return the ActionForward
	 */
	public ActionForward goAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String orderKind = request.getParameter("orderKind");
			if (orderKind == null) {
				orderKind = "";
			}
			CrkddForm crkddForm = (CrkddForm) form;
			if ("rkdd".equals(orderKind)) {
				crkddForm.getVo().setDdbh(FormateDate.formate("RK"));
				Random random = new Random();
				int Int = random.nextInt(899999) + 100000;
				crkddForm.getVo().setKhzlh(String.valueOf(Int));
				crkddForm.getVo().setXdsj(FormateDate.formate());
				this.saveToken(request);
				request.setAttribute("orderKind", orderKind);
				return mapping.findForward("addRcPage");
			} else if ("ckdd".equals(orderKind)) {
				crkddForm.getVo().setDdbh(FormateDate.formate("CK"));
				crkddForm.getVo().setXdsj(FormateDate.formate());
				this.saveToken(request);
				request.setAttribute("orderKind", orderKind);
				return mapping.findForward("addCcPage");
			} else {
				return mapping.findForward("error");
			}

		}
	
	/**
	 * 保存出入库订单信息 Method saveObject
	 * 
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return the ActionForward
	 */
	public ActionForward saveObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if (this.isTokenValid(request)) {
				CrkddForm crkddForm = (CrkddForm) form;
				String orderKind = request.getParameter("orderKind");
				int djzj = (Integer) request.getSession().getAttribute(
						"userDjxxzj");
				if ("rkdd".equals(orderKind)) {
					String htzj = request.getParameter("htzj");
					Crkdd rkdd = crkddForm.getVo();
					boolean flag = this.getService().save(djzj,
							Contants_st.rkd_add, rkdd, htzj, orderKind);
					request.setAttribute("msg", flag ? "入库订单添加成功！"
							: "入库订单添加失败！");
					this.resetToken(request);
				} else {
					String htzj = request.getParameter("htzj");
					Crkdd rkdd = crkddForm.getVo();
					boolean flag = this.getService().save(djzj,
							Contants_st.ckd_add, rkdd, htzj, orderKind);
					request.setAttribute("msg", flag ? "出库订单添加成功！"
							: "出库订单添加失败！");
					this.resetToken(request);
				}
			}
			// 防止搜索栏填入了信息而返回页面无法显示刚刚添加的信息
			request.getSession().removeAttribute("queryMsg");
			request.getSession().removeAttribute("fieldName");
			request.getSession().removeAttribute("fieldValue");
			return mapping.findForward("getList");
		}

	/**
	 * 跳转到修改页面 Method goUpdate
	 * 
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return the ActionForward
	 */
	@SuppressWarnings("unchecked")
	public ActionForward goUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CrkddForm crkddForm = (CrkddForm) form;
		String pk = request.getParameter("pk");
		String orderKind = request.getParameter("orderKind");
		if (orderKind != null && "rkdd".equals(orderKind)) {// 入库订单
			Crkdd rkdd = this.getService().getCrkdd(Integer.parseInt(pk));
			if (rkdd.getKhht() != null) {
				request.setAttribute("htmc", rkdd.getKhht().getHtmc());
				request.setAttribute("htzj", rkdd.getKhht().getHtzj());
			}
			if (rkdd.getCrkhps() != null) {
				List<Crkhp> list = new ArrayList<Crkhp>(rkdd.getCrkhps());
				Collections.sort(list);
				request.setAttribute("list", list);
			}
			crkddForm.setVo(rkdd);
			request.setAttribute("orderKind", orderKind);
			return mapping.findForward("updateRcPage");
		} else {// 出库订单
			Crkdd rkdd = this.getService().getCrkdd(Integer.parseInt(pk));
			if (rkdd.getKhht() != null) {
				if (rkdd.getKhht() != null) {
					request.setAttribute("rkddbh", this.getService().getRkddbh(
							rkdd.getKhht().getHtzj()));
				}
			}
			if (rkdd.getCrkhps() != null) {
				List<Crkhp> list = new ArrayList<Crkhp>(rkdd.getCrkhps());
				Collections.sort(list);
				request.setAttribute("list", list);
			}
			crkddForm.setVo(rkdd);
			request.setAttribute("orderKind", orderKind);
			return mapping.findForward("updateCcPage");
		}
	}
	
	/**
	 * 修改出入库订单信息 Method updateObject
	 * 
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return the ActionForward
	 */
	public ActionForward updateObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if (this.isTokenValid(request)) {
				CrkddForm crkddForm = (CrkddForm) form;
				String orderKind = request.getParameter("orderKind");
				int djzj = (Integer) request.getSession().getAttribute(
						"userDjxxzj");
				Crkdd rkdd = crkddForm.getVo();
				Crkdd rkddpo = this.getService().getCrkdd(rkdd.getCrkzj());
				rkddpo.setJjcd(rkdd.getJjcd());
				rkddpo.setKfmc(rkdd.getKfmc());
				rkddpo.setSykfzj(rkdd.getSykfzj());
				rkddpo.setYjcrksj(rkdd.getYjcrksj());
				rkddpo.setCrkfs(rkdd.getCrkfs());
				rkddpo.setCrklx(rkdd.getCrklx());
				if ("rkdd".equals(orderKind)) {
					boolean flag = this.getService().update(djzj,
							Contants_st.rkd_upd, rkddpo);
					request.setAttribute("msg", flag ? "入库订单修改成功！"
							: "入库订单修改失败！");
				}else{
					boolean flag = this.getService().update(djzj,
							Contants_st.ckd_upd, rkddpo);
					request.setAttribute("msg", flag ? "出库订单修改成功！"
							: "出库订单修改失败！");
				}
			}
			return mapping.findForward("getList");
		}
	
	/**
	 * 查看出入库订单信息 Method viewObject
	 * 
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return the ActionForward
	 */
	@SuppressWarnings("unchecked")
	public ActionForward viewObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CrkddForm crkddForm = (CrkddForm) form;
		String pk = request.getParameter("pk");
		String orderKind = request.getParameter("orderKind");
		String backPath = request.getParameter("backPath");
		if(backPath!=null){
			request.setAttribute("backPath",backPath);
		}
		if (orderKind != null && "rkdd".equals(orderKind)) {
			Crkdd rkdd = this.getService().getCrkdd(Integer.parseInt(pk));
			if (rkdd.getKhht() != null) {
				request.setAttribute("htmc", rkdd.getKhht().getHtmc());
				request.setAttribute("htzj", rkdd.getKhht().getHtzj());
			}
			if (rkdd.getCrkhps() != null) {
				List<Crkhp> list = new ArrayList<Crkhp>(rkdd.getCrkhps());
				Collections.sort(list);
				request.setAttribute("list", list);
			}
			crkddForm.setVo(rkdd);
			request.setAttribute("orderKind", orderKind);
			request.setAttribute("ddzt", rkdd.getDdzt());
			return mapping.findForward("viewRcPage");
		} else {
			Crkdd rkdd = this.getService().getCrkdd(Integer.parseInt(pk));
			if (rkdd.getKhht() != null) {
				if (rkdd.getKhht() != null) {
					request.setAttribute("rkddbh", this.getService().getRkddbh(
							rkdd.getKhht().getHtzj()));
				}
			}
			if (rkdd.getCrkhps() != null) {
				List<Crkhp> list = new ArrayList<Crkhp>(rkdd.getCrkhps());
				Collections.sort(list);
				request.setAttribute("list", list);
			}
			crkddForm.setVo(rkdd);
			request.setAttribute("orderKind", orderKind);
			request.setAttribute("ddzt", rkdd.getDdzt());;
			return mapping.findForward("viewCcPage");
		}
	}
	
	/**
	 * 删除出入库订单 Method delObject
	 * 
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return the ActionForward
	 */
	public ActionForward delObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String orderKind = request.getParameter("orderKind");
			if (isTokenValid(request)) {
				int djzj = (Integer) request.getSession().getAttribute(
						"userDjxxzj");
				String[] pk = request.getParameterValues("pk");
				int stzj = 0;
				if("rkdd".equals(orderKind)){
					stzj=Contants_st.rkd_del;
				}else{
					stzj=Contants_st.ckd_del;
				}
				boolean flag = this.getService().delCrkdd(djzj,
						stzj, pk);
				request.setAttribute("msg", flag ? "订单删除成功！" : "订单删除失败！");
				// 防止搜索栏填入了信息而返回页面无法显示刚刚添加的信息
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			request.setAttribute("orderKind", orderKind);
			return mapping.findForward("getList");
		}
	
	/**
	 * 生成作业计划 Method goWork
	 * 
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return the ActionForward
	 */
	public ActionForward goWork(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
			String pk = request.getParameter("crkpk");
			Crkdd rkddpo = this.getService().getCrkdd(Integer.parseInt(pk));
			if(rkddpo!=null){
				rkddpo.setDdzt(1);
			}
			boolean flag = this.getService().update(djzj,0, rkddpo);
			request.setAttribute("msg", flag ? "分拣成功！" : "分拣失败！");
			return mapping.findForward("success");
		}
	
	
	/**
	 * 得到调度信息列表 Method getDDList
	 * 
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return the ActionForward
	 */
	public ActionForward getDdList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			int djzj = (Integer) request.getSession()
					.getAttribute("userDjxxzj");
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
						con+" and ddzt>? ", djzj, 0, Integer.parseInt(page),
						userPk, userSyszzj,"%" + fieldValue + "%", 0);
				request.setAttribute("pageinfo", pageinfo);
			} else {
				Pageinfo pageinfo = this.getService().getPagedata(
						" and ddzt>? ", djzj, 0, Integer.parseInt(page),
						userPk, userSyszzj, 0);
				request.setAttribute("pageinfo", pageinfo);
			}
			this.saveToken(request);
			return mapping.findForward("listDdPage");
		}
	
	public ActionForward goDd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String pk = request.getParameter("pk");
		Crkdd crkdd = this.getService().getCrkddNoLazy(Integer.parseInt(pk));
		request.setAttribute("vo", crkdd);
		this.saveToken(request);
		return mapping.findForward("ddPage");
	}
	
	public ActionForward dDu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(isTokenValid(request)){
				CrkddForm crkddForm = (CrkddForm) form;
				int djzj = (Integer) request.getSession()
				.getAttribute("userDjxxzj");
				int stzj =0;
				if("入库".equals(crkddForm.getVo().getDdlx())){
					stzj = Contants_st.rkd_dd;
				}else{
					stzj = Contants_st.ckd_dd;
				}
				String zjryzj = request.getParameter("zjryzj");
				String []ccryzj = request.getParameterValues("ccryzj");
				String []sbzj = request.getParameterValues("sbzj");
				boolean flag = this.getService().Dd(djzj,stzj,crkddForm.getVo().getCrkzj(), zjryzj, ccryzj, sbzj);
				request.setAttribute("msg", flag?"调度成功！":"调度失败！");
				this.resetToken(request);
			}
			return mapping.findForward("getDdList");
		}
	/**
	 * 调度查询
	 * Method queryDdList
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * the ActionForward
	 */
	public ActionForward queryDdList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			StringBuffer sb = new StringBuffer();
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if (fieldName != null && !"".equals(fieldName)
					&& fieldValue != null && !"".equals(fieldValue)) {
				sb.append(" and A.").append(fieldName).append(" like ?");
				request.getSession().setAttribute("fieldName", fieldName);
				request.getSession().setAttribute("fieldValue", fieldValue);
				request.getSession().setAttribute("queryMsg", sb.toString());
			} else {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			return mapping.findForward("getDdList");
		}
	
	@SuppressWarnings("unchecked")
	public ActionForward dDViewObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String pk = request.getParameter("pk");
		DdVo ddvo = this.getService().getCrkddDdInfo(Integer.parseInt(pk));
		request.setAttribute("vo", ddvo.getCrkdd());
		request.setAttribute("ygList", ddvo.getYgList());
		request.setAttribute("sbList", ddvo.getSbList());
		return mapping.findForward("viewDdPage");
	}
	
	public ActionForward objList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			CrkddForm crkddForm = (CrkddForm) form;
			int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
			String page = request.getParameter("page");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			Integer userPk = (Integer) request.getSession().getAttribute("userPk");
			Integer userSyszzj = (Integer) request.getSession().getAttribute("userSyszzj");
			String rmMsg = request.getParameter("rmMsg");
			if ("true".equals(rmMsg)) {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			int stzj=0;
			String con = (String) request.getSession().getAttribute("queryMsg");
			if (con != null) {
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				crkddForm.setFieldName(fieldName);
				Pageinfo pageinfo = this.getService().getPagedata(con, djzj, stzj,Integer.parseInt(page), userPk, userSyszzj,"%" + fieldValue + "%");
				request.setAttribute("pageinfo", pageinfo);
			} else {
				Pageinfo pageinfo = this.getService().getPagedata("", djzj, 0, Integer.parseInt(page),userPk, userSyszzj);
				request.setAttribute("pageinfo", pageinfo);
			}
			return mapping.findForward("objList");
		}
	/**
	 * Method queryList 按条件查询
	 * 
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return the ActionForward
	 */
	public ActionForward queryList1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			StringBuffer sb = new StringBuffer();
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if (fieldName != null && !"".equals(fieldName)
					&& fieldValue != null && !"".equals(fieldValue)) {
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
	/**
	 * @return the service
	 */
	public CrkddService getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(CrkddService service) {
		this.service = service;
	}
}