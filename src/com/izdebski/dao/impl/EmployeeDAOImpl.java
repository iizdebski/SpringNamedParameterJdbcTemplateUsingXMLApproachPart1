package com.izdebski.dao.impl;

import com.izdebski.dao.EmployeeDAO;
import com.izdebski.model.Employee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createEmployee(Employee employee) {
        Connection connection = null;
        PreparedStatement ps = null;

        try{
            connection=dataSource.getConnection();
            String SQL = "INSERT INTO employee_table(employee_name, email, gender,salary) VALUES(?,?,?,?)";
            ps = connection.prepareStatement(SQL);

            ps.setString(1, employee.getEmployeeName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getGender());
            ps.setDouble(4, employee.getSalary());

            int executeUpdate = ps.executeUpdate();
            if (executeUpdate>0)
                System.out.println("Employee is created ... ");

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return null;
    }

    @Override
    public void deleteEmployeeById(int employeeId) {

    }

    @Override
    public void updateEmployeeEmailById(String newEmail, int employeeId) {

    }

    @Override
    public List<Employee> getAllEmployeesDetails() {
        return null;
    }
}
