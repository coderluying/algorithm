package exercises1;

public class T {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

	public int[] findbest(int[][] board) {
		int max = 0;
		int now = 0;
		int best[] = new int[2];
		for (int i = 0; i < board[0].length; i++)
			for (int j = 0; j < board[0].length; j++) {
				now = evaluate(board, i, j);
				if (now >= max) {
					best[0] = i;
					best[j] = j;
				}
			}

		return best;

	}

	public int evaluate(int[][] board, int i, int j) {

		return 0;

	}

	int[][] board;
	int color = 1;

	public int count(int i,int j,int color)
	
	{int count=0;
	boolean f=false;
		//count upside 
		int ux=i-5;
    	while(ux<0)
	    	ux++;
    	while(ux!=i)
    	{
    		while(board[ux][j]==0)
    			ux++;
    		
    		//count how many
    		while(board[ux][j]==color)
    		{	
    		   count++;
    		   ux++;
    		   if(board[ux][j]!=color&&board[ux][j]!=0)
    			   count=0;
    		}   		
    		
    	}
	 
		
		
		
		
		
		return 0;
	}

}
