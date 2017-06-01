package com.whjbsoft.www.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import com.whjbsoft.www.form.KfxxForm;
import com.whjbsoft.www.po.Kfxx;
import com.whjbsoft.www.service.KfxxService;
import com.whjbsoft.www.servicei.KfxxServicei;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.Pageinfo;

public class KfxxAction extends DispatchAction {
	private KfxxService service;
	public KfxxAction(){
		this.setService(new KfxxServicei());
	}
	public KfxxService getService() {
		return service;
	}
	public void setService(KfxxService service) {
		this.service = service;
	}
	public ActionForward objList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {		
		
			KfxxForm kfxxForm = (KfxxForm) form;
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
				request.getSession().removeAttribute("qwkfzj");
			}
			StringBuffer sb = new StringBuffer(" and (A.ssxs = ? or A.ssxs = 0) and (A.sssysz = ? or A.sssysz = 0)");
			String con = (String) request.getSession().getAttribute("queryMsg");
			Pageinfo pageinfo = null;
			if (con != null) {
				sb.append(con);
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				kfxxForm.setFieldName(fieldName);
				kfxxForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPageinfo(djzj, Contants_st.kf_query,sb.toString(), Integer.parseInt(page), ssxs, sssysz,"%" + fieldValue + "%");
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
		
			KfxxForm kfxxForm = (KfxxForm) form;
			Integer ssxs = (Integer) request.getSession().getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute("userSyszzj");			
			SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
			Kfxx vo = kfxxForm.getVo();
			vo.setKfbh("KF"+sdf.format(new Date()));
			vo.setSsxs(ssxs);
			vo.setSssysz(sssysz);
			this.saveToken(request);
			return mapping.findForward("gotoAdd");
	}
	public ActionForward addObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)){
				KfxxForm kfxxForm = (KfxxForm) form;
				Kfxx vo = kfxxForm.getVo();
				Integer ssxs = (Integer) request.getSession().getAttribute("userPk");
				Integer sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
				boolean flag = this.getService().isExist(" and A.kfmc=? and A.ssxs = ? and A.sssysz = ?", vo.getKfmc(),ssxs,sssysz);
				if(!flag){
					Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
					flag = this.getService().save(djzj, Contants_st.kf_add, vo);
					request.setAttribute("msg", flag?"录入信息成功!":"录入信息失败!");
				}else{
					request.setAttribute("msg","该记录已存在于数据库!");
				}
				this.resetToken(request);
			}
			return mapping.findForward("success");
	}
	public ActionForward gotoUpd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			KfxxForm kfxxForm = (KfxxForm) form;
			Kfxx kfxx = this.getService().getKfxx(kfxxForm.getVo().getKfzj());
			kfxxForm.setVo(kfxx);
			this.saveToken(request);
			return mapping.findForward("gotoUpd");
	}
	public ActionForward updObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)){
				KfxxForm kfxxForm = (KfxxForm) form;
				Kfxx vo = kfxxForm.getVo();
				String oldName = request.getParameter("oldName");
				boolean flag = false;
				if(oldName.equals(vo.getKfmc())){
					Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
					flag = this.getService().update(djzj, Contants_st.kf_upd, vo);
					request.setAttribute("msg", flag?"信息修改成功!":"信息修改失败!");
				}else{
					Integer ssxs = (Integer) request.getSession().getAttribute("userPk");
					Integer sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
					flag = this.getService().isExist(" and A.kfmc=? and A.ssxs = ? and A.sssysz = ?", vo.getKfmc(),ssxs,sssysz);
					if(!flag){
						Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
						flag = this.getService().update(djzj, Contants_st.kf_upd, vo);
						request.setAttribute("msg", flag?"信息修改成功!":"信息修改失败!");
					}else{
						request.setAttribute("msg","该记录已存在于数据库!");
					}
				}				
				this.resetToken(request);
			}
			return mapping.findForward("success");
	}
	public ActionForward delObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String[] ids = request.getParameterValues("pk");
			Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
			boolean flag = this.getService().delete(djzj, Contants_st.kf_del, ids);
			request.setAttribute("msg",flag?"删除成功!":"删除失败!");
			return mapping.findForward("success");
	}
	public ActionForward viewObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			KfxxForm kfxxForm = (KfxxForm) form;
			Kfxx kfxx = this.getService().getKfxx(kfxxForm.getVo().getKfzj());
			kfxxForm.setVo(kfxx);
			return mapping.findForward("gotoView");
	}
}