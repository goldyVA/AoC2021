import java.io.*;
import java.util.*;

public class Day5Part1 
{
	//976,35 -> 24,987
	public static void main(String[] args) 
	{
		ArrayList<Line> list = new ArrayList<Line>();
		
		try {
			File myObj = new File("dataDay5.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
					String data = myReader.nextLine();
					int x1 = Integer.parseInt(data.substring(0,data.indexOf(",")));
					data = data.substring(data.indexOf(",")+1);
					int y1 = Integer.parseInt(data.substring(0,data.indexOf(" ")));
					data = data.substring(data.indexOf(">")+2);
					int x2 = Integer.parseInt(data.substring(0,data.indexOf(",")));
					data = data.substring(data.indexOf(",")+1);
					int y2 = Integer.parseInt(data);
					Line in = new Line(x1, y1, x2, y2);
					list.add(in);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		int[][] grid = new int [1000][1000];
		
		for(Line x : list)
		{
			if(x.isHorizontal()) 
			{
				int y = x.gety1();
				int x1 = x.getx1();
				int x2 = x.getx2();
				if(x1<x2)
				{
					for(int i = x1; i <=x2; i++)
					{
						grid[i][y]++;
					}
				}
				else
				{
					for(int i = x2; i <=x1; i++)
					{
						grid[i][y]++;
					}
				}
				
			}
			else if(x.isVertical()) 
			{
				int x1 = x.getx1();
				int y1 = x.gety1();
				int y2 = x.gety2();
				if(y1<y2)
				{
					for(int i = y1; i <=y2; i++)
					{
						grid[x1][i]++;
					}
				}
				else
				{
					for(int i = y2; i <=y1; i++)
					{
						grid[x1][i]++;
					}
				}
				
			}
		}
		
		int count = 0;
		for(int i = 0; i<1000; i++)
		{
			for(int j = 0; j < 1000; j++)
			{
				if(grid[i][j]>1)
					count++;
			}
		}
		System.out.println(count);
	}

}
