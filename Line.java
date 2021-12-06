
public class Line 
{
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	public Line(int a, int b, int c, int d)
	{
		x1 = a;
		y1 = b;
		x2 = c;
		y2 = d;
	}
	
	public int getx1()
	{
		return x1;
	}
	
	public int gety1()
	{
		return y1;
	}
	
	public int getx2()
	{
		return x2;
	}
	
	public int gety2()
	{
		return y2;
	}
	
	public boolean isHorizontal()
	{
		return y1 == y2;
	}
	
	public boolean isVertical()
	{
		return x1 == x2;
	}
	
	public void printLine()
	{
		System.out.println(x1 + "," + y1 + "  " + x2 +","+y2);
	}
}
