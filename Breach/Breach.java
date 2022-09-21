package Breach;

import java.util.Stack;

public class Breach {
	
	String[][] matrix;
	String[] password;
	int n;
	boolean isHor = false;
	
	int index = 0;
	
//	Stack<String> stack = new Stack();
	Stack<Node> path = new Stack();
	public Breach(String[][] matrix, String[] password)
	{
		this.matrix = matrix;
		this.password = password;
		n = matrix.length;
		
		findPath();
	}
	
	public boolean findPath()
	{
		for(int x = 0; x < n; x++)
		{
			for(int y = 0; y < n; y++)
			{
				if(matrix[x][y] == password[0])
				{
//					stack.push(password[0]);
					path.push(new Node(y, x, password[0]));
					isHor = false;
					index = 1;
					if(recursion(x, y) == true)
					{
						System.out.println();
						System.out.println("found");
						System.out.println(path.toString());
						return true;
					}
//					stack.pop();
					path.pop();
				}
			}
		}
		return false;
	}
	
//	boolean hasFound = false;
	public boolean recursion(int x, int y)
	{
//		if(hasFound == true)
//		{
//			return true;
//		}
		boolean backup = isHor;
		if(isHor == false)
		{
			for(int i = 0; i < n; i++)
			{
				if(matrix[i][y] == password[index])
				{
					isHor = !isHor;
//					stack.push(password[index]);
					path.push(new Node(y, i, password[index]));
					index++;
					if(index == password.length)
					{
//						hasFound = true;
//						System.out.println(path.toString());
						return true;
					}
					else
					{
						if(recursion(i, y) == true)
						{
							
							return true;
						}
						isHor = !isHor;
						index--;
//						stack.pop();
						path.pop();
					}
				}
			}
//			isHor = !isHor;
//			index--;
			
		}
		else
		{
			for(int i = 0; i < n; i++)
			{
				if(matrix[x][i] == password[index])
				{
					isHor = !isHor;
//					stack.push(password[index]);
					path.push(new Node(i, x, password[index]));
					index++;
					if(index == password.length)
					{
//						hasFound = true;
//						System.out.println(path.toString());
						return true;
					}
					else
					{
						if(recursion(x, i) == true)
						{
							return true;
						}
						isHor = !isHor;
						index--;
//						stack.pop();
						path.pop();
					}
				}
			}
//			isHor = !isHor;
//			index--;
			
		}
		isHor = backup;
		return false;
	}

}
class Node
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
