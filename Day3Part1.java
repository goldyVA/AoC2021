import java.io.*;
import java.util.*;

public class Day3Part1 
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
		
		String gamma = "";
		
		for(int i =0; i <list.get(0).length(); i++)
		{
			int sum = 0;
			for(String x: list)
			{
				sum += Integer.parseInt(x.substring(i,i+1));
			}
			double average = (double) sum/list.size();
			if(average < .5)
				gamma+="0";
			else
				gamma+="1";
		}
		
		System.out.println(gamma);
		
		String epsilon = "";
		
		for(int i =0; i <list.get(0).length(); i++)
		{
			int sum = 0;
			for(String x: list)
			{
				sum += Integer.parseInt(x.substring(i,i+1));
			}
			double average = (double) sum/list.size();
			if(average > .5)
				epsilon+="0";
			else
				epsilon+="1";
		}
		
		System.out.println(epsilon);
		
		int first = Integer.parseInt(gamma,2);
		int second = Integer.parseInt(epsilon,2);
		
		System.out.println(first + " " + second + " " + (first*second));
		
		
		
		
	}

}
