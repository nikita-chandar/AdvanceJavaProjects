package com.nikita.multithreading.threads;

	
	import com.nikita.multithreading.resource.Bike;
import com.nikita.multithreading.resource.Resource;

	public class Ajinkya extends Thread{
		Bike bike;
		public Ajinkya(Bike bike)
		{
			super();
			this.bike=bike;
		}
		
		@Override
		public void run()
		{
			synchronized(bike.Bike)
			{
				System.out.println(this.getName()+" locked "+bike.Bike);
				synchronized(bike.KeyOfBike)
				{
					System.out.println(this.getName()+" locked "+bike.Bike);
				}
					System.out.println(this.getName()+" Realesed "+bike.Bike);
				
			}
				System.out.println(this.getName()+" Realesed "+bike.KeyOfBike);
				
		}

	}




