package com.whjbsoft.www.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.KhddForm;
import com.whjbsoft.www.po.Khdd;
import com.whjbsoft.www.po.Khddhpb;
import com.whjbsoft.www.po.Khxx;
import com.whjbsoft.www.service.KhddService;
import com.whjbsoft.www.servicei.KhddServicei;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.Pageinfo;

public class KhddAction extends DispatchAction{
	private KhddService servicei;
	public KhddAction(){
		this.setServicei(new KhddServicei());
	}
	public KhddService getServicei() {
		return servicei;
	}
	public void setServicei(KhddService servicei) {
		this.servicei = servicei;
	}
	
	public ActionForward getList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {		
			KhddForm khddForm = (KhddForm) form;;
			String rmMsg = request.getParameter("rmMsg");
			Integer ssxs = (Integer) request.getSession().getAttribute("userPk");
			Integer sssysz = (Integer) request.getSession().getAttribute("userSyszzj");
			Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
			int ktzj = Contants_st.khdd_query;
			String page = request.getParameter("page");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			if ("true".equals(rmMsg)) {
				request.getSession().removeAttribute("queryMsg");
				request.getSession().removeAttribute("fieldName");
				request.getSession().removeAttribute("fieldValue");
			}
			StringBuffer sb = new StringBuffer(" and (A.ssxs = ? and A.sssysz = ? or A.ssxs = 0 and A.sssysz = 0)");
			/*if("single".equals(queryType)){
				sb.append(" and A.ddzt = 0");
			}
			khddForm.setQueryType(queryType);*/
			String con = (String) request.getSession().getAttribute("queryMsg");
			if (con != null) {
				sb.append(con);
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				khddForm.setFieldName(fieldName);
				khddForm.setFieldValue(fieldValue);				
				Pageinfo pageinfo = this.getServicei().getPagedata(djzj, ktzj,sb.toString(),
						Integer.parseInt(page), ssxs, sssysz,"%" + fieldValue + "%");
				request.setAttribute("pageinfo", pageinfo);
			} else {
				Pageinfo pageinfo = this.getServicei().getPagedata(sb.toString(), 
						Integer.parseInt(page), ssxs, sssysz);
				request.setAttribute("pageinfo", pageinfo);
			}
			this.saveToken(request);
			return mapping.findForward("listPage");
	}
	
	public ActionForward goSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {		
			KhddForm khddForm = (KhddForm) form;
			Khdd vo = khddForm.getVo();
			vo.setDdrq(FormateDate.formateTime());
			vo.setDdbh(FormateDate.formate("KD"));			
			this.saveToken(request);			
			return mapping.findForward("savePage");
	}
	
	public ActionForward save(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			KhddForm khddForm = (KhddForm) form;
			if (this.isTokenValid(request)) {
				Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				int ktzj = Contants_st.khdd_add;
				Khdd vo = khddForm.getVo();
				Khxx shf = khddForm.getShf();
				Khxx dhf = khddForm.getDhf();
				vo.setKhxxByKhzj(dhf);
				vo.setKhxxByKhxKhzj(shf);
				List<Khddhpb> list = khddForm.getList();
				if (list != null && list.size()>0) {
					for (Khddhpb khddhpb : list) {
						if(khddhpb.getHpbm()!=null && !"".equals(khddhpb.getHpbm())) {
							khddhpb.setKhdd(vo);
							vo.getKhddhpbs().add(khddhpb);
						}
					}
				}				
				boolean flag = this.getServicei().save(djzj,ktzj,vo);
				request.setAttribute("msg", flag ? "信息录入成功!" : "信息录入失败!");
				this.resetToken(request);
			}
			//防止搜索栏填入了信息而返回页面无法显示刚刚添加的信息
			request.getSession().removeAttribute("queryMsg");
			request.getSession().removeAttribute("fieldName");
			request.getSession().removeAttribute("fieldValue");
			return mapping.findForward("getList");
		}
	
	public ActionForward goUpdate(ActionMapping mapping,ActionForm form ,
			HttpServletRequest request ,HttpServletResponse response) {
			KhddForm khddForm = (KhddForm) form;
			String pk = request.getParameter("pk");
			Khdd khdd = this.getServicei().getKhdd(Integer.parseInt(pk));
			khddForm.setVo(khdd);
			khddForm.setDhf(khdd.getKhxxByKhzj());
			khddForm.setShf(khdd.getKhxxByKhxKhzj());
			request.setAttribute("list", khdd.getKhddhpbs());
			this.saveToken(request);
			return mapping.findForward("updatePage");
	}
	
