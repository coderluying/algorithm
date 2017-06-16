package exercises1;

import exercises1.Father.Son;

public class Father2 {

	
	private  String baseName = "father2";
   private String fown="fown";

	Father2() {
		
	}
	static {
		showSname();
	}

		private static String sName = "sName :  father2";
	
	
		public static void showSname()
		{System.out.println("load static of father");
			System.out.println(sName);
		}
		
	String q="q";
   public void show()
   {
	   System.out.println("show");
	   System.out.println("q : "+q);
   }
	public void callName() {
		

		System.out.println("fa2 callName");
		System.out.println("f2baseName   " + baseName);
	}
	public static void main(String[] args) {
		
		System.out.println("ssssssss");
		
		System.out.println("------------------");
		Son2 s=new Son2();
	}

}
