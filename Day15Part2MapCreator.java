import java.io.*;
import java.util.*;

public class Day15Part2MapCreator
{

	public static void main(String[] args) 
	{
		long startTime = System.nanoTime();
		
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			File myObj = new File("dataDay15.txt");
			Scanner myReader = new Scanner(myObj);
			
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
		
		int[][] grid = new int[list.size()][list.get(0).length()];
		
		
		for(int i = 0; i < list.size(); i++)
		{
			for(int j = 0; j < list.get(0).length(); j++)
			{
				grid[i][j] = Integer.parseInt(list.get(i).substring(j,j+1));
			}
		}
		
		int[][] biggergrid = new int[list.size()*5][list.size()*5];
		for(int i = 0; i < list.size(); i++)
		{
			for(int j = 0; j < list.get(0).length(); j++)
			{
				biggergrid[i][j] = Integer.parseInt(list.get(i).substring(j,j+1));
			}
		}
		
	
		for(int a = 1; a < 5; a++)
		{
			for(int i = 0; i < 100; i++)
			{
				for(int j =0; j< 100; j++)
				{
					biggergrid[i][a*100+j] = grid[i][j]+a;
					if(biggergrid[i][a*100+j]>9)
						biggergrid[i][a*100+j]= biggergrid[i][a*100+j]-9;
				}
			}
		}
		
		
		for(int i = 100; i < 500; i++)
		{
			for(int j =0; j< 500; j++)
			{
				biggergrid[i][j] = biggergrid[i-100][j]+1;
				if(biggergrid[i][j]>9)
					biggergrid[i][j]= biggergrid[i][j]-9;
			}
		}
		
		
		
		for(int i = 0; i < 500; i++)
		{
			for(int j =0; j< 500; j++)
			{
				System.out.print(biggergrid[i][j]);
			}
			System.out.println();
		}
		
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime/1000000000. + " seconds");
	}
}
