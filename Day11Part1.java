import java.io.*;
import java.util.*;

public class Day11Part1 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();

		try {
			File myObj = new File("dataDay11.txt");
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
		// set up grid
		Octupus[][] grid = new Octupus[12][12];
		for (int i = 0; i < 12; i++) {

			for (int j = 0; j < 12; j++) {
				if (i == 0 || j == 0 || i == 11 || j == 11) {
					grid[i][j] = new Octupus(-10000000);
				} else {
					String temp = list.get(i - 1);
					grid[i][j] = new Octupus(Integer.parseInt(temp.substring(j - 1, j)));
				}
			}
		}

		
		int flashes = 0;
		for (int z = 0; z < 100; z++) {
			// increase energy by 1
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 11; j++) {
					grid[i][j].increaseEnergy();
				}
			}

			//
			for (int a = 0; a < 10; a++) {
				for (int i = 1; i < 11; i++) {
					for (int j = 1; j < 11; j++) {
						if (grid[i][j].getEnergyLevel() > 9 && !grid[i][j].hasFlashed()) {
							flashes++;

							grid[i - 1][j - 1].increaseEnergy();
							grid[i - 1][j].increaseEnergy();
							grid[i - 1][j + 1].increaseEnergy();
							grid[i][j + 1].increaseEnergy();
							grid[i + 1][j + 1].increaseEnergy();
							grid[i + 1][j].increaseEnergy();
							grid[i + 1][j - 1].increaseEnergy();
							grid[i][j - 1].increaseEnergy();

							grid[i][j].setFlash(true);
						}
					}
				}
			}

			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 11; j++) {
					if (grid[i][j].hasFlashed())
						grid[i][j].reset();
				}
			}

		}

		System.out.println(flashes);

	}

}
