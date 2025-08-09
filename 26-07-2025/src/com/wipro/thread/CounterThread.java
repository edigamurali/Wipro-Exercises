package com.wipro.thread;

public class CounterThread extends Thread
{
	Counter counter;
	public CounterThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 1; i <=10; i++) {
        	
            counter.increment();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) 
    {
    	Counter counter = new Counter();
        CounterThread t1 = new CounterThread(counter);
        CounterThread t2 = new CounterThread(counter);
        t1.start();
        t2.start();
        try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println(counter.getCount());
	}

}
