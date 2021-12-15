import java.io.*;
import java.util.*;

public class Day15Part1
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
		
		
		HashMap<String, Integer> cost = new HashMap<String, Integer>();
		for(int i =0; i< grid.length; i++)
		{
			for(int j = 0; j < grid.length; j++)
			{
				cost.put(i+","+j, Integer.MAX_VALUE);
			}
		}
		cost.replace("0,0", 0);
		ArrayList<String> toCheck = new ArrayList<String>();
		toCheck.add(0+","+0);
		
		while(toCheck.size() > 0 )
		{
			ArrayList<String> newCheck = new ArrayList<String>();
			for(int i = 0; i < toCheck.size(); i++)
			{
				int r = Integer.parseInt(toCheck.get(i).substring(0,toCheck.get(i).indexOf(",")));
				int c = Integer.parseInt(toCheck.get(i).substring(toCheck.get(i).indexOf(",")+1));
				String current = r+","+c;
				String left = r+","+(c-1);
				String right = r+","+(c+1);
				String up = r-1+","+c;
				String down = r+1+","+c;
				
				if(cost.containsKey(right))
				{
					if(cost.get(current)+grid[r][c+1]<cost.get(right))
					{
						cost.replace(right, cost.get(current)+grid[r][c+1]);
						if(!newCheck.contains(right))
							newCheck.add(right);
					}
				}
				if(cost.containsKey(down))
				{
					if(cost.get(current)+grid[r+1][c]<cost.get(down))
					{
						cost.replace(down, cost.get(current)+grid[r+1][c]);
						if(!newCheck.contains(down))
							newCheck.add(down);
					}
				}
				if(cost.containsKey(left))
				{
					if(cost.get(current)+grid[r][c-1]<cost.get(left))
					{
						cost.replace(left, cost.get(current)+grid[r][c-1]);
						if(!newCheck.contains(left))
							newCheck.add(left);
					}
				}
				if(cost.containsKey(up))
				{
					if(cost.get(current)+grid[r-1][c]<cost.get(up))
					{
						cost.replace(up, cost.get(current)+grid[r-1][c]);
						if(!newCheck.contains(up))
							newCheck.add(up);
					}
				}
				
			}
			toCheck.clear();
			for(String x: newCheck)
				toCheck.add(x);
		}
		
		System.out.println(cost.get(499+","+499));
		
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime/1000000000. + " seconds");
	}
}
