package exercises1;

import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Testt {

	public static void main(String[] args) {

		 int a=2011111000;
		String n=Integer.toString(a);
		String p="(11111)";
		Pattern pt=Pattern.compile(p);
	    Matcher m=pt.matcher(n);
	    int i=0;
	    
	    m.find();
	    while(i++<2)
	    	System.out.println(m.group());
	}

	private int size;
	private int[][] chessBoard;

	public void showMap() {
		for (int i = 0; i < size; i++) {
			System.out.println();
			for (int j = 0; j < size; j++) {
				System.out.print(chessBoard[i][j] + "|");

			}
		}
	}

	public void init() {
		size = 9;
		chessBoard = new int[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				chessBoard[i][j] = 0;
			}
		// test
		// chessBoard[0][0] = 5;
		// chessBoard[0][1] = 6;
		 chessBoard[0][0] = 5;
		 chessBoard[0][1] = 3;
		 chessBoard[0][4] = 7;
		 chessBoard[1][0] = 6;
		 
		 
		int[] s = { 0, 0 };
		s=next(s);
		
		
		if (fill2(s) == true) {
			for (int i = 0; i < size; i++) {
				System.out.println();
				for (int j = 0; j < size; j++) {
					System.out.print(chessBoard[i][j] + "|");

				}
			}
		}

	}
	
	public boolean fill2(int[]start)
	{
		showMap();
		System.out.println();
		int[] next;
		boolean f;
		LinkedList<Integer> q;
		
		if(start[0]<0||start[1]<0)
		return true;
		
		q=count(start);
		
		while(q.size()!=0)
		{
			
			chessBoard[start[0]][start[1]]=q.removeFirst();
			next=next(start);
			
			f=fill2(next);
			if(f==true)
				return true;

			
		}
		chessBoard[start[0]][start[1]]=0;
		return false;
		
	}

	public boolean fill(int[] start) {
		showMap();
		System.out.println();
		int[] next;
		LinkedList<Integer> q;

		q = count(start);

		// fill this blanket
		if (q.size() != 0) {
			chessBoard[start[0]][start[1]] = q.removeFirst();
			next = next(start);
			if (next[0] < 0 || next[1] < 0)
				return true;

		} else
			return false;
		
		
		boolean f = fill(next);
		// dfs
		while (f != true && q.size() != 0) {
			//recover
			chessBoard[next[0]][next[1]]=0;
			
			chessBoard[start[0]][start[1]] = q.removeFirst();
			f = fill(next);
		}

		if (f == true)
			return true;
		return false;

	}

	public int[] next(int[] last) {
		int x = last[0];
		int y = last[1];

		while (x < size && y < size && chessBoard[x][y] != 0) {
			if (x >= size)
				break;
			if (y == size - 1) {
				x++;
				y = 0;
			} else
				y++;

		}

		if (x == size || y == size) {
			x = -1;
			y = -1;
		}
		int[] n = { x, y };
		return n;
	}

	public LinkedList<Integer> count(int[] last) {
		int i = last[0];
		int j = last[1];

		LinkedList<Integer> c = new LinkedList<Integer>();
		LinkedList<Integer> cow = new LinkedList<Integer>();
		LinkedList<Integer> row = new LinkedList<Integer>();
		LinkedList<Integer> nine = new LinkedList<Integer>();

		for (int x = 1; x < 10; x++) {
			row.add(x);
			cow.add(x);
			nine.add(x);
		}

		// count cow
		for (int r = 0; r < size; r++) {
			if (chessBoard[i][r] != 0)
				c.add(chessBoard[i][r]);
		}
		row.removeAll(c);
		c.clear();

		// count row
		for (int r = 0; r < size; r++) {
			if (chessBoard[r][j] != 0)
				c.add(chessBoard[r][j]);
		}
		cow.removeAll(c);
		c.clear();

		// count nine
		int p = (i / 3) * 3;
		int q = (j / 3) * 3;

		for (int t = p; t < p + 3; t++)
			for (int w = q; w < q + 3; w++) {

				if (chessBoard[t][w] != 0)
					c.add(chessBoard[t][w]);
			}
		nine.removeAll(c);

		cow.retainAll(nine);
		cow.retainAll(row);

		return cow;

	}

	public String test(String str) {
		int i = 0;
		String anwser = "";
		HashMap<Boolean, LinkedList<Character>> map = new HashMap<Boolean, LinkedList<Character>>();
		while (str.charAt(i) != '(')
			i++;
		LinkedList<Character> nq;
		map = getStr(i, str);
		Iterator it = map.keySet().iterator();
		if (it.hasNext()) {
			// juedge can add or not
			Boolean f = (Boolean) it.next();

			nq = map.get(f);
			while (nq.size() != 0)
				anwser += nq.removeFirst();

		}
		return anwser;

	}

	// "(()(())"
	public HashMap<Boolean, LinkedList<Character>> getStr(int begin, String str) {
		HashMap<Boolean, LinkedList<Character>> map = new HashMap<Boolean, LinkedList<Character>>();
		HashMap<Boolean, LinkedList<Character>> nmap = new HashMap<Boolean, LinkedList<Character>>();
		LinkedList<Character> q = new LinkedList<Character>();

		boolean fl = false;
		int i = begin;
		while (i != str.length()) {
			q.add(str.charAt(i));
			if (str.charAt(i) == ')') {
				if ((i + 1) == str.length())
					break;
				if (str.charAt(i + 1) == '(') {
					nmap = getStr(i + 1, str);
					break;
				}
			}
			i++;
		}

		// judge this layer can add or not
		String thisStr = "";
		while (q.size() != 0)
			thisStr += q.removeFirst();
		int left = count('(', thisStr);
		int right = count(')', thisStr);
		if (left <= right)
			fl = true;

		// get this layer's str
		int difv = Math.abs(left - right);
		if (left > right)
			thisStr = thisStr.substring(difv);
		else
			thisStr = thisStr.substring(0, thisStr.length() - difv);

		// get next layer's string
		String nString = "";
		Boolean f = false;
		Iterator it = nmap.keySet().iterator();
		LinkedList<Character> nq = new LinkedList<Character>();
		if (it.hasNext()) {
			// juedge can add or not
			f = (Boolean) it.next();

		}
		nq = nmap.get(f);
		if (nq != null)
			while (nq.size() != 0)
				nString += nq.removeFirst();

		String anwser = "";
		if (f == true)
			anwser = thisStr + nString;

		if (f == false) {
			if (thisStr.length() >= nString.length())
				anwser = thisStr;
			else
				anwser = nString;
		}

		int k = 0;
		while (k != anwser.length())
			q.add(anwser.charAt(k++));

		map.put(fl, q);
		return map;

	}

	int count(char c, String str) {
		int i = 0;
		int count = 0;
		while (i != str.length()) {
			if (str.charAt(i++) == c)
				count++;

		}
		return count;
	}

}
