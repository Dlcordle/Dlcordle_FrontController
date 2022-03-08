package com.revature.dao;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

import antlr.collections.List;

public class EmployeeDao 
{
	public int insert(Employee e) 
	{
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = (Transaction) ses.beginTransaction();
		
		int pk = (int) ses.save(e);
		
		try 
		{
			tx.commit();
		} 
		catch (SecurityException | RollbackException | HeuristicMixedException | HeuristicRollbackException
				| SystemException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return pk;
	}
	
	public List findAll()
	{
		Session ses = HibernateUtil.getSession();
		
		//List<Employee> emps = ses.createQuery("from Employee", Employee.class, )>;
		return null;
	}

}
