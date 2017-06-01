package com.whjbsoft.www.exam.dao;

import java.util.List;

import com.whjbsoft.www.exam.po.Sjkts;
import com.whjbsoft.www.exam.po.Sjxxs;

public interface SjxxDAO {
	//ͳ�����ݿ��¼
	public int count(String con,Object... params);
	//������ѯ
	public List getObjects(String hql,Object... params);
	//��ҳ��¼��Ϣ
	public List getPageinfo(String con,int curpage,int pagerecord,Object... params);
	//��Ӽ�¼
	public void save(Sjxxs sjxx) throws Exception;
	public void save(Sjkts sjkt) throws Exception;
	//�޸ļ�¼
	public void update(Sjxxs sjxx) throws Exception;
	//ɾ����¼
	public void delete(int id) throws Exception;
	//������ѯ
	public Sjxxs getSjxx(int id);
}
