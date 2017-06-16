package exercises1;

public class Father {

	private static String baseName = "father";


	Father() {
		System.out.println("fa struct");
		callName();
		
		System.out.println("endFather---------");
	}

	static {
		baseName = "basefather";
	}

	public void callName() {

		System.out.println("fa callName");
		System.out.println("fbaseName   " + baseName);
	}

	 public class Son extends Father

	{
		private String baseName = "son";
		
		public Son() {
			System.out.println("son struct");
			callName();
			System.out.println("endSon-----------");
		}

		public void callName() {
			System.out.println("son callName");
			System.out.println("sonbaseName   " + baseName);
			
		}

	}

	public static void main(String[] args) {
		Father2 f = new Son2();
		f.callName();
	}

}
