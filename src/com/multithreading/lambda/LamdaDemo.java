//Thread with Lambda Implementation
package com.multithreading.lambda;

public class LamdaDemo {
	public static void main(String[] args) throws InterruptedException{
		System.out.println("Thread with lambda DEMO");	
		//inner class implemented to reduce lines of codes
		Thread t1=new Thread(() -> {
			for(int i=0;i<5;i++) {
				System.out.println("Hi");
				try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
			}
		});
		Thread t2=new Thread(() -> {
			for(int i=0;i<5;i++) {
			System.out.println("Hello");
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
			}
	});
		t1.start();
		//10 ms delay between to two to prevent clash, and run them simultaneously
		try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
		t2.start();
		
		/*		Some properties
		 
			t1.setPriority(10);							//Setting Priority
			t2.setPriority(1);
			System.out.println(t1.getPriority());		//Checking priority, 10-Max, 1-least,5-normal
			System.out.println(t2.getPriority());
			
			System.out.println(t1.isAlive()); 			//t1 after join, isAlive gives false
			
			System.out.println(t1.getName()); 			//t1 thread default name
			t1.setName("Thread_ONE");					//t1 thread name changed
			System.out.println(t1.getName()); 			
			
			t1.join();
			t2.join();									//asks main thread to wait until this thread is done
		
			System.out.println("BYE");
		*/
	}
}
