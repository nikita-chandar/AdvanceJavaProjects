package com.nikita.multithreading.threads;

import com.nikita.multithreading.resource.Shop;

public class Supplier extends Thread {
	Shop shop;
	public Supplier(Shop shop)
	{
		this.shop=shop;
	}

	@Override
	public void run()
	{
		shop.restockproducts(20);
	}
 }
  