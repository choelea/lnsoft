package com.whjbsoft.www.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.service.SjxxService;
import com.whjbsoft.www.servicei.SjxxServicei;
import com.whjbsoft.www.util.Pageinfo;

public class TaskCircsAction extends DispatchAction {
	private SjxxService service;
	public TaskCircsAction(){
		this.setService(new SjxxServicei());
	}
	/**
	 * @return the service
	 */
	public SjxxService getService() {
		return service;
	}
	/**
	 * @param service the service to set
	 */
	public void setService(SjxxService service) {
		this.service = service;
	}
	public ActionForward objList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
//		DjxxForm djxxForm = (DjxxForm) form;
		
			Pageinfo pageinfo = new Pageinfo();
			request.setAttribute("pageinfo",pageinfo);
			return mapping.findForward("success");
		}
}