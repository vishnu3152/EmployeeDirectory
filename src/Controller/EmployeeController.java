package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;
import Entity.Employee;

/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {
	
	RequestDispatcher dispatcher=null;
	
	// create reference variable
	
	EmployeeDAO employeeDAO=null;
	
	// create constructor to create object for EmployeeDAO
	
	
	public EmployeeController() {
		
		employeeDAO=new EmployeeDAOImpl();
	}
	
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String action=request.getParameter("action");
	
	if(action == null) {
		action="LIST";
	}
	
	switch(action) {
		case "LIST":
			listEmployees(request,response);
			break;
			
		case "EDIT":
			getSingleEmployee(request,response);
			break;
			
		case "DELETE":
			deleteEmployee(request,response);
			break;
			
		default:
			listEmployees(request,response);
			break;
	}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String name=request.getParameter("firstname");
		String dob=request.getParameter("dob");
		String department=request.getParameter("department");
		
		Employee e=new Employee();
		
		e.setName(name);
		e.setDob(dob);
		e.setDepartment(department);
		if(id.isEmpty() || id==null)
		{
			//Save Operation
			if(employeeDAO.save(e))
			{
			request.setAttribute("message", "Saved Successfully");
			}
		}
		else
		{
			//Update Operation
			e.setId(Integer.parseInt(id));
			if(employeeDAO.update(e))
			{
			request.setAttribute("message", "Updated Successfully");
			}
		}
	
		listEmployees(request,response);

	} 
	
	public void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// call the dao method to get the list of employee objects
		
		List<Employee> list=employeeDAO.get();
		
		// Add employees to request object
		
		request.setAttribute("list", list);
	
		//Get the request Dispatcher
		
		dispatcher=request.getRequestDispatcher("/views/employee-list.jsp");
		
		//forward req and res objects
		
		dispatcher.forward(request, response);
	}
	
	public void getSingleEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		Employee employee=employeeDAO.get(Integer.parseInt(id));
		request.setAttribute("employee", employee);
		dispatcher = request.getRequestDispatcher("/views/employee-add.jsp");
		
		//forward req and res objects
		dispatcher.forward(request, response);
	}
	
	public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id=request.getParameter("id");
		if(employeeDAO.delete(Integer.parseInt(id)))
		{
			request.setAttribute("message", "Record Deleted Succesfully");
		}
		listEmployees(request,response);
	}

}
