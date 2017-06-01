package com.whjbsoft.www.servicei;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;

import com.whjbsoft.www.dao.DjxxDAO;
import com.whjbsoft.www.dao.HtxxDAO;
import com.whjbsoft.www.dao.ZdglDAO;
import com.whjbsoft.www.daoi.DjxxDAOi;
import com.whjbsoft.www.daoi.HtxxDAOi;
import com.whjbsoft.www.daoi.ZdglDAOi;
import com.whjbsoft.www.po.Crkdd;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Khht;
import com.whjbsoft.www.po.Yspsd;
import com.whjbsoft.www.po.Zdgl;
import com.whjbsoft.www.service.ZdglService;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;
import com.whjbsoft.www.vo.ZdtjVo;

public class ZdglServicei extends HibernateDaoSupport implements ZdglService {
	private ZdglDAO dao;
	private DjxxDAO ddao;
	private HtxxDAO hdao;
	public ZdglServicei() {
		this.setDao(new ZdglDAOi());
		this.setDdao(new DjxxDAOi());
		this.setHdao(new HtxxDAOi());
	}
	public ZdglDAO getDao() {
		return dao;
	}
	public void setDao(ZdglDAO dao) {
		this.dao = dao;
	}
	public DjxxDAO getDdao() {
		return ddao;
	}
	public void setDdao(DjxxDAO ddao) {
		this.ddao = ddao;
	}
	public HtxxDAO getHdao() {
		return hdao;
	}
	public void setHdao(HtxxDAO hdao) {
		this.hdao = hdao;
	}
	public boolean delete(int djzj, int stzj, String[] ids) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			this.getHibernate_Template().beginTran();
				if(dtxx!=null){
					dtxx.setSfdt(1);
				}
				for (String string : ids) {
					this.getDao().delete(Integer.parseInt(string));
				}
			this.getHibernate_Template().commitTran();
			return true;
		}catch(Exception e){
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	
	public List getObjects(String con, Object... params) {
		try{
			return this.getDao().getObjects(con, params);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public Pageinfo getPageinfo(int djzj, int stzj, String con, int curpage, Object... params) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			this.getHibernate_Template().beginTran();
			if(dtxx!=null)
				dtxx.setSfdt(1);
			int count = this.getDao().count(con, params);
			List list = this.getDao().getPageinfo(con, curpage, pagerecord, params);
			Pageinfo pageinfo = new Pageinfo(count,pagerecord,list);
			pageinfo.setCurpage(curpage);
			this.getHibernate_Template().commitTran();
			return pageinfo;
		}catch(Exception e){
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public Pageinfo getPageinfo(String con, int curpage, Object... params) {
		try{
			int count = this.getDao().count(con, params);
			List list = this.getDao().getPageinfo(con, curpage, pagerecord, params);
			Pageinfo pageinfo = new Pageinfo(count,pagerecord,list);
			pageinfo.setCurpage(curpage);
			return pageinfo;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public Zdgl getZdgl(int id) {
		try{
			return this.getDao().getZdgl(id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public boolean save(int djzj, int stzj, Zdgl zdgl,Khht khht) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			this.getHibernate_Template().beginTran();
			if(dtxx!=null)
				dtxx.setSfdt(1);
			this.getDao().save(zdgl);
			Khht ht = this.getHdao().getHtxx(khht.getHtzj());
			ht.setSfjs(1);
			this.getHibernate_Template().commitTran();
			return true;
		}catch(Exception e){
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public boolean update(int djzj, int stzj, Zdgl zdgl) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			this.getHibernate_Template().beginTran();
			if(dtxx!=null)
				dtxx.setSfdt(1);
			this.getDao().update(zdgl);
			this.getHibernate_Template().commitTran();
			return true;
		}catch(Exception e){
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public boolean valiZdgl(int djzj, int stzj, Zdgl zdgl) {
		try{
			Dtxx dtxx = this.getDdao().getDtxx("",djzj,stzj);
			this.getHibernate_Template().beginTran();
			if(dtxx!=null)
				dtxx.setSfdt(1);
			Zdgl zd = this.getDao().getZdgl(zdgl.getZzdzj());
			zd.setSfhx(1);
			this.getHibernate_Template().commitTran();
			return true;
		}catch(Exception e){
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public ZdtjVo countZdfy(int htzj) {
		try{
			ZdtjVo vo = new ZdtjVo();
			Khht ht = this.getHdao().getHtxx(htzj);
			vo.setKhxm(ht.getKhdd().getKhxxByKhzj().getDwmc());
			vo.setSkr(ht.getKhdd().getKhxxByKhzj().getSsjg());
			vo.setYfk(0.0);
			vo.setYf(0.0);
			vo.setBf(0.0);
			vo.setZf(0.0);
			vo.setCcfy(0.0);
			vo.setCcyqfy(0.0);
			vo.setZje(0.0);
			if("外包合同".equals(ht.getHtlx())){
				//运输配送费用
				String hql = "from Yspsd A where A.khht.htzj = ?";
				List list = this.getDao().getObjects(hql,htzj);
				if(list!=null && !list.isEmpty()){
					Yspsd ys = (Yspsd)list.get(list.size()-1);
					vo.setYfk(ys.getYsk());
					vo.setYf(ys.getYf());
					vo.setBf(ys.getBxf());
					vo.setZf(ys.getZf());
				}
				//仓储费用
				hql = "select A.hpsl*A.hptj,A.tjdw from Khddhpb A where A.khdd.ddzj = ?";
				list = this.getDao().getObjects(hql, ht.getKhdd().getDdzj());
				//计算存储总体积
				double sum = 0.0;
				if(list!=null && !list.isEmpty()){
					for(int i=0;i<list.size();i++){
						Object[] obj = (Object[])list.get(i);
						Double ztj = (Double)obj[0];
						if(ztj==null){
							ztj=0.0;
						}
						String dw = String.valueOf(obj[1]);
						if("立方厘米".equals(dw)){
							ztj/=1000000;
						}else if("立方毫米".equals(dw)){
							ztj/=1000000000;
						}
						sum+=ztj;
					}
				}
				//计算存储天数
				int num = 1;
				String start = FormateDate.formate();//入库时间
				String end = start;//出库时间
				hql = "from Crkdd A where A.khht.htzj = ? and A.ddlx = ?";
				list = this.getDao().getObjects(hql, htzj,"入库");
				if(list!=null && !list.isEmpty()){
					Crkdd crkdd = (Crkdd)list.get(0);//查询第一次入库时间
					if(crkdd.getSjcrksj()!=null&&!"".equals(crkdd.getSjcrksj())){
						start = crkdd.getSjcrksj();
					}
				}
				list = this.getDao().getObjects(hql, htzj,"出库");
				if(list!=null && !list.isEmpty()){
					Crkdd crkdd = (Crkdd)list.get(list.size()-1);//查询最后一次出库时间
					if(crkdd.getSjcrksj()!=null&&!"".equals(crkdd.getSjcrksj())){
						end = crkdd.getSjcrksj();
					}
				}
				num+=FormateDate.contrastDate(start,end);
				vo.setCcfy(num*sum*ht.getCcdj());
				vo.setZje(vo.getYf()+vo.getZf()+vo.getBf()+vo.getCcfy()-vo.getYfk());//总金额=运费+杂费+保费+仓储费-预付款
				//仓储延期费用
				
			}else if("仓储合同".equals(ht.getHtlx())){//仓储合同费用计算公式=合同签订
//				仓储费用
				String hql = "select A.hpsl*A.hptj,A.tjdw from Khddhpb A where A.khdd.ddzj = ?";
				List list = this.getDao().getObjects(hql, ht.getKhdd().getDdzj());
				//计算存储总体积
				double sum = 0.0;
				if(list!=null && !list.isEmpty()){
					for(int i=0;i<list.size();i++){
						Object[] obj = (Object[])list.get(i);
						Double ztj = (Double)obj[0];
						if(ztj==null){
							ztj=0.0;
						}
						String dw = String.valueOf(obj[1]);
						if("立方厘米".equals(dw)){
							ztj/=1000000;
						}else if("立方毫米".equals(dw)){
							ztj/=1000000000;
						}
						sum+=ztj;
					}
				}
//				计算存储天数
				int num = 1;
				String start = ht.getTdsj();//入库时间
				String end = ht.getJzrq();//出库时间
				num+=FormateDate.contrastDate(start,end);
				vo.setCcfy(num*sum*ht.getCcdj());
				vo.setZje(vo.getCcfy());//总金额=仓储费
			}else{
				String hql = "from Yspsd A where A.khht.htzj = ?";
				List list = this.getDao().getObjects(hql,htzj);
				if(list!=null && !list.isEmpty()){
					Yspsd ys = (Yspsd)list.get(list.size()-1);
					vo.setYfk(ys.getYsk());
					vo.setYf(ys.getYf());
					vo.setBf(ys.getBxf());
					vo.setZf(ys.getZf());
					vo.setZje(vo.getYf()+vo.getZf()+vo.getBf()-vo.getYfk());//总金额=运费+杂费+保费-预付款
				}
			}
			return vo;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
	public boolean exportExcel(int zdzj, HttpServletResponse response) {
		try{
			Zdgl zd = this.getDao().getZdgl(zdzj);
			if(zd!=null){				
				HSSFWorkbook book = new HSSFWorkbook();//创建工作簿
				HSSFSheet sheet = book.createSheet("账单");//创建工作表
				//账单格式管理
				//1、账单标题样式管理
				HSSFCellStyle titleStyle = book.createCellStyle();//创建样式对象
				titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//设置居中排版格式
				titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//设置列居中排版
				titleStyle.setBorderBottom(HSSFCellStyle.BORDER_NONE);
				titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
				titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
				titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);				
				HSSFFont titleFont = book.createFont();//设置字体样式
				titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体
				titleFont.setFontName(HSSFFont.FONT_ARIAL);//设置字体				
				titleStyle.setFont(titleFont);
				//2、账单内容样式管理
				HSSFCellStyle contentStyle = book.createCellStyle();//创建样式对象
				contentStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//设置居中排版格式
				contentStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//设置列居中排版
				contentStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				contentStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
				contentStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
				contentStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
				HSSFFont contentFont = book.createFont();//设置字体样式
				contentFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);//非粗体
				contentFont.setFontName(HSSFFont.FONT_ARIAL);//设置字体				
				contentStyle.setFont(contentFont);			
				
				HSSFRow titleRow = sheet.createRow(0);//创建标题行
				HSSFCell titleCell = titleRow.createCell((short)0);//标题列
				//设置行高和列宽
				titleRow.setHeight((short)(titleRow.getHeight()*2));
				sheet.setColumnWidth((short)0,(short)5000);
				sheet.setColumnWidth((short)1,(short)5000);
				sheet.setColumnWidth((short)2,(short)5000);
				sheet.setColumnWidth((short)3,(short)5000);
				//设置标题内容
				HSSFRichTextString titleContent = new HSSFRichTextString("合同("+zd.getSyhth()+")费用账单");
				titleCell.setCellValue(titleContent);
				titleCell.setCellStyle(titleStyle);
				sheet.addMergedRegion(new Region(0,(short)0,0,(short)3));//合并单元格
				
				//账单客户信息
				String[][] zdxx = new String[][]{{"账单编号",zd.getZzdbh()},{"账单编号",zd.getZzdbh()},{"合 同 号",zd.getSyhth()},{"结算方式 ",zd.getJsfs()},{"客户姓名",zd.getKhqm()},{"付款帐号",zd.getFkzh()}};
				int size = zdxx.length/2;
				for(int i=0;i<size;i++){
					int rowNo = 1+i;
					HSSFRow row1 = sheet.createRow(rowNo);
					row1.setHeight((short)(titleRow.getHeight()));//行高
					HSSFCell cell10 = row1.createCell((short)0);//第一列
					HSSFCell cell11 = row1.createCell((short)1);//第二列
					HSSFCell cell12 = row1.createCell((short)2);//第三列
					HSSFCell cell13 = row1.createCell((short)3);//第四列
									
					HSSFRichTextString content10 = new HSSFRichTextString(zdxx[i*2][0]);
					HSSFRichTextString content11 = new HSSFRichTextString(zdxx[i*2][1]);
					HSSFRichTextString content12 = new HSSFRichTextString(zdxx[i*2+1][0]);
					HSSFRichTextString content13 = new HSSFRichTextString(zdxx[i*2+1][1]);
					cell10.setCellValue(content10);
					cell10.setCellStyle(contentStyle);
					cell11.setCellValue(content11);
					cell11.setCellStyle(contentStyle);
					cell12.setCellValue(content12);
					cell12.setCellStyle(contentStyle);
					cell13.setCellValue(content13);
					cell13.setCellStyle(contentStyle);
				}				
				//费用明细信息
				String[][] mx = new String[][]{{"序 号","费用名称","金 额"},{"1","预付款",zd.getYfk()+""},{"2","运 费",zd.getYf()+""},{"3","杂 费",zd.getZf()+""},{"4","保 费",zd.getBf()+""},{"","总 计",zd.getZje()+""}};
				for(int i=0;i<mx.length;i++){
					int rowNo = 4+i;//行号
					HSSFRow row2 = sheet.createRow(rowNo);
					row2.setHeight((short)(titleRow.getHeight()));//行高
					HSSFCell cell20 = row2.createCell((short)0);//第一列
					HSSFCell cell21 = row2.createCell((short)1);//第二列
					sheet.addMergedRegion(new Region(rowNo,(short)1,rowNo,(short)2));
					HSSFCell cell23 = row2.createCell((short)3);//第四列
					HSSFRichTextString content20 = new HSSFRichTextString(mx[i][0]);
					HSSFRichTextString content21 = new HSSFRichTextString(mx[i][1]);					
					HSSFRichTextString content23 = new HSSFRichTextString(mx[i][2]);
					cell20.setCellValue(content20);
					cell20.setCellStyle(contentStyle);
					cell21.setCellValue(content21);
					cell21.setCellStyle(contentStyle);
					cell23.setCellValue(content23);
					cell23.setCellStyle(contentStyle);					
				}
				
				//下载文件
				response.setHeader("Content-Disposition", "attachment;filename="+zd.getZzdbh()+".xls");
				OutputStream os = response.getOutputStream();
				book.write(os);
				if(os!=null)
					os.close();
				book=null;
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			this.getHibernate_Template().closeSession();
		}
	}
}