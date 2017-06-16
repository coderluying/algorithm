package exercises1;

public class Node {
	int val;
	Node next;

	Node(int x) {
		val = x;
	}

	public void show(Node head) {

		System.out.println();
		Node current = head;
		while (current != null) {
			System.out.print(current.val + " -> ");
			current = current.next;
		}
	}

	private Node[] getNodes(int index, Node head) {

		Node n = getNode(index, head);
		Node last = getNode(index - 1, head);
		Node next = getNode(index + 1, head);
		Node[] nodes = { last, n, next };
		return nodes;
	}

	private Node getNode(int n, Node head) {
		if (n <= 0)
			return null;

		int i = 0;
		Node current = head;
		while (i++ < (n - 1)) {
			current = current.next;
		}
		return current;

	}

	private Node exchange(int i, int j, Node head) {

		if (i >= j || j <= 1)
			return head;
		Node[] a = getNodes(i, head);

		Node al = a[0];
		Node at = a[1];
		Node an = a[2];

		Node[] b = getNodes(j, head);

		Node bl = b[0];
		Node bt = b[1];
		Node bn = b[2];

		
		if (an == bt && al != null) {
			al.next = bt;
			bt.next = at;
			at.next = bn;
			return head;
		}

		if (bt == null)
			return head;

		if (al != null)
			al.next = bt;

		bt.next = an;

		bl.next = at;
		at.next = bn;
		
		
		show(bt);
		System.out.println();
		if(al==null)
			return bt;
		return head;
		
	}

	public Node revers(int k, Node head) {
		int i = 1;
		if (k <= 1)
			return head;
		Node newHead = getNode(k, head);
		Node nHead=head;
		while (i <= k / 2) {
			System.out.println("i is "+i);
			System.out.println();
		nHead=exchange(i, k-i+1 , nHead);
			i++;
			
		}
		return newHead;

	}

	public static void main(String args[]) {
		Node head = new Node(1);
		Node current = head;
		Node test = new Node(0);
		for (int i = 2; i <= 6; i++) {

			current.next = new Node(i);
			current = current.next;
		}

		// test.revers(6, head);
		head=test.revers(4, head);
		test.show(head);
		System.out.println();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Node reversePair(Node head) {
		Node oldhead = head.next;

		Node am = new Node(-1);
		Node cl = am;
		Node c = head;
		Node s = head.next;
		Node a;

		cl.next = c;

		while (c != null && s != null && cl != null) {
			cl.next = s;
			a = s.next;
			s.next = c;
			c.next = a;

			cl = c;
			if (cl == null || cl.next == null || cl.next.next == null)
				break;
			c = cl.next;
			s = c.next;

		}

		return oldhead;
	}
}
