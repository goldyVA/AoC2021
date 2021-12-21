import java.io.*;
import java.util.*;

public class Day20
{
	public static void main(String[] args) 
	{
		long startTime = System.nanoTime();
		ArrayList<String> list = new ArrayList<String>();
		String enhance = "";
		
		try {
			File myObj = new File("dataDay20.txt");
			Scanner myReader = new Scanner(myObj);
			enhance = myReader.nextLine();
			myReader.nextLine();
			
			while (myReader.hasNextLine()) 
			{
				String input = myReader.nextLine();
				list.add(input);
				
				
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		String[] enhancement = enhance.split("");
		
		
		char[][] grid = new char[500][500];
		for(int i = 0; i< grid.length; i++)
		{
			for(int j = 0; j < grid[0].length; j++)
			{
				grid[i][j]='.';
			}
		}
		int row = 200;
		for(String x: list)
		{
			for(int j = 0; j<x.length(); j++)
			{
				grid[row][j+200] = x.charAt(j);
			}
			row++;
		}
		
		
		//Actual problem
		
		for(int z = 0; z<50; z++)
		{
			char[][] temp = new char[grid.length][grid[0].length];
			for(int i = 0; i< temp.length; i++)
			{
				for(int j = 0; j < temp[0].length; j++)
				{
					temp[i][j]='.';
				}
			}
		
		
		
			for(int i = 1; i< grid.length-1; i++)
			{
				for(int j = 1; j < grid[0].length-1; j++)
				{
					String values = ""+grid[i-1][j-1] + grid[i-1][j] + grid[i-1][j+1] + grid[i][j-1] + grid[i][j] + grid[i][j+1] + grid[i+1][j-1] + grid[i+1][j] + grid[i+1][j+1];
					String binary = "";
					for(int a = 0; a < values.length(); a++)
					{
						if(values.charAt(a)=='.')
							binary += 0;
						else
							binary += 1;
					}
				
					int position = Integer.parseInt(binary,2);
					temp[i][j] = enhancement[position].charAt(0);
	
				}
			
			}
		
			for(int i = 0; i< grid.length; i++)
			{
				for(int j = 0; j < grid[0].length; j++)
				{
					grid[i][j] = temp[i][j];
				}
			}
			
			if(z==1)
			{
				int count = 0;
				for(int i = 80; i< grid.length-80; i++)
				{
					for(int j = 80; j < grid[0].length-80; j++)
					{
						if(grid[i][j]=='#')
							count++;
					}
				}
				System.out.println("Part 1: " + count);
			}
			if(z==49)
			{
				int count = 0;
				for(int i = 80; i< grid.length-80; i++)
				{
					for(int j = 80; j < grid[0].length-80; j++)
					{
						if(grid[i][j]=='#')
							count++;
					}
				}
				System.out.println("Part 2: " + count);
			}
		}

		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime/1000000000. + " seconds");
	}	
}
