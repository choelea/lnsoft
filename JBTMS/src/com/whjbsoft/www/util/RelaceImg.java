package com.whjbsoft.www.util;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class RelaceImg extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 675068234801679272L;
	public String imgs;

	public static String getonerow(String HTMLStr) {
		String htmlStr = HTMLStr;
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;
		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
			String regEx_html = "<[^>]+>";
			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll("");
			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll("");
			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll("");
			textStr = htmlStr.replaceAll(" ", "");
			textStr = htmlStr.replaceAll("<", "<");
			textStr = htmlStr.replaceAll(">", ">");
			textStr = htmlStr.replaceAll("&", "&");
			textStr=htmlStr.replace("&nbsp;", "");
		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}
		return textStr.trim();
	}

	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		try {
//			String str = imgs.trim().replaceAll("\"", "\'").replaceAll(
//					"<img(.*?)/>", "");
//			int a = str.indexOf("<img");
//			String msg = "";
//			if (a == -1) {
//				msg = str;
//			} else {
//				msg = str.substring(0, a);
//			}
			String msg=RelaceImg.getonerow(imgs);
			out.write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
}
