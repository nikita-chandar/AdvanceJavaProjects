package com.nikita.multithreading.threads;

import com.nikita.multithreading.resource.Resource;

public class Thread1 extends Thread{
	Resource resource;
	public Thread1(Resource resource)
	{
		super();
		this.resource=resource;
	}
	
	@Override
	public void run()
	{
		synchronized(resource.resource1)
		{
			System.out.println(this.getName()+"locked"+resource.resource1);
			synchronized(resource.resource2)
			{
				System.out.println(this.getName()+"locked"+resource.resource1);
			}
				System.out.println(this.getName()+" Realesed"+resource.resource1);
			
		}
			System.out.println(this.getName()+" Realesed"+resource.resource2);
			
	}

}

