package com.multithreading.interThread;

class Q{
	int value;
	boolean valueSet=false;
	
	public synchronized void put(int value) {
		while(valueSet) {
			try{wait();} catch(Exception e) {}
		}
		System.out.println("Put: "+value);
		this.value=value;
		valueSet=true;
		notify();
	}
	
	public synchronized void get() {
		while(!valueSet) {
			try{wait();} catch(Exception e) {}
		}
		System.out.println("Get: "+value);
		valueSet=false;
		notify();
	}
}

class Producer implements Runnable{
	Q q;
	public Producer(Q q) {
		this.q = q;
		Thread t1=new Thread(this,"Producer");
		t1.start();		
	}
	@Override
	public void run() {
		System.out.println("Hello");
		int i=0;
		while(true) {
			q.put(i++);
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		}	
	}
}

class Consumer implements Runnable{
	Q q;

	public Consumer(Q q) {
		this.q = q;
		Thread t1=new Thread(this,"Consumer");
		t1.start();
	}

	@Override
	public void run() {
		while(true) {
			q.get();
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}

public class Inter_Thread {

	public static void main(String[] args) {
			Q q=new Q();
			new Producer(q);
			new Consumer(q);
			
	}

}
