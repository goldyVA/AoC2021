import java.io.*;
import java.util.*;

public class Day1 
{

	public static void main(String[] args) 
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		try {
			File myObj = new File("dataDay1.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				int data = myReader.nextInt();
				list.add(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		int count = 0;
		for(int i = 1; i < list.size(); i++)
		{
			if(list.get(i) > list.get(i-1))
				count++;
		}
		System.out.println(count);
		
		count = 0;
		for(int i = 3; i < list.size(); i++)
		{
			if(list.get(i) > list.get(i-3))
				count++;
		}
		System.out.println(count);
		
	}

}
