package com.whjbsoft.www.util;

import java.awt.Color;
import java.awt.RenderingHints;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleEdge;

public class BarChartDemo {

	/**
	 * 饼状图
	 */
	public static String generatePieChart(HttpSession session, PrintWriter pw,
			int w, int h) {
		String filename = null;
		PieDataset dataset = getDataSet();
		JFreeChart chart = ChartFactory.createPieChart3D("水果产量图", // 图表标题
				dataset, // 数据集
				true, // 是否显示图例
				false, // 是否生成工具
				false // 是否生成URL链接
				);
		chart.setBackgroundPaint(Color.pink);
		chart.getLegend().setBackgroundPaint(Color.green);
		//chart.getLegend().setBorder(BlockBorder.NONE);
		//chart.getLegend().setHorizontalAlignment(HorizontalAlignment.RIGHT);
		//chart.getLegend().setMargin(100.0, 100.0, 100.0, 100.0);
		//chart.getLegend().setVerticalAlignment(VerticalAlignment.BOTTOM);
		chart.getLegend().setPosition(RectangleEdge.TOP);
		chart.getTitle().setBackgroundPaint(Color.blue);
		chart.getTitle().setPaint(Color.red);
		chart.getTitle().setText("haha");
		chart.getTitle().setPosition(RectangleEdge.RIGHT);
		chart.getPlot().setBackgroundAlpha(1.0f);
		chart.getPlot().setBackgroundPaint(Color.orange);
		chart.getPlot().setForegroundAlpha(0.5f);
		chart.getPlot().setNoDataMessage("暂无数据");
		chart.getPlot().setOutlinePaint(Color.cyan);
		/*List list = new ArrayList();
		list.add(new TextTitle("1"));
		chart.setSubtitles(list);*/
		try {
			/*------得到chart的保存路径----*/
			ChartRenderingInfo info = new ChartRenderingInfo(
					new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, w, h, info,
					session);
			/*------使用printWriter将文件写出----*/
			ChartUtilities.writeImageMap(pw, filename, info, true);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(filename);
		return filename;
	}

	/**
	 * 柱状图
	 */
	public static String generateBarChart(HttpSession session, PrintWriter pw,
			int w, int h) {

		String filename = null;
		CategoryDataset dataset = getDataSet2();
		JFreeChart chart = ChartFactory.createBarChart3D("水果产量图", // 图表标题
				"水果", // 目录轴的显示标签
				"产量", // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				true // 是否生成URL链接
				);
		List list = chart.getCategoryPlot().getCategories();
		for(Object obj:list){
			System.out.println(obj);
		}
		chart.setBackgroundPaint(Color.pink);
		chart.getCategoryPlot().setBackgroundAlpha(1.0f);
		chart.getCategoryPlot().setForegroundAlpha(0.5f);
		try {
			/*------得到chart的保存路径----*/
			ChartRenderingInfo info = new ChartRenderingInfo(
					new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, w, h, info,
					session);
			/*------使用printWriter将文件写出----*/
			ChartUtilities.writeImageMap(pw, filename, info, true);
			pw.flush();
		} catch (IOException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return filename;
	}

	/**
	 * 折线图
	 */
	public static String generateLineChart(HttpSession session, PrintWriter pw,
			int w, int h) {
		String filename = null;
		CategoryDataset dataset = getDataSet3();
		JFreeChart chart = ChartFactory.createLineChart("水果产量图", // 图表标题
				"水果", // 目录轴的显示标签
				"产量", // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
				);

		/*----------设置消除字体的锯齿渲染（解决中文问题）--------------*/
		chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);

		/*------------配置图表属性--------------*/
		// 1,设置整个图表背景颜色
		chart.setBackgroundPaint(Color.pink);

		/*------------设定Plot参数-------------*/
		CategoryPlot plot = chart.getCategoryPlot();
		// 2,设置详细图表的显示细节部分的背景颜色
		// plot.setBackgroundPaint(Color.PINK);
		// 3,设置垂直网格线颜色
		plot.setDomainGridlinePaint(Color.black);
		// 4,设置是否显示垂直网格线
		plot.setDomainGridlinesVisible(true);
		// 5,设置水平网格线颜色
		plot.setRangeGridlinePaint(Color.blue);
		// 6,设置是否显示水平网格线
		plot.setRangeGridlinesVisible(true);
		try {
			/*------得到chart的保存路径----*/
			ChartRenderingInfo info = new ChartRenderingInfo(
					new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, w, h, info,
					session);
			/*------使用printWriter将文件写出----*/
			ChartUtilities.writeImageMap(pw, filename, info, true);
			pw.flush();
		} catch (IOException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return filename;
	}

	/**
	 * 在本地生成图片文件
	 */
	public static void ganarateFruitChart() {
		CategoryDataset dataset = getDataSet2();
		JFreeChart chart = ChartFactory.createBarChart3D("水果产量图", // 图表标题
				"月份", // 目录轴的显示标签
				"产量（公斤）", // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
				);

		FileOutputStream fos_jpg = null;
		try {
			fos_jpg = new FileOutputStream("D:\\fruit.jpg");
			ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f, chart, 400, 300,
					null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos_jpg.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * 获取一个饼状图的简单数据集对象
	 * 
	 * @return
	 */
	private static PieDataset getDataSet() {
		DefaultPieDataset dataset = new DefaultPieDataset();
/*		dataset.setValue("苹果", 100);
		dataset.setValue("梨子", 200);
		dataset.setValue("葡萄", 300);
		dataset.setValue("香蕉", 400);
		dataset.setValue("荔枝", 500);*/
		dataset.setValue("a", null);
		dataset.setValue("b", null);
		dataset.setValue("c", null);
		dataset.setValue("d", null);
		dataset.setValue("e", null);
		return dataset;
	}

	/**
	 * 获取一个柱状图数据集对象
	 * 
	 * @return
	 */
	private static CategoryDataset getDataSet2() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, "北京", "苹果");
		dataset.addValue(500, "北京", "荔枝");
		dataset.addValue(400, "北京", "香蕉");
		dataset.addValue(200, "北京", "梨子");
		dataset.addValue(300, "北京", "葡萄");
		dataset.addValue(500, "上海", "葡萄");
		dataset.addValue(600, "上海", "梨子");
		dataset.addValue(400, "上海", "香蕉");
		dataset.addValue(700, "上海", "苹果");
		dataset.addValue(300, "上海", "荔枝");
		dataset.addValue(300, "广州", "苹果");
		dataset.addValue(200, "广州", "梨子");
		dataset.addValue(500, "广州", "香蕉");
		dataset.addValue(400, "广州", "葡萄");
		dataset.addValue(700, "广州", "荔枝");
		return dataset;
	}

	/**
	 * 获取一个折线图数据集对象
	 * 
	 * @return
	 */
	private static CategoryDataset getDataSet3() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, "北京", "一月");
		dataset.addValue(200, "北京", "二月");
		dataset.addValue(100, "北京", "三月");
		dataset.addValue(400, "北京", "四月");
		dataset.addValue(300, "北京", "五月");
		dataset.addValue(500, "北京", "六月");
		dataset.addValue(90, "北京", "七月");
		dataset.addValue(700, "北京", "八月");
		dataset.addValue(800, "北京", "九月");
		dataset.addValue(1000, "北京", "十月");
		dataset.addValue(300, "北京", "十一月");
		dataset.addValue(700, "北京", "十二月");
		dataset.addValue(1200, "上海", "一月");
		dataset.addValue(1100, "上海", "二月");
		dataset.addValue(1000, "上海", "三月");
		dataset.addValue(900, "上海", "四月");
		dataset.addValue(800, "上海", "五月");
		dataset.addValue(700, "上海", "六月");
		dataset.addValue(600, "上海", "七月");
		dataset.addValue(500, "上海", "八月");
		dataset.addValue(400, "上海", "九月");
		dataset.addValue(300, "上海", "十月");
		dataset.addValue(200, "上海", "十一月");
		dataset.addValue(100, "上海", "十二月");
		dataset.addValue(600, "武汉", "一月");
		dataset.addValue(500, "武汉", "二月");
		dataset.addValue(400, "武汉", "三月");
		dataset.addValue(300, "武汉", "四月");
		dataset.addValue(200, "武汉", "五月");
		dataset.addValue(100, "武汉", "六月");
		dataset.addValue(200, "武汉", "七月");
		dataset.addValue(300, "武汉", "八月");
		dataset.addValue(400, "武汉", "九月");
		dataset.addValue(500, "武汉", "十月");
		dataset.addValue(600, "武汉", "十一月");
		dataset.addValue(700, "武汉", "十二月");
		return dataset;
	}

	public static void main(String[] args) {
		ganarateFruitChart();
	}

}
