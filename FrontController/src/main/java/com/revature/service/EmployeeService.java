package com.revature.service;

import java.util.Optional;

import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;

import java.util.List;

public class EmployeeService 
{
	private EmployeeDao edao;
	
	public EmployeeService(EmployeeDao edao)
	{
		this.edao = edao;
	}
	
public Employee confirmLogin(String username, String password) 
{
		
		Optional<Employee> possibleEmp = edao.findAll()
				.stream()
				.filter(e -> (e.getUsername().equals(username) && e.getPassword().equals(password)))
				.findFirst();
		
		// IF the employee object is present, return it, otherwise return null;
		return (possibleEmp.isPresent() ? possibleEmp.get() : null); 
	}
	
	public int insert(Employee e) 
	{
		return edao.insert(e);
	}

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
