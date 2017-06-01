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
import com.whjbsoft.www.po.Yspsd;
import com.whjbsoft.www.service.CwtjService;
import com.whjbsoft.www.util.FormateDate;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.vo.ZdtjVo;

public class CwtjServicei extends HibernateDaoSupport implements CwtjService {
	private ZdglDAO dao;

	private HtxxDAO hdao;

	public CwtjServicei() {
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
		try {
			ZdtjVo vo = new ZdtjVo();
			// 初始信息
			vo.setYfk(0.0);
			vo.setYf(0.0);
			vo.setBf(0.0);
			vo.setZf(0.0);
			vo.setCcfy(0.0);
			vo.setCcyqfy(0.0);
			vo.setZje(0.0);
			StringBuffer hql1 = new StringBuffer("from Khht A where A.htzt>0 ");
			hql1.append(con);// 此处拼接的条件应该有所属学生、所属试验设置
			List list1 = this.getDao().getObjects(hql1.toString(), params);
			if (list1 != null && !list1.isEmpty()) {
				for (int j = 0; j < list1.size(); j++) {
					Khht ht = (Khht) list1.get(j);// 获取合同信息
					if ("外包合同".equals(ht.getHtlx())) {
						// 运输配送费用
						String hql = "from Yspsd A where A.khht.htzj = ?";
						List list = this.getDao().getObjects(hql, ht.getHtzj());
						if (list != null && !list.isEmpty()) {
							Yspsd ys = (Yspsd) list.get(list.size() - 1);
							vo.setYfk(ys.getYsk() + vo.getYfk());
							vo.setYf(ys.getYf() + vo.getYf());
							vo.setBf(ys.getBxf() + vo.getBf());
							vo.setZf(ys.getZf() + vo.getZf());
						}
						// 仓储费用
						hql = "select A.hpsl*A.hptj,A.tjdw from Khddhpb A where A.khdd.ddzj = ?";
						list = this.getDao().getObjects(hql,
								ht.getKhdd().getDdzj());
						// 计算存储总体积
						double sum = 0.0;
						if (list != null && !list.isEmpty()) {
							for (int i = 0; i < list.size(); i++) {
								Object[] obj = (Object[]) list.get(i);
								Double ztj = (Double) obj[0];
								if (ztj == null) {
									ztj = 0.0;
								}
								String dw = String.valueOf(obj[1]);
								if ("立方厘米".equals(dw)) {
									ztj /= 1000000;
								} else if ("立方毫米".equals(dw)) {
									ztj /= 1000000000;
								}
								sum += ztj;
							}
						}
						// 计算存储天数
						int num = 1;
						String start = FormateDate.formate();// 入库时间
						String end = start;// 出库时间
						hql = "from Crkdd A where A.khht.htzj = ? and A.ddlx = ?";
						list = this.getDao()
								.getObjects(hql, ht.getHtzj(), "入库");
						if (list != null && !list.isEmpty()) {
							Crkdd crkdd = (Crkdd) list.get(0);// 查询第一次入库时间
							if (crkdd.getSjcrksj() != null
									&& !"".equals(crkdd.getSjcrksj())) {
								start = crkdd.getSjcrksj();
							}
						}
						list = this.getDao()
								.getObjects(hql, ht.getHtzj(), "出库");
						if (list != null && !list.isEmpty()) {
							Crkdd crkdd = (Crkdd) list.get(list.size() - 1);// 查询最后一次出库时间
							if (crkdd.getSjcrksj() != null
									&& !"".equals(crkdd.getSjcrksj())) {
								end = crkdd.getSjcrksj();
							}
						}
						num += FormateDate.contrastDate(start, end);
						vo.setCcfy(num * sum * ht.getCcdj() + vo.getCcfy());
						vo.setZje(vo.getYf() + vo.getZf() + vo.getBf()
								+ vo.getCcfy());// 总金额=运费+杂费+保费+仓储费
						// 仓储延期费用

					} else if ("仓储合同".equals(ht.getHtlx())) {// 仓储合同费用计算公式=合同签订
						// 仓储费用
						String hql = "select A.hpsl*A.hptj,A.tjdw from Khddhpb A where A.khdd.ddzj = ?";
						List list = this.getDao().getObjects(hql,
								ht.getKhdd().getDdzj());
						// 计算存储总体积
						double sum = 0.0;
						if (list != null && !list.isEmpty()) {
							for (int i = 0; i < list.size(); i++) {
								Object[] obj = (Object[]) list.get(i);
								Double ztj = (Double) obj[0];
								if (ztj == null) {
									ztj = 0.0;
								}
								String dw = String.valueOf(obj[1]);
								if ("立方厘米".equals(dw)) {
									ztj /= 1000000;
								} else if ("立方毫米".equals(dw)) {
									ztj /= 1000000000;
								}
								sum += ztj;
							}
						}
						// 计算存储天数
						int num = 1;
						String start = ht.getTdsj();// 入库时间
						String end = ht.getJzrq();// 出库时间
						num += FormateDate.contrastDate(start, end);
						vo.setCcfy(num * sum * ht.getCcdj() + vo.getCcfy());
						vo.setZje(vo.getCcfy());// 总金额=仓储费
					} else {
						String hql = "from Yspsd A where A.khht.htzj = ?";
						List list = this.getDao().getObjects(hql, ht.getHtzj());
						if (list != null && !list.isEmpty()) {
							Yspsd ys = (Yspsd) list.get(list.size() - 1);
							vo.setYfk(ys.getYsk() + vo.getYfk());
							vo.setYf(ys.getYf() + vo.getYf());
							vo.setBf(ys.getBxf() + vo.getBf());
							vo.setZf(ys.getZf() + vo.getZf());
							vo.setZje(vo.getYf() + vo.getZf() + vo.getBf());// 总金额=运费+杂费+保费
						}
					}
				}
			}
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public String getBarChartName(HttpSession session, String con,
			Object... params) {
		ZdtjVo vo = this.countCw(con, params);
		String filename = null;
		PrintWriter pw = null;
		CategoryDataset dataset = getBarDataset(vo);
		JFreeChart chart = ChartFactory.createBarChart3D("财务统计表", "费 用", "金 额",
				dataset, PlotOrientation.VERTICAL, true, false, false);
		ChartRenderingInfo info = new ChartRenderingInfo(
				new StandardEntityCollection());
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setNoDataMessage("暂无数据");
		plot.setForegroundAlpha(0.6f);
		plot.getDomainAxis().setCategoryLabelPositions(
				CategoryLabelPositions.UP_45);
		// 设置柱状图数值显示
		CategoryItemRenderer renderer = plot.getRenderer();
		renderer
				.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setItemLabelsVisible(true);
		// 显示位置
		renderer.setPositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_RIGHT));
		try {
			String path = session.getServletContext().getRealPath("/tempImg");
			File tempFile = new File(path);
			if (tempFile.exists()) {
				File[] childs = tempFile.listFiles();
				if (childs != null && childs.length != 0) {
					for (File file : childs) {
						file.delete();
					}
				}
			} else {
				tempFile.mkdir();
			}
			filename = ServletUtilities.saveChartAsPNG(chart, 600, 400, info,
					session);
			pw = new PrintWriter(new FileOutputStream("../webapps/JBTMS/tempImg/"
					+ filename));
			ChartUtilities.writeImageMap(pw, filename, info, false);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}
		return filename;

	}

