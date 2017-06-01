package com.whjbsoft.www.util;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.whjbsoft.www.po.Cwxx;
import com.whjbsoft.www.po.Ggxx;
import com.whjbsoft.www.po.Kfxx;
import com.whjbsoft.www.po.Sjxx;
import com.whjbsoft.www.po.Xsxx;
import com.whjbsoft.www.service.BjglService;
import com.whjbsoft.www.service.GgxxService;
import com.whjbsoft.www.service.JsglService;
import com.whjbsoft.www.service.KfxxService;
import com.whjbsoft.www.service.QwxxService;
import com.whjbsoft.www.service.SjxxService;
import com.whjbsoft.www.service.SjzdService;
import com.whjbsoft.www.service.TestSetupService;
import com.whjbsoft.www.service.XsglService;
import com.whjbsoft.www.service.ZdglService;
import com.whjbsoft.www.servicei.BjglServicei;
import com.whjbsoft.www.servicei.GgxxServicei;
import com.whjbsoft.www.servicei.JsglServicei;
import com.whjbsoft.www.servicei.KfxxServicei;
import com.whjbsoft.www.servicei.KhddServicei;
import com.whjbsoft.www.servicei.QwxxServicei;
import com.whjbsoft.www.servicei.SjxxServicei;
import com.whjbsoft.www.servicei.SjzdServicei;
import com.whjbsoft.www.servicei.TestSetupServicei;
import com.whjbsoft.www.servicei.XsglServicei;
import com.whjbsoft.www.servicei.YsddServicei;
import com.whjbsoft.www.servicei.ZdglServicei;
import com.whjbsoft.www.vo.KtxxVo;
import com.whjbsoft.www.vo.SjhpVo;
import com.whjbsoft.www.vo.SjxxVo;
import com.whjbsoft.www.vo.ZdtjVo;


public class UserDWR {
	public boolean  isExistJsxx(int sign,String fieldName,String fieldValue){
		JsglService service = new JsglServicei();
		boolean flag = service.isExistJsgl(sign, fieldName, fieldValue);
		return flag;
	}
	public Pageinfo getGoods(int curpage){
		SjxxService service = new SjxxServicei();
		Pageinfo pageinfo = service.getGoods("", curpage);
		return pageinfo;
	}
	/**
	 * �жϰ༶��Ϣ�Ƿ����ظ�
	 * Method isExistBjxx
	 * @author whjb
	 * date 2009-11-25 
	 * @param sign
	 * @param fieldName
	 * @param fieldValue
	 * @return boolean
	 */
	public boolean isExistBjxx(int sign, String fieldName, String fieldValue) {
		BjglService service = new BjglServicei();
		boolean flag = service.isExistBjgl(sign, fieldName, fieldValue);
		return flag;
	}
	
	//�ж������Ƿ����
	public boolean isExit(String hql,String... params){
		SjzdService s = new SjzdServicei();
		return s.nameExist(hql, params);
	}
	/**
	 * �����ҳ��Ϣ
	 * 
	 * @param con
	 *            ��ѯ����
	 * @param curpage
	 *            ��ǰҳ��
	 * @param params
	 *            ������Ϣ
	 * @return
	 */
	public Pageinfo claPagedata(String con, int curpage, Object... params) {
		GgxxService s = new GgxxServicei();
		return s.getClaPagedata(con, curpage, params);
	}
	
	//��ҳ
	public Pageinfo getPageinfo(String countHql,String hql,int curpage,int pagerecord,String... params){
		SjzdService s = new SjzdServicei();	
		return s.getPageinfo(countHql, hql, curpage,pagerecord, params);
	}
	
	//����������
	public String createTxm(){
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int i = r.nextInt(1000000000);
		while(i<100000000){
			i = r.nextInt(1000000000);
		}
		sb.append(i);
		i = r.nextInt(10000);
		while(i<1000){
			i = r.nextInt(10000);
		}
		sb.append(i);
		return sb.toString();
	}
	//��ȡƴ����
	public String createPym(String sour){
		return Letter.getBeginCharacter(sour);
	}
	/**
	 * Method getSjzdmx ��ȡ�����ֵ���Ϣ
	 * @param curpage ҳ��
	 * @param sjzdzj �����ֵ�����
	 * @return the Pageinfo ��ҳ����
	 */
	public Pageinfo getSjzdmx(int curpage, int sjzdzj) {
		SjzdService s = new SjzdServicei();	
		Pageinfo pageinfo = s.getPagedata(" and A.sjzd.sjzdzj = ?", curpage,sjzdzj);
		return pageinfo;
	}
	
	/**
	 * �޸�ѧ����Ϣ
	 * 
	 * @param xsxx
	 * @return
	 */
	public boolean updateXsxx(Xsxx xsxx,HttpSession session) {
		XsglServicei s = new XsglServicei();
		Xsxx user = s.getXsgl(xsxx.getXszj());
		user.setXsxm(xsxx.getXsxm());
		user.setXsmm(xsxx.getXsmm());
		user.setRxsj(xsxx.getRxsj());
		user.setXb(xsxx.getXb());
		user.setXsdz(xsxx.getXsdz());
		user.setXsdh(xsxx.getXsdh());
		user.setZjhm(xsxx.getZjhm());
		user.setXsjg(xsxx.getXsjg());
		boolean flag = s.update(user);
		if(flag){	
			session.setAttribute("userTName", user.getXsxm());
			session.setAttribute("userPaw", user.getXsmm());
		}
		return flag;
	}
	
