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
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.Pageinfo;

public class SendAction extends DispatchAction{
	private SendService service;
	public SendService getService() {
		return service;
	}

	public void setService(SendService service) {
		this.service = service;
	}
	public SendAction() {
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
			sb.append(" and (A.ssxs = ? and A.sssysz = ? or A.ssxs = 0 and A.sssysz = 0) ");
			if(con == null) {
				pageinfo = this.getService().getPagedata(sb.toString(),
						Integer.parseInt(page), ssxs,sssysz);
			}else {
				int djzj = (Integer)request.getSession().getAttribute("userDjxxzj");
				int ktzj = 0;
				if("send".equals(address)) {
					ktzj = Contants_st.psd_query;
				}else {
					ktzj = Contants_st.ysd_query;
				}
				sb.append(con);
				SendForm yspsdForm = (SendForm) form;
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				yspsdForm.setFieldName(fieldName);
				yspsdForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPagedata(djzj, ktzj, sb.toString(), 
						Integer.parseInt(page), ssxs,sssysz,"%" + fieldValue + "%");
			}
			request.setAttribute("pageinfo", pageinfo);
			this.saveToken(request);
			if("send".equals(address)) {
				return mapping.findForward("sendList");
			}else {
				return mapping.findForward("traList");
		}
	}
	
	public ActionForward goSave(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			String address = request.getParameter("address");
			if (address == null) {
				address = (String) request.getAttribute("address");
			}
			SendForm sendForm = (SendForm) form;
			if("send".equals(address)) {
				sendForm.getVo().setYsdbh(FormateDate.formate("PS"));
				sendForm.getVo().setZdsj(FormateDate.formate());
				return mapping.findForward("sendSave");
			}else {
				sendForm.getVo().setYsdbh(FormateDate.formate("YS"));
				sendForm.getVo().setZdsj(FormateDate.formate());
				return mapping.findForward("traSave");
			}
	}
	
	public ActionForward save(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			String address = request.getParameter("address");
			if (this.isTokenValid(request)) {
				SendForm sendForm = (SendForm) form;
				int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				int ktzj = 0;
				String kind = "";
				if ("send".equals(address)) {
					ktzj = Contants_st.psd_add;
					kind = "配送";
				} else {
					ktzj = Contants_st.ysd_add;
					kind = "运输";
				}
				Yspsd vo = sendForm.getVo();
				Khht khht = sendForm.getKhht();
				vo.setKhht(khht);
				boolean flag = this.getService().save(djzj, ktzj, vo);
				request.setAttribute("msg", flag ? kind + "订单添加成功!" : kind
						+ "订单添加失败!");
				this.resetToken(request);
			}			
			request.setAttribute("address", address);
			return mapping.findForward("getList");
	}
	
	public ActionForward goUpdate(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			String address = request.getParameter("address");
			String pk = request.getParameter("pk");
			SendForm sendForm = (SendForm) form;
			Yspsd vo = this.getService().getYspsdxx(Integer.parseInt(pk));
			Khht khht = vo.getKhht();
			Khdd khdd = khht.getKhdd();
			sendForm.setVo(vo);
			sendForm.setKhht(khht);
			Khxx dhf = khdd.getKhxxByKhzj();
			Khxx shf = khdd.getKhxxByKhxKhzj();
			sendForm.setDhf(dhf);
			sendForm.setShf(shf);
			request.setAttribute("ddzj", khdd.getDdzj());
			this.saveToken(request);
			if("send".equals(address)) {
				return mapping.findForward("sendUpdate");
			}else {
				return mapping.findForward("traUpdate");
			}
	}
	
	public ActionForward update(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			String address = request.getParameter("address");
			if (this.isTokenValid(request)) {
				SendForm sendForm = (SendForm) form;
				int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				int ktzj = 0;
				String kind = "";
				if ("send".equals(address)) {
					ktzj = Contants_st.psd_upd;
					kind = "配送";
				} else {
					ktzj = Contants_st.ysd_upd;
					kind = "运输";
				}
				Yspsd vo = sendForm.getVo();
				Khht khht = sendForm.getKhht();
				vo.setKhht(khht);
				boolean flag = this.getService().update(djzj, ktzj, vo);
				request.setAttribute("msg", flag ? kind + "订单修改成功!" : kind
						+ "订单修改失败!");
				this.resetToken(request);
			}			
			request.setAttribute("address", address);
			return mapping.findForward("getList");
	}
	
	public ActionForward task(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			String address = request.getParameter("address");
			int djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
			int ktzj = 0;
			String kind = "";
			if ("send".equals(address)) {
				ktzj = Contants_st.psd_zy;
				kind = "配送";
			} else {
				ktzj = Contants_st.ysd_zy;
				kind = "运输";
			}
			String pk = request.getParameter("pk");
			boolean flag = this.getService().task(djzj, ktzj, Integer.parseInt(pk));
			request.setAttribute("msg", flag ? kind + "订单分拣成功!" : kind
					+ "订单分拣失败!");
			request.setAttribute("address", address);
			return mapping.findForward("success1");
	}
	
