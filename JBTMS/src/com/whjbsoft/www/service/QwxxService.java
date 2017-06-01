package com.whjbsoft.www.service;

import java.util.List;

import com.whjbsoft.www.po.Cwxx;
import com.whjbsoft.www.po.Kfxx;
import com.whjbsoft.www.po.Qwxx;
import com.whjbsoft.www.util.Pageinfo;

public interface QwxxService {
	int pagerecord = 10;
	//��ҳ��Ϣ
	public Pageinfo getPageinfo(String con,int curpage,Object... params);
	public Pageinfo getPageinfo(int djzj,int stzj,String con,int curpage,Object... params);
	//������ѯ
	public List getObjects(String con,Object... params);
	//��ӿⷿ
	public boolean save(int djzj,int stzj,Qwxx qwxx);
	//�޸Ŀⷿ
	public boolean update(int djzj,int stzj,Qwxx qwxx);
	//ɾ��
	public boolean delete(int djzj,int stzj,String[] ids);
	//������ѯ
	public Qwxx getQwxx(int id);
	//�ⷿ�Ƿ��Ѵ���
	public boolean isExist(String con,Object... params);
	
	//��ȡ�ⷿ��Ϣ
	public Kfxx getKfxx(int id);
	//��Ӵ�λ
	public boolean saveCwxx(int djzj,int stzj,Qwxx qwxx);
	//�޸Ĵ�λ
	public boolean update(Cwxx cwxx);
	//���ô�λ���޺ʹ洢��Ʒ����
	public boolean resetCwxx(Cwxx cwxx);
	//��λ�б�
	public List getCwxxList(String con,Object... params);
	//�޸�����״̬
	public void setDtxx(int djzj,int stzj);
}
