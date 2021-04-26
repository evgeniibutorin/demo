package com.example.demo.app.servlets;

import com.example.demo.app.dto.EmployeeService;
import com.example.demo.app.entities.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AddServlet extends HttpServlet {

    private EmployeeService employeeService;

    public void init() {
        employeeService = new EmployeeService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String position = request.getParameter("position");

        Employee employee = new Employee();
        employee.setName(name);
        employee.setPosition(position);

        try {
            int i = employeeService.registerEmployee(employee);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ArrayList<Employee> employees = employeeService.getEmployees();
        request.setAttribute("employees", employees);
        response.sendRedirect("views/add.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Employee> employees = employeeService.getEmployees();
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("views/add.jsp").forward(req, resp);
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
