package com.whjbsoft.www.util;

import com.whjbsoft.www.exam.service.KsszService;
import com.whjbsoft.www.exam.service.StglService;
import com.whjbsoft.www.exam.servicei.KsszServicei;
import com.whjbsoft.www.exam.servicei.StglServicei;
import com.whjbsoft.www.service.JsglService;
import com.whjbsoft.www.servicei.JsglServicei;



public class ExamDwr {
	public boolean isExist(String hql) {
		JsglService s = new JsglServicei();
		return s.isExist(hql);
	}

	/**
	 * 获取试题分页信息
	 * 
	 * @param con
	 * @return
	 */
	public Pageinfo stPageinfo(String con, int curpage) {
		StglService s = new StglServicei();
		return s.getPageinfo(con, curpage);
	}

	public Pageinfo getPageinfo(String countHql, String hql, int curpage) {
		KsszService s = new KsszServicei();
		return s.getPageinfo(countHql, hql, curpage);
	}
}
