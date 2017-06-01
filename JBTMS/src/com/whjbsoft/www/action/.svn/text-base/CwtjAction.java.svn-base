package com.whjbsoft.www.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.CwtjForm;
import com.whjbsoft.www.service.CcCwtjService;
import com.whjbsoft.www.service.CwtjService;
import com.whjbsoft.www.servicei.CcCwtjServicei;
import com.whjbsoft.www.servicei.CwtjServicei;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.vo.ZdtjVo;

public class CwtjAction extends DispatchAction {
	private CwtjService service;
	private CcCwtjService ccCwtjServicei;
	public CcCwtjService getCcCwtjServicei() {
		return ccCwtjServicei;
	}
	public void setCcCwtjServicei(CcCwtjService ccCwtjServicei) {
		this.ccCwtjServicei = ccCwtjServicei;
	}
	public CwtjAction() {
		this.setService(new CwtjServicei());
		this.setCcCwtjServicei(new CcCwtjServicei());
	}

	public CwtjService getService() {
		return service;
	}

	public void setService(CwtjService service) {
		this.service = service;
	}
	
	public ActionForward objList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			CwtjForm cwtjForm = (CwtjForm) form;
			if (cwtjForm.getYear() == null || "".equals(cwtjForm.getYear())) {
				cwtjForm.setYear(FormateDate.appointFormat("yyyy", new Date()));
			}
			if (cwtjForm.getMonth() == null || "".equals(cwtjForm.getMonth())) {
				cwtjForm.setMonth(FormateDate.appointFormat("MM", new Date()));
			}
			if (cwtjForm.getType() == null || "".equals(cwtjForm.getType())) {
				cwtjForm.setType("pie");
			}
			HttpSession session = request.getSession();
			String con = " and A.ssxs = ? and A.sssysz = ? and A.tdsj like ?";
			Integer ssxs = (Integer) request.getSession()
					.getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute(
					"userSyszzj");
			String fileName = "";
			if ("pie".equals(cwtjForm.getType()))
				fileName = this.getService().getPieChartName(session, con,
						ssxs, sssysz,
						cwtjForm.getYear() + "-" + cwtjForm.getMonth() + "%");
			else
				fileName = this.getService().getBarChartName(session, con,
						ssxs, sssysz,
						cwtjForm.getYear() + "-" + cwtjForm.getMonth() + "%");
			StringBuffer path = new StringBuffer("./DisplayChart?filename=");
			path.append(fileName);
			request.setAttribute("ny", cwtjForm.getYear() + "-" + cwtjForm.getMonth());
			request.setAttribute("path", path);
			return mapping.findForward("success");
		}
	public ActionForward swCbCwtj(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			CwtjForm cwtjForm = (CwtjForm) form;
			if (cwtjForm.getYear() == null || "".equals(cwtjForm.getYear())) {
				cwtjForm.setYear(FormateDate.appointFormat("yyyy", new Date()));
			}
			if (cwtjForm.getMonth() == null || "".equals(cwtjForm.getMonth())) {
				cwtjForm.setMonth(FormateDate.appointFormat("MM", new Date()));
			}
			if (cwtjForm.getType() == null || "".equals(cwtjForm.getType())) {
				cwtjForm.setType("pie");
			}
			HttpSession session = request.getSession();
			String con = " and A.ssxs = ? and A.sssysz = ? ";
			Integer ssxs = (Integer) request.getSession()
					.getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute(
					"userSyszzj");
			String fileName = "";
			if ("pie".equals(cwtjForm.getType()))
				fileName = this.getService().getSwCbPieChartName(session,"",cwtjForm.getYear() + "-" + cwtjForm.getMonth() + "%" ,con,
						ssxs, sssysz);
			else
				fileName = this.getService().getSwCbBarChartName(session,"",cwtjForm.getYear() + "-" + cwtjForm.getMonth() + "%", con,
						ssxs, sssysz);
			StringBuffer path = new StringBuffer("./DisplayChart?filename=");
			path.append(fileName);
			request.setAttribute("path", path);
			request.setAttribute("ny", cwtjForm.getYear() + "-" + cwtjForm.getMonth());
			return mapping.findForward("swcbtjt");
		}
	
	public ActionForward swJlrCwtj(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			CwtjForm cwtjForm = (CwtjForm) form;
			if (cwtjForm.getYear() == null || "".equals(cwtjForm.getYear())) {
				cwtjForm.setYear(FormateDate.appointFormat("yyyy", new Date()));
			}
			if (cwtjForm.getMonth() == null || "".equals(cwtjForm.getMonth())) {
				cwtjForm.setMonth(FormateDate.appointFormat("MM", new Date()));
			}
			if (cwtjForm.getType() == null || "".equals(cwtjForm.getType())) {
				cwtjForm.setType("pie");
			}
			HttpSession session = request.getSession();
			String con = " and A.ssxs = ? and A.sssysz = ? ";
			Integer ssxs = (Integer) request.getSession()
					.getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute(
					"userSyszzj");
			String fileName = "";
			fileName = this.getService().getSwBarChartName(session,cwtjForm.getYear() + "-" + cwtjForm.getMonth() + "%", con,
						ssxs, sssysz);
			StringBuffer path = new StringBuffer("./DisplayChart?filename=");
			path.append(fileName);
			request.setAttribute("path", path);
			request.setAttribute("ny", cwtjForm.getYear() + "-" + cwtjForm.getMonth());
			return mapping.findForward("swjlrcwtjt");
		}
	
	public ActionForward swJlrBb(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String con = " and A.ssxs = ? and A.sssysz = ? ";
			Integer ssxs = (Integer) request.getSession()
					.getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute(
					"userSyszzj");
			String ny = request.getParameter("ny");
			ZdtjVo vo = this.getService().getSwZdtj(ny+"%", con, ssxs, sssysz);
			request.setAttribute("vo", vo);
			request.setAttribute("ny", ny);
			return mapping.findForward("swJlrbb");
		}
	
	public ActionForward swCbBb(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String con = " and A.ssxs = ? and A.sssysz = ? ";
			Integer ssxs = (Integer) request.getSession()
					.getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute(
					"userSyszzj");
			String ny = request.getParameter("ny");
			ZdtjVo vo = this.getService().getSwCbZdtj(ny+"%", con, ssxs, sssysz);
			request.setAttribute("vo", vo);
			request.setAttribute("ny", ny);
			return mapping.findForward("swcbbb");
		}
	
	public ActionForward swSrBb(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String con = " and A.ssxs = ? and A.sssysz = ? and A.tdsj like ?";
			Integer ssxs = (Integer) request.getSession()
					.getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute(
					"userSyszzj");
			String ny = request.getParameter("ny");
			ZdtjVo vo = this.getService().countCw(con, ssxs, sssysz,
					ny + "%");
			request.setAttribute("vo", vo);
			request.setAttribute("ny", ny);
			return mapping.findForward("swsrbb");
		}
	
	/**
	 * 收入统计
	 * Method ysLrCwtj
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * the ActionForward
	 */
	public ActionForward ysLrCwtj(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			CwtjForm cwtjForm = (CwtjForm) form;
			if (cwtjForm.getYear() == null || "".equals(cwtjForm.getYear())) {
				cwtjForm.setYear(FormateDate.appointFormat("yyyy", new Date()));
			}
			if (cwtjForm.getMonth() == null || "".equals(cwtjForm.getMonth())) {
				cwtjForm.setMonth(FormateDate.appointFormat("MM", new Date()));
			}
			if (cwtjForm.getType() == null || "".equals(cwtjForm.getType())) {
				cwtjForm.setType("pie");
			}
			HttpSession session = request.getSession();
			String con = " and A.ssxs = ? and A.sssysz = ? ";
			Integer ssxs = (Integer) request.getSession()
					.getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute(
					"userSyszzj");
			String fileName = "";
			String kind = request.getParameter("kind");
			String hzkind = "";
			if(kind!=null){
				if("ys".equals(kind)){
					hzkind = "运输";
				}else{
					hzkind = "配送";
				}
			}
			if ("pie".equals(cwtjForm.getType()))
				fileName = this.getService().getYsPieChartName(session,hzkind,cwtjForm.getYear() + "-" + cwtjForm.getMonth() + "%" ,con,
						ssxs, sssysz);
			else
				fileName = this.getService().getYsBarChartName(session,"",hzkind,cwtjForm.getYear() + "-" + cwtjForm.getMonth() + "%", con,
						ssxs, sssysz);
			StringBuffer path = new StringBuffer("./DisplayChart?filename=");
			path.append(fileName);
			request.setAttribute("path", path);
			request.setAttribute("kind", kind);
			request.setAttribute("ny", cwtjForm.getYear() + "-" + cwtjForm.getMonth());
			request.setAttribute("jrl", "");
			return mapping.findForward("yslrcwtjt");
		}
	
	
	/**
	 * 净利润统计
	 * Method ysJlrCwtj
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * the ActionForward
	 */
	public ActionForward ysJlrCwtj(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			CwtjForm cwtjForm = (CwtjForm) form;
			if (cwtjForm.getYear() == null || "".equals(cwtjForm.getYear())) {
				cwtjForm.setYear(FormateDate.appointFormat("yyyy", new Date()));
			}
			if (cwtjForm.getMonth() == null || "".equals(cwtjForm.getMonth())) {
				cwtjForm.setMonth(FormateDate.appointFormat("MM", new Date()));
			}
			if (cwtjForm.getType() == null || "".equals(cwtjForm.getType())) {
				cwtjForm.setType("pie");
			}
			HttpSession session = request.getSession();
			String con = " and A.ssxs = ? and A.sssysz = ? ";
			Integer ssxs = (Integer) request.getSession()
					.getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute(
					"userSyszzj");
			String fileName = "";
			String kind = request.getParameter("kind");
			String hzkind = "";
			if(kind!=null){
				if("ys".equals(kind)){
					hzkind = "运输";
				}else{
					hzkind = "配送";
				}
			}
			fileName = this.getService().getYsBarChartName(session,"jlr",hzkind,cwtjForm.getYear() + "-" + cwtjForm.getMonth() + "%", con,
						ssxs, sssysz);
			StringBuffer path = new StringBuffer("./DisplayChart?filename=");
			path.append(fileName);
			request.setAttribute("path", path);
			request.setAttribute("kind", kind);
			request.setAttribute("ny", cwtjForm.getYear() + "-" + cwtjForm.getMonth());
			request.setAttribute("jlr", "jlr");
			return mapping.findForward("yslrcwtjt");
		}
	/**
	 * 收入利润报表
	 * Method ysLrBb
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * the ActionForward
	 */
	public ActionForward ysLrBb(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String con = " and A.ssxs = ? and A.sssysz = ? ";
			Integer ssxs = (Integer) request.getSession()
					.getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute(
					"userSyszzj");
			String kind = request.getParameter("kind");
			String hzkind = "";
			if(kind!=null){
				if("ys".equals(kind)){
					hzkind = "运输";
				}else{
					hzkind = "配送";
				}
			}
			String ny = request.getParameter("ny");
			ZdtjVo vo = this.getService().getYsZdtj(hzkind, ny+"%", con, ssxs, sssysz);
			request.setAttribute("vo", vo);
			request.setAttribute("kind", kind);
			request.setAttribute("ny", ny);
			request.setAttribute("jlr", request.getParameter("jlr"));
			return mapping.findForward("yslrbb");
		}
	
	/**
	 * 成本统计
	 * Method ysCbCwtj
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * the ActionForward
	 */
	public ActionForward ysCbCwtj(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			CwtjForm cwtjForm = (CwtjForm) form;
			if (cwtjForm.getYear() == null || "".equals(cwtjForm.getYear())) {
				cwtjForm.setYear(FormateDate.appointFormat("yyyy", new Date()));
			}
			if (cwtjForm.getMonth() == null || "".equals(cwtjForm.getMonth())) {
				cwtjForm.setMonth(FormateDate.appointFormat("MM", new Date()));
			}
			if (cwtjForm.getType() == null || "".equals(cwtjForm.getType())) {
				cwtjForm.setType("pie");
			}
			HttpSession session = request.getSession();
			String con = " and A.ssxs = ? and A.sssysz = ? ";
			Integer ssxs = (Integer) request.getSession()
					.getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute(
					"userSyszzj");
			String fileName = "";
			String kind = request.getParameter("kind");
			String hzkind = "";
			if(kind!=null){
				if("ys".equals(kind)){
					hzkind = "运输";
				}else{
					hzkind = "配送";
				}
			}
			if ("pie".equals(cwtjForm.getType()))
				fileName = this.getService().getCbPieChartName(session,hzkind,cwtjForm.getYear() + "-" + cwtjForm.getMonth() + "%" ,con,
						ssxs, sssysz);
			else
				fileName = this.getService().getCbBarChartName(session,hzkind,cwtjForm.getYear() + "-" + cwtjForm.getMonth() + "%", con,
						ssxs, sssysz);
			StringBuffer path = new StringBuffer("./DisplayChart?filename=");
			path.append(fileName);
			request.setAttribute("path", path);
			request.setAttribute("kind", kind);
			request.setAttribute("ny", cwtjForm.getYear() + "-" + cwtjForm.getMonth());
			return mapping.findForward("yscbcwtjt");
		}
	
	/**
	 * 成本报表
	 * Method ysCbBb
	 * @author whjb
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * the ActionForward
	 */
	public ActionForward ysCbBb(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String con = " and A.ssxs = ? and A.sssysz = ? ";
			Integer ssxs = (Integer) request.getSession()
					.getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute(
					"userSyszzj");
			String kind = request.getParameter("kind");
			String hzkind = "";
			if(kind!=null){
				if("ys".equals(kind)){
					hzkind = "运输";
				}else{
					hzkind = "配送";
				}
			}
			String ny = request.getParameter("ny");
			ZdtjVo vo = this.getService().getCbZdtj(hzkind, ny+"%", con, ssxs, sssysz);
			request.setAttribute("vo", vo);
			request.setAttribute("kind", kind);
			request.setAttribute("ny", ny);
			return mapping.findForward("yscbbb");
	}
	public ActionForward ccCbCwtj(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			CwtjForm cwtjForm = (CwtjForm) form;
			if(cwtjForm.getYear()==null||"".equals(cwtjForm.getYear())){
				cwtjForm.setYear(FormateDate.appointFormat("yyyy",new Date()));
			}
			if(cwtjForm.getMonth()==null||"".equals(cwtjForm.getMonth())){
				cwtjForm.setMonth(FormateDate.appointFormat("MM",new Date()));
			}
			if(cwtjForm.getType()==null||"".equals(cwtjForm.getType())){
				cwtjForm.setType("pie");
			}
			HttpSession session = request.getSession();
			String con = " and A.ssxs = ? and A.sssysz = ? and A.tdsj like ? and (A.htlx = '外包合同' or A.htlx = '仓储合同')";
			Integer ssxs = (Integer) request.getSession().getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
			String fileName = "";
			if("pie".equals(cwtjForm.getType()))
				fileName = this.getCcCwtjServicei().getPieChartName(session, con, ssxs,sssysz,cwtjForm.getYear()+"-"+cwtjForm.getMonth()+"%");
			else
				fileName = this.getCcCwtjServicei().getBarChartName("",session, con, ssxs,sssysz,cwtjForm.getYear()+"-"+cwtjForm.getMonth()+"%");
			StringBuffer path = new StringBuffer("./DisplayChart?filename=");
			path.append(fileName);
			request.setAttribute("path",path);
			return mapping.findForward("ccCbList");
		}		
	
	public ActionForward ccLrCwtj(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			CwtjForm cwtjForm = (CwtjForm) form;
			if(cwtjForm.getYear()==null||"".equals(cwtjForm.getYear())){
				cwtjForm.setYear(FormateDate.appointFormat("yyyy",new Date()));
			}
			if(cwtjForm.getMonth()==null||"".equals(cwtjForm.getMonth())){
				cwtjForm.setMonth(FormateDate.appointFormat("MM",new Date()));
			}
			if(cwtjForm.getType()==null||"".equals(cwtjForm.getType())){
				cwtjForm.setType("bar");
			}
			HttpSession session = request.getSession();
			String con = " and A.ssxs = ? and A.sssysz = ? and A.tdsj like ? and (A.htlx = '外包合同' or A.htlx = '仓储合同')";
			Integer ssxs = (Integer) request.getSession().getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
			String fileName = "";
			fileName = this.getCcCwtjServicei().getBarChartName("lr",session, con, ssxs,sssysz,cwtjForm.getYear()+"-"+cwtjForm.getMonth()+"%");
			StringBuffer path = new StringBuffer("./DisplayChart?filename=");
			path.append(fileName);
			request.setAttribute("path",path);
			return mapping.findForward("ccLrList");
		}		
	
	public ActionForward cbPrint(ActionMapping mapping,ActionForm form ,
			HttpServletRequest request,HttpServletResponse response) {
		
			CwtjForm cwtjForm = (CwtjForm) form;
			String con = " and A.ssxs = ? and A.sssysz = ? and A.tdsj like ? and (A.htlx = '外包合同' or A.htlx = '仓储合同')";
			Integer ssxs = (Integer) request.getSession().getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
			ZdtjVo vo = this.getCcCwtjServicei().countCw(con, ssxs,sssysz,cwtjForm.getYear()+"-"+cwtjForm.getMonth()+"%");
			request.setAttribute("vo", vo);
			request.setAttribute("tjsj", cwtjForm.getYear()+"-"+cwtjForm.getMonth());
			return mapping.findForward("ccCbPrint");
		}
	public ActionForward lrPrint(ActionMapping mapping,ActionForm form ,
			HttpServletRequest request,HttpServletResponse response) {
		
			CwtjForm cwtjForm = (CwtjForm) form;
			String con = " and A.ssxs = ? and A.sssysz = ? and A.tdsj like ? and (A.htlx = '外包合同' or A.htlx = '仓储合同')";
			Integer ssxs = (Integer) request.getSession().getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
			ZdtjVo vo = this.getCcCwtjServicei().countCw(con, ssxs,sssysz,cwtjForm.getYear()+"-"+cwtjForm.getMonth()+"%");
			request.setAttribute("vo", vo);
			request.setAttribute("tjsj", cwtjForm.getYear()+"-"+cwtjForm.getMonth());
			return mapping.findForward("ccLrPrint");
		}
}