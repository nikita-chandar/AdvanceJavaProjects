package com.nikita.multithreading.resource;

import java.lang.module.FindException;

public class Shop {
	int availbleProducts;
	public Shop (int availbleProducts)
	{
		this.availbleProducts=availbleProducts;
	}
	
	public synchronized void orderproducts(int noOfProducts)
	{
		System.out.println("trying to purchase"+noOfProducts+"products");
		if(noOfProducts >availbleProducts)
		{
			System.out.println(noOfProducts+"Products Not Availble...!!");
			System.out.println("plz wait...");
		}
		try {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch(FindException e)
		{
			e.printStackTrace();
		}
	
	    availbleProducts-=noOfProducts;
	System.out.println(noOfProducts+"product purchased");
	System.out.println("Now available products:"+availbleProducts);
	
	}
	public synchronized void restockproducts(int noOfProducts)
	{
		System.out.println("Restocking"+noOfProducts+"products....!!!");
		System.out.println("Now availble products:"+availbleProducts);
		this.notify();
	}
}
