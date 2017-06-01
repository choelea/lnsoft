package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Bjxx;
import com.whjbsoft.www.po.Xsxx;

public interface XsglDAO {
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
	public Xsxx getXsgl(int id);
	/**
	 * ������ѯ
	 * @param hql
	 * @param params
	 * @return
	 */
	public List getObjects(String hql,Object... params);
	/**
	 * ��Ӷ���
	 * @param xsgl
	 * @throws Exception
	 */
	public void save(Xsxx xsgl) throws Exception;
	/**
	 * �޸Ķ�����Ϣ
	 * @param xsgl
	 * @throws Exception
	 */
	public void update(Xsxx xsgl) throws Exception;
	/**
	 * ɾ��������Ϣ
	 * @param id
	 * @throws Exception
	 */
	public void delete(int id) throws Exception;
	/**
	 * ��ʦ��½��֤
	 * @param userName
	 * @param paw
	 * @return
	 */
	public Xsxx getXsgl(String userName,String paw);
	
	/**
	 * ȡ�ð༶��Ϣ
	 * Method getBjgl
	 * @author whjb
	 * date 2009-10-26 ����10:08:07
	 * @param id
	 * @return Bjgl
	 */
	public Bjxx getBjgl(int id);
	
	/**
	 * Method getObject
	 * @author whjb
	 * date 2009-10-26 ����10:28:31
	 * @param hql
	 * @param params
	 * @return Object
	 */
	public Object getObject(String hql,Object...params);
	
	public List getStu(String hql, Object... params);
}
