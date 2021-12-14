import java.io.*;
import java.util.*;

public class Day13Part1 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();

		try {
			File myObj = new File("dataDay13.txt");
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
		
		ArrayList<String> coordinates = new ArrayList<String>();
		ArrayList<String> instructions = new ArrayList<String>();
		
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).indexOf(",")>0)
				coordinates.add(list.get(i));
			else if(list.get(i).length()>0)
				instructions.add(list.get(i));
		}
		
		String[][] grid = new String[895][1310];
		for(int i = 0; i < grid.length; i++)
		{
			for(int j =0; j < grid[0].length; j++)
			{
				grid[i][j] = ".";
			}
		}
		
		for(String x: coordinates)
		{
			int first = Integer.parseInt(x.substring(0, x.indexOf(",")));
			int second = Integer.parseInt(x.substring(x.indexOf(",")+1));
			grid[second][first] = "#";
		}
		
		//i is y, j is x
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (j > 655 && grid[i][j].equals("#")) {
					grid[i][655 - (j - 655)] = "#";
					grid[i][j] = ".";
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j].equals("#")) {
					count++;
				}
			}
		}
		
		System.out.println(count);
		
		
		
		

	}

}
