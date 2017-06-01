package com.whjbsoft.www.servicei;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.TextAnchor;

import com.whjbsoft.www.dao.HtxxDAO;
import com.whjbsoft.www.dao.ZdglDAO;
import com.whjbsoft.www.daoi.HtxxDAOi;
import com.whjbsoft.www.daoi.ZdglDAOi;
import com.whjbsoft.www.po.Crkdd;
import com.whjbsoft.www.po.Khht;
import com.whjbsoft.www.po.Sbwxjlb;
import com.whjbsoft.www.po.Ygxx;
import com.whjbsoft.www.service.CcCwtjService;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.vo.ZdtjVo;

public class CcCwtjServicei extends HibernateDaoSupport implements CcCwtjService {
	private ZdglDAO dao;
	private HtxxDAO hdao;
	public CcCwtjServicei() {
		this.setDao(new ZdglDAOi());
		this.setHdao(new HtxxDAOi());
	}
	public ZdglDAO getDao() {
		return dao;
	}
	public void setDao(ZdglDAO dao) {
		this.dao = dao;
	}
	public HtxxDAO getHdao() {
		return hdao;
	}
	public void setHdao(HtxxDAO hdao) {
		this.hdao = hdao;
	}
	public ZdtjVo countCw(String con, Object... params) {
		try{
			ZdtjVo vo = new ZdtjVo();
			//初始信息
			vo.setYfk(0.0);
			vo.setYf(0.0);
			vo.setBf(0.0);
			vo.setZf(0.0);
			vo.setCcfy(0.0);
			vo.setCcyqfy(0.0);
			vo.setZje(0.0);
			StringBuffer hql1 = new StringBuffer("from Khht A where A.htzt>0 ");
			hql1.append(con);//此处拼接的条件应该有所属学生、所属试验设置
			List list1 = this.getDao().getObjects(hql1.toString(), params);
			if(list1!=null&&!list1.isEmpty()){
				for(int j=0;j<list1.size();j++){
					Khht ht = (Khht)list1.get(j);//获取合同信息
						//员工工资
						String hql = "from Ygxx A where A.ygzw <> ? ";
						List list = this.getDao().getObjects(hql,"司机");
						if(list!=null && !list.isEmpty()){
							for(int i=0;i<list.size();i++){
								Ygxx ygxx = (Ygxx) list.get(i);
								vo.setCcyqfy(ygxx.getYggz()+vo.getCcyqfy());
							}
						}
						//设备维修费
						hql = " from Sbwxjlb where ssxtmk = ?";
						list = this.getDao().getObjects(hql, 4);
						if(list!=null && !list.isEmpty()){
							for(int i=0;i<list.size();i++){
								Sbwxjlb sbwxjlb = (Sbwxjlb) list.get(i);
								vo.setBf(sbwxjlb.getWxfy()+vo.getBf());
							}
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
						list = this.getDao().getObjects(hql,ht.getHtzj(),"入库");
						if(list!=null && !list.isEmpty()){
							Crkdd crkdd = (Crkdd)list.get(0);//查询第一次入库时间
							if(crkdd.getSjcrksj()!=null&&!"".equals(crkdd.getSjcrksj())){
								start = crkdd.getSjcrksj();
							}
						}
						list = this.getDao().getObjects(hql,ht.getHtzj(),"出库");
						if(list!=null && !list.isEmpty()){
							Crkdd crkdd = (Crkdd)list.get(list.size()-1);//查询最后一次出库时间
							if(crkdd.getSjcrksj()!=null&&!"".equals(crkdd.getSjcrksj())){
								end = crkdd.getSjcrksj();
							}
						}
						num+=FormateDate.contrastDate(start,end);
						vo.setCcfy(num*sum*ht.getCcdj()+vo.getCcfy());
						vo.setZje(vo.getCcfy()-vo.getBf()-vo.getCcyqfy());//净收入=仓储费-员工工资-设备维修费
						//仓储延期费用
						
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
	
	public String getBarChartName(String type,HttpSession session,String con, Object... params) {
		ZdtjVo vo = this.countCw(con, params);
		String filename = null;
		PrintWriter pw = null;
		CategoryDataset dataset = getBarDataset(vo,type);
		JFreeChart chart = ChartFactory.createBarChart3D("财务统计表", "费 用", "金 额", dataset, PlotOrientation.VERTICAL, true, false, false);
		ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setNoDataMessage("暂无数据");
		plot.setForegroundAlpha(0.6f);
		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		//设置柱状图数值显示
		CategoryItemRenderer renderer= plot.getRenderer();
		renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setItemLabelsVisible(true);
		//显示位置
		renderer.setPositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,TextAnchor.BASELINE_RIGHT));
		try {
			String path = session.getServletContext().getRealPath("/tempImg");
			File tempFile = new File(path);
			if(tempFile.exists()){
				File[] childs = tempFile.listFiles();
				if(childs!=null&&childs.length!=0){
					for (File file : childs) {
						file.delete();
					}
				}				
			}else{
				tempFile.mkdir();
			}
			filename = ServletUtilities.saveChartAsPNG(chart, 600, 400, info, session);
			pw = new PrintWriter(new FileOutputStream("../webapps/WMS/tempImg/"+filename));
			ChartUtilities.writeImageMap(pw, filename, info,false);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}
		return filename;

	}
	public String getPieChartName(HttpSession session,String con, Object... params) {
		ZdtjVo vo = this.countCw(con, params);
		//文件名
		String filename = null;
		PrintWriter pw = null;
		//数据集
		PieDataset dataset = getPieDataset(vo);
		JFreeChart chart = ChartFactory.createPieChart3D("财务统计图表",dataset,true,true,true);
		ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
		//设置背景色
		chart.setBackgroundPaint(Color.pink);
		//设置前景透明
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setForegroundAlpha(0.6f);
		plot.setNoDataMessage("暂无数据");
		plot.setLabelGenerator(new StandardPieItemLabelGenerator("{0}={1}={2}",new DecimalFormat("0.0"),new DecimalFormat("0.00%")));
		//椭圆
		plot.setCircular(false);
		//角度
		plot.setStartAngle(150D);
		try {		
			String path = session.getServletContext().getRealPath("/tempImg");
			File tempFile = new File(path);
			if(tempFile.exists()){
				File[] childs = tempFile.listFiles();
				if(childs!=null&&childs.length!=0){
					for (File file : childs) {
						file.delete();
					}
				}				
			}else{
				tempFile.mkdir();
			}
			//根据数据集产生一个png图片，返回文件名
			filename = ServletUtilities.saveChartAsPNG(chart, 600, 400,info, session);
			pw = new PrintWriter(new FileOutputStream("../webapps/WMS/tempImg/"+filename));
			//输出文件
			ChartUtilities.writeImageMap(pw, filename, info, false);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}
		return filename;


	}
	private PieDataset getPieDataset(ZdtjVo vo) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("设备维修费",vo.getBf());
		dataset.setValue("员工工资",vo.getCcyqfy());
		dataset.setValue("仓储费",vo.getCcfy());
//		dataset.setValue("总 计",vo.getZje());//总费用不应该占用份额，所以还是不显示了
		return dataset;
	}
	private CategoryDataset getBarDataset(ZdtjVo vo,String type) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(vo.getBf(),"设备维修费","设备维修费");
		dataset.setValue(vo.getCcyqfy(),"员工工资","员工工资");
		if("lr".equals(type)) {
			dataset.setValue(vo.getCcfy(), "仓储费", "仓储费");
			dataset.setValue(vo.getZje(), "净收入", "净收入");
		}else {
			dataset.setValue(vo.getCcyqfy()+vo.getBf(), "总 计", "总 计");
		}
		return dataset;
	}
	
	
	
}
