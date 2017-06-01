package com.whjbsoft.www.exam.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class LoginLtsForm extends ActionForm {
	private String userName;
	private String userPaw;
	private String userType;
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		return null;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPaw() {
		return userPaw;
	}
	public void setUserPaw(String userPaw) {
		this.userPaw = userPaw;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
}