	public String getPieChartName(HttpSession session, String con,
			Object... params) {
		ZdtjVo vo = this.countCw(con, params);
		// 文件名
		String filename = null;
		PrintWriter pw = null;
		// 数据集
		PieDataset dataset = getPieDataset(vo);
		JFreeChart chart = ChartFactory.createPieChart3D("财务统计图表", dataset,
				true, true, true);
		ChartRenderingInfo info = new ChartRenderingInfo(
				new StandardEntityCollection());
		// 设置背景色
		chart.setBackgroundPaint(Color.pink);
		// 设置前景透明
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setForegroundAlpha(0.6f);
		plot.setNoDataMessage("暂无数据");
		plot.setLabelGenerator(new StandardPieItemLabelGenerator("{0}={1}={2}",
				new DecimalFormat("0.0"), new DecimalFormat("0.00%")));
		// 椭圆
		plot.setCircular(false);
		// 角度
		plot.setStartAngle(150D);
		try {
			String path = session.getServletContext().getRealPath("/tempImg");
			File tempFile = new File(path);
			if (tempFile.exists()) {
				File[] childs = tempFile.listFiles();
				if (childs != null && childs.length != 0) {
					for (File file : childs) {
						file.delete();
					}
				}
			} else {
				tempFile.mkdir();
			}
			// 根据数据集产生一个png图片，返回文件名
			filename = ServletUtilities.saveChartAsPNG(chart, 600, 400, info,
					session);
			pw = new PrintWriter(new FileOutputStream("../webapps/JBTMS/tempImg/"
					+ filename));
			// 输出文件
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
		dataset.setValue("运 费", vo.getYf());
		dataset.setValue("杂 费", vo.getZf());
		dataset.setValue("保 费", vo.getBf());
		dataset.setValue("仓储费", vo.getCcfy());
		// dataset.setValue("总 计",vo.getZje());//总费用不应该占用份额，所以还是不显示了
		return dataset;
	}

	private CategoryDataset getBarDataset(ZdtjVo vo) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(vo.getYf(), "运 费", "运 费");
		dataset.setValue(vo.getZf(), "杂 费", "杂 费");
		dataset.setValue(vo.getBf(), "保 费", "保 费");
		dataset.setValue(vo.getCcfy(), "仓储费", "仓储费");
		dataset.setValue(vo.getZje(), "总 计", "总 计");
		return dataset;
	}

