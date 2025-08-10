package com.wipro.SpringDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.beans.Department;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");
        //Department dept=(Department)ctx.getBean("department");
        Department dept=ctx.getBean(Department.class);
        dept.setDeptCode("Fin");
        dept.setDepartmentName("Finance");
        System.out.println(dept);
        

    }
}
