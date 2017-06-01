package com.whjbsoft.www.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

  /*
   * ���SessionFactory/Session/Transaction�Ĺ���
   */
public class Hibernate_Util 
{
    private static final String config_file="hibernate.cfg.xml";
	private static final Configuration conf=new Configuration();//??
	private static SessionFactory factory=null;//??
	private static final Log log=LogFactory.getLog(Hibernate_Util.class);
	//ʢ��session
	private static final ThreadLocal<Session> sessThreadLocal=new ThreadLocal<Session>();
	//ʢ��transacion
	private static final ThreadLocal<Transaction> tranThreadLocal=new ThreadLocal<Transaction>();

	
    public Hibernate_Util()
	{
	}
    static{
    	conf.configure(config_file);
    	factory=conf.buildSessionFactory();
    }
    //�õ�һ��Session����
    public static Session getSession()
    {
      Session session=sessThreadLocal.get();	
      try{
        if(session==null)
        {
           if(factory==null)
            factory=conf.buildSessionFactory();
           session=factory.openSession();
           log.info("Session�����ɹ���");
           sessThreadLocal.set(session);
        }
      }catch(Exception e){
    	 e.printStackTrace(); 
    	 log.error("Session����ʧ�ܣ�");
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
    	   log.info("����ʼ�ɹ���");
    	   tranThreadLocal.set(tran);
    	 }
      }catch(Exception e){
    	 e.printStackTrace(); 
    	 log.error("����ʼʧ�ܣ�");
      }
    }
    public static void commitTran() throws Exception
    {
      Transaction tran=tranThreadLocal.get();
      try{
    	 if(tran!=null&&!tran.wasCommitted()&&!tran.wasRolledBack())
    	 {
    	   tran.commit();
    	   log.info("�����ύ�ɹ���");
    	   tranThreadLocal.set(null);
    	 }
      }catch (Exception e) {
    	  e.printStackTrace();
    	  log.error("�����ύʧ��!");
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
    	   log.info("����ع��ɹ���");
    	   tranThreadLocal.set(null);
    	 }
      }catch(Exception e){
    	 e.printStackTrace(); 
    	 log.error("����ع�ʧ�ܣ�");
      }
    }
    public static void closeSession()
    {
      Session session=sessThreadLocal.get();	
      try{
        if(session!=null)
        {
           session.close();
           log.info("Session�رճɹ���");
           sessThreadLocal.set(null);
        }
      }catch(Exception e){
    	 e.printStackTrace(); 
    	 log.error("Session�ر�ʧ�ܣ�");
      }
    }
}
