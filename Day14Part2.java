import java.io.*;
import java.util.*;

public class Day14Part2 
{

	public static void main(String[] args) 
	{
		HashMap<String, String> list = new HashMap<String, String>();
		HashMap<String, Long> combos = new HashMap<String, Long>();
		HashMap<String, Long> letters = new HashMap<String, Long>();
		ArrayList<String> letter = new ArrayList<String>();
		String start = "";
		
		try {
			File myObj = new File("dataDay14.txt");
			Scanner myReader = new Scanner(myObj);
			start = myReader.nextLine();
			myReader.nextLine();
			while (myReader.hasNextLine()) 
			{
				String input = myReader.nextLine();
				if(!letter.contains(input.substring(6, 7)))
					letter.add(input.substring(6,7));
				list.put(input.substring(0,2), input.substring(6,7));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		for (String i : list.keySet()) 
		{
			  combos.put(i, (long)0);
		}
		
		for(int i = 0; i < start.length()-1; i++)
		{
			String key = start.substring(i,i+2);
			combos.replace(key, combos.get(key)+1);
		}
		
		
		for(String x: letter)
			letters.put(x, (long)0);
		
		for(int i = 0; i < start.length(); i++)
		{
			String key = start.substring(i,i+1);
			letters.replace(key, letters.get(key)+1);
		}		
		
		for(int a = 0; a < 40; a++)
		{
			HashMap<String, Long> update = new HashMap<String, Long>();
			for (String i : list.keySet()) 
			{
				  update.put(i, (long)0);
			}
			
			for (String i : combos.keySet()) 
			{
				long initialValue= combos.get(i);
				String first = i.substring(0,1);
				String second = i.substring(1,2);
				String middle = list.get(i);
				update.replace(first+middle, update.get(first+middle) + initialValue);
				update.replace(middle+second, update.get(middle+second)+initialValue);
				letters.replace(middle, letters.get(middle)+initialValue);
			}
			
			for (String i : update.keySet()) 
			{
				combos.replace(i, update.get(i));
			}	
		}
		
		Long max = Long.MIN_VALUE;
		Long min = Long.MAX_VALUE;
		
		for (Long i : letters.values()) 
		{
			  if(i>max)
				  max = i;
			  if(i<min)
				  min = i;
		}
		
		System.out.println("min " + min);
		System.out.println("max " + max);
		System.out.println("difference " + (max - min));
	}
}
