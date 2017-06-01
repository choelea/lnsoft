package com.whjbsoft.www.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.ZdglForm;
import com.whjbsoft.www.po.Khht;
import com.whjbsoft.www.po.Zdgl;
import com.whjbsoft.www.service.ZdglService;
import com.whjbsoft.www.servicei.ZdglServicei;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.Pageinfo;
	public class ZdglAction extends DispatchAction {
	private ZdglService service;
	public ZdglAction(){
		this.setService(new ZdglServicei());
	}
	public ZdglService getService() {
		return service;
	}
	public void setService(ZdglService service) {
		this.service = service;
	}
	public ActionForward objList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {		
		
			ZdglForm zdglForm = (ZdglForm) form;
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
				zdglForm.setFieldName(fieldName);
				zdglForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPageinfo(djzj, Contants_st.zd_query,sb.toString(), Integer.parseInt(page), ssxs, sssysz,"%" + fieldValue + "%");
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
		
			ZdglForm zdglForm = (ZdglForm) form;
			Integer ssxs = (Integer) request.getSession().getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute("userSyszzj");			
			Zdgl vo = zdglForm.getVo();
			vo.setZdrq(FormateDate.formate());
			vo.setZzdbh(FormateDate.formate("ZD"));
			vo.setSfhx(0);
			vo.setSsxs(ssxs);
			vo.setSssysz(sssysz);//币种字段修改用于存储合同类型，货币类型显示固定显示￥
			this.saveToken(request);
			return mapping.findForward("gotoAdd");
		}		
	public ActionForward addObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)){
				ZdglForm zdglForm = (ZdglForm) form;
				Zdgl vo = zdglForm.getVo();
				Khht khht = zdglForm.getKhht();
				Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				boolean flag = this.getService().save(djzj, Contants_st.zd_add, vo,khht);
				request.setAttribute("msg", flag?"录入信息成功!":"录入信息失败!");				
				this.resetToken(request);
			}
			return mapping.findForward("success");
		}
	public ActionForward viewObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			ZdglForm zdglForm = (ZdglForm) form;
			Zdgl zdgl = this.getService().getZdgl(zdglForm.getVo().getZzdzj());
			zdglForm.setVo(zdgl);
			return mapping.findForward("gotoView");
		}		
	public ActionForward valiObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			ZdglForm zdglForm = (ZdglForm) form;
			Zdgl zdgl = zdglForm.getVo();
			Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
			boolean flag = this.getService().valiZdgl(djzj, Contants_st.zd_hx, zdgl);
			request.setAttribute("msg",flag?"核销成功!":"核销失败!");
			return mapping.findForward("success");
		}		
	public ActionForward exportObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			ZdglForm zdglForm = (ZdglForm) form;
			Zdgl zdgl = zdglForm.getVo();
			this.getService().exportExcel(zdgl.getZzdzj(), response);
			return null;
		}		
}