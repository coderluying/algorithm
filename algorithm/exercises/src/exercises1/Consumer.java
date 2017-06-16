package exercises1;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Consumer implements Runnable {

	Product p;

	Consumer(Product p) {
		this.p = p;
		System.out.println("make consumer");
	}

	@Override

	public void run() {
		while (true) {
			while (p.num > 0) {

				System.out.println("buy product " + (p.num--) + "  - 1");
				System.out.println("now product is " + p.num);

				try {
					if (p.num == 0) {

						System.out.println("notify seller");
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
