package com.whjbsoft.www.exam.dao;

import java.util.List;

import com.whjbsoft.www.exam.po.Djxxs;

public interface DjxxDAO {
//	ͳ�����ݿ��¼
	public int count(String con,Object... params);
	//������ѯ
	public List getObjects(String hql,Object... params);
	//��ҳ��¼��Ϣ
	public List getPageinfo(String con,int curpage,int pagerecord,Object... params);
	//��Ӽ�¼
	public void save(Djxxs djxx) throws Exception;
	//�޸ļ�¼
	public void update(Djxxs djxx) throws Exception;
	//ɾ����¼
	public void delete(int id) throws Exception;
	//������ѯ
	public Djxxs getDjxx(int id);
}
