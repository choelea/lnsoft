package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Khht;
import com.whjbsoft.www.util.Pageinfo;

public interface HtxxService {
	public int pagerecord = 10;
	//	��ȡ��ͬ��Ϣ��ҳ��¼
	public Pageinfo getPagedata(String con,int curpage,Object...params);
	//��Ӻ�ͬ��Ϣ
	public boolean save(int dtzj,int stzj,Khht htxx);
	//�޸ĺ�ͬ��Ϣ
	public boolean update(int dtzj,int stzj,Khht htxx);
	//ɾ����ͬ��Ϣ
	public boolean delete(int dtzj,int stzj,String[] ids);
	//��ѯ��ͬ��Ϣ
	public Khht getHtxx(int id);
	//��ͬ��Ϣ����
	public Pageinfo getPagedata(int dtzj,int stzj,String con,int curpage,Object...params);
	//��ͬ��Ϣ�Ƿ����
//	public boolean htxxExist(String con,Object... params);
	
}
