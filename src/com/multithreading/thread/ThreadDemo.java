//Thread Implementation
package com.multithreading.thread;

class Hi extends Thread{
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Hi");
			try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		}
	}	
}

class Hello extends Thread{
	public void run() {
		for(int i=0;i<5;i++) {
		System.out.println("Hello");
		//Could have used throws/throw to throw the exception as well
		try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}

public class ThreadDemo {

	public static void main(String[] args) {
		System.out.println("Thread DEMO");
		Hi hi=new Hi();
		Hello hello=new Hello();
		hi.start();
		//10 ms delay between to two to prevent clash, and run them simultaneously
		try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
		hello.start();
	}
}