package DAO;

import java.util.List;

import Entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> get();
	
	boolean save(Employee e);
	
	Employee get(int id);
	
	boolean update(Employee e);
	
	boolean delete(int id);
	
}
