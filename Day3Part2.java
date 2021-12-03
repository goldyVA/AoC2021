import java.io.*;
import java.util.*;

public class Day3Part2 
{

	public static void main(String[] args) 
	{
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			File myObj = new File("dataDay3.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				list.add(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		/*To find oxygen generator rating, determine the most common value (0 or 1) in the current bit 
		 * position, and keep only numbers with that bit in that position. If 0 and 1 are equally 
		 * common, keep values with a 1 in the position being considered.
		 * 
		 * To find CO2 scrubber rating, determine the least common value (0 or 1) in the current bit 
		 * position, and keep only numbers with that bit in that position. If 0 and 1 are equally 
		 * common, keep values with a 0 in the position being considered.*/
		
		ArrayList<String> oxygen = new ArrayList<String>();
		ArrayList<String> co2 = new ArrayList<String>();
		int oxygenRating = 0;
		int co2Rating = 0;
		
		for(String x:list)
		{
			oxygen.add(x);
			co2.add(x);
		}
		
		for(int i =0; i <list.get(0).length(); i++)
		{
			int one = 0;
			int zero = 0;
			for(String x: oxygen)
			{
				if(Integer.parseInt(x.substring(i,i+1))==0)
					zero++;
				else
					one++;
			}
			String search = "";
			if(one>zero)
				search="1";
			else if(zero>one)
				search = "0";
			else
				search = "1";
			
			if(search.equals("0")||search.equals("1"))
			{
				for(int j = 0; j<oxygen.size(); j++)
				{
					if(!oxygen.get(j).substring(i,i+1).equals(search))
					{
						oxygen.remove(j);
						j--;
					}
				}
			}
			
			if(oxygen.size()==1)
			{
				oxygenRating = Integer.parseInt(oxygen.get(0),2);
				i=100;
			}
			
		}
		System.out.println(oxygenRating);
		
		for(int i =0; i <list.get(0).length(); i++)
		{
			int one = 0;
			int zero = 0;
			for(String x: co2)
			{
				if(Integer.parseInt(x.substring(i,i+1))==0)
					zero++;
				else
					one++;
			}
			String search = "";
			if(one>zero)
				search="0";
			else if(zero>one)
				search = "1";
			else
				search = "0";
			
			if(search.equals("0")||search.equals("1"))
			{
				for(int j = 0; j<co2.size(); j++)
				{
					if(!co2.get(j).substring(i,i+1).equals(search))
					{
						co2.remove(j);
						j--;
					}
				}
			}
			
			if(co2.size()==1)
			{
				co2Rating = Integer.parseInt(co2.get(0),2);
				i=100;
			}
			
		}
		System.out.println(co2Rating);
		
		System.out.println(oxygenRating*co2Rating);
		
		
		
	}

}
