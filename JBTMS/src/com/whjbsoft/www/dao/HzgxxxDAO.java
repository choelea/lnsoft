package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Hzgxxx;

public interface HzgxxxDAO {
//	��ѯ��¼
	public List list(String hql,int curpage,int pagerecord,Object...params);
	//��ѯָ������
	public Hzgxxx getHzgxxx(int id);
	//��Ӻ�����ϵ
	public void save(Hzgxxx hzgxxx) throws Exception ;
	//�޸ĺ�����ϵ��Ϣ
	public void update(Hzgxxx hzgxxx) throws Exception ;
	//ɾ��������ϵ��Ϣ
	public void delete(int id) throws Exception ;
	//��֤������ϵ�Ƿ����
	public List getHzgxxxs(String hql,Object... params);
	//��ѯ���ݿ��ܼ�¼��
	public int count(String hql,Object... params);
	//��ȡ������Ϣ
	public Dtxx getDtxx(int djzj,int stzj);
}
