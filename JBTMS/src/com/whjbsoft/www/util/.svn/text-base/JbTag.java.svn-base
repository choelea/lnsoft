package com.whjbsoft.www.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class JbTag extends TagSupport {
	private Integer property;

	@Override
	public int doStartTag() throws JspException {
		String[] nums = { "一", "二", "三", "四", "五", "六", "七", "八", "九", "十" };
		if (property >= 0 && property < nums.length) {
			JspWriter out = this.pageContext.getOut();
			try {
				out.write(nums[property]);
			} catch (Exception e) {
			}
		}
		return EVAL_BODY_INCLUDE;
	}

	public Integer getProperty() {
		return property;
	}

	public void setProperty(Integer property) {
		this.property = property;
	}
}
