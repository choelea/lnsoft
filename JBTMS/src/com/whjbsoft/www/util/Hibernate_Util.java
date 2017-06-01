package com.whjbsoft.www.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

  /*
   * 完成SessionFactory/Session/Transaction的管理
   */
public class Hibernate_Util 
{
    private static final String config_file="hibernate.cfg.xml";
	private static final Configuration conf=new Configuration();//??
	private static SessionFactory factory=null;//??
	private static final Log log=LogFactory.getLog(Hibernate_Util.class);
	//盛放session
	private static final ThreadLocal<Session> sessThreadLocal=new ThreadLocal<Session>();
	//盛放transacion
	private static final ThreadLocal<Transaction> tranThreadLocal=new ThreadLocal<Transaction>();

	
    public Hibernate_Util()
	{
	}
    static{
    	conf.configure(config_file);
    	factory=conf.buildSessionFactory();
    }
    //得到一个Session对象
    public static Session getSession()
    {
      Session session=sessThreadLocal.get();	
      try{
        if(session==null)
        {
           if(factory==null)
            factory=conf.buildSessionFactory();
           session=factory.openSession();
           log.info("Session创建成功！");
           sessThreadLocal.set(session);
        }
      }catch(Exception e){
    	 e.printStackTrace(); 
    	 log.error("Session创建失败！");
      }
        return session;
    }
    public static void beginTran()
    {
      Session session=getSession();
      try{
    	 if(session!=null)
    	 {
    	   Transaction tran=session.beginTransaction();
    	   log.info("事务开始成功！");
    	   tranThreadLocal.set(tran);
    	 }
      }catch(Exception e){
    	 e.printStackTrace(); 
    	 log.error("事务开始失败！");
      }
    }
    public static void commitTran() throws Exception
    {
      Transaction tran=tranThreadLocal.get();
      try{
    	 if(tran!=null&&!tran.wasCommitted()&&!tran.wasRolledBack())
    	 {
    	   tran.commit();
    	   log.info("事务提交成功！");
    	   tranThreadLocal.set(null);
    	 }
      }catch (Exception e) {
    	  e.printStackTrace();
    	  log.error("事务提交失败!");
    	  throw e;
      }
    }
    public static void rollbackTran()
    {
      Transaction tran=tranThreadLocal.get();
      try{
    	 if(tran!=null&&!tran.wasCommitted()&&!tran.wasRolledBack())
    	 {
    	   tran.rollback();
    	   log.info("事务回滚成功！");
    	   tranThreadLocal.set(null);
    	 }
      }catch(Exception e){
    	 e.printStackTrace(); 
    	 log.error("事务回滚失败！");
      }
    }
    public static void closeSession()
    {
      Session session=sessThreadLocal.get();	
      try{
        if(session!=null)
        {
           session.close();
           log.info("Session关闭成功！");
           sessThreadLocal.set(null);
        }
      }catch(Exception e){
    	 e.printStackTrace(); 
    	 log.error("Session关闭失败！");
      }
    }
}