	/**
	 * �����Ծ������鿴�Ծ���ϸ��Ϣ
	 * 
	 * @param pk
	 *            �������Ծ�����
	 * @return
	 */
	public SjxxVo getSjxx(int pk,int djzj) {
		SjxxService s = new SjxxServicei();
		/** ��ȡ�Ծ���Ϣ */
		Sjxx sjxx = s.getSjxx(pk);
		/** ��ȡ������Ϣ */
		List list = s.getKtxxList("", pk,djzj);
		/** ���췵�ض�����Ϣ */
		/** ��ȡ�Ծ��Ʒ*/
		List<SjhpVo> sjhp = s.getSjhpVo(pk);
		/** ���췵�ض�����Ϣ */
		SjxxVo vo = new SjxxVo();
		vo.setSjhp(sjhp);
		try {
			BeanUtils.copyProperties(vo, sjxx);
			for (int i = 0; i < list.size(); i++) {
				KtxxVo ktxx = (KtxxVo) list.get(i);
				KtxxVo ktxxvo = new KtxxVo();
				BeanUtils.copyProperties(ktxxvo, ktxx);
				ktxxvo.setStlx(s.getKtlx(ktxx.getStlx()));
				vo.getList().add(ktxxvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	public Pageinfo getGgxxList(int claPk, int curpage) {
		GgxxService s = new GgxxServicei();
		Pageinfo pageinfo = s.getGgxxPagedata("and A.bjxx.bjzj=?", curpage,
				claPk);
		return pageinfo;
	}
	/**
	 * �õ�������Ϣ
	 */
	public String[] getFbGgxx(int ggzj){
		GgxxService service = new GgxxServicei();
		Ggxx ggxx = service.getGgxx(ggzj);
		String[]arr = new String[3];
		arr[0]=ggxx.getGgbt();
		arr[1]=ggxx.getFbsj();
		arr[2]=ggxx.getGgnr();
		return arr;
	}
	
	/**
	 * ��ѯ�Ծ��Ʒ��Ϣ
	 * @param sjzj
	 * @return
	 */
	public List getList(String hql,String ...params){
		KhddServicei s = new KhddServicei();
		return s.getList(hql,params);
	}
	public boolean resetCwxx(Cwxx cwxx){
		QwxxService s = new QwxxServicei();
		return s.resetCwxx(cwxx);
	}
	
	public ZdtjVo getZdgl(int htzj){
		ZdglService s = new ZdglServicei();
		return s.countZdfy(htzj);
	}
	/**
	 * �ɹ�
	 * @param hql
	 * @param ysddzj
	 * @param djzj
	 * @param ysddlx
	 * @param ygzj
	 * @return
	 */
	public boolean pgWork(String ysddlx,int ysddzj,int djzj,String[] ygzj) {
		YsddServicei s = new YsddServicei();
		int ktzj=0;
		if("����".equals(ysddlx)) {
			ktzj = Contants_st.ysdd_pg;
		}else {
			ktzj = Contants_st.psdd_pg;
		}
		boolean flag = s.pg(ysddzj, djzj, ktzj,ygzj);
		return flag;
	}
	/**
	 * �ɳ�
	 * @param hql
	 * @param ysddzj
	 * @param djzj
	 * @param ysddlx
	 * @param ylzj
	 * @return
	 */
	public boolean pcWork(String ysddlx,int ysddzj,int djzj,String[] ylzj) {
		YsddServicei s = new YsddServicei();
		int ktzj=0;
		if("����".equals(ysddlx)) {
			ktzj = Contants_st.ysdd_pc;
		}else {
			ktzj = Contants_st.psdd_pc;
		}
		boolean flag = s.pc(ysddzj, djzj, ktzj,ylzj);
		return flag;
	}
	//ͳ�ư༶ѧ������
	public int getXsxxCount(int claPk){
		TestSetupService s = new TestSetupServicei();
		return s.countXsxx(claPk);
	}
	//�ж��Ƿ�ӵ��Ȩ��
	public boolean changeSystemMode(int ruleId,HttpSession session){
		TestSetupService s = new TestSetupServicei();
		Integer userId = (Integer)session.getAttribute("userStuPk");//ѧ������
		boolean flag = s.hasRule(userId, ruleId);
		if(flag){
			session.setAttribute("curGwzj", ruleId);
		}
		return flag;
	}
	
	public String getKfSsjg(int kfzj){
		KfxxService service = new KfxxServicei();
		Kfxx kfxx = service.getKfxx(kfzj);
		if(kfxx!=null&&kfxx.getSsjg()!=null){
			return kfxx.getSsjg();
		}else{
			return "";
		}
	}
	
	public Xsxx getXsxx(int pk) {
		XsglService service = new XsglServicei();
		Xsxx xsxx = service.getXsgl(pk);
		return xsxx;
	}
}
