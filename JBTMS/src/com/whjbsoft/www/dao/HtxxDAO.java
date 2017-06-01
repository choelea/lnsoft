package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Khdd;
import com.whjbsoft.www.po.Khht;

public interface HtxxDAO {
	//	��ѯ��¼
	public List list(String hql,int curpage,int pagerecord,Object...params);
	//��ѯָ������
	public Khht getHtxx(int id);
	//��Ӻ�ͬ��Ϣ
	public void save(Khht htxx) throws Exception ;
	//�޸ĺ�ͬ��Ϣ
	public void update(Khht htxx) throws Exception ;
	//ɾ���ͻ���Ϣ
	public void delete(int id) throws Exception ;
	//��֤��ͬ��Ϣ�Ƿ����
	public List getHtxxs(String hql,Object... params);
	//��ѯ���ݿ��ܼ�¼��
	public int count(String hql,Object... params);
	//��ȡ������Ϣ
	Dtxx getDtxx(int djzj,int ktzj);
	public Khdd getKhdd(int id);
}