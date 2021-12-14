import java.io.*;
import java.util.*;

public class Day14Part1 
{

	public static void main(String[] args) 
	{
		HashMap<String, String> list = new HashMap<String, String>();
		ArrayList<String> letters = new ArrayList<String>();
		String start = "";
		
		try {
			File myObj = new File("dataDay14.txt");
			Scanner myReader = new Scanner(myObj);
			start = myReader.nextLine();
			myReader.nextLine();
			while (myReader.hasNextLine()) 
			{
				String input = myReader.nextLine();
				if(!letters.contains(input.substring(6, 7)))
					letters.add(input.substring(6,7));
				list.put(input.substring(0,2), input.substring(6,7));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		for(int a = 0; a < 10; a++)
		{
			String current = "";
			for(int i = 0; i <start.length()-1; i++)
			{
				current = current + start.charAt(i)+list.get(start.substring(i,i+2));
				if(i == start.length()-2)
				{
					current = current + start.charAt(start.length()-1);
				}
			}
			start = current;
		}	
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(String x: letters)
		{
			int count = 0;
			for(int i = 0; i < start.length(); i++)
			{
				if(start.substring(i,i+1).equals(x))
					count++;
			}
			if(count < min)
				min = count;
			if(count > max)
				max = count;
			
		}
		
		System.out.println("min " + min);
		System.out.println("max " + max);
		System.out.println("difference " + (max - min));
	}
}
