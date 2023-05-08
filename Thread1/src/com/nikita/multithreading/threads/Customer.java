package com.nikita.multithreading.threads;

import com.nikita.multithreading.resource.Shop;

public class Customer extends Thread
 {
	Shop shop;
	public Customer(Shop shop)
	{
		this.shop=shop;
	}
	@Override
	public void run()
	{
		shop.orderproducts(10);
	}
 }
  

