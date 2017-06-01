package com.whjbsoft.www.dao;

import java.util.List;

import com.whjbsoft.www.po.Cwxx;
import com.whjbsoft.www.po.Qwxx;

public interface QwxxDAO {
//	��ѯ��¼����
	public int count(String con , Object... params);
	//��ѯ��ҳ��¼
	public List getPageinfo(String con,int curpage,int pagerecord,Object... params);
	//������ѯ
	public List getObjects(String con,Object... params);
	//������ѯ
	public Qwxx getQwxx(int id);
	//��ӿⷿ
	public void save(Qwxx qwxx) throws Exception;
	//�޸Ŀⷿ
	public void update(Qwxx qwxx) throws Exception;
	//ɾ���ⷿ
	public void delete(int id) throws Exception;
	//��Ӵ�λ
	public void save(Cwxx cwxx) throws Exception;
	//�޸Ĵ�λ
	public void update(Cwxx cwxx) throws Exception;
	//��λ�б�
	public List getCwlist(String con,Object... params);
	//��λ��Ϣ
	public Cwxx getCwxx(int id);
}
