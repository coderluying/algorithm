package exercises1;

public class Son2 extends Father2 {
	private String baseName = "son2";
	String sonq = "sonq";

	public Son2() {
	
	}

	private static String sonName = "sNameSon2";
	static {
		showSname();
	}
	
	public static void showSname()
	{System.out.println("load static of son");
		
		System.out.println("sonName of son :"+sonName);
	}
	
	public void showq() {
		System.out.println("showq");
		System.out.println("sonq : " + sonq);
	}

	public void callName() {
	
		System.out.println("son2 callName");
		System.out.println("sonbaseName2   " + baseName);

	}
}
