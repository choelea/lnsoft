/**
 * 
 */
package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Bjxx;
import com.whjbsoft.www.po.Jsgl;

/**
 * @author whjb
 * @Date 2009-9-24 ����05:46:34
 */
public interface BjglDAO {

	/**
	 * ��ѯ�ܼ�¼��
	 * @param con
	 * @param params
	 * @return
	 */
	public int count(String con,Object... params);
	/**
	 * ��ѯ��ҳ��Ϣ
	 * @param con
	 * @param curpage
	 * @param pagerecord
	 * @param params
	 * @return
	 */
	public List getObjects(String con,int curpage,int pagerecord,Object...params);
	/**
	 * ��ѯ������Ϣ
	 * @param id
	 * @return
	 */
	public Bjxx getBjxx(int id);
	/**
	 * ������ѯ
	 * @param hql
	 * @param params
	 * @return
	 */
	public List getObjects(String hql,Object... params);
	/**
	 * ��Ӷ���
	 * @param bjgl
	 * @throws Exception
	 */
	public void save(Bjxx bjxx) throws Exception;
	/**
	 * �޸Ķ�����Ϣ
	 * @param bjgl
	 * @throws Exception
	 */
	public void update(Bjxx bjxx) throws Exception;
	/**
	 * ɾ��������Ϣ
	 * @param id
	 * @throws Exception
	 */
	public void delete(int id) throws Exception;
	
	/**
	 * Method getJsgl
	 * @author whjb
	 * @date 2009-9-25 ����09:59:19
	 * @param id
	 * @return Jsgl
	 */
	public Jsgl getJsgl(int id);
	
}
