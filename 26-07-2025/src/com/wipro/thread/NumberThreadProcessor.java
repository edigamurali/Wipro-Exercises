package com.wipro.thread;

import java.util.ArrayList;
import java.util.List;

public class NumberThreadProcessor extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
