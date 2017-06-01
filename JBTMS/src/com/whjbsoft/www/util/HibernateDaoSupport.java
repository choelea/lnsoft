package com.whjbsoft.www.util;

public class HibernateDaoSupport
{
    private Hibernate_Template hibernate_Template;
    
	public HibernateDaoSupport()
	{
	  this.setHibernate_Template(new Hibernate_Template());
	}
	public Hibernate_Template getHibernate_Template() {
		return hibernate_Template;
	}

	public void setHibernate_Template(Hibernate_Template hibernate_Template) {
		this.hibernate_Template = hibernate_Template;
	}
    
}
