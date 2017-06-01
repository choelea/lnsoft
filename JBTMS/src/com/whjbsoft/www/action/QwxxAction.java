package com.whjbsoft.www.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.QwxxForm;
import com.whjbsoft.www.po.Kfxx;
import com.whjbsoft.www.po.Qwxx;
import com.whjbsoft.www.service.QwxxService;
import com.whjbsoft.www.servicei.QwxxServicei;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.Pageinfo;

public class QwxxAction extends DispatchAction {
	private QwxxService service;
	public QwxxAction(){
		this.setService(new QwxxServicei());
	}
	public QwxxService getService() {
		return service;
	}
	public void setService(QwxxService service) {
		this.service = service;
	}
	public ActionForward objList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {		
		
			QwxxForm qwxxForm = (QwxxForm) form;
			String rmMsg = request.getParameter("rmMsg");
			Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
			String page = request.getParameter("page");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			if ("true".equals(rmMsg)) {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
				request.getSession().setAttribute("qwkfzj", qwxxForm.getKfxx().getKfzj());
			}
			Integer qwkfzj = (Integer)request.getSession().getAttribute("qwkfzj");
			StringBuffer sb = new StringBuffer(" and A.kfxx.kfzj = ?");
			String con = (String) request.getSession().getAttribute("queryMsg");
			Pageinfo pageinfo = null;
			if (con != null) {
				sb.append(con);
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				qwxxForm.setFieldName(fieldName);
				qwxxForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPageinfo(djzj, Contants_st.qw_query,sb.toString(), Integer.parseInt(page), qwkfzj,"%" + fieldValue + "%");
				request.setAttribute("pageinfo", pageinfo);
			} else {
				pageinfo = this.getService().getPageinfo(sb.toString(), Integer.parseInt(page), qwkfzj);				
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
		
			QwxxForm qwxxForm = (QwxxForm) form;
			SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
			Qwxx vo = qwxxForm.getVo();
			vo.setQwbh("QW"+sdf.format(new Date()));
			vo.setSffpcw(0);
			Integer qwkfzj = (Integer)request.getSession().getAttribute("qwkfzj");
			Kfxx kfxx = this.getService().getKfxx(qwkfzj);
			qwxxForm.setKfxx(kfxx);
			if("电子标签".equals(kfxx.getKflx())){
				vo.setQfabm(0);//是否区分AB面
				vo.setAmhs(Contants_st.hjlx_dzbq_hs);
				vo.setAmls(Contants_st.hjlx_dzbq_ls);
			}else if("立体仓库".equals(kfxx.getKflx())){
				vo.setQfabm(1);//是否区分AB面
				vo.setAmhs(Contants_st.hjlx_ltck_hsa);
				vo.setAmls(Contants_st.hjlx_ltck_lsa);
				vo.setBmhs(Contants_st.hjlx_ltck_hsb);
				vo.setBmls(Contants_st.hjlx_ltck_lsb);
			}else{
				vo.setQfabm(0);//是否区分AB面
				vo.setAmhs(1);//普通库房初始行
				vo.setAmls(1);//普通库房初始列
			}
			this.saveToken(request);
			return mapping.findForward("gotoAdd");
	}
	public ActionForward addObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)){
				QwxxForm qwxxForm = (QwxxForm) form;
				Qwxx vo = qwxxForm.getVo();
				Integer qwkfzj = (Integer)request.getSession().getAttribute("qwkfzj");
				boolean flag = this.getService().isExist(" and A.qwmc=? and A.kfxx.kfzj=?", vo.getQwmc(),qwkfzj);
				if(!flag){
					Kfxx kfxx = qwxxForm.getKfxx();
					vo.setKfxx(kfxx);
					Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
					flag = this.getService().save(djzj, Contants_st.qw_add, vo);
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
		
			QwxxForm qwxxForm = (QwxxForm) form;
			Qwxx qwxx = this.getService().getQwxx(qwxxForm.getVo().getQwzj());
			qwxxForm.setVo(qwxx);
			qwxxForm.setKfxx(qwxx.getKfxx());
			this.saveToken(request);
			return mapping.findForward("gotoUpd");
	}
	public ActionForward updObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)){
				QwxxForm qwxxForm = (QwxxForm) form;
				Qwxx vo = qwxxForm.getVo();
				vo.setKfxx(qwxxForm.getKfxx());
				String oldName = request.getParameter("oldName");
				boolean flag = false;
				if(oldName.equals(vo.getQwmc())){
					Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
					flag = this.getService().update(djzj, Contants_st.qw_upd, vo);
					request.setAttribute("msg", flag?"信息修改成功!":"信息修改失败!");
				}else{
					Integer qwkfzj = (Integer)request.getSession().getAttribute("qwkfzj");
					flag = this.getService().isExist(" and A.qwmc=? and A.kfxx.kfzj=?", vo.getQwmc(),qwkfzj);
					if(!flag){
						Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
						flag = this.getService().update(djzj, Contants_st.qw_upd, vo);
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
			boolean flag = this.getService().delete(djzj, Contants_st.qw_del, ids);
			request.setAttribute("msg",flag?"删除成功!":"删除失败!");
			return mapping.findForward("success");
	}
	public ActionForward viewObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			QwxxForm qwxxForm = (QwxxForm) form;
			Qwxx qwxx = this.getService().getQwxx(qwxxForm.getVo().getQwzj());
			qwxxForm.setVo(qwxx);
			qwxxForm.setKfxx(qwxx.getKfxx());
			return mapping.findForward("gotoView");
	}
	public ActionForward gotoFpcw(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			QwxxForm qwxxForm = (QwxxForm) form;
			Qwxx qwxx = this.getService().getQwxx(qwxxForm.getVo().getQwzj());
			qwxxForm.setVo(qwxx);
			qwxxForm.setKfxx(qwxx.getKfxx());
			this.saveToken(request);
			return mapping.findForward("gotoFpcw");
	}
	/**
	 * 分配储位
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward fpcw(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)){
				QwxxForm qwxxForm = (QwxxForm) form;
				Qwxx vo = qwxxForm.getVo();
				Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				boolean flag = this.getService().saveCwxx(djzj, Contants_st.cw_set, vo);
				request.setAttribute("msg",flag?"储位分配成功!":"储位分配失败!");
				this.resetToken(request);
			}
			return mapping.findForward("success");
	}
	public ActionForward resetFpcw(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			QwxxForm qwxxForm = (QwxxForm) form;
			Qwxx qwxx = this.getService().getQwxx(qwxxForm.getVo().getQwzj());
			qwxxForm.setVo(qwxx);
			qwxxForm.setKfxx(qwxx.getKfxx());
			List alist = this.getService().getCwxxList(" and A.qwxx.qwzj=? and A.cwzfm='A'",qwxx.getQwzj());
			request.setAttribute("alist",alist);
			List blist = this.getService().getCwxxList(" and A.qwxx.qwzj=? and A.cwzfm='B'",qwxx.getQwzj());
			request.setAttribute("blist",blist);
			return mapping.findForward("resetFpcw");
	}
}