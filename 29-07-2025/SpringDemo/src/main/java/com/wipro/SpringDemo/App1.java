package com.wipro.SpringDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.beans.College;
import com.wipro.beans.Department;

public class App1 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");
        Department dept=ctx.getBean(Department.class);
        System.out.println(dept);
        College college=ctx.getBean(College.class);
        System.out.println(college);


    }
}
