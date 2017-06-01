package com.whjbsoft.www.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.whjbsoft.www.form.KccxForm;
import com.whjbsoft.www.po.Kfxx;
import com.whjbsoft.www.po.Qwxx;
import com.whjbsoft.www.service.QwxxService;
import com.whjbsoft.www.servicei.QwxxServicei;
import com.whjbsoft.www.util.Contants_st;

public class KccxAction extends DispatchAction {
	private QwxxService service;
	public KccxAction(){
		this.setService(new QwxxServicei());
	}
	public QwxxService getService() {
		return service;
	}
	public void setService(QwxxService service) {
		this.service = service;
	}
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
			KccxForm kccxForm = (KccxForm) form;
			Kfxx kfxx = kccxForm.getKfxx();
			Qwxx qwxx = kccxForm.getQwxx();
			List alist = new ArrayList();
			List blist = new ArrayList();
			if(kfxx.getKfzj()!=null && kfxx.getKfzj()!=0 && qwxx.getQwzj()!=null && qwxx.getQwzj()!=0){
				alist = this.getService().getCwxxList(" and A.qwxx.qwzj=? and A.cwzfm='A'",qwxx.getQwzj());				
				blist = this.getService().getCwxxList(" and A.qwxx.qwzj=? and A.cwzfm='B'",qwxx.getQwzj());
				qwxx = this.getService().getQwxx(qwxx.getQwzj());
				kccxForm.setQwxx(qwxx);
				Integer djzj = (Integer) request.getSession().getAttribute("userDjxxzj");
				this.getService().setDtxx(djzj, Contants_st.kf_cx);
			}
			request.setAttribute("alist",alist);
			request.setAttribute("blist",blist);
			return mapping.findForward("success");
		}		
}