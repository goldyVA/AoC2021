import java.io.*;
import java.util.*;

public class Day4Part2 
{

	public static void main(String[] args) 
	{
		ArrayList<Board> list = new ArrayList<Board>();
		
		int[] selected = {74,79,46,2,19,27,31,90,21,83,94,77,0,29,38,72,42,23,6,62,45,95,41,55,93,69,39,17,12,1,20,53,49,71,61,13,88,25,87,26,50,58,28,51,89,64,3,80,36,65,57,92,52,86,98,78,9,33,44,63,16,34,97,60,40,66,75,4,7,84,22,43,11,85,91,32,48,14,18,76,8,47,24,81,35,30,82,67,37,70,15,5,73,59,54,68,56,96,99,10};
		
		try {
			File myObj = new File("dataDay4.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				int[][] board = new int[5][5];
				for(int i = 0; i < 5; i++)
				{
					String data = myReader.nextLine();
					String[] array = data.split(" ");
					int count = 0;
					for(String a: array)
					{
						if(a.length()>0)
						{
							board[i][count] = Integer.parseInt(a);
							count++;
						}
					}	
				}
				
				Board input = new Board(board);
				list.add(input);
				if(myReader.hasNextLine())
					myReader.nextLine();	
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		boolean done =false;
		int index = 0; 
		while(list.size()>0)
		{
			for(int i = 0; i < list.size(); i++)
			{
				list.get(i).newNumber(selected[index]);
				if(list.get(i).isBingo())
				{
					System.out.println("Last number = " + selected[index]);
					list.get(i).printBoard();
					list.remove(i);
					i--;
				}
			}	
			index++;
		}
		
		
		
		
		
		
		
		
	}

}