	/**
	 * 统计运输配送费用 Method getYsPieChartName
	 * 
	 * @author whjb
	 * @param session
	 * @param con
	 * @param params
	 * @return the String
	 */
	public String getYsPieChartName(HttpSession session, String ddlx,
			String ny, String con, Object... params) {
		ZdtjVo vo = this.getYsZdtj(ddlx, ny, con, params);
		// 文件名
		String filename = null;
		PrintWriter pw = null;
		// 数据集
		PieDataset dataset = getYsPieDataset(vo);
		JFreeChart chart = ChartFactory.createPieChart3D("财务统计图表", dataset,
				true, true, true);
		ChartRenderingInfo info = new ChartRenderingInfo(
				new StandardEntityCollection());
		// 设置背景色
		chart.setBackgroundPaint(Color.pink);
		// 设置前景透明
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setForegroundAlpha(0.6f);
		plot.setNoDataMessage("暂无数据");
		plot.setLabelGenerator(new StandardPieItemLabelGenerator("{0}={1}={2}",
				new DecimalFormat("0.0"), new DecimalFormat("0.00%")));
		// 椭圆
		plot.setCircular(false);
		// 角度
		plot.setStartAngle(150D);
		try {
			String path = session.getServletContext().getRealPath("/tempImg");
			System.out.println("Path is -------------"+path);
			File tempFile = new File(path);
			if (tempFile.exists()) {
				File[] childs = tempFile.listFiles();
				if (childs != null && childs.length != 0) {
					for (File file : childs) {
						file.delete();
					}
				}
			} else {
				tempFile.mkdir();
			}
			// 根据数据集产生一个png图片，返回文件名
			filename = ServletUtilities.saveChartAsPNG(chart, 600, 400, info,
					session);
			
			pw = new PrintWriter(new FileOutputStream(path+"\\"
					+ filename));
			// 输出文件
			ChartUtilities.writeImageMap(pw, filename, info, false);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}
		return filename;
	}

