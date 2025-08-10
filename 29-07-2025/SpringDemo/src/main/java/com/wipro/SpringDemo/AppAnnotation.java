package com.wipro.SpringDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wipro.beans.Display;
import com.wipro.beans.Mobile;

public class AppAnnotation 
{
    public static void main( String[] args )
    {
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext(AppAnnotation.class);
		ctx.scan("com.wipro.*");
		Display display=ctx.getBean(Display.class);
		display.setSize(25);
		Mobile mobile=ctx.getBean(Mobile.class);
		System.out.println(mobile);
    }
}
