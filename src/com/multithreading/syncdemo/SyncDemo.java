package com.multithreading.syncdemo;

class Counter{
	int count;
	//synchronized keyword asks one thread to wait until another is done to prevent error
	public synchronized void increment() {
		count++;
	}
}

public class SyncDemo {

	public static void main(String[] args) throws InterruptedException {
		Counter counter=new Counter();
		Thread t1=new Thread(new Runnable()
			{
				public void run() {
					for(int i=1;i<=1000;i++) {
						counter.increment();}
					}
			});
		Thread t2=new Thread(new Runnable()
		{
			public void run() {
				for(int i=1;i<=1000;i++) {
					counter.increment();}
				}
		});
		t1.start();
		t2.start();
		t2.join();
		t1.join();      	//Asks main thread to wait until this thread is done
		System.out.println("count = "+counter.count);

	}

}
