package com.whjbsoft.www.servicei;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.whjbsoft.www.dao.YsddDAO;
import com.whjbsoft.www.daoi.YsddDAOi;
import com.whjbsoft.www.po.Bxxx;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.po.Xlyh;
import com.whjbsoft.www.po.XlyhId;
import com.whjbsoft.www.po.Ygxx;
import com.whjbsoft.www.po.Ylxx;
import com.whjbsoft.www.po.Yscldd;
import com.whjbsoft.www.po.YsclddId;
import com.whjbsoft.www.po.Ysddd;
import com.whjbsoft.www.po.YsdddId;
import com.whjbsoft.www.po.Ysddxx;
import com.whjbsoft.www.po.Yspsd;
import com.whjbsoft.www.po.Ysrydd;
import com.whjbsoft.www.po.YsryddId;
import com.whjbsoft.www.service.YsddService;
import com.whjbsoft.www.util.Contants_st;
import com.whjbsoft.www.util.HibernateDaoSupport;
import com.whjbsoft.www.util.Pageinfo;

public class YsddServicei extends HibernateDaoSupport implements YsddService {
	private YsddDAO dao;

	public YsddDAO getDao() {
		return dao;
	}

	public void setDao(YsddDAO dao) {
		this.dao = dao;
	}

	public YsddServicei() {
		dao = new YsddDAOi();
	}
	
