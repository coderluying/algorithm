package exercises1;

public class TEST {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
Sell s=new Sell();
Thread t1=new Thread(s);
Thread t2=new Thread(s);
t1.setName("t1");
t2.setName("t2");
t1.start();
t2.start();
	}

}
