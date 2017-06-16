package exercises1;

import java.io.*;
import java.util.concurrent.SynchronousQueue;

public class Pai extends Thread {

	public class buyer implements Runnable {
		Product p;

		buyer(Product p) {
			this.p = p;

		}

		public void run() {

			while(true)
				buy(p);
		}

	}

	public class seller implements Runnable {
		Product p;

		seller(Product p) {
			this.p = p;

		}

		public void run() {

			while(true)
				make(p);
		}

	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Product p = new Product();
		Pai pp = new Pai();
		new Thread(pp.new buyer(p)).start();

		new Thread(pp.new seller(p)).start();

	}

	public synchronized void buy(Product p) {

		if (p.num > 0) {
			p.num--;
			System.out.println("buy ------  now p is " + p.num);
		}
	}

	public synchronized void make(Product p) {
		if (p.num < 1000) {
			p.num++;
			System.out.println("make ------  now p is " + p.num);
		}
	}
}
