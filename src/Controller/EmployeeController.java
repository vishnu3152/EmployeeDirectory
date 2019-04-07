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
	
	// create reference variable
	
	EmployeeDAO employeeDAO=null;
	
	// create constructor to create object for EmployeeDAO
	
	
	public EmployeeController() {
		
		employeeDAO=new EmployeeDAOImpl();
	}
	
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			// call the dao method to get the list of employee objects
		
			List<Employee> list=employeeDAO.get();
			
			// Add employees to request object
			
			request.setAttribute("list", list);
		
			//Get the request Dispatcher
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("/views/employee-list.jsp");
			
			//forward req and res objects
			
			dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
