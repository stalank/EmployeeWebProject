package capgemini.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import capgemini.dao.EmployeeDao;

@WebServlet("/ReadAll")
public class ReadAllEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReadAllEmployees() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao dao = new EmployeeDao();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
			ResultSet rs =dao.readAllEmployees();
			while (rs.next()) {
				int id = rs.getInt("employee_id");
				String name = rs.getString("employee_name");
				double salary = rs.getDouble("employee_salary");

				out.println(id + " , " + name + " , " + salary+"<br>");
				//out.println();
			}
		} catch (ClassNotFoundException e) {
			out.println("Class Not Found Errot.");
			e.printStackTrace();
		} catch (SQLException e){
			out.println("Database Error");
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}

}