	public ActionForward view(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			String address = request.getParameter("address");
			String pk = request.getParameter("pk");
			SendForm sendForm = (SendForm) form;
			Yspsd vo = this.getService().getYspsdxx(Integer.parseInt(pk));
			Khht khht = vo.getKhht();
			Khdd khdd = khht.getKhdd();
			sendForm.setVo(vo);
			sendForm.setKhht(khht);
			Khxx dhf = khdd.getKhxxByKhzj();
			Khxx shf = khdd.getKhxxByKhxKhzj();
			sendForm.setDhf(dhf);
			sendForm.setShf(shf);
			request.setAttribute("ddzj", khdd.getDdzj());
			if("send".equals(address)) {
				return mapping.findForward("sendView");
			}else {
				return mapping.findForward("traView");
			}
	}
	
	public ActionForward delete(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			String address = request.getParameter("address");
			if (this.isTokenValid(request)) {
				String[] pks = request.getParameterValues("pk");
				int djzj = (Integer) request.getSession().getAttribute(
				"userDjxxzj");
				int ktzj = 0;
				String kind = "";
				if ("send".equals(address)) {
					ktzj = Contants_st.psd_query;
					kind = "配送";
				} else {
					ktzj = Contants_st.ysd_query;
					kind = "运输";
				}
				boolean flag = this.getService().delete(djzj, ktzj, pks);
				request.setAttribute("msg", flag ? kind + "订单删除成功!" : kind
						+ "订单删除失败!");
				this.resetToken(request);
			}
			request.setAttribute("address", address);
			return mapping.findForward("getList");
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
	public ActionForward objList(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			SendForm yspsdForm = (SendForm) form;
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
				request.getSession().removeAttribute("cxddzt");
			}else {
				con = (String) request.getSession().getAttribute("queryMsg");
			}
			Pageinfo pageinfo = null;
			StringBuffer sb = new StringBuffer();
			sb.append(" and (A.ssxs = ? and A.sssysz = ? or A.ssxs = 0 and A.sssysz = 0) ");
			Integer rddzt = yspsdForm.getCxddzt();
			Integer sddzt = (Integer)request.getSession().getAttribute("cxddzt");
			if(rddzt!=null&&!"-1".equals(rddzt.toString())){
				request.getSession().setAttribute("cxddzt",rddzt);
				sb.append(" and A.yszt = ").append(rddzt);
			}else if(sddzt!=null&&!"-1".equals(sddzt.toString())){
				sb.append(" and A.yszt = ").append(sddzt);
				yspsdForm.setCxddzt(sddzt);
			}
			if(con == null) {
				pageinfo = this.getService().getPagedata(sb.toString(), Integer.parseInt(page), ssxs,sssysz);
			}else {
				sb.append(con);				
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				yspsdForm.setFieldName(fieldName);
				yspsdForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPagedata(sb.toString(), 
						Integer.parseInt(page), ssxs,sssysz,"%" + fieldValue + "%");
			}
			request.setAttribute("pageinfo", pageinfo);
			if("send".equals(address)) {
				return mapping.findForward("sendList1");
			}else {
				return mapping.findForward("traList1");
			}
	}
	public ActionForward queryList(ActionMapping mapping,ActionForm form,
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
			return mapping.findForward("success");
	}
	public ActionForward view1(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			String address = request.getParameter("address");
			String pk = request.getParameter("pk");
			SendForm sendForm = (SendForm) form;
			Yspsd vo = this.getService().getYspsdxx(Integer.parseInt(pk));
			Khht khht = vo.getKhht();
			Khdd khdd = khht.getKhdd();
			sendForm.setVo(vo);
			sendForm.setKhht(khht);
			Khxx dhf = khdd.getKhxxByKhzj();
			Khxx shf = khdd.getKhxxByKhxKhzj();
			sendForm.setDhf(dhf);
			sendForm.setShf(shf);
			request.setAttribute("ddzj", khdd.getDdzj());
			if("send".equals(address)) {
				return mapping.findForward("sendView1");
			}else {
				return mapping.findForward("traView1");
			}
	}
	public ActionForward objList1(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			SendForm yspsdForm = (SendForm) form;
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
			sb.append(" and (A.ssxs = ? and A.sssysz = ? or A.ssxs = 0 and A.sssysz = 0) ");
			if(con == null) {
				pageinfo = this.getService().getPagedata(sb.toString(), Integer.parseInt(page), ssxs,sssysz);
			}else {
				sb.append(con);				
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				yspsdForm.setFieldName(fieldName);
				yspsdForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPagedata(sb.toString(), 
						Integer.parseInt(page), ssxs,sssysz,"%" + fieldValue + "%");
			}
			request.setAttribute("pageinfo", pageinfo);
			if("send".equals(address)) {
				return mapping.findForward("sendList2");
			}else {
				return mapping.findForward("traList2");
			}
	}
	public ActionForward queryList1(ActionMapping mapping,ActionForm form,
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
			return mapping.findForward("success1");
	}
	public ActionForward view2(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
		
			String address = request.getParameter("address");
			String pk = request.getParameter("pk");
			SendForm sendForm = (SendForm) form;
			Yspsd vo = this.getService().getYspsdxx(Integer.parseInt(pk));
			Khht khht = vo.getKhht();
			Khdd khdd = khht.getKhdd();
			sendForm.setVo(vo);
			sendForm.setKhht(khht);
			Khxx dhf = khdd.getKhxxByKhzj();
			Khxx shf = khdd.getKhxxByKhxKhzj();
			sendForm.setDhf(dhf);
			sendForm.setShf(shf);
			request.setAttribute("ddzj", khdd.getDdzj());
			if("send".equals(address)) {
				return mapping.findForward("sendView2");
			}else {
				return mapping.findForward("traView2");
			}
	}
}