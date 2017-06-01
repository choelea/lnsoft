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

public class YdcxAction extends DispatchAction{
	private YsddService service;
	public YsddService getService() {
		return service;
	}

	public void setService(YsddService service) {
		this.service = service;
	}
	public YdcxAction() {
		service = new YsddServicei();
	}
	
	public ActionForward getList(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response ) {
			int sysz = (Integer)request.getSession().getAttribute("userSyszzj");
			int ssxs = (Integer)request.getSession().getAttribute("userPk");
			String page = (String) request.getSession().getAttribute("page");
			String rmMsg = request.getParameter("rmMsg");
			if(page == null || "".equals(page)){
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
			StringBuffer sb = new StringBuffer();
			sb.append(" and A.ssxs = ? and A.sssysz = ? ");
			Integer curGwzj = (Integer)request.getSession().getAttribute("curGwzj");
			if(curGwzj==2){
				sb.append(" and A.ysddlx='‘À ‰'");
			}else if(curGwzj==3){
				sb.append(" and A.ysddlx='≈‰ÀÕ'");
			}
			Pageinfo pageinfo = null;
			if(con == null) {
				pageinfo = this.getService().getPageinfo(sb.toString(), 
						Integer.parseInt(page), ssxs,sysz);
			}else {
				sb.append(con);
				YsddForm ysddForm = (YsddForm) form;
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				ysddForm.setFieldName(fieldName);
				ysddForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPageinfo(sb.toString(), 
						Integer.parseInt(page), ssxs,sysz,"%" + fieldValue + "%");
			}
			request.setAttribute("pageinfo", pageinfo);
			return mapping.findForward("listPage");
		}
	
	public ActionForward view(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response ) {
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
			return mapping.findForward("viewPage");
	}
	
	public ActionForward query(ActionMapping mapping ,ActionForm form,
			HttpServletRequest request,HttpServletResponse response ){
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if(fieldName != null && !"".equals(fieldName) && fieldValue != null && !"".equals(fieldValue)) {
				StringBuffer sb = new StringBuffer();
				sb.append(" and A.").append(fieldName).append(" like ?");
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