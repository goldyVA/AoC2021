
public class Board 
{
	int[][] board = new int[5][5];
	boolean[][] marked = new boolean[5][5];
	
	public Board(int[][] input)
	{
		board = input;
		for(int i = 0; i < 5; i++)
		{
			for(int j =0 ; j<5; j++)
			{
				marked[i][j] = false;
			}
		}
	}
	
	public void newNumber(int num)
	{
		for(int i = 0; i < 5; i++)
		{
			for(int j =0 ; j<5; j++)
			{
				if(board[i][j] == num)
					marked[i][j] = true;
			}
		}	
	}
	
	public boolean isBingo()
	{
		for(int i = 0; i < 5; i++)
		{
			boolean allTrue = true;
			for(int j =0 ; j<5; j++)
			{
				if(!marked[i][j])
					allTrue = false;
			}
			if(allTrue)
				return true;
		}
		
		for(int i = 0; i < 5; i++)
		{
			boolean allTrue = true;
			for(int j =0 ; j<5; j++)
			{
				if(!marked[j][i])
					allTrue = false;
			}
			if(allTrue)
				return true;
		}
		
		return false;	
	}
	
	public void printBoard()
	{
		for(int i = 0; i < 5; i++)
		{
			for(int j =0 ; j<5; j++)
			{
				if(board[i][j] < 10)
					System.out.print(" " + board[i][j]+" ");
				else
					System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
		int sum = 0;
		for(int i = 0; i < 5; i++)
		{
			for(int j =0 ; j<5; j++)
			{
				if(!marked[i][j])
				{
					System.out.print(board[i][j]+ " ");
					sum += board[i][j];
				}
			}
		}
		System.out.println("Sum is " + sum);
	}
	
	
	
	
}
