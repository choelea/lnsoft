package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Sbwxjlb;
import com.whjbsoft.www.util.Pageinfo;

public interface SbwxjlService {
	int pagerecord = 10;
	//��ҳ��Ϣ
	public Pageinfo getPageinfo(String con,int curpage,Object... params);	
	//���ά�޼�¼
	public boolean save(Sbwxjlb sbwxjl);
	//�޸�ά�޼�¼
	public boolean update(Sbwxjlb sbwxjl);
	//ɾ��ά�޼�¼
	public boolean delete(String[] ids);
	//��ѯά�޼�¼
	public Sbwxjlb getSbwxjlb(int id);
	
}
