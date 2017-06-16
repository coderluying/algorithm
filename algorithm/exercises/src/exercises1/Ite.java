package exercises1;

import java.util.*;

public class Ite<T> implements Iterable<T> {

	LinkedList<String> q = new LinkedList<String>();

	public void init()
	
	{
		q.add("a");
		q.add("b");
	System.out.println("after init size is "+q.size());	
	}
	
	public static void main(String[] args) {
		Ite i=new Ite();
		i.init();
		for(Object x:i)
		System.out.println(x);
			
	}
	itor it = new itor();
	public class itor implements Iterator {

		@Override
		public boolean hasNext() {
		System.out.println("hasnext");
              if(q.size()!=0)
            	  return true;
			return false;
		}

		@Override
		public String next() {
		return "s";
			//	return q.removeFirst();
			}

	}

	@Override
	public Iterator<T> iterator() {
		return it;
	}

}
