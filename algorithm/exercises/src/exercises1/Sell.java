package exercises1;

public class Sell implements Runnable {

	public int ticket = 1000;
	Object o ;
	public void run() {
o=new Object();
		System.out.println(o.toString());
		System.out.println(this.toString()+"buit a unlock o");
		
			while (ticket >= 1) {

				synchronized (this) {
					
				
				System.out.println(Thread.currentThread().getName() + "  :  sell ticket " + ticket);
				if (ticket <= 0)
					System.out.println(Thread.currentThread().getName() + ":  sssssssssssssssssss");

				ticket--;
				}
			
		}
	}

	public synchronized  void sell() {
		while (ticket >= 1) {

			System.out.println(Thread.currentThread().getName() + "  :  sell ticket " + ticket);
			ticket--;

		}
	}

}
