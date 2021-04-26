package com.example.demo.app.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.demo.app.dto.EmployeeService;
import com.example.demo.app.entities.Employee;

public class AddServlet extends HttpServlet {

    private EmployeeService employeeService;

    public void init(){
        employeeService = new EmployeeService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String position = request.getParameter("position");

        //
//
//        String INSERT_USERS_SQL = "INSERT INTO employee" +
//                "  (id, name, position) VALUES " +
//                " (?, ?, ?);";
//
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException classNotFoundException) {
//            classNotFoundException.printStackTrace();
//        }
//
//        try (Connection connection = DriverManager
//                .getConnection("jdbc:postgresql://localhost:5432/employees", "postgres", "32167");
//
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
//            preparedStatement.setInt(1, 1);
//            preparedStatement.setString(2, name);
//            preparedStatement.setString(3, position);
//
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//
//        } catch (SQLException e) {
//            // process sql exception
//            System.out.println(e);
//        }




        Employee employee = new Employee();
        employee.setName(name);
        employee.setPosition(position);

        try {
            int i = employeeService.registerEmployee(employee);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("employeedetails.jsp");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Employee> employees = employeeService.getEmployees();
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("views/add.jsp").forward(req, resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try (Connection conn = DriverManager.getConnection(
//                "jdbc:postgresql://localhost:5432/employees", "postgres", "32167")) {
//
//            if (conn != null) {
//                System.out.println("Connected to the database!");
//            } else {
//                System.out.println("Failed to make connection!");
//            }
//
//        } catch (SQLException e) {
//            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        String name = req.getParameter("name");
//        String position = req.getParameter("position");
//        System.out.println(name +" "+ position);
//        //super.doPost(req, resp);
//    }
}
