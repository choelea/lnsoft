package com.whjbsoft.www.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

public class Hibernate_Template {

	public Hibernate_Template()
	{	
	}
	public Session getSession()
	{
		return Hibernate_Util.getSession();
	}
	public void closeSession()
	{
	   Hibernate_Util.closeSession();
	}
	public void beginTran()
	{
	   Hibernate_Util.beginTran();
	}
	public void commitTran() throws Exception 
	{
	   Hibernate_Util.commitTran();
	}
	public void rollbackTran()
	{
	   Hibernate_Util.rollbackTran();
	}
	
	public Object get(Class pocalss,Serializable id)
	{
	   return this.getSession().get(pocalss,id);
	}
	public Object load(Class pocalss,Serializable id)
	{
	   return this.getSession().load(pocalss,id);
	}
	public Object get(String hql,Object... params)
	{
		Query query=this.getSession().createQuery(hql);
	    this.setParameter(query, params);
	   return query.uniqueResult();
	}

	public Integer count(String hql,Object... params)
	{
	   Object obj=this.get(hql, params);
	   return (Integer)obj;
	}
	public List getObjects(String hql,Object...params)
   	{
	   Query query=this.getSession().createQuery(hql);
	   this.setParameter(query, params);
	   return query.list();
	}
	
	public List getObjects(String hql,int curpage,int pagerecord,Object...params)
   	{
	   Query query=this.getSession().createQuery(hql);
	   this.setParameter(query, params);
	   query.setFirstResult((curpage-1)*pagerecord);
	   query.setMaxResults(pagerecord); 
	   return query.list();
	}

	public List getObjects(String hql,int curpage,int pagerecord,Class voclass,Object...params)
   	{
	  List vos=new ArrayList();
	  try{
	   Query query=this.getSession().createQuery(hql);
	   this.setParameter(query, params);
	   query.setFirstResult((curpage-1)*pagerecord);
	   query.setMaxResults(pagerecord); 
	   List<Object[]> list=query.list();
	   for(Object[] objs:list)//emp,dept
	   {
		 Object vo=voclass.newInstance();  
		 for(Object obj:objs)
		 {
		   BeanUtils.copyProperties(vo,obj);  	 
		 }
		 vos.add(vo);
	   }
	  }catch(Exception e){
		 e.printStackTrace(); 
	  }
	   return vos;
	}
	//Criteria
	public List getObjects(DetachedCriteria c,int curpage,int pagerecord,Criterion...params)
	{
	    if(params!=null&&params.length>0)
	    {
	    	for(Criterion cond:params)
	    	{
	    	   c.add(cond);	
	    	}
	    }
	    Criteria criteria=c.getExecutableCriteria(this.getSession());
	    criteria.setFirstResult((curpage-1)*pagerecord);
	    criteria.setMaxResults(pagerecord);
	    criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}
	public Integer countByDetached(DetachedCriteria c,Criterion...params)
	{
	    if(params!=null&&params.length>0)
	    {
	    	for(Criterion cond:params)
	    	{
	    	   c.add(cond);	
	    	}
	    }
	    Criteria criteria=c.getExecutableCriteria(this.getSession());
	    criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
	    criteria.setProjection(Projections.rowCount());
		return (Integer)criteria.uniqueResult();
	}
	
	public void delete(Class pocalss,Serializable id)throws Exception
	{
	  try{	
	   Object obj=this.getSession().get(pocalss,id);
	   this.getSession().delete(obj);
	  }catch(Exception e){
		 e.printStackTrace(); 
		 throw e;
	  } 
	}
	public void delete(Object po)throws Exception
	{
	  try{	
	   this.getSession().delete(po);
	  }catch(Exception e){
		 e.printStackTrace(); 
		 throw e;
	  }
	}
	public void delete(String hql) throws Exception
	{
	  try{
	   Query query=this.getSession().createQuery(hql);
	   query.executeUpdate();
	  }catch(Exception e){		 
		 e.printStackTrace();
		 throw e;
	  }
	}
	
	public void update(Object po)throws Exception
	{
	 try{
	   this.getSession().update(po);
	  }catch(Exception e){			 
			 e.printStackTrace();
			 throw e;
	  }
	}
	public void update(String hql,Object...params)throws Exception
	{
	 try{
	    Query query=this.getSession().createQuery(hql);
	    this.setParameter(query, params); 
	    query.executeUpdate();
	  }catch(Exception e){			
			 e.printStackTrace();
			 throw e;
	  }
	}
	public void merge(Object po)throws Exception
	{
	 try{
	   this.getSession().merge(po);
	  }catch(Exception e){
			 e.printStackTrace();
			 throw e;
	  }
	}
	
	public Serializable save(Object po)throws Exception
	{
	   try{
	       return this.getSession().save(po);
	    }catch(Exception e){			 
			 e.printStackTrace();
			 throw e;
	   }
	}
	
	public void saveOrUpdate(Object po)throws Exception
	{
	   try{
	       this.getSession().saveOrUpdate(po);
	    }catch(Exception e){
			 e.printStackTrace();
			 throw e;
	   }
	}

	public void persist(Object po)throws Exception
	{
	   try{
	       this.getSession().persist(po);
	    }catch(Exception e){			 
			 e.printStackTrace();
			 throw e;
	   }
	}
	//setParamValue
	public void setParameter(Query query,Object...params)
	{	
		if(params!=null&&params.length>0)
		{
		   for(int i=0;i<params.length;i++)
		   {
			   query.setString(i,params[i].toString()); 
		   }
		}	
	}
	
}
