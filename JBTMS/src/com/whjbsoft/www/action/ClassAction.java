/**
 * 
 */
package com.whjbsoft.www.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.ClassForm;
import com.whjbsoft.www.po.Bjxx;
import com.whjbsoft.www.service.BjglService;
import com.whjbsoft.www.servicei.BjglServicei;
import com.whjbsoft.www.util.Pageinfo;

/**
 * @author whjb
 * @Date 2009-9-25 上午09:49:50
 */
public class ClassAction extends DispatchAction {
	private BjglService service;

	public ClassAction() {
		service = new BjglServicei();
	}

	/**
	 * 分页取得班级信息 Method getList
	 * 
	 * @author whjb
	 * @Date 2009-9-21 上午09:29:24
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward getList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String curpage = request.getParameter("page");
			if (curpage == null || "".equals(curpage)) {
				curpage = "1";
			}
			String con ="";
			Integer userType = (Integer) request.getSession().getAttribute("userType");
			if(userType==1){
				Integer userPk = (Integer) request.getSession().getAttribute("userPk");
				con = " and C.jxzj = "+userPk;
			}
			Pageinfo pageinfo = this.getService().getPagedata(con,
					Integer.parseInt(curpage));
			request.setAttribute("pageinfo", pageinfo);
			this.saveToken(request);
			return mapping.findForward("listPage");
		}

	/**
	 * 跳转到添加页面 Method goAdd
	 * 
	 * @author whjb
	 * @Date 2009-9-21 上午09:28:01
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward goAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			this.saveToken(request);
			return mapping.findForward("addPage");
		}

	/**
	 * 添加班级 Method saveObject
	 * 
	 * @author whjb
	 * @Date 2009-9-21 上午09:58:13
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward saveObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if (isTokenValid(request)) {
				int jszj = (Integer) request.getSession()
						.getAttribute("userPk");
				ClassForm bjglForm = (ClassForm) form;
				Bjxx bjgl = bjglForm.getVo();
				boolean flag = this.getService().save(bjgl, jszj);
				request.setAttribute("msg", flag ? "班级信息添加成功！" : "班级信息添加失败！");
				this.resetToken(request);
			}
			return mapping.findForward("getList");
		}

	/**
	 * 跳转到修改页面 Method goUpdate
	 * 
	 * @author whjb
	 * @Date 2009-9-21 上午09:58:26
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward goUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			ClassForm bjglForm = (ClassForm) form;
			String pk = request.getParameter("pk");
			Bjxx bjgl = this.getService().getBjgl(Integer.parseInt(pk));
			bjglForm.setVo(bjgl);
			this.saveToken(request);
			return mapping.findForward("updatePage");
		}

	/**
	 * 修改班级信息 Method updateObject
	 * 
	 * @author whjb
	 * @Date 2009-9-21 上午09:58:41
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward updateObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if (this.isTokenValid(request)) {
				ClassForm bjglForm = (ClassForm) form;
				Bjxx bjgl = bjglForm.getVo();
				boolean flag = this.getService().update(bjgl);
				request.setAttribute("msg", flag ? "修改班级信息成功！" : "修改班级信息失败！");
				this.resetToken(request);
			}
			return mapping.findForward("getList");
		}

	/**
	 * 删除班级信息 Method delObject
	 * 
	 * @author whjb
	 * @Date 2009-9-21 上午10:03:26
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward delObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			if (this.isTokenValid(request)) {
				String[] pk = request.getParameterValues("pk");
				boolean flag = this.getService().delBjgl(pk);
				request.setAttribute("msg", flag ? "删除班级信息成功！" : "删除班级信息失败！");
				this.resetToken(request);
			}
			return mapping.findForward("getList");
		}

	/**
	 * 查看班级详细信息 Method viewObject
	 * 
	 * @author whjb
	 * @Date 2009-9-21 上午10:03:35
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward viewObject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			ClassForm bjglForm = (ClassForm) form;
			String pk = request.getParameter("pk");
			Bjxx bjgl = this.getService().getBjgl(Integer.parseInt(pk));
			bjglForm.setVo(bjgl);
			return mapping.findForward("viewPage");
		}

	/**
	 * 分页取得班级信息 Method getList
	 * 
	 * @author whjb
	 * @Date 2009-9-21 上午09:29:24
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward getListForStu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			String curpage = request.getParameter("page");
			if (curpage == null || "".equals(curpage)) {
				curpage = "1";
			}
			String con ="";
			Integer userType = (Integer) request.getSession().getAttribute("userType");
			if(userType==1){
				Integer userPk = (Integer) request.getSession().getAttribute("userPk");
				con = " and C.jxzj = "+userPk;
			}
			Pageinfo pageinfo = this.getService().getPagedata(con,
					Integer.parseInt(curpage));
			request.setAttribute("pageinfo", pageinfo);
			return mapping.findForward("listForStuPage");
		}

	/**
	 * @return the service
	 */
	public BjglService getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(BjglService service) {
		this.service = service;
	}
}