	public ActionForward update(ActionMapping mapping,ActionForm form,
			HttpServletRequest request ,HttpServletResponse response) {
			KhddForm khddForm = (KhddForm) form;
			if (this.isTokenValid(request)) {
				Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				int ktzj = Contants_st.khdd_upd;
				Khdd vo = khddForm.getVo();
				Khxx shf = khddForm.getShf();
				Khxx dhf = khddForm.getDhf();
				vo.setKhxxByKhzj(dhf);
				vo.setKhxxByKhxKhzj(shf);
				List<Khddhpb> list = khddForm.getList();
				for (Khddhpb khddhpb : list) {
					if(khddhpb.getDdhpzj()!=null && khddhpb.getDdhpzj()!=0){
						khddhpb.setKhdd(vo);
						vo.getKhddhpbs().add(khddhpb);
					}
				}
				boolean flag = this.getServicei().update(djzj,ktzj,vo);
				request.setAttribute("msg", flag ? "信息修改成功!" : "信息修改失败!");
				this.resetToken(request);
			}
			return mapping.findForward("getList");
	}
	
	public ActionForward valid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			String pk = request.getParameter("pk");
			Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
			int ktzj = 0;
			this.getServicei().valiKhdd(djzj,ktzj,Integer.parseInt(pk));	
			return mapping.findForward("getList");
	}
	
	public ActionForward view(ActionMapping mapping,ActionForm form ,
			HttpServletRequest request ,HttpServletResponse response) {
			KhddForm khddForm = (KhddForm) form;
			String pk = request.getParameter("pk");
			Khdd khdd = this.getServicei().getKhdd(Integer.parseInt(pk));
			khddForm.setVo(khdd);
			khddForm.setDhf(khdd.getKhxxByKhzj());
			khddForm.setShf(khdd.getKhxxByKhxKhzj());
			request.setAttribute("list", khdd.getKhddhpbs());
			return mapping.findForward("viewPage");
	}
	
	public ActionForward delete(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) {
			if (this.isTokenValid(request)) {
				Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				int ktzj = Contants_st.khdd_del;
				String[] pks = request.getParameterValues("pk");
				boolean flag = this.getServicei().delete(djzj, ktzj, pks);
				request.setAttribute("msg", flag?"客户订单删除成功!":"客户订单删除失败");
				this.resetToken(request);
			}
			return mapping.findForward("getList");
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {		
			StringBuffer sb = new StringBuffer();
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if (fieldName != null && !"".equals(fieldName) && fieldValue != null && !"".equals(fieldValue)) {
				sb.append(" and ").append(fieldName).append(" like ?");
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
	public ActionForward objList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {		
			KhddForm khddForm = (KhddForm) form;;
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
				request.getSession().removeAttribute("cxhtzt");
			}
			StringBuffer sb = new StringBuffer(" and (A.ssxs = ? and A.sssysz = ? or A.ssxs = 0 and A.sssysz = 0)");
			Integer rhtzt = khddForm.getCxhtzt();
			Integer shtzt = (Integer)request.getSession().getAttribute("cxhtzt");
			if(rhtzt!=null){
				request.getSession().setAttribute("cxhtzt",rhtzt);
				sb.append(" and A.ddzt = ").append(rhtzt);
			}else if(shtzt!=null){
				sb.append(" and A.ddzt = ").append(shtzt);
				khddForm.setCxhtzt(shtzt);
			}
			String con = (String) request.getSession().getAttribute("queryMsg");
			if (con != null) {
				sb.append(con);
				String fieldName = (String) request.getSession().getAttribute("fieldName");
				String fieldValue = (String) request.getSession().getAttribute("fieldValue");
				khddForm.setFieldName(fieldName);
				khddForm.setFieldValue(fieldValue);				
				Pageinfo pageinfo = this.getServicei().getPagedata(sb.toString(),
						Integer.parseInt(page), ssxs, sssysz,"%" + fieldValue + "%");
				request.setAttribute("pageinfo", pageinfo);
			} else {
				Pageinfo pageinfo = this.getServicei().getPagedata(sb.toString(), 
						Integer.parseInt(page), ssxs, sssysz);
				request.setAttribute("pageinfo", pageinfo);
			}
			return mapping.findForward("objList");
	}
	public ActionForward queryList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {		
			StringBuffer sb = new StringBuffer();
			String fieldName = request.getParameter("fieldName");
			String fieldValue = request.getParameter("fieldValue");
			if (fieldName != null && !"".equals(fieldName) && fieldValue != null && !"".equals(fieldValue)) {
				sb.append(" and ").append(fieldName).append(" like ?");
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
	public ActionForward view1(ActionMapping mapping,ActionForm form ,
			HttpServletRequest request ,HttpServletResponse response) {
			KhddForm khddForm = (KhddForm) form;
			String pk = request.getParameter("pk");
			Khdd khdd = this.getServicei().getKhdd(Integer.parseInt(pk));
			khddForm.setVo(khdd);
			khddForm.setDhf(khdd.getKhxxByKhzj());
			khddForm.setShf(khdd.getKhxxByKhxKhzj());
			request.setAttribute("list", khdd.getKhddhpbs());
			return mapping.findForward("viewPage1");
		}
}