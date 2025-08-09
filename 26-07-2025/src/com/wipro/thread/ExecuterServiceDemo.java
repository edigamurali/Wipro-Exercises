package com.wipro.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterServiceDemo 
{
	public static void main(String[] args)
	{
		ExecutorService executor = Executors.newFixedThreadPool(5);
		executor.submit(()->{
			for(int i=0;i<=5;i++)
			{
				System.out.println(Thread.currentThread().getName()+" "+i);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		executor.submit(()->{
			for(int i=0;i<=5;i++)
			{
				System.out.println(Thread.currentThread().getName()+" "+i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		executor.shutdown();
		}
}
