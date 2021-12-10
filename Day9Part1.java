import java.io.*;
import java.util.*;

public class Day9Part1 
{
	
	public static void main(String[] args) 
	{
		ArrayList<String> list = new ArrayList<String>();
		
		
		try {
			File myObj = new File("dataDay9.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
					String input = myReader.nextLine();
					list.add(input);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		int[][] grid = new int[102][102];
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid.length; j++)
			{
				grid[i][j] = 9;
			}
		}
		
		for(int i = 1; i < 101; i++)
		{
			String line = list.get(i-1);
			String[] split = line.split("");
			for(int j = 1; j < 101; j++)
			{
				grid[i][j] = Integer.parseInt(split[j-1]);
			}
		}
		
		int risk = 0;
		for(int i = 1; i < 101; i++)
		{
			for(int j = 1; j < 101; j++)
			{
				int val = grid[i][j];
				if(val < grid[i][j-1] && val < grid[i][j+1] && val < grid[i-1][j] && val < grid[i+1][j])
				{
					risk += val +1;
				}
			}
		}
		
		System.out.println(risk);	
		for(int i = 1; i < 101; i++)
		{
			for(int j = 1; j < 101; j++)
			{
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
