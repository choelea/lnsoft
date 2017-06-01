package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Khht;
import com.whjbsoft.www.po.Yspsd;

public interface SendDAO {
	//��ҳ��ѯ���Ͷ�����Ϣ
	public List list(String hql,int curpage,int pagerecord,Object...params);
	//��ѯָ������
	public Yspsd getYspsdxx(int id);
	//��ѯ���ݿ��ܼ�¼��
	public int count(String hql,Object... params);
	//�޸����͵���Ϣ
	public void update(Yspsd yspsdxx) throws Exception;
	public void save(Yspsd yspsdxx) throws Exception;
	public void delete(int id) throws Exception;
	//��ѯ����������Ϣ
	public List getInfo(String hql,Object...params);
	//��ȡ������Ϣ
	public Dtxx getDtxx(Object... params);
	public Khht getKhht(int id);
	public Object getObject(String hql,Object...params);
	public Object getObject(Class clazz, int id);
}