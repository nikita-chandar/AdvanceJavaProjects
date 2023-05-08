package com.nikita.multithreading.threads;

	import com.nikita.multithreading.resource.Bike;
import com.nikita.multithreading.resource.Resource;

	public class Rutu extends Thread
	{
		Bike bike;
	public  Rutu (Bike bike)
	{
		this.bike=bike;
	}

	@Override
	public void run()
	{
	 synchronized (bike.KeyOfBike)
	 {
		 System.out.println(this.getName()+"locked"+bike.KeyOfBike);
		 synchronized(bike.KeyOfBike)
			{
				System.out.println(this.getName()+" locked"+bike.KeyOfBike);
			
		}
			System.out.println(this.getName()+" Realesed"+bike.Bike);
			
	}
	 System.out.println(this.getName()+" Realesed"+bike.KeyOfBike);

	}

	 }


