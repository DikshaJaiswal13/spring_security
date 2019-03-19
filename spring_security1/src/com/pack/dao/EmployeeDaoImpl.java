package com.pack.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pack.model.Employee;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addEmployee(Employee e) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(e);
	}

	@Override
	public List<Employee> listEmployees() {
		// TODO Auto-generated method stub
		
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		Employee e=(Employee)sessionFactory.getCurrentSession().load(Employee.class, new Integer(id));
		if(null!=e)
			sessionFactory.getCurrentSession().delete(e);
	}

}
