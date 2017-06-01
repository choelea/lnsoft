package com.whjbsoft.www.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.SendForm;
import com.whjbsoft.www.po.Khdd;
import com.whjbsoft.www.po.Khht;
import com.whjbsoft.www.po.Khxx;
import com.whjbsoft.www.po.Yspsd;
import com.whjbsoft.www.service.SendService;
import com.whjbsoft.www.servicei.SendServicei;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.Pageinfo;

public class YspsAction extends DispatchAction{
	private SendService service;
	public SendService getService() {
		return service;
	}

	public void setService(SendService service) {
		this.service = service;
	}
	public YspsAction() {
		service = new SendServicei();
	}
	
	public ActionForward getList(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			int ssxs = (Integer)request.getSession().getAttribute("userPk");
			int sssysz = (Integer)request.getSession().getAttribute("userSyszzj");
			String page = request.getParameter("page");
			String rmMsg = request.getParameter("rmMsg");
			String address = request.getParameter("address");
			if (address == null) {
				address = (String) request.getAttribute("address");
			}
			if(page == null || "".equals(page)) {
				page = "1";
			}
			String con = null;
			if("true".equals(rmMsg)) {
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
				request.getSession().removeAttribute("queryMsg");
			}else {
				con = (String) request.getSession().getAttribute("queryMsg");
			}
			Pageinfo pageinfo = null;
			StringBuffer sb = new StringBuffer();
			sb.append(" and (A.ssxs = ? and A.sssysz = ? or A.ssxs = 0 and A.sssysz = 0) and A.yszt >= ?");
			Integer curGwzj = (Integer)request.getSession().getAttribute("curGwzj");
			if(curGwzj==2){
				sb.append(" and A.ysdlx='运输'");
			}else if(curGwzj==3){
				sb.append(" and A.ysdlx='配送'");
			}
			int yszt ;
			if("feiyong".equals(address)) {
				yszt = 1;
			}else {
				yszt = 3;
			}
			if(con == null) {
				pageinfo = this.getService().getPagedata(sb.toString(),
						Integer.parseInt(page), ssxs,sssysz,yszt);
			}else {
				sb.append(con);
				SendForm yspsdForm = (SendForm) form;
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				yspsdForm.setFieldName(fieldName);
				yspsdForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPagedata(sb.toString(), 
						Integer.parseInt(page), ssxs,sssysz,yszt,"%" + fieldValue + "%");
			}
			request.setAttribute("pageinfo", pageinfo);
			this.saveToken(request);
			if("feiyong".equals(address)) {
				return mapping.findForward("feiyongList");
			}else {
				return mapping.findForward("qsList");
			}
	}
	
	public ActionForward goCharge(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse respon) {
		
			SendForm sendForm = (SendForm) form;
			Yspsd vo = this.getService().getYspsdxx(sendForm.getVo().getYsdzj());
			Khht khht = vo.getKhht();
			Khdd khdd = khht.getKhdd();
			sendForm.setVo(vo);
			sendForm.setKhht(khht);
			Khxx dhf = khdd.getKhxxByKhzj();
			Khxx shf = khdd.getKhxxByKhxKhzj();
			sendForm.setDhf(dhf);
			sendForm.setShf(shf);
			request.setAttribute("ddzj", khdd.getDdzj());
			request.setAttribute("ysdlx", vo.getYsdlx());
			this.saveToken(request);
			return mapping.findForward("feiyongCharge");
	}
	
	public ActionForward charge(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			String address = request.getParameter("address");
			if (this.isTokenValid(request)) {
				SendForm sendForm = (SendForm) form;
				int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				int ktzj = 0;
				String ysdlx = sendForm.getVo().getYsdlx();
				if ("配送".equals(ysdlx)) {
					ktzj = Contants_st.psd_tz;
				} else {
					ktzj = Contants_st.ysd_tz;
				}
				Yspsd vo = sendForm.getVo();
				Khht khht = sendForm.getKhht();
				vo.setKhht(khht);
				boolean flag = this.getService().update(djzj, ktzj, vo);
				request.setAttribute("msg", flag ? ysdlx + "订单费用调整成功!" : ysdlx
						+ "订单费用调整失败!");
				this.resetToken(request);
			}			
			request.setAttribute("address", address);
			return mapping.findForward("getList");
	}
	
	public ActionForward goQs(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse respon) {
		
			SendForm sendForm = (SendForm) form;
			Yspsd vo = this.getService().getYspsdxx(sendForm.getVo().getYsdzj());
			Khht khht = vo.getKhht();
			Khdd khdd = khht.getKhdd();
			sendForm.setVo(vo);
			sendForm.setKhht(khht);
			Khxx dhf = khdd.getKhxxByKhzj();
			Khxx shf = khdd.getKhxxByKhxKhzj();
			sendForm.setDhf(dhf);
			sendForm.setShf(shf);
			request.setAttribute("ddzj", khdd.getDdzj());
			request.setAttribute("ysdlx", vo.getYsdlx());
			this.saveToken(request);
			return mapping.findForward("qsPage");
	}
	
	public ActionForward ddqs(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			String address = request.getParameter("address");
			if (this.isTokenValid(request)) {
				SendForm sendForm = (SendForm) form;
				int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				int ktzj = 0;
				String ysdlx = sendForm.getVo().getYsdlx();
				if ("配送".equals(ysdlx)) {
					ktzj = Contants_st.psd_qs;
				} else {
					ktzj = Contants_st.ysd_qs;
				}
				Yspsd vo = sendForm.getVo();
				Khht khht = sendForm.getKhht();
				vo.setKhht(khht);
				boolean flag = this.getService().ddqs(djzj, ktzj, vo);
				request.setAttribute("msg", flag ? "订单签收成功!" : "订单签收失败!");
				this.resetToken(request);
			}			
			request.setAttribute("address", address);
			return mapping.findForward("getList");
	}
	
	public ActionForward view(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			String address = request.getParameter("address");
			SendForm sendForm = (SendForm) form;
			Yspsd vo = this.getService().getYspsdxx(sendForm.getVo().getYsdzj());
			Khht khht = vo.getKhht();
			Khdd khdd = khht.getKhdd();
			sendForm.setVo(vo);
			sendForm.setKhht(khht);
			Khxx dhf = khdd.getKhxxByKhzj();
			Khxx shf = khdd.getKhxxByKhxKhzj();
			sendForm.setDhf(dhf);
			sendForm.setShf(shf);
			request.setAttribute("ddzj", khdd.getDdzj());
			request.setAttribute("ysdlx", vo.getYsdlx());
			if("feiyong".equals(address)) {
				return mapping.findForward("feiyongView");
			}else {
				return mapping.findForward("qsView");
			}
	}
	
	public ActionForward query(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			String address = request.getParameter("address");
			if (fieldName != null && !"".equals(fieldName)
					&& fieldValue != null && !"".equals(fieldValue)) {
				StringBuffer sb = new StringBuffer();
				sb.append(" and ").append(fieldName).append(" like ?");
				request.getSession().setAttribute("fieldName", fieldName);
				request.getSession().setAttribute("fieldValue", fieldValue);
				request.getSession().setAttribute("queryMsg", sb.toString());
			} else {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			request.setAttribute("address", address);
			return mapping.findForward("getList");
	}

}