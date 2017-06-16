package exercises1;

import java.util.concurrent.SynchronousQueue;

public class Seller implements Runnable {

	Product p;

	Seller(Product p) {
		this.p = p;
		System.out.println("make seller");
	}

	public void run() {

		while (true) {
			while (p.num < 100) {

				System.out.println("start make product " + (p.num++) + "  + 1");
				System.out.println("now product is " + p.num);

					try {
						if (p.num == 100) {
							
							System.out.println("notify consumer");
							Thread.currentThread().yield();
						}

					} catch (Exception e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
			}
			
		}

	}

}
