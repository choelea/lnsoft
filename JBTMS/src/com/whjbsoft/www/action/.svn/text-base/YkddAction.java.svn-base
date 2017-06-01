package com.whjbsoft.www.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.YkddForm;
import com.whjbsoft.www.po.Kfxx;
import com.whjbsoft.www.po.Ykdd;
import com.whjbsoft.www.po.Ykmx;
import com.whjbsoft.www.service.YkddService;
import com.whjbsoft.www.servicei.YkddServicei;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.Pageinfo;
import com.whjbsoft.www.vo.YkmxVo;
public class YkddAction extends DispatchAction {
	private YkddService service;
	public YkddAction(){
		this.setService(new YkddServicei());
	}
	public YkddService getService() {
		return service;
	}
	public void setService(YkddService service) {
		this.service = service;
	}
	public ActionForward objList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			YkddForm ykddForm = (YkddForm) form;
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
				ykddForm.setFieldName(fieldName);
				ykddForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPageinfo(djzj, Contants_st.ykd_query,sb.toString(), Integer.parseInt(page), ssxs, sssysz,"%" + fieldValue + "%");
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
		
			YkddForm ykddForm = (YkddForm) form;
			Integer ssxs = (Integer) request.getSession().getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
			String userTName = (String)request.getSession().getAttribute("userTName");
			Ykdd vo = ykddForm.getVo();
			vo.setYkbh(FormateDate.formate("YK"));
			vo.setSsxs(ssxs);
			vo.setSssysz(sssysz);
			vo.setYkzt(0);
			vo.setTdr(userTName);
			vo.setTdsj(FormateDate.formateTime());
			this.saveToken(request);
			return mapping.findForward("gotoAdd");
	}
	public ActionForward addObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)){
				YkddForm ykddForm = (YkddForm) form;
				Ykdd vo = ykddForm.getVo();
				List<YkmxVo> list = ykddForm.getList();
				if(list!=null&&!list.isEmpty()){//移库明细
					for (YkmxVo ykmxVo : list) {
						if(ykmxVo.getYcw().getCwzj()!=null && ykmxVo.getYcw().getCwzj()!=0 && ykmxVo.getMbcw().getCwzj()!=null && ykmxVo.getMbcw().getCwzj()!=0){
							Ykmx ykmx = new Ykmx();
							ykmx.setYkdd(vo);
							ykmx.setCwxxByCwzj(ykmxVo.getYcw());//源储位
							ykmx.setCwxxByCwxCwzj(ykmxVo.getMbcw());//目标储位
							ykmx.setYkhpsl(ykmxVo.getYkhpsl());
							ykmx.setYkshsl(ykmxVo.getYkshsl());
							vo.getYkmxes().add(ykmx);
						}						
					}
				}
				Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				boolean flag = this.getService().save(djzj, Contants_st.ykd_add, vo);
				request.setAttribute("msg", flag?"信息录入成功!":"信息录入失败!");
				this.resetToken(request);
			}
			return mapping.findForward("success");
	}
	public ActionForward gotoUpd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			YkddForm ykddForm = (YkddForm) form;
			Ykdd vo = this.getService().getYkdd(ykddForm.getVo().getYkzj());
			ykddForm.setVo(vo);
			List list = this.getService().getObjects(" and A.ykdd.ykzj=?",vo.getYkzj());
			request.setAttribute("list",list);
			Kfxx kfxx = this.getService().getKfxx(vo.getCkkfzj());
			request.setAttribute("kfxx", kfxx);
			this.saveToken(request);
			return mapping.findForward("gotoUpd");
	}
	public ActionForward updObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)){
				YkddForm ykddForm = (YkddForm) form;
				Ykdd vo = ykddForm.getVo();
				List<YkmxVo> list = ykddForm.getList();
				if(list!=null&&!list.isEmpty()){//移库明细
					for (YkmxVo ykmxVo : list) {
						if(ykmxVo.getYcw().getCwzj()!=null && ykmxVo.getYcw().getCwzj()!=0 && ykmxVo.getMbcw().getCwzj()!=null && ykmxVo.getMbcw().getCwzj()!=0){
							Ykmx ykmx = new Ykmx();
							ykmx.setYkdd(vo);
							ykmx.setCwxxByCwzj(ykmxVo.getYcw());//源储位
							ykmx.setCwxxByCwxCwzj(ykmxVo.getMbcw());//目标储位
							ykmx.setYkhpsl(ykmxVo.getYkhpsl());
							ykmx.setYkshsl(ykmxVo.getYkshsl());
							vo.getYkmxes().add(ykmx);
						}
					}
				}
				Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				boolean flag = this.getService().update(djzj, Contants_st.ykd_upd, vo);
				request.setAttribute("msg", flag?"信息修改成功!":"信息修改失败!");
				this.resetToken(request);
			}
			return mapping.findForward("success");
	}
	public ActionForward delObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String[] ids = request.getParameterValues("pk");
			Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
			boolean flag = this.getService().delete(djzj, Contants_st.ykd_del, ids);
			request.setAttribute("msg",flag?"删除成功!":"删除失败!");
			return mapping.findForward("success");
	}
	public ActionForward viewObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			YkddForm ykddForm = (YkddForm) form;
			Ykdd vo = this.getService().getYkdd(ykddForm.getVo().getYkzj());
			ykddForm.setVo(vo);
			List list = this.getService().getObjects(" and A.ykdd.ykzj=?",vo.getYkzj());
			request.setAttribute("list",list);
			return mapping.findForward("gotoView");
	}
	public ActionForward valiList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			YkddForm ykddForm = (YkddForm) form;
			String rmMsg = request.getParameter("rmMsg");
			Integer ssxs = (Integer) request.getSession().getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
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
				ykddForm.setFieldName(fieldName);
				ykddForm.setFieldValue(fieldValue);
				pageinfo = this.getService().getPageinfo(sb.toString(), Integer.parseInt(page), ssxs, sssysz,"%" + fieldValue + "%");
			} else {
				pageinfo = this.getService().getPageinfo(sb.toString(), Integer.parseInt(page), ssxs, sssysz);				
			}
			request.setAttribute("pageinfo", pageinfo);
			return mapping.findForward("valiList");
	}
	public ActionForward queryList1(ActionMapping mapping, ActionForm form,
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
			return mapping.findForward("success1");
	}
	public ActionForward gotoVali(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			YkddForm ykddForm = (YkddForm) form;
			Ykdd vo = this.getService().getYkdd(ykddForm.getVo().getYkzj());
			ykddForm.setVo(vo);
			List list = this.getService().getObjects(" and A.ykdd.ykzj=?",vo.getYkzj());
			request.setAttribute("list",list);			
			this.saveToken(request);
			return mapping.findForward("gotoVali");
	}
	public ActionForward valiObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)){
				YkddForm ykddForm = (YkddForm) form;
				Ykdd vo = ykddForm.getVo();
				Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				boolean flag = this.getService().ykczState(djzj, Contants_st.ykd_zy, vo.getYkzj());
				request.setAttribute("msg", flag?"移库成功!":"移库失败!");
				this.resetToken(request);
			}
			return mapping.findForward("success1");
	}
	public ActionForward viewObject1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			YkddForm ykddForm = (YkddForm) form;
			Ykdd vo = this.getService().getYkdd(ykddForm.getVo().getYkzj());
			ykddForm.setVo(vo);
			List list = this.getService().getObjects(" and A.ykdd.ykzj=?",vo.getYkzj());
			request.setAttribute("list",list);
			return mapping.findForward("gotoView1");
	}
}