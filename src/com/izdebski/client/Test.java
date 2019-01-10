package com.izdebski.client;

import com.izdebski.model.Employee;
import com.izdebski.service.EmployeeService;
import com.izdebski.service.impl.EmployeeServiceImpl;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {

        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");

        EmployeeService employeeService = ctx.getBean("employeeService", EmployeeServiceImpl.class);

        //createEmployee(employeeService);

        Employee employee = employeeService.fetchEmployeeById(2);
        System.out.println(employee.getEmployeeId()+"\t"+employee.getEmployeeName());
        ctx.close();
    }

        private static void createEmployee(EmployeeService employeeService){

            Employee employee = new Employee();
            employee.setEmail("peter.s@yahoo.com");
            employee.setEmployeeName("Peter");
            employee.setGender("Male");
            employee.setSalary(90000.00);

            employeeService.addEmployee(employee);
        }
}