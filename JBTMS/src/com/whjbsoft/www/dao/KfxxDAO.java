package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Kfxx;

public interface KfxxDAO {
	//��ѯ��¼����
	public int count(String con , Object... params);
	//��ѯ��ҳ��¼
	public List getPageinfo(String con,int curpage,int pagerecord,Object... params);
	//������ѯ
	public List getObjects(String con,Object... params);
	//������ѯ
	public Kfxx getKfxx(int id);
	//��ӿⷿ
	public void save(Kfxx kfxx) throws Exception;
	//�޸Ŀⷿ
	public void update(Kfxx kfxx) throws Exception;
	//ɾ���ⷿ
	public void delete(int id) throws Exception;
	
}
