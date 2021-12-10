import java.io.*;
import java.util.*;

public class Day10Part1 
{
	
	public static void main(String[] args) 
	{
		ArrayList<String> list = new ArrayList<String>();
		
		
		try {
			File myObj = new File("dataDay10.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
					String input = myReader.nextLine();
					list.add(input);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		ArrayList<String> illegals = new ArrayList<String>();
		for(String a: list)
		{
			ArrayList<Character> ends = new ArrayList<Character>();
			for(int i = 0; i < a.length(); i++)
			{
				if(a.charAt(i) == ')' || a.charAt(i) == ']' || a.charAt(i) == '}' || a.charAt(i) == '>')
					ends.add(a.charAt(i));
			}
			
			ArrayList<String> temp = new ArrayList<String>();
			String[] temp2 = a.split("");
			for(String x : temp2)
				temp.add(x);
		
			boolean done = false;
			while(ends.size()>0 && !done)
			{
				String find = ""+ends.get(0);
				int index = temp.indexOf(find); //always get(0) at the end
				if(ends.get(0) == ')')
				{
					if(temp.get(index-1).equals("("))
					{
						temp.remove(index);
						temp.remove(index-1);
						ends.remove(0);
					}
					else
					{
						illegals.add(temp.get(index));
						done = true;
					}
				}
				else if(ends.get(0) == ']')
				{
					if(temp.get(index-1).equals("["))
					{
						temp.remove(index);
						temp.remove(index-1);
						ends.remove(0);
					}
					else
					{
						illegals.add(temp.get(index));
						done = true;
					}
				}
				else if(ends.get(0) == '}')
				{
					if(temp.get(index-1).equals("{"))
					{
						temp.remove(index);
						temp.remove(index-1);
						ends.remove(0);
					}
					else
					{
						illegals.add(temp.get(index));
						done = true;
					}
				}
				else
				{
					if(temp.get(index-1).equals("<"))
					{
						temp.remove(index);
						temp.remove(index-1);
						ends.remove(0);
					}
					else
					{
						illegals.add(temp.get(index));
						done = true;
						
					}
				}
			
			}
		}
		
		int sum = 0;
		for(String x : illegals)
		{
			if(x.equals(")"))
				sum+=3;
			else if(x.equals("]"))
				sum+=57;
			else if(x.equals("}"))
				sum+=1197;
			else
				sum+=25137;
		}
		System.out.println(sum);
		
	}

}
