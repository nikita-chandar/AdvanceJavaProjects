package com.nikita.multithreading.main;

import com.nikita.multithreading.resource.Bike;
import com.nikita.multithreading.threads.Ajinkya;
import com.nikita.multithreading.threads.Rutu;


public class DeadlockMain2 {

		public static void main(String args[]) 
		{
			Bike bike=new Bike();
			Ajinkya ajinkya= new Ajinkya (bike);
			ajinkya.setName("ajinkya");
			
			Rutu rutu=new Rutu(bike);
			rutu.setName("rutu");
			
			ajinkya.start();
			rutu.start();
		} 
	}



