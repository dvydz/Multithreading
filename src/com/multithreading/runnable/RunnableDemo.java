//Runnable Implementation
package com.multithreading.runnable;

import com.multithreading.runnable.Hello;
import com.multithreading.runnable.Hi;

class Hi implements Runnable{
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Hi");
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		}
	}	
}

class Hello implements Runnable{
	public void run() {
		for(int i=0;i<5;i++) {
		System.out.println("Hello");
		//using runnable we can't use throws/throw because they can only be used for unchecked exception
		//Use try/catch for checked exception in run()
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}

public class RunnableDemo {

	public static void main(String[] args){
		System.out.println("Runnable DEMO");
		//class Hi is Runnable too, so we can use either for reference
		Runnable hi=new Hi();
		Runnable hello=new Hello();
		Thread t1=new Thread(hi);
		Thread t2=new Thread(hello);
		hi.run();
		t1.start();
		//10 ms delay between to two to prevent clash, and run them simultaneously
		try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
		t2.start();
	}
}

