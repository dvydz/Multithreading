package com.multithreading.interThread;

class Q{
	int value;
	boolean valueSet=false;
	
	public synchronized void put(int value) {
		while(valueSet) {						//When valueSet=true,value is set already, it waits and lets get() get value first
			try{wait();} catch(Exception e) {}	//then when get() notifies it, it increments and set another value.....
		}
		System.out.println("Put: "+value);
		this.value=value;
		valueSet=true;
		notify();			//notifies the get() that it has already been set,and that it can proceed now
	}
	
	/* In 1st iteration, -> If Consumer thread reaches first, valueSet=false so it will enter the while loop and wait
	 * until the put() method reaches and sets the value. Once the value is set, Put() will notify get() to proceed
	 * and the valueSet=true now, so get() will exit the while loop and print Get value.
	 * -> If producer has already reached before Consumer,the valueSet will already be set true because Put() will skip the
	 * while loop and put the value and set valueSet=true. Then when consumer reach, valueSet=true so it will not go inside
	 * while loop and print the get() value instead
	 */
	public synchronized void get() {		
		while(!valueSet) {					//when valueSet=false, new value is not set, so this has to wait
			try{wait();} catch(Exception e) {}
		}
		System.out.println("Get: "+value);
		valueSet=false;
		notify();     		//notifies the set() that it has already been set,and that it can proceed now
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