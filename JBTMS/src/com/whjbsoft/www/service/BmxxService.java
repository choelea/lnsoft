package com.whjbsoft.www.service;

import com.whjbsoft.www.po.Bmxx;
import com.whjbsoft.www.util.Pageinfo;

public interface BmxxService {
	int pagerecord = 10;
	//��ҳ��Ϣ
	public Pageinfo getPageinfo(String con,int curpage,Object... params);	
	//��Ӳ���
	public boolean save(Bmxx bmxx);
	//�޸Ĳ���
	public boolean update(Bmxx bmxx);
	//ɾ������
	public boolean delete(String[] ids);
	//��ѯ����
	public Bmxx getBmxx(int id);
	//�Ƿ����
	public boolean isExist(String con,Object... params);
	
	
}
