package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Khdd;

public interface KhddDAO {
	public List list(String hql,int curpage,int pagerecord,Object...params);
	public Khdd getKhdd(int id);
	//��ӿͻ�����
	public void save(Khdd khddb) throws Exception ;
	//�޸Ŀͻ�������Ϣ
	public void update(Khdd  khdd) throws Exception ;
	//ɾ���ͻ�������Ϣ
	public void delete(int id) throws Exception ;
	//��ѯ���ݿ��ܼ�¼��
	public int count(String hql,Object... params);
	//������ѯ
	public List getObjects(String hql,Object... params);
	//ɾ������
	public void delete(Object obj) throws Exception;
//	��ȡ������Ϣ
	public Dtxx getDtxx(int djzj,int ktzj);
}
