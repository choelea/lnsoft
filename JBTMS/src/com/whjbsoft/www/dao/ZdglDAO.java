package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Zdgl;


public interface ZdglDAO {
	//��ѯ��¼����
	public int count(String con , Object... params);
	//��ѯ��ҳ��¼
	public List getPageinfo(String con,int curpage,int pagerecord,Object... params);
	//������ѯ
	public List getObjects(String con,Object... params);
	//������ѯ
	public Zdgl getZdgl(int id);
	//��ӿⷿ
	public void save(Zdgl zdgl) throws Exception;
	//�޸Ŀⷿ
	public void update(Zdgl zdgl) throws Exception;
	//ɾ���ⷿ
	public void delete(int id) throws Exception;
}
