import java.io.*;
import java.util.*;

public class Day2Part1 
{

	public static void main(String[] args) 
	{
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			File myObj = new File("dataDay2.txt");
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
		
		int pos = 0;
		int depth =0;
		
		for(String x: list)
		{
			if(x.charAt(0)== 'f')
			{
				int move = Integer.parseInt(x.substring(x.indexOf(" ")+1));
				pos += move;
			}
			else if(x.charAt(0)== 'd')
			{
				int move = Integer.parseInt(x.substring(x.indexOf(" ")+1));
				depth += move;
			}
			else
			{
				int move = Integer.parseInt(x.substring(x.indexOf(" ")+1));
				depth -= move;
			}
		}
		System.out.println(pos);
		System.out.println(depth);
		System.out.println(pos*depth);
		
		
		
	}

}
