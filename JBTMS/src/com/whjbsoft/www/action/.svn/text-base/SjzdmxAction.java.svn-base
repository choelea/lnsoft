package com.whjbsoft.www.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.SjzdForm;
import com.whjbsoft.www.po.Hpxx;
import com.whjbsoft.www.po.Sjzd;
import com.whjbsoft.www.po.Sjzdmx;
import com.whjbsoft.www.service.SjzdService;
import com.whjbsoft.www.servicei.SjzdServicei;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.Pageinfo;
public class SjzdmxAction extends DispatchAction {
	private SjzdService servicei;
	public SjzdmxAction(){
		this.setServicei(new SjzdServicei());
	}
	
	public SjzdService getServicei() {
		return servicei;
	}

	public void setServicei(SjzdService servicei) {
		this.servicei = servicei;
	}

	public ActionForward sjzdList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			List list = this.getServicei().getSjzdList("");
			request.setAttribute("sjzdlist", list);
			request.getSession().removeAttribute("objPk");
			request.getSession().removeAttribute("fqPk");
			return mapping.findForward("sjzdList");
	}
	public ActionForward sjzdmxList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			SjzdForm sjzdForm = (SjzdForm) form;
			Sjzd sjzd = sjzdForm.getSjzd();
			Sjzdmx vo = sjzdForm.getVo();
			StringBuffer path = new StringBuffer("mxlist");
			path.append(sjzd.getSjzdzj());
			String page = request.getParameter("page");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			if(Contants_st.sjzd_type21!=sjzd.getSjzdzj()){
				Pageinfo pageinfo = this.getServicei().getPagedata(" and A.sjzd.sjzdzj = ? and A.fqzj = ?",
						Integer.parseInt(page), sjzd.getSjzdzj(), vo.getFqzj());
				request.setAttribute("pageinfo", pageinfo);				
			}else{
				Pageinfo pageinfo = this.getServicei().getHpxxPage("",Integer.valueOf(page));
				request.setAttribute("pageinfo", pageinfo);
			}
			request.getSession().setAttribute("objPk", sjzd.getSjzdzj());
			request.getSession().setAttribute("fqPk", vo.getFqzj());
			return mapping.findForward(path.toString());
		}

	public ActionForward gotoAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			StringBuffer path = new StringBuffer("gotoAdd");
			Integer objPk = (Integer) request.getSession().getAttribute("objPk");
			path.append(objPk);
			this.saveToken(request);
			return mapping.findForward(path.toString());
		}

	public ActionForward addObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			SjzdForm sjzdForm = (SjzdForm) form;
			Sjzd sjzd = sjzdForm.getSjzd();
			
			if (this.isTokenValid(request)) {
				if(Contants_st.sjzd_type21==sjzd.getSjzdzj()){//添加货品
					Hpxx hpxx = sjzdForm.getHpxx();
					String hql = "from Hpxx A where A.hpbm = ? or A.hpmc = ?";
					boolean flag = this.getServicei().nameExist(hql,hpxx.getHpbm(),hpxx.getHpmc());
					if(!flag){
						flag = this.getServicei().save(hpxx);
						request.setAttribute("msg", flag ? "参数录入成功!":"参数录入失败!");
					}else{
						request.setAttribute("msg", "该信息已存在于数据库!");
					}
				}else{//添加数据字典明细
					Sjzdmx vo = sjzdForm.getVo();
					vo.setSjzd(sjzd);
					StringBuffer sb = new StringBuffer("from Sjzdmx A where 1=1");				
					boolean fExist = false;
					if(Contants_st.sjzd_type14==sjzd.getSjzdzj()){
						sb.append(" and A.sjzdmxmc=? and A.sjzd.sjzdzj = ?");
						fExist = this.getServicei().nameExist(sb.toString(), vo.getSjzdmxmc(),sjzd.getSjzdzj());
					}else{
						sb.append(" and (A.sjzdmxbh = ? or A.sjzdmxmc = ?) and A.sjzd.sjzdzj=?");
						fExist = this.getServicei().nameExist(sb.toString(),vo.getSjzdmxbh(), vo.getSjzdmxmc(),sjzd.getSjzdzj());
					}
					if (!fExist) {
						boolean flag = this.getServicei().save(vo);
						request.setAttribute("msg", flag ? "参数录入成功!":"参数录入失败!");
					} else {
						request.setAttribute("msg", "该信息已存在于数据库!");
					}
				}				
				this.resetToken(request);
			}
			return mapping.findForward("success");

	}
	
	public ActionForward gotoUpd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			StringBuffer path = new StringBuffer("gotoUpd");
			Integer objPk = (Integer) request.getSession().getAttribute("objPk");
			path.append(objPk);
			SjzdForm sjzdForm = (SjzdForm) form;
			if(objPk==Contants_st.sjzd_type21){
				Hpxx hpxx = this.getServicei().getHpxx(sjzdForm.getHpxx().getHpzj());
				sjzdForm.setHpxx(hpxx);
			}else{
				Sjzdmx sjzdmx = this.getServicei().getSjzdmx(sjzdForm.getVo().getSjzdmxzj());
				sjzdForm.setVo(sjzdmx);
				sjzdForm.setSjzd(sjzdmx.getSjzd());
			}
			this.saveToken(request);
			return mapping.findForward(path.toString());
	}
	public ActionForward updObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			SjzdForm sjzdForm = (SjzdForm) form;
			Sjzd sjzd = sjzdForm.getSjzd();
			String oldName = request.getParameter("oldName");
			if (this.isTokenValid(request)) {
				if(Contants_st.sjzd_type21==sjzd.getSjzdzj()){//修改货品
					Hpxx hpxx = sjzdForm.getHpxx();
					if(!oldName.equals(hpxx.getHpmc())){
						String hql = "from Hpxx A where A.hpmc = ?";
						boolean flag = this.getServicei().nameExist(hql,hpxx.getHpmc());
						if(!flag){
							flag = this.getServicei().update(hpxx);
							request.setAttribute("msg", flag ? "参数修改成功!":"参数修改失败!");
						}else{
							request.setAttribute("msg", "该信息已存在于数据库!");
						}
					}else{
						boolean flag = this.getServicei().update(hpxx);
						request.setAttribute("msg", flag ? "参数修改成功!":"参数修改失败!");
					}
				}else{//修改数据字典明细
					Sjzdmx vo = sjzdForm.getVo();
					vo.setSjzd(sjzdForm.getSjzd());
					if (oldName.equals(vo.getSjzdmxmc())) {
						boolean flag = this.getServicei().update(vo);
						request.setAttribute("msg", flag ? "参数修改成功!" : "参数修改失败!");
					} else {
						String hql = "from Sjzdmx A where A.sjzdmxmc = ? and A.sjzd.sjzdzj = ?";
						if (!this.getServicei().nameExist(hql,vo.getSjzdmxmc(), sjzd.getSjzdzj())) {
							boolean flag = this.getServicei().update(vo);
							request.setAttribute("msg", flag ? "参数修改成功!"	:"参数修改失败!");
						} else {
							request.setAttribute("msg", "该信息已存在于数据库!");
						}
					}
				}
				this.resetToken(request);
			}
			return mapping.findForward("success");
	}
	public ActionForward delObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			SjzdForm sjzdForm = (SjzdForm) form;
			Sjzd sjzd = sjzdForm.getSjzd();
			String[] ids = request.getParameterValues("pk");
			boolean flag = false;
			if(Contants_st.sjzd_type21==sjzd.getSjzdzj()){//修改货品
				flag = this.getServicei().delHp(ids);
			}else{
				flag = this.getServicei().delete(ids);
			}
			request.setAttribute("msg", flag ? "参数删除成功!" : "参数删除失败!");
			return mapping.findForward("success");
	}

}