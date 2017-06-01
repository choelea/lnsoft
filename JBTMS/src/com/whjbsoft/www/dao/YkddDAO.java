package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Ykdd;

public interface YkddDAO {
	//��ѯ��¼����
	public int count(String con , Object... params);
	//��ѯ��ҳ��¼
	public List getPageinfo(String con,int curpage,int pagerecord,Object... params);
	//������ѯ
	public List getObjects(String con,Object... params);
	//������ѯ
	public Ykdd getYkdd(int id);
	//�����Ϣ
	public void save(Ykdd ykdd) throws Exception;
	//�޸���Ϣ
	public void update(Ykdd ykdd) throws Exception;
	//ɾ����Ϣ
	public void delete(int id) throws Exception;
}
