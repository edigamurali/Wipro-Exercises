package com.wipro.thread;

import java.util.ArrayList;
import java.util.List;

public class AlphabetsThread extends Thread
{
	public void run()
	{
		for(char c='A';c<='J';c++)
		{
			System.out.println(c);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
