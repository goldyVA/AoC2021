import java.io.*;
import java.util.*;

public class Day6Part1 
{
	//976,35 -> 24,987
	public static void main(String[] args) 
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		String input = "";
		
		try {
			File myObj = new File("dataDay6.txt");
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
			list.add(Integer.parseInt(input.substring(0,1)));
			if(input.length()>1)
				input = input.substring(2);
			else
				input = input.substring(1);
		}
		
		int add = 0;
		for(int i = 0; i<80; i++)
		{
			add = 0;
			for(int j = 0; j < list.size(); j++)
			{
				if(list.get(j) == 0)
				{
					add++;
					list.set(j, 6);
				}
				else if(list.get(j)<=8)
				{
					list.set(j, list.get(j)-1);
				}
			}
			for(int j = 0; j < add; j++)
			{
				list.add(8);
			}
		}
		
		System.out.println(list.size());		
	}

}
