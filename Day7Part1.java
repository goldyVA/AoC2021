import java.io.*;
import java.util.*;

public class Day7Part1 
{
	//976,35 -> 24,987
	public static void main(String[] args) 
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		String input = "";
		
		try {
			File myObj = new File("dataDay7.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
					input = myReader.nextLine();
					
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		while(input.length() > 0)
		{
			
			if(input.indexOf(",")>0)
			{
				list.add(Integer.parseInt(input.substring(0,input.indexOf(","))));
				input = input.substring(input.indexOf(",")+1);
			}
			else
			{
				list.add(Integer.parseInt(input.substring(0)));
				input = "";
			}
		}
		
		Collections.sort(list);
		//Part 1
		int median = list.get(499);
		int fuel = 0;
		for(int x: list)
		{
			int diff = Math.abs(x-median);
			fuel += diff;
		}
		System.out.println(fuel);
		
		//Part 2
		int sum = 0;
		for(int x : list)
		{
			sum +=x;
		}
		int average = sum/list.size();
		
		fuel = 0;
		for(int x: list)
		{
			int diff = Math.abs(x-average);
			diff = diff*(diff+1)/2;
			fuel += diff;
			
		}
		System.out.println(fuel);
				
	}

}
