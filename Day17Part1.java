import java.io.*;
import java.util.*;

public class Day17Part1
{
	static int index = 0;
	

	public static void main(String[] args) 
	{
		long startTime = System.nanoTime();
		
		int targetXmin = 0;
		int targetXmax = 0;
		int targetYmin = 0;
		int targetYmax = 0;
		//target area: x=20..30, y=-10..-5
		
		try {
			File myObj = new File("dataDay17.txt");
			Scanner myReader = new Scanner(myObj);
			
			while (myReader.hasNextLine()) 
			{
				String input = myReader.nextLine();
				input = input.substring(input.indexOf("=")+1);
				targetXmin = Integer.parseInt(input.substring(0,input.indexOf(".")));
				input = input.substring(input.indexOf(".")+2);
				targetXmax = Integer.parseInt(input.substring(0,input.indexOf(",")));
				input = input.substring(input.indexOf("=")+1);
				targetYmax = Integer.parseInt(input.substring(0,input.indexOf(".")));
				input = input.substring(input.indexOf(".")+2);
				targetYmin = Integer.parseInt(input);
				
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
			
		int xPos = 0;
		int yPos = 0;
		int xVelo = 0;
		int yVelo = 0;
		int maxY=0;
		int highestY = 0;
		
		for(int i = 0; i < 500; i++)
		{
			for(int j = 0; j < 500; j++)
			{
				xPos = 0;
				yPos = 0;
				xVelo = i;
				yVelo = j;
				maxY=0;
				
				
				boolean hitTarget = false;
				while(!hitTarget && yPos>targetYmin)
				{
					xPos += xVelo;
					yPos += yVelo;
					
					if(xVelo > 0)
						xVelo--;
					else if(xVelo < 0)
						xVelo++;
					
					yVelo--;
					
					if(xPos >= targetXmin && xPos <= targetXmax && yPos <= targetYmin && yPos >= targetYmax)
					{
						hitTarget = true;
					}
					if(yPos > maxY)
						maxY = yPos;
					
				}
				
				if(hitTarget)
				{
					if(maxY > highestY)	
						highestY = maxY;
					
				}
			}
		}
		System.out.println(highestY);
			
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime/1000000000. + " seconds");
	}	
}
