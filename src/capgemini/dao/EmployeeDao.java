package capgemini.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeDao {// DAO: Data Access Object

	public void createEmployee(int employee_id, String employee_name,
			double employee_salary) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", "system", "root");
		Statement stmt = conn.createStatement();
		String sql = "insert into emp values(" + employee_id + ",'"
				+ employee_name + "'," + employee_salary + ")";
		// System.out.println(sql);
		int rs = stmt.executeUpdate(sql);

		if (rs == 1) {
			System.out.println("Data Inserted");
		} else
			System.out.println("Data Not Inserted");

	}

	public void deleteEmployee(int employee_id) throws ClassNotFoundException,
			SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", "system", "root");
		Statement stmt = conn.createStatement();
		String sql = "Delete from emp where employee_id=" + employee_id + "";
		System.out.println(sql);

		int rs = stmt.executeUpdate(sql);
		if (rs == 1) {
			System.out.println("Data Deleted");
		} else
			System.out.println("Data Not Deleted");

	}

	public void readEmployee(int employee_id) throws ClassNotFoundException,
			SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", "system", "root");
		Statement stmt = conn.createStatement();
		String sql = "select * from emp where employee_id=" + employee_id;
		// System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			int id = rs.getInt("employee_id");
			String name = rs.getString("employee_name");
			double salary = rs.getDouble("employee_salary");

			System.out.println(id + " , " + name + " , " + salary);
		}

	}

	public void updateEmployee(int employee_id, double employee_salary)
			throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", "system", "root");
		Statement stmt = conn.createStatement();
		Scanner s1 = new Scanner(System.in);
		employee_id = s1.nextInt();
		Scanner s2 = new Scanner(System.in);
		employee_salary = s2.nextDouble();
		String sql = "update emp set employee_salary= "+employee_salary+" where employee_id= "+employee_id+")";
		int rs = stmt.executeUpdate(sql);
		if (rs == 1) {
			System.out.println("Data Updated.");
		} else
			System.out.println("Data Not Updated.");
		

	}

	public ResultSet readAllEmployees() throws ClassNotFoundException, SQLException {// only
																				// one
																				// way
																				// of
																				// handling
																				// exception
		Class.forName("oracle.jdbc.driver.OracleDriver"); // in java.(Using
															// try-catch only).

		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", "system", "root");
		Statement stmt = conn.createStatement();
		String sql = "select employee_id, employee_name, employee_salary from emp";
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
		
	}
}
