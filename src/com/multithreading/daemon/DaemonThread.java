package com.multithreading.daemon;

class JavaDaemonThread implements Runnable{

	@Override
	public void run() {
		while(true) {
			process_Something();
		}
	}
	
	private void process_Something() {
		System.out.println("Processing Daemon Thread");
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
 }

public class DaemonThread {
	public static void main(String[] args) {
		JavaDaemonThread jdt=new JavaDaemonThread();
		Thread t1=new Thread(jdt,"DaemonThread-1");
		//if t1 is not set as Daemon thread, the while loop in JavaDaemonThread class will keep running(true)
		t1.setDaemon(true);
		t1.start();
		
		//The below Thread.sleep represents main thread
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finishing Program");
	}
 }


