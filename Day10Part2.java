import java.io.*;
import java.util.*;

public class Day10Part2 
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
		ArrayList<String> incompletes = new ArrayList<String>();
		for(String a: list)
		{
			ArrayList<Character> ends = new ArrayList<Character>();
			for(int i = 0; i < a.length(); i++)
			{
				if(a.charAt(i) == ')' || a.charAt(i) == ']' || a.charAt(i) == '}' || a.charAt(i) == '>')
					ends.add(a.charAt(i));
			}
			//System.out.println(ends);
			
			ArrayList<String> temp = new ArrayList<String>();
			String[] temp2 = a.split("");
			for(String x : temp2)
				temp.add(x);
			//System.out.println(temp);
		
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
			if(!done)
			{
				String add = "";
				for(String b : temp)
					add+=b;
				incompletes.add(add);
			}
		}
		
		ArrayList<Long> scores = new ArrayList<Long>();
		for(String a : incompletes)
		{
			long score = 0;
			int addition = 0;
			for(int i = a.length()-1; i>=0; i--)
			{
				if(a.substring(i, i+1).equals("("))
					addition = 1;
				else if(a.substring(i, i+1).equals("["))
					addition = 2;
				else if(a.substring(i, i+1).equals("{"))
					addition = 3;
				else
					addition = 4;
				
				score = score * 5 + addition;
					
			}
			scores.add(score);
		}
		Collections.sort(scores);
		System.out.println(scores.get(scores.size()/2));
		
		
	}

}
