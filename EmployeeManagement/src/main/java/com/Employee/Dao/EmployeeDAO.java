package com.Employee.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Employee.Model.Employee;
import com.Employee.util.JdbcHelper;


public class EmployeeDAO {
	private static final String INSERT_EMPLOYEES_SQL = "INSERT INTO employees" + "  (name, email, country) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_EMPLOYEES_BY_ID = "select id,name,email,country from employees where id =?";
	private static final String SELECT_ALL_EMPLOYEES = "select * from employees";
	private static final String DELETE_EMPLOYEES_SQL = "delete from employees where id = ?;";
	private static final String UPDATE_EMPLOYEES_SQL = "update employees set name = ?,email= ?, country =? where id = ?;";

	public EmployeeDAO() {
	}

	protected Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = JdbcHelper.getConnection();
		} catch (ClassNotFoundException e) {
	 		e.printStackTrace();
	}
		return connection;
	}

	
	public void insertEmployee(Employee employee) throws SQLException {
		System.out.println(INSERT_EMPLOYEES_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = JdbcHelper.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEES_SQL)) {
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getEmail());
			preparedStatement.setString(3, employee.getCountry());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Employee selectEmployee(int id) {
		Employee employee = null;
		// Step 1: Establishing a Connection
		try (Connection connection = JdbcHelper.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEES_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				employee = new Employee(id, name, email, country);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return employee;
	}

	public List<Employee> selectAllEmployees() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Employee> employees = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = JdbcHelper.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				Employee.add(new Employee(id, name, email, country));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return employees;
	}

	public boolean deleteEmployee(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JdbcHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEES_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateEmployee(Employee employee) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = JdbcHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEES_SQL);) {
			System.out.println("updated Employee:"+statement);
			statement.setString(1, employee.getName());
			statement.setString(2, employee.getEmail());
			statement.setString(3, employee.getCountry());
			statement.setInt(4, employee.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		
	}

	public static List<Employee> selectAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

}
