package com.whjbsoft.www.util;

import java.awt.Color;
import java.awt.RenderingHints;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

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




public class BarChartDemo1 {

	/**
	 * ��״ͼ
	 */
	public static String generatePieChart(HttpSession session, PrintWriter pw,
			int w, int h) {
		String filename = null;
		PieDataset dataset = getDataSet();
		JFreeChart chart = ChartFactory.createPieChart3D("ˮ������ͼ", // ͼ������
				dataset, // ���ݼ�
				true, // �Ƿ���ʾͼ��
				false, // �Ƿ����ɹ���
				false // �Ƿ�����URL����
				);
		chart.setBackgroundPaint(Color.pink);
		try {
			/*------�õ�chart�ı���·��----*/
			ChartRenderingInfo info = new ChartRenderingInfo(
					new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, w, h, info,
					session);
			/*------ʹ��printWriter���ļ�д��----*/
			ChartUtilities.writeImageMap(pw, filename, info, true);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filename;
	}

	/**
	 * ��״ͼ
	 */
	public static String generateBarChart(HttpSession session, PrintWriter pw,
			int w, int h) {

		String filename = null;
		CategoryDataset dataset = getDataSet2();
		JFreeChart chart = ChartFactory.createBarChart3D("ˮ������ͼ", // ͼ������
				"ˮ��", // Ŀ¼�����ʾ��ǩ
				"����", // ��ֵ�����ʾ��ǩ
				dataset, // ���ݼ�
				PlotOrientation.VERTICAL, // ͼ������ˮƽ����ֱ
				true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
				false, // �Ƿ����ɹ���
				false // �Ƿ�����URL����
				);
		try {
			/*------�õ�chart�ı���·��----*/
			ChartRenderingInfo info = new ChartRenderingInfo(
					new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, w, h, info,
					session);
			/*------ʹ��printWriter���ļ�д��----*/
			ChartUtilities.writeImageMap(pw, filename, info, true);
			pw.flush();
		} catch (IOException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
		return filename;
	}

	/**
	 * ����ͼ
	 */
	public static String generateLineChart(HttpSession session, PrintWriter pw,
			int w, int h) {
		String filename = null;
		CategoryDataset dataset = getDataSet3();
		JFreeChart chart = ChartFactory.createLineChart("ˮ������ͼ", // ͼ������
				"ˮ��", // Ŀ¼�����ʾ��ǩ
				"����", // ��ֵ�����ʾ��ǩ
				dataset, // ���ݼ�
				PlotOrientation.VERTICAL, // ͼ������ˮƽ����ֱ
				true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
				false, // �Ƿ����ɹ���
				false // �Ƿ�����URL����
				);

		/*----------������������ľ����Ⱦ������������⣩--------------*/
		chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);

		/*------------����ͼ������--------------*/
		// 1,��������ͼ��������ɫ
		chart.setBackgroundPaint(Color.pink);

		/*------------�趨Plot����-------------*/
		CategoryPlot plot = chart.getCategoryPlot();
		// 2,������ϸͼ������ʾϸ�ڲ��ֵı�����ɫ
		// plot.setBackgroundPaint(Color.PINK);
		// 3,���ô�ֱ��������ɫ
		plot.setDomainGridlinePaint(Color.black);
		// 4,�����Ƿ���ʾ��ֱ������
		plot.setDomainGridlinesVisible(true);
		// 5,����ˮƽ��������ɫ
		plot.setRangeGridlinePaint(Color.blue);
		// 6,�����Ƿ���ʾˮƽ������
		plot.setRangeGridlinesVisible(true);

		try {
			/*------�õ�chart�ı���·��----*/
			ChartRenderingInfo info = new ChartRenderingInfo(
					new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, w, h, info,
					session);
			/*------ʹ��printWriter���ļ�д��----*/
			ChartUtilities.writeImageMap(pw, filename, info, true);
			pw.flush();
		} catch (IOException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
		return filename;
	}

	/**
	 * �ڱ�������ͼƬ�ļ�
	 */
	public static void ganarateFruitChart() {
		CategoryDataset dataset = getDataSet2();
		JFreeChart chart = ChartFactory.createBarChart3D("ˮ������ͼ", // ͼ������
				"�·�", // Ŀ¼�����ʾ��ǩ
				"���������", // ��ֵ�����ʾ��ǩ
				dataset, // ���ݼ�
				PlotOrientation.VERTICAL, // ͼ������ˮƽ����ֱ
				true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
				true, // �Ƿ����ɹ���
				false // �Ƿ�����URL����
				);
		FileOutputStream fos_jpg = null;
		try {
			fos_jpg = new FileOutputStream("D:\\fruit.jpg");
			ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f, chart, 800, 600,
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
	public static void generatePieChart(){
		PieDataset dataset = getDataSet();
		JFreeChart chart = ChartFactory.createPieChart("ˮ������ͼ",dataset,true,false,false);
		FileOutputStream fos_jpg = null;
		try{
			fos_jpg = new FileOutputStream("D:\\Pie.jpg");
			ChartUtilities.writeChartAsJPEG(fos_jpg, chart, 800, 600);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				fos_jpg.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ��ȡһ����״ͼ�ļ����ݼ�����
	 * 
	 * @return
	 */
	private static PieDataset getDataSet() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		/*dataset.setValue("ƻ��", 100);
		dataset.setValue("����", 200);
		dataset.setValue("����", 300);
		dataset.setValue("�㽶", 400);
		dataset.setValue("��֦", 500);*/
//		Cwtj cwtj = new Cwtj();
//		cwtj.setBf(100.0);
//		cwtj.setCcfy(200.0);
//		cwtj.setYf(300.0);
//		cwtj.setZf(10.5);
//		cwtj.setZjfy(52.1);
//		dataset.setValue("�˷�", cwtj.getYf());
//		dataset.setValue("�ӷ�", cwtj.getZf());
//		dataset.setValue("����", cwtj.getBf());
//		dataset.setValue("�洢����", cwtj.getCcfy());
//		dataset.setValue("�ʼ����", cwtj.getZjfy());
		return dataset;
	}

	/**
	 * ��ȡһ����״ͼ���ݼ�����
	 * 
	 * @return
	 */
	private static CategoryDataset getDataSet2() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, "����", "ƻ��");
		dataset.addValue(500, "����", "��֦");
		dataset.addValue(400, "����", "�㽶");
		dataset.addValue(200, "����", "����");
		dataset.addValue(300, "����", "����");
		dataset.addValue(500, "�Ϻ�", "����");
		dataset.addValue(600, "�Ϻ�", "����");
		dataset.addValue(400, "�Ϻ�", "�㽶");
		dataset.addValue(700, "�Ϻ�", "ƻ��");
		dataset.addValue(300, "�Ϻ�", "��֦");
		dataset.addValue(300, "����", "ƻ��");
		dataset.addValue(200, "����", "����");
		dataset.addValue(500, "����", "�㽶");
		dataset.addValue(400, "����", "����");
		dataset.addValue(700, "����", "��֦");
		return dataset;
	}

	/**
	 * ��ȡһ������ͼ���ݼ�����
	 * 
	 * @return
	 */
	private static CategoryDataset getDataSet3() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, "����", "һ��");
		dataset.addValue(200, "����", "����");
		dataset.addValue(100, "����", "����");
		dataset.addValue(400, "����", "����");
		dataset.addValue(300, "����", "����");
		dataset.addValue(500, "����", "����");
		dataset.addValue(90, "����", "����");
		dataset.addValue(700, "����", "����");
		dataset.addValue(800, "����", "����");
		dataset.addValue(1000, "����", "ʮ��");
		dataset.addValue(300, "����", "ʮһ��");
		dataset.addValue(700, "����", "ʮ����");
		dataset.addValue(1200, "�Ϻ�", "һ��");
		dataset.addValue(1100, "�Ϻ�", "����");
		dataset.addValue(1000, "�Ϻ�", "����");
		dataset.addValue(900, "�Ϻ�", "����");
		dataset.addValue(800, "�Ϻ�", "����");
		dataset.addValue(700, "�Ϻ�", "����");
		dataset.addValue(600, "�Ϻ�", "����");
		dataset.addValue(500, "�Ϻ�", "����");
		dataset.addValue(400, "�Ϻ�", "����");
		dataset.addValue(300, "�Ϻ�", "ʮ��");
		dataset.addValue(200, "�Ϻ�", "ʮһ��");
		dataset.addValue(100, "�Ϻ�", "ʮ����");
		dataset.addValue(600, "�人", "һ��");
		dataset.addValue(500, "�人", "����");
		dataset.addValue(400, "�人", "����");
		dataset.addValue(300, "�人", "����");
		dataset.addValue(200, "�人", "����");
		dataset.addValue(100, "�人", "����");
		dataset.addValue(200, "�人", "����");
		dataset.addValue(300, "�人", "����");
		dataset.addValue(400, "�人", "����");
		dataset.addValue(500, "�人", "ʮ��");
		dataset.addValue(600, "�人", "ʮһ��");
		dataset.addValue(700, "�人", "ʮ����");
		return dataset;
	}

	public static void main(String[] args) {
		//ganarateFruitChart();
		generatePieChart();
	}

}