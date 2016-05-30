package com.tester;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pojos.Customer;
import com.util.HibernateUtil;

public class TestCustomer 
{
	public static void main(String[] args) 
	{
		
		Customer cc = new Customer();
		cc.setName("Hodor");
		Session sess = HibernateUtil.getFactory().getCurrentSession();
		Transaction tx = sess.getTransaction();
		tx.begin();
		sess.save(cc);
		tx.commit();
	}
	
}
