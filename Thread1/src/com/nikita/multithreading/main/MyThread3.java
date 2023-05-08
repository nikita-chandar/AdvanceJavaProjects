package com.nikita.multithreading.main;

public class MyThread3  extends Thread
{
	
	@SuppressWarnings("deprecation")
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
			if(i>2)
			{
				this.stop();
			}
		}
		System.out.println("Mythread3 is now running...");
	}
	
	

}



