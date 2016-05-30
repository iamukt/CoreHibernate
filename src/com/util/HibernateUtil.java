package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil 
{
	private static HibernateUtil hu = new HibernateUtil();
	private SessionFactory factory = null;
	
	private HibernateUtil()
	{
		/*factory = new Configuration().configure().addAnnotatedClass(com.pojos.Customer.class).buildSessionFactory();*/
		/*Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(com.pojos.Customer.class);
		*//*ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(
				cfg.getProperties()).build();*/
		StandardServiceRegistryBuilder service = new StandardServiceRegistryBuilder();
		
		service.applySetting("hibernate.connection.autocommit", "false");
		service.applySetting("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		service.applySetting("hibernate.connection.password", "root");
		service.applySetting("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
		service.applySetting("hibernate.connection.username", "root");
		service.applySetting("hibernate.current_session_context_class", "thread");
		service.applySetting("hibernate.connection.pool_size", 2);
		service.applySetting("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		service.applySetting("hibernate.show_sql", true);
		service.applySetting("hibernate.format_sql", true);
		service.applySetting("hibernate.hbm2ddl.auto", "update");
		ServiceRegistry reg = service.build();
		
		
		MetadataSources metadatasources = new MetadataSources(reg);
		metadatasources.addAnnotatedClass(com.pojos.Customer.class);
		
		MetadataBuilder mdb = metadatasources.getMetadataBuilder();
		
		Metadata md = mdb.build();
		
		factory = md.buildSessionFactory();
		/*factory = cfg.buildSessionFactory(reg);*/
		System.out.println(factory);
		System.out.println("sf created");
	}
	
	public static SessionFactory getFactory()
	{
		System.out.println(hu.factory);
		System.out.println("Factory got created");
		return hu.factory;
	}
	
}
