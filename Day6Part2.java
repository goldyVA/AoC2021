import java.io.*;
import java.util.*;

public class Day6Part2 
{
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
		
		long zero = 0;
		long one = 0;
		long two = 0;
		long three = 0;
		long four = 0;
		long five = 0;
		long six = 0;
		long seven = 0;
		long eight = 0;
		
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i) == 1)
				one++;
			else if(list.get(i) == 2)
				two++;
			else if(list.get(i) == 3)
				three++;
			else if(list.get(i) == 4)
				four++;
			else
				five++;
		}
		
		for(int i = 0; i<256; i++)
		{
			long add = 0;
			add = zero;
			zero = one;
			one = two;
			two = three;
			three = four;
			four = five;
			five = six;
			six = seven;
			seven = eight;
			eight = add;
			six += add;	
		}
			
		long total = zero + one + two + three + four + five + six + seven + eight;
		System.out.println(total);	
	}

}
