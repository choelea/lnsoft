package com.whjbsoft.www.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.whjbsoft.www.po.Khht;
import com.whjbsoft.www.po.Zdgl;
import com.whjbsoft.www.util.Pageinfo;
import com.whjbsoft.www.vo.ZdtjVo;

public interface ZdglService {
	int pagerecord = 10;
	//��ҳ��¼
	public Pageinfo getPageinfo(String con,int curpage,Object... params);
	public Pageinfo getPageinfo(int djzj,int stzj,String con,int curpage,Object... params);
	//������ѯ
	public List getObjects(String con,Object... params);
	//���
	public boolean save(int djzj,int stzj,Zdgl zdgl,Khht khht);
	//�޸�
	public boolean update(int djzj,int stzj,Zdgl zdgl);
	//ɾ��
	public boolean delete(int djzj,int stzj,String[] ids);
	//������ѯ
	public Zdgl getZdgl(int id);
	
	//�˵�����
	public boolean valiZdgl(int djzj,int stzj,Zdgl zdgl);
	//ͳ�ƺ�ͬ����
	public ZdtjVo countZdfy(int htzj);
	//�����˵�
	public boolean exportExcel(int zdzj,HttpServletResponse response);
}
