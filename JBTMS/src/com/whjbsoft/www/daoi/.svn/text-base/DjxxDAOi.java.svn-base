package com.whjbsoft.www.daoi;

import com.whjbsoft.www.dao.DjxxDAO;
import com.whjbsoft.www.po.Djxx;
import com.whjbsoft.www.po.Dtxx;
import com.whjbsoft.www.util.HibernateDaoSupport;

public class DjxxDAOi extends HibernateDaoSupport implements DjxxDAO {

	public DjxxDAOi() {
		
	}

	public Djxx getDjxx(int id) {
		return (Djxx)this.getHibernate_Template().get(Djxx.class, id);
	}

	public void save(Djxx djxx) throws Exception {
		this.getHibernate_Template().save(djxx);
	}

	public Dtxx getDtxx(String con, Object... params) {
		StringBuffer hql = new StringBuffer("from Dtxx A where A.djxx.djzj = ? and A.ktzj = ?");
		hql.append(con);
		return (Dtxx)this.getHibernate_Template().get(hql.toString(), params);
	}

}
