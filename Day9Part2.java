import java.io.*;
import java.util.*;

public class Day9Part2 
{
	static int[][] grid;
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
		
		grid = new int[102][102];
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
		
		ArrayList<String> lowPoints = new ArrayList<String>();
		for(int i = 1; i < 101; i++)
		{
			for(int j = 1; j < 101; j++)
			{
				int val = grid[i][j];
				if(val < grid[i][j-1] && val < grid[i][j+1] && val < grid[i-1][j] && val < grid[i+1][j])
				{
					lowPoints.add(i +"," +j);
				}
			}
		}
		
		for(int i = 1; i < 101; i++)
		{
			for(int j = 1; j < 101; j++)
			{
				int val = grid[i][j];
				if(val < grid[i][j-1] && val < grid[i][j+1] && val < grid[i-1][j] && val < grid[i+1][j])
				{
					lowPoints.add(i +"," +j);
				}
			}
		}
		
		ArrayList<Integer> basins = new ArrayList<Integer>();
		
		for(int i = 1; i < 101; i++)
		{
			for(int j = 1; j < 101; j++)
			{
				if(lowPoints.contains(i+","+j))
				{
					int size = basinSize(i, j);
					basins.add(size);
				}
			}
		}
		
		Collections.sort(basins);
		System.out.println(basins);
		System.out.println(basins.get(basins.size()-1));
		System.out.println(basins.get(basins.size()-2));
		System.out.println(basins.get(basins.size()-3));
		System.out.println(basins.get(basins.size()-1)*basins.get(basins.size()-2)*basins.get(basins.size()-3));
			
	}
	
	private static int basinSize(int i, int j) 
	{
		if (grid[i][j] == 9)
			return 0;

		
		grid[i][j] = 9;

		
		return 1 + basinSize(i - 1, j) + basinSize(i + 1, j) + basinSize(i, j - 1) + basinSize(i, j + 1);
	}

}