	private PieDataset getYsPieDataset(ZdtjVo vo) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("运 费", vo.getYf());
		dataset.setValue("杂 费", vo.getZf());
		dataset.setValue("保 费", vo.getBf());
		return dataset;
	}

	@SuppressWarnings("unchecked")
	public ZdtjVo getYsZdtj(String ddlx, String ny, String con,
			Object... params) {
		ZdtjVo vo = new ZdtjVo();
		// 初始信息
		vo.setYfk(0.0);// 员工工资（司机）
		vo.setYf(0.0);
		vo.setBf(0.0);// 设备维修费用
		vo.setZf(0.0);
		vo.setCcfy(0.0);
		vo.setCcyqfy(0.0);
		vo.setZje(0.0);
		try {
			StringBuffer hql1 = new StringBuffer(
					"from Khht A where A.htzt>0 and A.tdsj like ? ");
			hql1.append(con);// 此处拼接的条件应该有所属学生、所属试验设置
			List list1 = this.getDao().getObjects(hql1.toString(), ny,
					params[0], params[1]);
			if (list1 != null && !list1.isEmpty()) {
				for (int j = 0; j < list1.size(); j++) {
					Khht ht = (Khht) list1.get(j);// 获取合同信息
					if ("外包合同".equals(ht.getHtlx())) {
						// 运输配送费用
						String hql = "from Yspsd A where A.khht.htzj = ? ";
						List list = this.getDao().getObjects(hql, ht.getHtzj());
						if (list != null && !list.isEmpty()) {
							Yspsd ys = (Yspsd) list.get(list.size() - 1);
							// vo.setYfk(ys.getYsk() + vo.getYfk());
							vo.setYf(ys.getYf() + vo.getYf());
							vo.setBf(ys.getBxf() + vo.getBf());
							vo.setZf(ys.getZf() + vo.getZf());
							vo.setZje(vo.getZje() + ys.getYf() + ys.getZf()
									+ ys.getBxf());// 总金额=运费+杂费+保费
						}
					} else if (!"仓储合同".equals(ht.getHtlx())) {
						String hql = "from Yspsd A where A.khht.htzj = ? ";
						List list = this.getDao().getObjects(hql, ht.getHtzj());
						if (list != null && !list.isEmpty()) {
							Yspsd ys = (Yspsd) list.get(list.size() - 1);
							// vo.setYfk(ys.getYsk() + vo.getYfk());
							vo.setYf(ys.getYf() + vo.getYf());
							vo.setBf(ys.getBxf() + vo.getBf());
							vo.setZf(ys.getZf() + vo.getZf());
							vo.setZje(vo.getZje() + ys.getYf() + ys.getZf()
									+ ys.getBxf());// 总金额=运费+杂费+保费
						}
					}
				}
			}
			String hql = "from Ygxx A where 1=1 ";
			List<Ygxx> ygList = this.getDao().getObjects(hql + con, params[0],
					params[1]);
			if (ygList != null && !ygList.isEmpty()) {
				for (Ygxx y : ygList) {
					vo.setYfk(vo.getYfk() + y.getYggz());
				}
			}
			hql = "from Sbwxjlb A where 1=1 and A.sblx=? and A.wxrq like ? ";
			List<Sbwxjlb> sbwxList = this.getDao().getObjects(hql + con,
					"运输车辆", ny, params[0], params[1]);
			if (sbwxList != null && !sbwxList.isEmpty()) {
				for (Sbwxjlb s : sbwxList) {
					vo.setCcyqfy(vo.getCcyqfy() + s.getWxfy());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	public String getYsBarChartName(HttpSession session, String tjlx,
			String ddlx, String ny, String con, Object... params) {
		ZdtjVo vo = this.getYsZdtj(ddlx, ny, con, params);
		String filename = null;
		PrintWriter pw = null;
		CategoryDataset dataset = getYsBarDataset(vo, tjlx);
		JFreeChart chart = ChartFactory.createBarChart3D("财务统计表", "费 用", "金 额",
				dataset, PlotOrientation.VERTICAL, true, false, false);
		ChartRenderingInfo info = new ChartRenderingInfo(
				new StandardEntityCollection());
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setNoDataMessage("暂无数据");
		plot.setForegroundAlpha(0.6f);
		plot.getDomainAxis().setCategoryLabelPositions(
				CategoryLabelPositions.UP_45);
		// 设置柱状图数值显示
		CategoryItemRenderer renderer = plot.getRenderer();
		renderer
				.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setItemLabelsVisible(true);
		// 显示位置
		renderer.setPositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_RIGHT));
		try {
			String path = session.getServletContext().getRealPath("/tempImg");
			File tempFile = new File(path);
			if (tempFile.exists()) {
				File[] childs = tempFile.listFiles();
				if (childs != null && childs.length != 0) {
					for (File file : childs) {
						file.delete();
					}
				}
			} else {
				tempFile.mkdir();
			}
			filename = ServletUtilities.saveChartAsPNG(chart, 600, 400, info,
					session);
			pw = new PrintWriter(new FileOutputStream(path+"\\"
					+ filename));
			ChartUtilities.writeImageMap(pw, filename, info, false);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}
		return filename;

	}

	private CategoryDataset getYsBarDataset(ZdtjVo vo, String tjlx) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		if ("jlr".equals(tjlx)) {
			dataset.setValue(vo.getYf(), "运 费", "运 费");
			dataset.setValue(vo.getZf(), "杂 费", "杂 费");
			dataset.setValue(vo.getBf(), "保 费", "保 费");
			dataset.setValue(vo.getYfk(), "员工工资", "员工工资");
			dataset.setValue(vo.getCcyqfy(), "车辆维修费", "车辆维修费");
			dataset.setValue(vo.getYf() + vo.getZf() + vo.getBf(), "收入总计",
					"收入总计");
			dataset.setValue(vo.getYfk() + vo.getCcyqfy(), "成本统计", "成本统计");
			dataset.setValue(vo.getYf() + vo.getZf() + vo.getBf() - vo.getYfk()
					- vo.getCcyqfy(), "利润总计", "利润总计");
		} else {
			dataset.setValue(vo.getYf(), "运 费", "运 费");
			dataset.setValue(vo.getZf(), "杂 费", "杂 费");
			dataset.setValue(vo.getBf(), "保 费", "保 费");
			dataset.setValue(vo.getYf() + vo.getZf() + vo.getBf(), "收入总计",
					"收入总计");
		}
		return dataset;
	}

	/**
	 * 统计运输配送费用 Method getYsPieChartName
	 * 
	 * @author whjb
	 * @param session
	 * @param con
	 * @param params
	 * @return the String
	 */
	public String getCbPieChartName(HttpSession session, String ddlx,
			String ny, String con, Object... params) {
		ZdtjVo vo = this.getCbZdtj(ddlx, ny, con, params);
		// 文件名
		String filename = null;
		PrintWriter pw = null;
		// 数据集
		PieDataset dataset = getCbPieDataset(vo);
		JFreeChart chart = ChartFactory.createPieChart3D("财务统计图表", dataset,
				true, true, true);
		ChartRenderingInfo info = new ChartRenderingInfo(
				new StandardEntityCollection());
		// 设置背景色
		chart.setBackgroundPaint(Color.pink);
		// 设置前景透明
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setForegroundAlpha(0.6f);
		plot.setNoDataMessage("暂无数据");
		plot.setLabelGenerator(new StandardPieItemLabelGenerator("{0}={1}={2}",
				new DecimalFormat("0.0"), new DecimalFormat("0.00%")));
		// 椭圆
		plot.setCircular(false);
		// 角度
		plot.setStartAngle(150D);
		try {
			String path = session.getServletContext().getRealPath("/tempImg");
			File tempFile = new File(path);
			if (tempFile.exists()) {
				File[] childs = tempFile.listFiles();
				if (childs != null && childs.length != 0) {
					for (File file : childs) {
						file.delete();
					}
				}
			} else {
				tempFile.mkdir();
			}
			// 根据数据集产生一个png图片，返回文件名
			filename = ServletUtilities.saveChartAsPNG(chart, 600, 400, info,
					session);
			pw = new PrintWriter(new FileOutputStream(path+"\\"
					+ filename));
			// 输出文件
			ChartUtilities.writeImageMap(pw, filename, info, false);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}
		return filename;
	}

	private PieDataset getCbPieDataset(ZdtjVo vo) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("员工工资", vo.getYfk());
		dataset.setValue("车辆维修费", vo.getBf());
		return dataset;
	}

	@SuppressWarnings("unchecked")
	public ZdtjVo getCbZdtj(String ddlx, String ny, String con,
			Object... params) {
		ZdtjVo vo = new ZdtjVo();
		// 初始信息
		vo.setYfk(0.0);// 员工工资（司机）
		vo.setYf(0.0);
		vo.setBf(0.0);// 设备维修费用
		vo.setZf(0.0);
		vo.setCcfy(0.0);
		vo.setCcyqfy(0.0);
		vo.setZje(0.0);
		try {
			String hql = "from Ygxx A where 1=1 ";
			List<Ygxx> ygList = this.getDao().getObjects(hql + con, params[0],
					params[1]);
			if (ygList != null && !ygList.isEmpty()) {
				for (Ygxx y : ygList) {
					vo.setYfk(vo.getYfk() + y.getYggz());
				}
			}
			hql = "from Sbwxjlb A where 1=1 and A.sblx=? and A.wxrq like ? ";
			List<Sbwxjlb> sbwxList = this.getDao().getObjects(hql + con,
					"运输车辆", ny, params[0], params[1]);
			if (sbwxList != null && !sbwxList.isEmpty()) {
				for (Sbwxjlb s : sbwxList) {
					vo.setBf(vo.getBf() + s.getWxfy());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	public String getCbBarChartName(HttpSession session, String ddlx,
			String ny, String con, Object... params) {
		ZdtjVo vo = this.getCbZdtj(ddlx, ny, con, params);
		String filename = null;
		PrintWriter pw = null;
		CategoryDataset dataset = getCbBarDataset(vo);
		JFreeChart chart = ChartFactory.createBarChart3D("财务统计表", "费 用", "金 额",
				dataset, PlotOrientation.VERTICAL, true, false, false);
		ChartRenderingInfo info = new ChartRenderingInfo(
				new StandardEntityCollection());
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setNoDataMessage("暂无数据");
		plot.setForegroundAlpha(0.6f);
		plot.getDomainAxis().setCategoryLabelPositions(
				CategoryLabelPositions.UP_45);
		// 设置柱状图数值显示
		CategoryItemRenderer renderer = plot.getRenderer();
		renderer
				.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setItemLabelsVisible(true);
		// 显示位置
		renderer.setPositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_RIGHT));
		try {
			String path = session.getServletContext().getRealPath("/tempImg");
			File tempFile = new File(path);
			if (tempFile.exists()) {
				File[] childs = tempFile.listFiles();
				if (childs != null && childs.length != 0) {
					for (File file : childs) {
						file.delete();
					}
				}
			} else {
				tempFile.mkdir();
			}
			filename = ServletUtilities.saveChartAsPNG(chart, 600, 400, info,
					session);
			pw = new PrintWriter(new FileOutputStream(path+"\\"
					+ filename));
			ChartUtilities.writeImageMap(pw, filename, info, false);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}
		return filename;

	}

	private CategoryDataset getCbBarDataset(ZdtjVo vo) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(vo.getYfk(), "员工工资", "员工工资");
		dataset.setValue(vo.getBf(), "车辆维修费", "车辆维修费");
		dataset.setValue(vo.getYfk() + vo.getBf(), "总 计", "总 计");
		return dataset;
	}

	public ZdtjVo getSwCbZdtj(String ny, String con, Object... params) {
		ZdtjVo vo = new ZdtjVo();
		// 初始信息
		vo.setYfk(0.0);// 员工工资（司机）
		vo.setYf(0.0);
		vo.setBf(0.0);// 设备维修费用
		vo.setZf(0.0);
		vo.setCcfy(0.0);
		vo.setCcyqfy(0.0);
		vo.setZje(0.0);
		try {
			String hql = "from Ygxx A where 1=1 ";
			List<Ygxx> ygList = (List<Ygxx>) this.getDao().getObjects(
					hql + con, params[0], params[1]);
			if (ygList != null && !ygList.isEmpty()) {
				for (Ygxx y : ygList) {
					vo.setYfk(vo.getYfk() + y.getYggz());
				}
			}
			hql = "from Sbwxjlb A where 1=1 and A.wxrq like ? ";
			List<Sbwxjlb> sbwxList = this.getDao().getObjects(hql + con, ny,
					params[0], params[1]);
			if (sbwxList != null && !sbwxList.isEmpty()) {
				for (Sbwxjlb s : sbwxList) {
					vo.setCcyqfy(vo.getCcyqfy() + s.getWxfy());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	public String getSwCbBarChartName(HttpSession session, String ddlx,
			String ny, String con, Object... params) {
		ZdtjVo vo = this.getSwCbZdtj(ny, con, params);
		String filename = null;
		PrintWriter pw = null;
		CategoryDataset dataset = getSwCbBarDataset(vo);
		JFreeChart chart = ChartFactory.createBarChart3D("财务统计表", "费 用", "金 额",
				dataset, PlotOrientation.VERTICAL, true, false, false);
		ChartRenderingInfo info = new ChartRenderingInfo(
				new StandardEntityCollection());
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setNoDataMessage("暂无数据");
		plot.setForegroundAlpha(0.6f);
		plot.getDomainAxis().setCategoryLabelPositions(
				CategoryLabelPositions.UP_45);
		// 设置柱状图数值显示
		CategoryItemRenderer renderer = plot.getRenderer();
		renderer
				.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setItemLabelsVisible(true);
		// 显示位置
		renderer.setPositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_RIGHT));
		try {
			String path = session.getServletContext().getRealPath("/tempImg");
			File tempFile = new File(path);
			if (tempFile.exists()) {
				File[] childs = tempFile.listFiles();
				if (childs != null && childs.length != 0) {
					for (File file : childs) {
						file.delete();
					}
				}
			} else {
				tempFile.mkdir();
			}
			filename = ServletUtilities.saveChartAsPNG(chart, 600, 400, info,
					session);
			pw = new PrintWriter(new FileOutputStream(path+"\\"
					+ filename));
			ChartUtilities.writeImageMap(pw, filename, info, false);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}
		return filename;

	}

	private CategoryDataset getSwCbBarDataset(ZdtjVo vo) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(vo.getYfk(), "员工工资", "员工工资");
		dataset.setValue(vo.getCcyqfy(), "设备维修费", "设备维修费");
		dataset.setValue(vo.getYfk() + vo.getCcyqfy(), "总 计", "总 计");
		return dataset;
	}

	public String getSwCbPieChartName(HttpSession session, String ddlx,
			String ny, String con, Object... params) {
		ZdtjVo vo = this.getSwCbZdtj(ny, con, params);
		// 文件名
		String filename = null;
		PrintWriter pw = null;
		// 数据集
		PieDataset dataset = getSwCbPieDataset(vo);
		JFreeChart chart = ChartFactory.createPieChart3D("财务统计图表", dataset,
				true, true, true);
		ChartRenderingInfo info = new ChartRenderingInfo(
				new StandardEntityCollection());
		// 设置背景色
		chart.setBackgroundPaint(Color.pink);
		// 设置前景透明
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setForegroundAlpha(0.6f);
		plot.setNoDataMessage("暂无数据");
		plot.setLabelGenerator(new StandardPieItemLabelGenerator("{0}={1}={2}",
				new DecimalFormat("0.0"), new DecimalFormat("0.00%")));
		// 椭圆
		plot.setCircular(false);
		// 角度
		plot.setStartAngle(150D);
		try {
			String path = session.getServletContext().getRealPath("/tempImg");
			File tempFile = new File(path);
			if (tempFile.exists()) {
				File[] childs = tempFile.listFiles();
				if (childs != null && childs.length != 0) {
					for (File file : childs) {
						file.delete();
					}
				}
			} else {
				tempFile.mkdir();
			}
			// 根据数据集产生一个png图片，返回文件名
			filename = ServletUtilities.saveChartAsPNG(chart, 600, 400, info,
					session);
			pw = new PrintWriter(new FileOutputStream(path+"\\"
					+ filename));
			// 输出文件
			ChartUtilities.writeImageMap(pw, filename, info, false);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}
		return filename;
	}

	private PieDataset getSwCbPieDataset(ZdtjVo vo) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("员工工资", vo.getYfk());
		dataset.setValue("设备维修费", vo.getCcyqfy());
		return dataset;
	}

	@SuppressWarnings("unchecked")
	public ZdtjVo getSwZdtj(String ny, String con, Object... params) {
		ZdtjVo vo = new ZdtjVo();
		// 初始信息
		vo.setYfk(0.0);// 员工工资（司机）
		vo.setYf(0.0);
		vo.setBf(0.0);// 设备维修费用
		vo.setZf(0.0);
		vo.setCcfy(0.0);
		vo.setCcyqfy(0.0);
		vo.setZje(0.0);
		try {
			StringBuffer hql1 = new StringBuffer(
					"from Khht A where A.htzt>0 and A.tdsj like ? ");
			hql1.append(con);// 此处拼接的条件应该有所属学生、所属试验设置
			List list1 = this.getDao().getObjects(hql1.toString(), ny,
					params[0], params[1]);
			if (list1 != null && !list1.isEmpty()) {
				for (int j = 0; j < list1.size(); j++) {
					Khht ht = (Khht) list1.get(j);// 获取合同信息
					if ("外包合同".equals(ht.getHtlx())) {
						// 运输配送费用
						String hql = "from Yspsd A where A.khht.htzj = ?";
						List list = this.getDao().getObjects(hql, ht.getHtzj());
						if (list != null && !list.isEmpty()) {
							Yspsd ys = (Yspsd) list.get(list.size() - 1);
							vo.setYfk(ys.getYsk() + vo.getYfk());
							vo.setYf(ys.getYf() + vo.getYf());
							vo.setBf(ys.getBxf() + vo.getBf());
							vo.setZf(ys.getZf() + vo.getZf());
						}
						// 仓储费用
						hql = "select A.hpsl*A.hptj,A.tjdw from Khddhpb A where A.khdd.ddzj = ?";
						list = this.getDao().getObjects(hql,
								ht.getKhdd().getDdzj());
						// 计算存储总体积
						double sum = 0.0;
						if (list != null && !list.isEmpty()) {
							for (int i = 0; i < list.size(); i++) {
								Object[] obj = (Object[]) list.get(i);
								Double ztj = (Double) obj[0];
								if (ztj == null) {
									ztj = 0.0;
								}
								String dw = String.valueOf(obj[1]);
								if ("立方厘米".equals(dw)) {
									ztj /= 1000000;
								} else if ("立方毫米".equals(dw)) {
									ztj /= 1000000000;
								}
								sum += ztj;
							}
						}
						// 计算存储天数
						int num = 1;
						String start = FormateDate.formate();// 入库时间
						String end = start;// 出库时间
						hql = "from Crkdd A where A.khht.htzj = ? and A.ddlx = ?";
						list = this.getDao()
								.getObjects(hql, ht.getHtzj(), "入库");
						if (list != null && !list.isEmpty()) {
							Crkdd crkdd = (Crkdd) list.get(0);// 查询第一次入库时间
							if (crkdd.getSjcrksj() != null
									&& !"".equals(crkdd.getSjcrksj())) {
								start = crkdd.getSjcrksj();
							}
						}
						list = this.getDao()
								.getObjects(hql, ht.getHtzj(), "出库");
						if (list != null && !list.isEmpty()) {
							Crkdd crkdd = (Crkdd) list.get(list.size() - 1);// 查询最后一次出库时间
							if (crkdd.getSjcrksj() != null
									&& !"".equals(crkdd.getSjcrksj())) {
								end = crkdd.getSjcrksj();
							}
						}
						num += FormateDate.contrastDate(start, end);
						vo.setCcfy(num * sum * ht.getCcdj() + vo.getCcfy());
						vo.setZje(vo.getYf() + vo.getZf() + vo.getBf()
								+ vo.getCcfy());// 总金额=运费+杂费+保费+仓储费
						// 仓储延期费用

					} else if ("仓储合同".equals(ht.getHtlx())) {// 仓储合同费用计算公式=合同签订
						// 仓储费用
						String hql = "select A.hpsl*A.hptj,A.tjdw from Khddhpb A where A.khdd.ddzj = ?";
						List list = this.getDao().getObjects(hql,
								ht.getKhdd().getDdzj());
						// 计算存储总体积
						double sum = 0.0;
						if (list != null && !list.isEmpty()) {
							for (int i = 0; i < list.size(); i++) {
								Object[] obj = (Object[]) list.get(i);
								Double ztj = (Double) obj[0];
								if (ztj == null) {
									ztj = 0.0;
								}
								String dw = String.valueOf(obj[1]);
								if ("立方厘米".equals(dw)) {
									ztj /= 1000000;
								} else if ("立方毫米".equals(dw)) {
									ztj /= 1000000000;
								}
								sum += ztj;
							}
						}
						// 计算存储天数
						int num = 1;
						String start = ht.getTdsj();// 入库时间
						String end = ht.getJzrq();// 出库时间
						num += FormateDate.contrastDate(start, end);
						vo.setCcfy(num * sum * ht.getCcdj() + vo.getCcfy());
						vo.setZje(vo.getCcfy());// 总金额=仓储费
					} else {
						String hql = "from Yspsd A where A.khht.htzj = ?";
						List list = this.getDao().getObjects(hql, ht.getHtzj());
						if (list != null && !list.isEmpty()) {
							Yspsd ys = (Yspsd) list.get(list.size() - 1);
							vo.setYfk(ys.getYsk() + vo.getYfk());
							vo.setYf(ys.getYf() + vo.getYf());
							vo.setBf(ys.getBxf() + vo.getBf());
							vo.setZf(ys.getZf() + vo.getZf());
							vo.setZje(vo.getYf() + vo.getZf() + vo.getBf());// 总金额=运费+杂费+保费
						}
					}
				}
			}
			String hql = "from Ygxx A where 1=1 ";
			List<Ygxx> ygList = this.getDao().getObjects(hql + con, params[0],
					params[1]);
			if (ygList != null && !ygList.isEmpty()) {
				for (Ygxx y : ygList) {
					vo.setYfk(vo.getYfk() + y.getYggz());
				}
			}
			hql = "from Sbwxjlb A where 1=1  and A.wxrq like ? ";
			List<Sbwxjlb> sbwxList = this.getDao().getObjects(hql + con, ny,
					params[0], params[1]);
			if (sbwxList != null && !sbwxList.isEmpty()) {
				for (Sbwxjlb s : sbwxList) {
					vo.setCcyqfy(vo.getCcyqfy() + s.getWxfy());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	public String getSwBarChartName(HttpSession session, String ny, String con,
			Object... params) {
		ZdtjVo vo = this.getSwZdtj(ny, con, params);
		String filename = null;
		PrintWriter pw = null;
		CategoryDataset dataset = getSwBarDataset(vo);
		JFreeChart chart = ChartFactory.createBarChart3D("财务统计表", "费 用", "金 额",
				dataset, PlotOrientation.VERTICAL, true, false, false);
		ChartRenderingInfo info = new ChartRenderingInfo(
				new StandardEntityCollection());
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setNoDataMessage("暂无数据");
		plot.setForegroundAlpha(0.6f);
		plot.getDomainAxis().setCategoryLabelPositions(
				CategoryLabelPositions.UP_45);
		// 设置柱状图数值显示
		CategoryItemRenderer renderer = plot.getRenderer();
		renderer
				.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setItemLabelsVisible(true);
		// 显示位置
		renderer.setPositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_RIGHT));
		try {
			String path = session.getServletContext().getRealPath("/tempImg");
			File tempFile = new File(path);
			if (tempFile.exists()) {
				File[] childs = tempFile.listFiles();
				if (childs != null && childs.length != 0) {
					for (File file : childs) {
						file.delete();
					}
				}
			} else {
				tempFile.mkdir();
			}
			filename = ServletUtilities.saveChartAsPNG(chart, 600, 400, info,
					session);
			pw = new PrintWriter(new FileOutputStream(path+"\\"
					+ filename));
			ChartUtilities.writeImageMap(pw, filename, info, false);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
		}
		return filename;

	}

	private CategoryDataset getSwBarDataset(ZdtjVo vo) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(vo.getYf(), "运 费", "运 费");
		dataset.setValue(vo.getZf(), "杂 费", "杂 费");
		dataset.setValue(vo.getBf(), "保 费", "保 费");
		dataset.setValue(vo.getCcfy(), "仓储费用", "仓储费用");
		dataset.setValue(vo.getYfk(), "员工工资", "员工工资");
		dataset.setValue(vo.getCcyqfy(), "设备维修费", "设备维修费");
		dataset.setValue(vo.getYf() + vo.getZf() + vo.getBf() + vo.getCcfy(),
				"收入总计", "收入总计");
		dataset.setValue(vo.getYfk() + vo.getCcyqfy(), "成本统计", "成本统计");
		dataset.setValue(vo.getYf() + vo.getZf() + vo.getBf() + vo.getCcfy()
				- vo.getYfk() - vo.getCcyqfy(), "利润总计", "利润总计");
		return dataset;
	}

}