package com.whjbsoft.www.servicei;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.whjbsoft.www.dao.XsglDAO;
import com.whjbsoft.www.daoi.XsglDAOi;
import com.whjbsoft.www.po.Bjxx;
import com.whjbsoft.www.po.Xsxx;
import com.whjbsoft.www.service.XsglService;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class XsglServicei extends HibernateDaoSupport implements XsglService {

	private XsglDAO dao;

	public XsglServicei() {
		dao = new XsglDAOi();
	}

	public boolean delXsgl(String[] pk) {
		try {
			this.getHibernate_Template().beginTran();
			for (String id : pk) {
				this.getDao().delete(Integer.parseInt(id));
			}
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public Pageinfo getPagedata(String con, int curpage, Object... params) {
		try {
			int count = this.getDao().count(con, params);
			List list = this.getDao().getObjects(con, curpage, pagerecord,
					params);
			Pageinfo page = new Pageinfo(count, pagerecord, list);
			page.setCurpage(curpage);
			return page;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	/**
	 * @see org.whjbsoft.ems.service.XsglService#getXsgl(int)
	 */
	public Xsxx getXsgl(int pk) {
		try {
			Xsxx xsgl = this.getDao().getXsgl(pk);
			return xsgl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean isExistXsgl(int sign, String fieldName, String fieldValue) {
		try {
			StringBuffer sb = new StringBuffer("from Xsxx where 1=1 ");
			sb.append(" and ").append(fieldName).append(" =? ");
			if (sign != 0) {
				sb.append(" and xszj <> ").append(sign);
			}
			List list = this.getDao().getObjects(sb.toString(), fieldValue);
			return !list.isEmpty();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	/**
	 * @see org.whjbsoft.ems.service.XsglService#save(org.whjbsoft.ems.po.Xsgl, int)
	 */
	public boolean save(Xsxx xsgl, int bjzj, int zcsl) {
		try {
			this.getHibernate_Template().beginTran();
			Bjxx bjgl = this.getDao().getBjgl(bjzj);
			for (int i = 0; i < zcsl; i++) {
				Xsxx x = new Xsxx();
				x.setSfdl(0);
				x.setBjxx(bjgl);
				x.setXsmm(xsgl.getXsmm());
				x.setRxsj(xsgl.getRxsj());
				x.setXsxh(getNo(xsgl.getXsxh(), i + bjgl.getBhzdz()));
				// 构建学生登陆号（学号）
				x.setXsxm(getNo(xsgl.getXsxh(), i + bjgl.getBhzdz()));
				x.setYxbj(xsgl.getYxbj());
				this.getDao().save(x);
			}
			bjgl.setBhzdz(bjgl.getBhzdz() + zcsl);
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		} finally {
			this.getHibernate_Template().closeSession();
		}

	}

	public boolean update(Xsxx xsgl) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().update(xsgl);
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public Bjxx getBjgl(int id) {
		try {
			Bjxx bjgl = this.getDao().getBjgl(id);
			return bjgl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	/**
	 * @return the dao
	 */
	public XsglDAO getDao() {
		return dao;
	}

	public void setDao(XsglDAO dao) {
		this.dao = dao;
	}

	public void updYxbj(int id, int state) {
		try {
			this.getHibernate_Template().beginTran();
			Xsxx xsxx = this.getDao().getXsgl(id);
			xsxx.setYxbj(state);
			this.getHibernate_Template().commitTran();
		} catch (Exception e) {
			e.printStackTrace();
			this.getHibernate_Template().rollbackTran();
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	/**
	 * 构造学号格式
	 * 
	 * @param no
	 * @return
	 */
	public String getNo(String pno, int no) {
		StringBuffer sbno = new StringBuffer(pno);
		if (no < 10) {
			String n = String.valueOf(no);
			sbno.append("0");
			sbno.append(n);
		} else {
			sbno.append(String.valueOf(no));
		}
		return sbno.toString();
	}

	public boolean importStu(InputStream in, int bjzj) {
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(in);
			HSSFSheet sheet = workbook.getSheetAt(0);
			int count = sheet.getLastRowNum() + 1;
			this.getHibernate_Template().beginTran();
			if (count > 1) {
				for (int i = 1; i < count; i++) {
					Xsxx xsxx = new Xsxx();
					xsxx.setYxbj(1);
					Bjxx bjxx = new Bjxx();
					bjxx.setBjzj(bjzj);
					xsxx.setBjxx(bjxx);
					HSSFRow row = sheet.getRow(i);
					HSSFCell cell2 = row.getCell((short) 2);
					HSSFCell cell3 = row.getCell((short) 3);
					HSSFCell cell4 = row.getCell((short) 4);
					HSSFCell cell5 = row.getCell((short) 5);
					HSSFCell cell6 = row.getCell((short) 6);
					HSSFCell cell7 = row.getCell((short) 7);
					HSSFCell cell8 = row.getCell((short) 8);
					HSSFCell cell9 = row.getCell((short) 9);
					HSSFCell cell10 = row.getCell((short) 10);
					String xsbh = "";
					if (cell2 != null) {
						if (cell2.getCellType() == 1) {
							xsbh = cell2.getRichStringCellValue() == null ? ""
									: cell2.getRichStringCellValue().toString();
						} else {
							xsbh = String.valueOf(cell2.getNumericCellValue());
						}
						int count1 = this.getDao().count(" and A.xsxh=?", xsbh);
						if (count1 > 0) {
							continue;
						} else {
							xsxx.setXsxh(xsbh);
						}
					}
					if (cell3 != null) {
						if (cell3.getCellType() == 1)
							xsbh = cell3.getRichStringCellValue() == null ? ""
									: cell3.getRichStringCellValue().toString();
						else
							xsbh = String.valueOf(cell3.getNumericCellValue());
						xsxx.setXsxm(xsbh);
					}
					if (cell4 != null) {
						if (cell4.getCellType() == 1)
							xsbh = cell4.getRichStringCellValue() == null ? "0"
									: cell4.getRichStringCellValue().toString();
						else
							xsbh = String.valueOf(cell4.getNumericCellValue());
						xsxx.setXsmm(xsbh);
					} else {
						xsxx.setXsmm("0");
					}
					if (cell5 != null) {
						if (cell5.getCellType() == 1)
							xsbh = cell5.getRichStringCellValue() == null ? ""
									: cell5.getRichStringCellValue().toString();
						else
							xsbh = String.valueOf(cell5.getNumericCellValue());
						xsxx.setRxsj(xsbh);
					}
					if (cell6 != null) {
						if (cell6.getCellType() == 1)
							xsbh = cell6.getRichStringCellValue() == null ? ""
									: cell6.getRichStringCellValue().toString();
						else
							xsbh = String.valueOf(cell6.getNumericCellValue());
						xsxx.setXb(xsbh.trim());
					}
					if (cell7 != null) {
						if (cell7.getCellType() == 1)
							xsbh = cell7.getRichStringCellValue() == null ? ""
									: cell7.getRichStringCellValue().toString();
						else
							xsbh = String.valueOf(cell7.getNumericCellValue());
						xsxx.setXsdz(xsbh);
					}
					if (cell8 != null) {
						if (cell8.getCellType() == 1)
							xsbh = cell8.getRichStringCellValue() == null ? ""
									: cell8.getRichStringCellValue().toString();
						else
							xsbh = String.valueOf(cell8.getNumericCellValue());
						xsxx.setXsdh(xsbh);
					}
					if (cell9 != null) {
						if (cell9.getCellType() == 1)
							xsbh = cell9.getRichStringCellValue() == null ? ""
									: cell9.getRichStringCellValue().toString();
						else
							xsbh = String.valueOf(cell9.getNumericCellValue());
						xsxx.setZjhm(xsbh);
					}
					if (cell10 != null) {
						if (cell10.getCellType() == 1)
							xsbh = cell10.getRichStringCellValue() == null ? ""
									: cell10.getRichStringCellValue()
											.toString();
						else
							xsbh = String.valueOf(cell10.getNumericCellValue());
						xsxx.setXsjg(xsbh);
					}
					this.getDao().save(xsxx);
				}
			}
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.getHibernate_Template().closeSession();
		}
	}

}
