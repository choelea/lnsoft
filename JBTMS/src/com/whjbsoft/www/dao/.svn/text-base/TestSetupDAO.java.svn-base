/**
 * 
 */
package com.whjbsoft.www.dao;

import java.io.Serializable;
import java.util.List;

import com.whjbsoft.www.po.Sjxx;
import com.whjbsoft.www.po.Sysz;
import com.whjbsoft.www.po.Xsgwxx;

/**
 * @author whjb
 *
 */
public interface TestSetupDAO {
	public List list(String hql,int curpage,int pagerecord,Object...params);
	public Sjxx getSjxx(int id);
	public void save(Sysz sysz) throws Exception ;
	public void delete(int id) throws Exception ;
	public void update(Sysz sysz)throws Exception;
	public List getTestInfo(String hql,Object...params);
	public int count(String hql,Object... params);
	public Sysz getSysz(int id);
//	删除学生岗位信息
	public void deleteXsgw(int id) throws Exception;
	public void update(Xsgwxx xsgwxx) throws Exception;
	public void save(Xsgwxx xsgwxx) throws Exception;
	public void delete(Serializable id) throws Exception;
}
