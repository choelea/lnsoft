package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Hzgxxx;
import com.whjbsoft.www.util.Pageinfo;

public interface HzgxxxService {
	public int pagerecord = 10;
	//	��ȡ������ϵ��ҳ��¼
	public Pageinfo getPagedata(String con,int curpage,Object...params);
	//��Ӻ�����ϵ��Ϣ
	public boolean save(int dtzj,int stzj,Hzgxxx hzgxxx);
	//�޸ĺ�����ϵ��Ϣ
	public boolean update(int dtzj,int stzj,Hzgxxx hzgxxx);
	//ɾ��������ϵ��Ϣ
	public boolean delete(int dtzj,int stzj,String[] ids);
	//��ѯ������ϵ��Ϣ
	public Hzgxxx getHzgxxx(int id);
	//������ϵ����
	public Pageinfo getPagedata(int dtzj,int stzj,String con,int curpage,Object...params);
	//������ϵ��Ϣ�Ƿ����
	public boolean hzgxExist(String con,Object... params);
	
}
