/**
 * 
 */
package com.whjbsoft.www.service;

import java.util.List;

import com.whjbsoft.www.util.Pageinfo;

/**
 * @author whjb
 *
 */
public interface TestSetupService {
	public int pagerecord = 10;
	
	public Pageinfo getPageinfo(String countHql,String hql,int curpage,int pagerecord,Object...params);
	public boolean setup(Integer claPk,String[] stuPks,int sjzj,String sjmc);
	//班级列表
	public Pageinfo getClaPageinfo(String con,int curpage,Object...params);
	//实验组列表
	public Pageinfo getGroupPageinfo(String con,int curpage,Object...params);
	//组员列表
	public List getXsxxList(String con,Object... params);
	//未分配学生列表
	public Pageinfo getXsxxPageinfo(String con,int curpage,Object...params);
	//角色列表
	public List getRuleList();
	/**
	 * 自动分配
	 * @param claPk
	 * 	参数：班级主键
	 * @param groupSize
	 * 	参数：实验组大小，即单人试验还是团队合作
	 */
	public void assignRule(int claPk,int groupSize);
	/**
	 * 角色交换
	 * @param claPk
	 * @param gids
	 */
	public void exchangeRule(int claPk,String[] gids);
	//手动分配
	public void handSetRule(int claPk,String[] stuIds);
	//设置组员权限
	public void resetRule(int id,String[] ruleIds);	
	//班级人数统计
	public int countXsxx(int claPk);
	//判断是否拥有指定权限
	public boolean hasRule(int userId,int ruleId);
}
