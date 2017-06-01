package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Bjxx;
import com.whjbsoft.www.po.Xsxx;

public interface XsglDAO {
	/**
	 * 查询总记录数
	 * @param con
	 * @param params
	 * @return
	 */
	public int count(String con,Object... params);
	/**
	 * 查询分页信息
	 * @param con
	 * @param curpage
	 * @param pagerecord
	 * @param params
	 * @return
	 */
	public List getObjects(String con,int curpage,int pagerecord,Object...params);
	/**
	 * 查询对象信息
	 * @param id
	 * @return
	 */
	public Xsxx getXsgl(int id);
	/**
	 * 条件查询
	 * @param hql
	 * @param params
	 * @return
	 */
	public List getObjects(String hql,Object... params);
	/**
	 * 添加对象
	 * @param xsgl
	 * @throws Exception
	 */
	public void save(Xsxx xsgl) throws Exception;
	/**
	 * 修改对象信息
	 * @param xsgl
	 * @throws Exception
	 */
	public void update(Xsxx xsgl) throws Exception;
	/**
	 * 删除对象信息
	 * @param id
	 * @throws Exception
	 */
	public void delete(int id) throws Exception;
	/**
	 * 教师登陆验证
	 * @param userName
	 * @param paw
	 * @return
	 */
	public Xsxx getXsgl(String userName,String paw);
	
	/**
	 * 取得班级信息
	 * Method getBjgl
	 * @author whjb
	 * date 2009-10-26 上午10:08:07
	 * @param id
	 * @return Bjgl
	 */
	public Bjxx getBjgl(int id);
	
	/**
	 * Method getObject
	 * @author whjb
	 * date 2009-10-26 上午10:28:31
	 * @param hql
	 * @param params
	 * @return Object
	 */
	public Object getObject(String hql,Object...params);
	
	public List getStu(String hql, Object... params);
}
