import java.io.*;
import java.util.*;

public class Day13Part2 {

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

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).indexOf(",") > 0)
				coordinates.add(list.get(i));
			else if (list.get(i).length() > 0)
				instructions.add(list.get(i));
		}

		String[][] grid = new String[895][1310];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = ".";
			}
		}

		for (String x : coordinates) {
			int first = Integer.parseInt(x.substring(0, x.indexOf(",")));
			int second = Integer.parseInt(x.substring(x.indexOf(",") + 1));
			grid[second][first] = "#";
		}

		// i is y, j is x
		// x = 655
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (j > 655 && grid[i][j].equals("#")) {
					grid[i][655 - (j - 655)] = "#";
					grid[i][j] = ".";
				}
			}
		}

		// y = 447
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < 655; j++) {
				if (i > 447 && grid[i][j].equals("#")) {
					grid[447 - (i - 447)][j] = "#";
					grid[i][j] = ".";
				}
			}
		}

		// x = 327
		for (int i = 0; i < 447; i++) {
			for (int j = 0; j < 655; j++) {
				if (j > 327 && grid[i][j].equals("#")) {
					grid[i][327 - (j - 327)] = "#";
					grid[i][j] = ".";
				}
			}
		}

		// y = 223
		for (int i = 0; i < 447; i++) {
			for (int j = 0; j < 327; j++) {
				if (i > 223 && grid[i][j].equals("#")) {
					grid[223 - (i - 223)][j] = "#";
					grid[i][j] = ".";
				}
			}
		}

		// x = 163
		for (int i = 0; i < 223; i++) {
			for (int j = 0; j < 327; j++) {
				if (j > 163 && grid[i][j].equals("#")) {
					grid[i][163 - (j - 163)] = "#";
					grid[i][j] = ".";
				}
			}
		}

		// y = 111
		for (int i = 0; i < 223; i++) {
			for (int j = 0; j < 163; j++) {
				if (i > 111 && grid[i][j].equals("#")) {
					grid[111 - (i - 111)][j] = "#";
					grid[i][j] = ".";
				}
			}
		}

		// x = 81
		for (int i = 0; i < 111; i++) {
			for (int j = 0; j < 163; j++) {
				if (j > 81 && grid[i][j].equals("#")) {
					grid[i][81 - (j - 81)] = "#";
					grid[i][j] = ".";
				}
			}
		}

		// y = 55
		for (int i = 0; i < 111; i++) {
			for (int j = 0; j < 81; j++) {
				if (i > 55 && grid[i][j].equals("#")) {
					grid[55 - (i - 55)][j] = "#";
					grid[i][j] = ".";
				}
			}
		}

		// x = 40
		for (int i = 0; i < 55; i++) {
			for (int j = 0; j < 81; j++) {
				if (j > 40 && grid[i][j].equals("#")) {
					grid[i][40 - (j - 40)] = "#";
					grid[i][j] = ".";
				}
			}
		}

		// y = 27
		for (int i = 0; i < 55; i++) {
			for (int j = 0; j < 40; j++) {
				if (i > 27 && grid[i][j].equals("#")) {
					grid[27 - (i - 27)][j] = "#";
					grid[i][j] = ".";
				}
			}
		}

		// y = 13
		for (int i = 0; i < 27; i++) {
			for (int j = 0; j < 40; j++) {
				if (i > 13 && grid[i][j].equals("#")) {
					grid[13 - (i - 13)][j] = "#";
					grid[i][j] = ".";
				}
			}
		}

		// y = 6
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 40; j++) {
				if (i > 6 && grid[i][j].equals("#")) {
					grid[6 - (i - 6)][j] = "#";
					grid[i][j] = ".";
				}
			}
		}
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 40; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		
		

	}

}
