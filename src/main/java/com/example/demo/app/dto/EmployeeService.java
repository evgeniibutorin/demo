package com.example.demo.app.dto;

import com.example.demo.app.entities.Employee;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeService {


    DBConnection mt = new DBConnection();
    Connection myConn = mt.myConn;

    private class DBConnection {
        public Connection myConn;

        public DBConnection() {

            try {
                Class.forName("org.postgresql.Driver");
                myConn =
                        DriverManager.getConnection("jdbc:postgresql://localhost:5432/employees", "postgres", "32167");
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
    }

    public int registerEmployee(Employee employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO employee" +
                "  (name, position) VALUES " +
                " (?, ?);";

        int result = 0;

//        Class.forName("org.postgresql.Driver");
//
//        try (Connection connection = DriverManager
//                .getConnection("jdbc:postgresql://localhost:5432/employees", "postgres", "32167");

             // Step 2:Create a statement using connection object
        try {
            PreparedStatement preparedStatement = myConn.prepareStatement(INSERT_USERS_SQL);
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setString(2, employee.getPosition());

                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }


    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement pst =
                    myConn.prepareStatement("select * from employee");
            ResultSet r = pst.executeQuery();
            while (r.next()) {
                Employee e = new Employee();
                e.setId(r.getInt("id"));
                e.setName(r.getString("name"));
                e.setPosition(r.getString("position"));
                employees.add(e);
            }
        } catch (SQLException exc) {
            System.out.println("An error occured. Error: " + exc.getMessage());
        }
        return employees;
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
