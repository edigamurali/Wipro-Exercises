package com.wipro.clienttest;

import com.wipro.thread.AlphabetsThread;
import com.wipro.thread.NumberThreadProcessor;

public class ThreadTest {

	public static void main(String[] args) 
	{
		NumberThreadProcessor nt=new NumberThreadProcessor();
		nt.start();
		AlphabetsThread at=new AlphabetsThread();
		at.start();
		
	}

}
