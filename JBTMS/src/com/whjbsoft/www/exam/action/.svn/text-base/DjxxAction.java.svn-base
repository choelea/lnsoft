
package com.whjbsoft.www.exam.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.exam.form.DjxxForm;
import com.whjbsoft.www.exam.po.Djxxs;
import com.whjbsoft.www.exam.po.Dtxxs;
import com.whjbsoft.www.exam.po.DtxxsId;
import com.whjbsoft.www.exam.po.Sjxxs;
import com.whjbsoft.www.exam.po.Stgls;
import com.whjbsoft.www.exam.service.DjxxService;
import com.whjbsoft.www.exam.servicei.DjxxServicei;
import com.whjbsoft.www.exam.vo.SjktVo;
import com.whjbsoft.www.exam.vo.SjxxVo;
import com.whjbsoft.www.po.Xsxx;
import com.whjbsoft.www.util.DogCreate;
import com.whjbsoft.www.util.Pageinfo;

public class DjxxAction extends DispatchAction {
	private DjxxService service;
	public DjxxAction(){
		this.setService(new DjxxServicei());
	}	
	public DjxxService getService() {
		return service;
	}
	public void setService(DjxxService service) {
		this.service = service;
	}

	public ActionForward objList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			String page = request.getParameter("page");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			Integer claPk = (Integer)request.getSession().getAttribute("userBjzj");
			Pageinfo pageinfo = this.getService().getSyszPage(" and A.ksszzt=1 and A.bjxx.bjzj=?",Integer.valueOf(page),claPk);
			request.setAttribute("pageinfo",pageinfo);
			return mapping.findForward("objList");
		}
	public ActionForward presave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			DjxxForm djxxForm = (DjxxForm) form;
			Sjxxs sjxx = this.getService().getSjxx(djxxForm.getSjxx().getSjzj());
			djxxForm.setSjxx(sjxx);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			djxxForm.getVo().setDjsj(sdf.format(new Date()));
			djxxForm.getVo().setSfjj(1);
			djxxForm.getVo().setSfyj(0);
			//学生信息
			Integer userPk = (Integer)request.getSession().getAttribute("userStuPk");
			String userName = (String)request.getSession().getAttribute("userName");
			djxxForm.getXsxx().setXszj(userPk);
			djxxForm.getXsxx().setXsxm(userName);
			//试卷试题
			List<SjxxVo> kt = this.getService().getSjst(djxxForm.getSjxx().getSjzj());
			request.setAttribute("kt", kt);
			this.saveToken(request);
			return mapping.findForward("gotoAdd");
		}
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)){
				DjxxForm djxxForm = (DjxxForm) form;
				Djxxs vo = djxxForm.getVo();
				Sjxxs sjxx = djxxForm.getSjxx();
				Xsxx xsxx = djxxForm.getXsxx();
				vo.setSjxx(sjxx);
				vo.setXsxx(xsxx);
				List list = djxxForm.getList();
				for(int i=0;i<list.size();i++){
					SjktVo sjktvo = (SjktVo)list.get(i);
					Stgls stgl = sjktvo.getStgl();
					if(stgl.getStzj()!=null||stgl.getStzj()!=0){
						Dtxxs dtxx = new Dtxxs(new DtxxsId(vo,stgl));
						if("多选题".equals(stgl.getStlx())){
							String[] values = request.getParameterValues("list["+i+"].stda");
							String stda = DogCreate.compageString(values);
							dtxx.setStda(stda);
							dtxx.setDtdf(0);
						}else{
							dtxx.setStda(sjktvo.getStda());
							dtxx.setDtdf(0);
						}
						vo.getDtxxes().add(dtxx);
					}					
				}
				boolean flag = this.getService().save(vo);
				request.setAttribute("msg",flag?"交卷成功!":"交卷失败!");
				this.resetToken(request);
			}
			return mapping.findForward("success");
	}
	public ActionForward cjList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String page = request.getParameter("page");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			Integer userPk = (Integer)request.getSession().getAttribute("userStuPk");
			Pageinfo pageinfo = this.getService().getPageinfo(" and A.xsxx.xszj=?",Integer.valueOf(page),userPk);
			request.setAttribute("pageinfo",pageinfo);
			return mapping.findForward("objList1");
	}
	public ActionForward syszList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String page = request.getParameter("page");
			String rmMsg = request.getParameter("rmMsg");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			if ("true".equals(rmMsg)) {
				request.getSession().removeAttribute("syszPk");
			}
			Pageinfo pageinfo = this.getService().getSyszPage("",Integer.valueOf(page));
			request.setAttribute("pageinfo",pageinfo);
			return mapping.findForward("syszList");
	}
	public ActionForward djxxList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			DjxxForm djxxForm = (DjxxForm) form;
			String page = request.getParameter("page");
			if (page == null || "".equals(page)) {
				page = "1";
			}
			String rmMsg = request.getParameter("rmMsg");
			if ("true".equals(rmMsg)) {
				request.getSession().setAttribute("syszPk",djxxForm.getVo().getSskssz());
			}
			Integer syszzj = (Integer)request.getSession().getAttribute("syszPk");
			Pageinfo pageinfo = this.getService().getPageinfo(" and A.sskssz = ?",Integer.valueOf(page),syszzj);
			request.setAttribute("pageinfo",pageinfo);
			return mapping.findForward("djxxList");
	}
	public ActionForward preupdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			DjxxForm djxxForm = (DjxxForm) form;
			Djxxs vo = this.getService().get(djxxForm.getVo().getDjzj());
			Sjxxs sjxx = vo.getSjxx();
			djxxForm.setSjxx(sjxx);
			djxxForm.setXsxx(vo.getXsxx());
			djxxForm.setVo(vo);
			List<SjxxVo> kt = this.getService().getDjst(djxxForm.getVo().getDjzj());
			request.setAttribute("kt", kt);
			this.saveToken(request);
			return mapping.findForward("gotoUpd");
	}
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if(this.isTokenValid(request)){
				DjxxForm djxxForm = (DjxxForm) form;
				Djxxs vo = djxxForm.getVo();
				Sjxxs sjxx = djxxForm.getSjxx();
				Xsxx xsxx = djxxForm.getXsxx();
				vo.setSjxx(sjxx);
				vo.setXsxx(xsxx);
				List list = djxxForm.getList();
				int count = 0;
				for(int i=0;i<list.size();i++){
					SjktVo sjktvo = (SjktVo)list.get(i);
					Stgls stgl = sjktvo.getStgl();
					if(stgl.getStzj()!=null||stgl.getStzj()!=0){
						Dtxxs dtxx = new Dtxxs(new DtxxsId(vo,stgl));
						dtxx.setDtdf(sjktvo.getDtdf());
						if("多选题".equals(stgl.getStlx())){
							String stda = request.getParameter("dxda"+i);
							dtxx.setStda(stda);
						}else{
							dtxx.setStda(sjktvo.getStda());							
						}
						vo.getDtxxes().add(dtxx);
					}
					count+=sjktvo.getDtdf();
				}
				vo.setDjdf(count);
				boolean flag = this.getService().update(vo);
				request.setAttribute("msg",flag?"阅卷成功!":"阅卷失败!");
				this.resetToken(request);
			}
			return mapping.findForward("successt");
	}
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String[] ids = request.getParameterValues("pk");
			boolean flag = this.getService().delete(ids);
			request.setAttribute("msg",flag?"删除成功!":"删除失败!");
			return mapping.findForward("successt");
	}
	public ActionForward preview(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			DjxxForm djxxForm = (DjxxForm) form;
			Djxxs vo = this.getService().get(djxxForm.getVo().getDjzj());
			Sjxxs sjxx = vo.getSjxx();
			djxxForm.setSjxx(sjxx);
			djxxForm.setXsxx(vo.getXsxx());
			djxxForm.setVo(vo);
			List<SjxxVo> kt = this.getService().getDjst(djxxForm.getVo().getDjzj());
			request.setAttribute("kt", kt);
			String backType = request.getParameter("backType");
			request.setAttribute("backType",backType);
			return mapping.findForward("gotoView");
	}
}