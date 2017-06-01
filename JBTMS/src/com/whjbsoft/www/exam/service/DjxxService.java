package com.whjbsoft.www.exam.service;

import java.util.List;

import com.whjbsoft.www.exam.po.Djxxs;
import com.whjbsoft.www.exam.po.Sjxxs;
import com.whjbsoft.www.exam.vo.SjxxVo;
import com.whjbsoft.www.util.Pageinfo;

public interface DjxxService {
	int pagerecord = 10;
//	��ҳ��Ϣ
	public Pageinfo getPageinfo(String con,int curpage,Object... params);
	//��ȡ�б�
	public List getObjects(String hql,Object... params);
	//�����Ϣ
	public boolean save(Djxxs djxx);
	//�޸���Ϣ
	public boolean update(Djxxs djxx);
	//ɾ����Ϣ
	public boolean delete(String[] ids);
	//������ѯ
	public Djxxs get(int id);
	//������ѯ�Ծ���Ϣ
	public Sjxxs getSjxx(int id);
	
	//�Ծ���ϸ��Ϣ
	public List<SjxxVo> getSjst(int id);
//	�����ϸ��Ϣ
	public List<SjxxVo> getDjst(int id);
	//�������÷�ҳ��Ϣ
	public Pageinfo getSyszPage(String con ,int curpage ,Object... params);
}
