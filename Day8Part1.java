import java.io.*;
import java.util.*;

public class Day8Part1 
{
	
	public static void main(String[] args) 
	{
		ArrayList<String[]> list = new ArrayList<String[]>();
		
		
		try {
			File myObj = new File("dataDay8.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
					String input = myReader.nextLine();
					String[] array = input.split(" ");
					list.add(array);
					
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		int sum = 0;
		for(String[] x : list)
		{
			int a = x[11].length();
			int b = x[12].length();
			int c = x[13].length();
			int d = x[14].length();
			
			if(a<5 || a == 7)
			{
				sum++;
			}
			if(b<5 || b == 7)
			{
				sum++;
			}
			if(c<5 || c == 7)
			{
				sum++;
			}
			if(d<5 || d == 7)
			{
				sum++;
			}
				
		}
		System.out.println(sum);
		
		
		
	}

}
