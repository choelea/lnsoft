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
	//�༶�б�
	public Pageinfo getClaPageinfo(String con,int curpage,Object...params);
	//ʵ�����б�
	public Pageinfo getGroupPageinfo(String con,int curpage,Object...params);
	//��Ա�б�
	public List getXsxxList(String con,Object... params);
	//δ����ѧ���б�
	public Pageinfo getXsxxPageinfo(String con,int curpage,Object...params);
	//��ɫ�б�
	public List getRuleList();
	/**
	 * �Զ�����
	 * @param claPk
	 * 	�������༶����
	 * @param groupSize
	 * 	������ʵ�����С�����������黹���ŶӺ���
	 */
	public void assignRule(int claPk,int groupSize);
	/**
	 * ��ɫ����
	 * @param claPk
	 * @param gids
	 */
	public void exchangeRule(int claPk,String[] gids);
	//�ֶ�����
	public void handSetRule(int claPk,String[] stuIds);
	//������ԱȨ��
	public void resetRule(int id,String[] ruleIds);	
	//�༶����ͳ��
	public int countXsxx(int claPk);
	//�ж��Ƿ�ӵ��ָ��Ȩ��
	public boolean hasRule(int userId,int ruleId);
}