	public boolean delete(String[] pks, int djzj, int ktzj) {
		try {
			this.getHibernate_Template().beginTran();
			for (String string : pks) {
				Set<Ysddd> set = this.getDao().getYsddxx(Integer.parseInt(string)).getYsddds();
				for(Ysddd y:set){
					y.getYspsd().setYszt(1);
				}
				this.getDao().delete(Integer.parseInt(string));
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

	public Pageinfo getPageinfo(String con, int curpage, Object... params) {
		try {
			String hql = "select new com.whjbsoft.www.vo.YsddxxVo(A.ysddzj,A.ysddbh,A.ysddlx,A.ysfs,A.ysddzt,A.sfpg,A.sfpc,B.bxxx.sfz) from Ysddxx A inner join A.xlyhs B where 1=1 " + con;
			String countHql = "select count(A) from Ysddxx A where 1=1 " + con;
			List list = this.getDao().list(hql, curpage, pagerecord, params);
			int count = this.getDao().count(countHql, params);
			Pageinfo page = new Pageinfo(count, pagerecord, list);
			page.setCurpage(curpage);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public Ysddxx getYsddxx(int id) {
		try {
			Ysddxx ysddxx = this.getDao().getYsddxx(id);
			/*
			 * Hibernate.initialize(ysddxx.getYsddds());
			 * Hibernate.initialize(ysddxx.getXlyhs());
			 * Hibernate.initialize((ysddxx.getYsrydds()));
			 * Hibernate.initialize(ysddxx.getYscldds());
			 */
			return ysddxx;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}

	public boolean save(Ysddxx ysddxx, int djzj, int ktzj, List<Yspsd> list,
			int bxzj) {
		try {
			this.getHibernate_Template().beginTran();
			this.getDao().save(ysddxx);
			for (Yspsd yspsd : list) {
				if (yspsd.getYsdzj() != null && !"".equals(yspsd.getYsdzj())
						&& yspsd.getYsdzj() != 0) {
					YsdddId id = new YsdddId(yspsd.getYsdzj(), ysddxx
							.getYsddzj());
					Ysddd ysddd = new Ysddd();
					ysddd.setId(id);
					ysddxx.getYsddds().add(ysddd);
					Yspsd yspsd2 = (Yspsd) this.getDao().getObject(Yspsd.class,
							yspsd.getYsdzj());
					yspsd2.setYszt(2);
				}
			}
			if (bxzj != 0) {
				XlyhId id = new XlyhId(bxzj, ysddxx.getYsddzj());
				Xlyh xlyh = new Xlyh();
				xlyh.setId(id);
				ysddxx.getXlyhs().add(xlyh);
			}
			Dtxx dtxx = this.getDao().getDtxx(djzj, ktzj);
			if (dtxx != null) {
				dtxx.setSfdt(1);
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
	public boolean fc(int ysddzj,int djzj,int ktzj) {
		try {
			this.getHibernate_Template().beginTran();
			Ysddxx ysddxx = this.getDao().getYsddxx(ysddzj);
			if("运输".equals(ysddxx.getYsddlx())) {
				ktzj = Contants_st.ysdd_fc;
			}else {
				ktzj = Contants_st.psdd_fc;
			}
			Set<Ysddd> set = ysddxx.getYsddds();
			if (set != null && set.size() > 0) {
				for (Ysddd ysddd : set) {
					Yspsd yspsd = (Yspsd) this.getDao().getObject(Yspsd.class,
							ysddd.getId().getYsdzj());
					yspsd.setYszt(3);
				}
			}else {
				this.getHibernate_Template().rollbackTran();
				return false;
			}
			ysddxx.setYsddzt(2);
			Dtxx dtxx = this.getDao().getDtxx(djzj,ktzj);
			if(dtxx != null) {
				dtxx.setSfdt(1);
			}
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}
	
	
	
	public boolean ysdZc(int ysddzj,int djzj,int ktzj) {
		try {
			this.getHibernate_Template().beginTran();
			Ysddxx ysddxx = this.getDao().getYsddxx(ysddzj);
			if("运输".equals(ysddxx.getYsddlx())) {
				ktzj = Contants_st.ysdd_fc;
			}else {
				ktzj = Contants_st.psdd_fc;
			}
			ysddxx.setYsddzt(1);
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}
	
	/**
	 * 调度分拣
	 */
	public List getList(int ysddzj) {
		try {
			List list = new ArrayList();
			Ysddxx ysddxx = this.getDao().getYsddxx(ysddzj);
			String bxHql = "select A from Bxxx A where A.bxzj = (select A.bxxx.bxzj from Xlyh A where A.ysddxx.ysddzj = ?)";
			List<Bxxx> bxList = this.getDao().getObjects(bxHql, ysddzj);
			String lcHql = "select A.bxzd from Bxlc A where 1=1 and A.bxxx.bxzj = ? order by A.tksx";
			List lcList = this.getDao().getObjects(lcHql,
					bxList.get(0).getBxzj());
			String str = "";
			if (lcList == null || lcList.size() == 0) {
				str = "无通达地区";
			} else {
				for (int i = 0; i < lcList.size(); i++) {
					if (i != lcList.size() - 1) {
						str += lcList.get(i) + "、";
					} else {
						str += lcList.get(i);
					}
				}
			}
			String ysdHql = "select new com.whjbsoft.www.vo.YspsdVo(A.ysdzj,A.ysdbh,A.ysdlx,A.ysfs,A.yszt,A.khht.khdd.khxxByKhzj.dwmc,A.khht.khdd.khxxByKhxKhzj.dwmc,A.khht.khdd.khxxByKhzj.ssjg,A.khht.khdd.khxxByKhxKhzj.ssjg)" +
					" from Yspsd A where A.ysdzj in (select A.yspsd.ysdzj from Ysddd A where A.ysddxx.ysddzj = ?)";
			List ysdList = this.getDao().getObjects(ysdHql, ysddzj);
			list.add(bxList.get(0));//班线
			list.add(str);//通达地区
			list.add(ysdList);//运输配送单
			list.add(ysddxx);//调度单
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			this.getHibernate_Template().closeSession();
		}
	}
	/**
	 * 派工派车方法
	 * @param ysddzj
	 * @return
	 */
	public Map<String, Object> getMap(int ysddzj) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			Ysddxx ysddxx = this.getDao().getYsddxx(ysddzj);
			String bxHql = "select A from Bxxx A where A.bxzj = (select A.bxxx.bxzj from Xlyh A where A.ysddxx.ysddzj = ?)";
			List<Bxxx> bxList = this.getDao().getObjects(bxHql, ysddzj);
			String lcHql = "select A.bxzd from Bxlc A where 1=1 and A.bxxx.bxzj = ? order by A.tksx";
			List lcList = this.getDao().getObjects(lcHql,
					bxList.get(0).getBxzj());
			String str = "";
			if (lcList == null || lcList.size() == 0) {
				str = "无通达地区";
			} else {
				for (int i = 0; i < lcList.size(); i++) {
					if (i != lcList.size() - 1) {
						str += lcList.get(i) + "、";
					} else {
						str += lcList.get(i);
					}
				}
			}
			String ysdHql = "select new com.whjbsoft.www.vo.YspsdVo(A.ysdzj,A.ysdbh,A.ysdlx,A.ysfs,A.yszt,A.khht.khdd.khxxByKhzj.dwmc,A.khht.khdd.khxxByKhxKhzj.dwmc,A.khht.khdd.khxxByKhzj.ssjg,A.khht.khdd.khxxByKhxKhzj.ssjg)" +
					" from Yspsd A where A.ysdzj in (select A.yspsd.ysdzj from Ysddd A where A.ysddxx.ysddzj = ?)";
			List ysdList = this.getDao().getObjects(ysdHql, ysddzj);
			String ygHql = "from Ygxx A where A.ygzj = ( select A.ygxx.ygzj from Ysrydd A where A.ysddxx.ysddzj = ?)";
			List ygList = this.getDao().getObjects(ygHql, ysddzj);
			String clHql = "from Ylxx A where A.ylzj = ( select A.ylxx.ylzj from Yscldd A where A.ysddxx.ysddzj = ?)";
			List clList = this.getDao().getObjects(clHql, ysddzj);
			map.put("tddq", str);//通达地区
			map.put("bxxx", bxList.get(0));//班线
			map.put("yspsd", ysdList);//运输配送单
			map.put("ysddxx", ysddxx);//调度单
			map.put("clxx", clList);//车辆
			map.put("ygxx", ygList);//员工
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}
	
	public boolean pg(int ysddzj, int djzj, int ktzj,String[] ygzj) {
		try {
			this.getHibernate_Template().beginTran();
			Ysddxx ysddxx = this.getDao().getYsddxx(ysddzj);
			if (ygzj != null && ygzj.length>0) {
				for (int i = 0; i < ygzj.length; i++) {
					if (ygzj[i] != null && !"".equals(ygzj[i])) {
						Ysrydd ysrydd = new Ysrydd();
						YsryddId id = new YsryddId(ysddzj, Integer
								.valueOf(ygzj[i]));
						ysrydd.setId(id);
						ysddxx.getYsrydds().add(ysrydd);
						Ygxx ygxx = (Ygxx) this.getDao().getObject(Ygxx.class,
								Integer.parseInt(ygzj[i]));
						if(ygxx.getSsxs()!=0){
							ygxx.setYgzt("1");
						}
					}
				}
			}else {
				this.getHibernate_Template().rollbackTran();
				return false;
			}
			ysddxx.setSfpg(1);
			Dtxx dtxx = this.getDao().getDtxx(djzj,ktzj);
			if(dtxx!=null) {
				dtxx.setSfdt(1);
			}
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}
	
	public boolean pc(int ysddzj, int djzj, int ktzj,String[] ylzj) {
		try {
			this.getHibernate_Template().beginTran();
			Ysddxx ysddxx = this.getDao().getYsddxx(ysddzj);
			if (ylzj != null && ylzj.length>0) {
				for (int i = 0; i < ylzj.length; i++) {
					if (ylzj[i] != null && !"".equals(ylzj[i])) {
						YsclddId id = new YsclddId(Integer.parseInt(ylzj[i]),ysddzj);
						Yscldd yscldd = new Yscldd();
						yscldd.setId(id);
						ysddxx.getYscldds().add(yscldd);
						Ylxx ylxx = (Ylxx) this.getDao().getObject(Ylxx.class, Integer.parseInt(ylzj[i]));
						if(ylxx.getSsxs()!=0){
							ylxx.setSyzt("使用");
						}
					}
				}
			}else {
				this.getHibernate_Template().rollbackTran();
				return false;
			}
			ysddxx.setSfpc(1);
			Dtxx dtxx = this.getDao().getDtxx(djzj,ktzj);
			if(dtxx != null) {
				dtxx.setSfdt(1);
			}
			this.getHibernate_Template().commitTran();
			return true;
		} catch (Exception e) {
			this.getHibernate_Template().rollbackTran();
			e.printStackTrace();
			return false;
		}finally {
			this.getHibernate_Template().closeSession();
		}
	}
	
}