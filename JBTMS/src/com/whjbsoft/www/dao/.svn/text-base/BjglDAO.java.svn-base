/**
 * 
 */
package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Bjxx;
import com.whjbsoft.www.po.Jsgl;

/**
 * @author whjb
 * @Date 2009-9-24 下午05:46:34
 */
public interface BjglDAO {

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
	public Bjxx getBjxx(int id);
	/**
	 * 条件查询
	 * @param hql
	 * @param params
	 * @return
	 */
	public List getObjects(String hql,Object... params);
	/**
	 * 添加对象
	 * @param bjgl
	 * @throws Exception
	 */
	public void save(Bjxx bjxx) throws Exception;
	/**
	 * 修改对象信息
	 * @param bjgl
	 * @throws Exception
	 */
	public void update(Bjxx bjxx) throws Exception;
	/**
	 * 删除对象信息
	 * @param id
	 * @throws Exception
	 */
	public void delete(int id) throws Exception;
	
	/**
	 * Method getJsgl
	 * @author whjb
	 * @date 2009-9-25 上午09:59:19
	 * @param id
	 * @return Jsgl
	 */
	public Jsgl getJsgl(int id);
	
}
