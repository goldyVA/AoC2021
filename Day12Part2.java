import java.io.*;
import java.util.*;

public class Day12Part2 
{

	public static void main(String[] args) 
	{
		HashMap<String, ArrayList<String>> list = new HashMap<String, ArrayList<String>>();
		ArrayList<String> letters = new ArrayList<String>();
		ArrayList<String> lowers = new ArrayList<String>();
		ArrayList<String> connections = new ArrayList<String>();
		String start = "";
		int count = 0;
		
		try {
			File myObj = new File("dataDay12.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) 
			{
				String input = myReader.nextLine();
				connections.add(input);
				if(!letters.contains(input.substring(0, input.indexOf("-"))))
					letters.add(input.substring(0, input.indexOf("-")));
				if(!letters.contains(input.substring(input.indexOf("-")+1)))
					letters.add(input.substring(input.indexOf("-")+1));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		System.out.println(letters);
		for(String x: letters)
		{
			if(x.compareTo("Z")>0 && !x.equals("start") && !x.equals("end"))
				lowers.add(x);
				
		}
		
		System.out.println(connections);
		
		for(String x: letters)
		{
			ArrayList<String> temp = new ArrayList<String>();
			for(String y: connections)
			{
				String first = y.substring(0,y.indexOf("-"));
				String second = y.substring(y.indexOf("-")+1);
				if(first.equals(x))
				{
					if(!second.equals("start"))
						temp.add(second);
				}
				if(second.equals(x))
				{
					if(!first.equals("start"))
						temp.add(first);
				}
			}
			list.put(x, temp);
		}
		
		System.out.println(list);
		
		//all set up now
		
		ArrayList<ArrayList<String>> open = new ArrayList<ArrayList<String>>();
		ArrayList<String> s = new ArrayList<String>();
		s.add("start");
		open.add(s);
		
		
		ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
		
		while(open.size()>0)
		{
		for(int i = 0; i < open.size(); i++)
		{
			ArrayList<String> a = open.get(i); //gets the current open cave list
			
			String last = a.get(a.size()-1); //gets the last element in the open cave
			
			ArrayList<String> toAdd = list.get(last); //gets the arraylist of connections
			for(String x: toAdd)
			{
				ArrayList<String> b = new ArrayList<String>();
				for(String c: a)
					b.add(c);
				char n = x.charAt(0);
				if(Character.isUpperCase(n))
				{
					b.add(x);
					temp.add(b);
				}
				else
				{
					boolean multiple = false;
					for(String g: lowers)
					{
						int doubles = 0;
						for(String h: b)
						{
							if(g.equals(h))
								doubles++;
						}
						if(doubles>1)
							multiple=true;
					}
					
					if(!multiple)
					{
						b.add(x);
						if(x.equals("end"))
						{
							count++;
						}
						else
							temp.add(b);
					}
					if(multiple && !a.contains(x))
					{
						b.add(x);
						if(x.equals("end"))
						{
							count++;
						}
						else
							temp.add(b);
					}
						
				}
				
			}	
		}
		open.clear();
		for(ArrayList<String> x: temp)
			open.add(x);
		temp.clear();
		}
		System.out.println(count);
	}
	
}
