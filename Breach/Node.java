package Breach;

public class Node
{
	int x;
	int y;
	String symbol;
	
	public Node(int x, int y, String symbol)
	{
		this.x = x;
		this.y = y;
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + ", symbol=" + symbol + "]";
	}
}