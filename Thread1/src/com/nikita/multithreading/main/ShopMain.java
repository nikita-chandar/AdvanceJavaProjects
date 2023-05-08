package com.nikita.multithreading.main;

import com.nikita.multithreading.resource.Shop;
import com.nikita.multithreading.threads.Customer;
import com.nikita.multithreading.threads.Supplier;

public class ShopMain {
	public static void main(String a[])
	{
		Shop shop= new Shop(5);
		Customer customer=new Customer(shop);
		Supplier supplier=new Supplier(shop);
		
		customer.start();
		supplier.start();
	}

}
