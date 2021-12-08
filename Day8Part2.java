import java.io.*;
import java.util.*;

public class Day8Part2 
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
		
		long sum = 0;
		for(int a = 0; a < list.size(); a++)
		{
		ArrayList<String> numbers = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		for(int i = 0; i<10; i++)
		{
			numbers.add(list.get(a)[i]);
		}
		for(int i = 11; i <15; i++)
		{
			values.add(list.get(a)[i]);
		}
		
		for(int i = 0; i < numbers.size(); i++)
		{
			numbers.set(i, sortString(numbers.get(i)));
		}
		for(int i = 0; i < values.size(); i++)
		{
			values.set(i, sortString(values.get(i)));
		}
		
		numbers.sort(Comparator.comparingInt(String::length)); 
		
		//finds one four seven and eight
		String one = numbers.get(0);
		String seven = numbers.get(1);
		String four = numbers.get(2);
		String eight = numbers.get(9);
		
		//top
		String top = "";
		if(one.indexOf(seven.substring(0,1)) == -1)
			top = seven.substring(0,1);
		else if(one.indexOf(seven.substring(1,2)) == -1)
			top = seven.substring(1,2);
		else
			top = seven.substring(2,3);
		
		//finds three
		String three = "";
		if(numbers.get(3).indexOf(one.substring(0,1))>=0 && numbers.get(3).indexOf(one.substring(1,2))>=0)
			three = numbers.get(3);
		else if(numbers.get(4).indexOf(one.substring(0,1))>=0 && numbers.get(4).indexOf(one.substring(1,2))>=0)
			three = numbers.get(4);
		else
			three = numbers.get(5);
		
		//right1 and right2
		String right1 = one.substring(0,1);
		String right2 = one.substring(1,2);
		
		
		//finds nine
		String nine = "";
		if(numbers.get(6).indexOf(three.substring(0,1))>=0 && numbers.get(6).indexOf(three.substring(1,2))>=0 && numbers.get(6).indexOf(three.substring(2,3))>=0 && numbers.get(6).indexOf(three.substring(3,4))>=0 &&numbers.get(6).indexOf(three.substring(4,5))>=0)
			nine = numbers.get(6);
		else if(numbers.get(7).indexOf(three.substring(0,1))>=0 && numbers.get(7).indexOf(three.substring(1,2))>=0 && numbers.get(7).indexOf(three.substring(2,3))>=0 && numbers.get(7).indexOf(three.substring(3,4))>=0 &&numbers.get(7).indexOf(three.substring(4,5))>=0)
			nine = numbers.get(7);
		else
			nine = numbers.get(8);
		
		//finds zero and six
		String zero = "";
		String six = "";
		
		if(numbers.get(6).equals(nine))
		{
			if(numbers.get(7).indexOf(right1) >=0  && numbers.get(7).indexOf(right2)>=0)
			{
				zero = numbers.get(7);
				six = numbers.get(8);
			}
			else
			{
				six = numbers.get(7);
				zero = numbers.get(8);
			}
			
		}
		else if(numbers.get(7).equals(nine))
		{
			if(numbers.get(6).indexOf(right1) >=0  && numbers.get(6).indexOf(right2)>=0)
			{
				zero = numbers.get(6);
				six = numbers.get(8);
			}
			else
			{
				six = numbers.get(6);
				zero = numbers.get(8);
			}
		}
		else
		{
			if(numbers.get(7).indexOf(right1) >=0  && numbers.get(7).indexOf(right2)>=0)
			{
				zero = numbers.get(7);
				six = numbers.get(6);
			}
			else
			{
				six = numbers.get(7);
				zero = numbers.get(6);
			}
		}
		
		//topleft and middle
		String topleftormiddle1 = "";
		String topleftormiddle2 = "";
		ArrayList<Integer> indeces = new ArrayList<Integer>();
		for(int i = 0; i < four.length(); i++)
		{
			if(!four.substring(i,i+1).equals(one.substring(0,1)) && !four.substring(i,i+1).equals(one.substring(1,2)))
			{
				indeces.add(i);
			}
		}
		topleftormiddle1 = four.substring(indeces.get(0),indeces.get(0)+1);
		topleftormiddle2 = four.substring(indeces.get(1),indeces.get(1)+1);
		
		
		//two and five
		String two = "";
		String five = "";
		if(numbers.get(3).equals(three))
		{
			if(numbers.get(4).indexOf(topleftormiddle1) >=0  && numbers.get(4).indexOf(topleftormiddle2)>=0)
			{
				five = numbers.get(4);
				two = numbers.get(5);
			}
			else
			{
				five = numbers.get(5);
				two = numbers.get(4);
			}
			
		}
		else if(numbers.get(4).equals(three))
		{
			if(numbers.get(3).indexOf(topleftormiddle1) >=0  && numbers.get(3).indexOf(topleftormiddle2)>=0)
			{
				five = numbers.get(3);
				two = numbers.get(5);
			}
			else
			{
				five = numbers.get(5);
				two = numbers.get(3);
			}
		}
		else
		{
			if(numbers.get(4).indexOf(topleftormiddle1) >=0  && numbers.get(4).indexOf(topleftormiddle2)>=0)
			{
				five = numbers.get(4);
				two = numbers.get(3);
			}
			else
			{
				five = numbers.get(3);
				two = numbers.get(4);
			}
		}
		
		
		System.out.println(one + " " + two + " " + three + " " + four + " " + five + " " + six + " " + seven + " " + eight + " " + nine + " " + zero);
		
		
		//values
		int thousands = 0;
		int hundreds = 0;
		int tens = 0;
		int ones = 0;
		
		String thousandString = values.get(0);
		String hundredString = values.get(1);
		String tenString = values.get(2);
		String oneString = values.get(3);
		
		if(thousandString.equals(one))
			thousands = 1;
		else if(thousandString.equals(two))
			thousands = 2;
		else if(thousandString.equals(three))
			thousands = 3;
		else if(thousandString.equals(four))
			thousands = 4;
		else if(thousandString.equals(five))
			thousands = 5;
		else if(thousandString.equals(six))
			thousands = 6;
		else if(thousandString.equals(seven))
			thousands = 7;
		else if(thousandString.equals(eight))
			thousands = 8;
		else if(thousandString.equals(nine))
			thousands = 9;
		else
			thousands = 0;
		
		if(hundredString.equals(one))
			hundreds = 1;
		else if(hundredString.equals(two))
			hundreds = 2;
		else if(hundredString.equals(three))
			hundreds = 3;
		else if(hundredString.equals(four))
			hundreds = 4;
		else if(hundredString.equals(five))
			hundreds = 5;
		else if(hundredString.equals(six))
			hundreds = 6;
		else if(hundredString.equals(seven))
			hundreds = 7;
		else if(hundredString.equals(eight))
			hundreds = 8;
		else if(hundredString.equals(nine))
			hundreds = 9;
		else
			hundreds = 0;
		
		if(tenString.equals(one))
			tens = 1;
		else if(tenString.equals(two))
			tens = 2;
		else if(tenString.equals(three))
			tens = 3;
		else if(tenString.equals(four))
			tens = 4;
		else if(tenString.equals(five))
			tens = 5;
		else if(tenString.equals(six))
			tens = 6;
		else if(tenString.equals(seven))
			tens = 7;
		else if(tenString.equals(eight))
			tens = 8;
		else if(tenString.equals(nine))
			tens = 9;
		else
			tens = 0;
		
		if(oneString.equals(one))
			ones = 1;
		else if(oneString.equals(two))
			ones = 2;
		else if(oneString.equals(three))
			ones = 3;
		else if(oneString.equals(four))
			ones = 4;
		else if(oneString.equals(five))
			ones = 5;
		else if(oneString.equals(six))
			ones = 6;
		else if(oneString.equals(seven))
			ones = 7;
		else if(oneString.equals(eight))
			ones = 8;
		else if(oneString.equals(nine))
			ones = 9;
		else
			ones = 0;
		
		String value = "" +thousands + hundreds + tens + ones;
		int val = Integer.parseInt(value);
		sum += val;
		System.out.println(val);
		}
		System.out.println(sum);
		
		
	}
	
	public static String sortString(String inputString)
    {
        // Converting input string to character array
        char tempArray[] = inputString.toCharArray();
 
        // Sorting temp array using
        Arrays.sort(tempArray);
 
        // Returning new sorted string
        return new String(tempArray);
    }

}
