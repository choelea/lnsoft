package com.whjbsoft.www.service;

import java.util.List;

import com.whjbsoft.www.po.Kfxx;
import com.whjbsoft.www.util.Pageinfo;

public interface KfxxService {
	int pagerecord = 10;
	//��ҳ��¼
	public Pageinfo getPageinfo(String con,int curpage,Object... params);
	public Pageinfo getPageinfo(int djzj,int stzj,String con,int curpage,Object... params);
	//������ѯ
	public List getObjects(String con,Object... params);
	//��ӿⷿ
	public boolean save(int djzj,int stzj,Kfxx kfxx);
	//�޸Ŀⷿ
	public boolean update(int djzj,int stzj,Kfxx kfxx);
	//ɾ��
	public boolean delete(int djzj,int stzj,String[] ids);
	//������ѯ
	public Kfxx getKfxx(int id);
	//�ⷿ�Ƿ��Ѵ���
	public boolean isExist(String con,Object... params);
	
}
