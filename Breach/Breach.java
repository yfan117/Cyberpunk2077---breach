package Breach;

import java.util.Stack;
import Breach.Node;

public class Breach {
	
	String[][] matrix;
	String[] password;
	int n;
	boolean isHor = false;
	
	int index = 0;

	Stack<Node> path;
	public Breach(String[][] matrix, String[] password)
	{
		this.path = new Stack();
		this.matrix = matrix;
		this.password = password;
		n = matrix.length;
	}
	
	public Node[] solve()
	{
		findPath();
		Node[] nodes = new Node[path.size()];
		
		for(int i = path.size()-1; i >= 0; i--)
		{
			nodes[i] = path.pop();
		}
		
		return nodes;
	}
 	
	public boolean findPath()
	{
		for(int x = 0; x < n; x++)
		{
			for(int y = 0; y < n; y++)
			{
				if(matrix[x][y] == password[0])
				{
					path.push(new Node(y, x, password[0]));
					isHor = false;
					index = 1;
					if(recursion(x, y) == true)
					{
						return true;
					}
					path.pop();
				}
			}
		}
		return false;
	}
	

	public boolean recursion(int x, int y)
	{
		if(isHor == false)
		{
			for(int i = 0; i < n; i++)
			{
				if(matrix[i][y] == password[index])
				{
					isHor = !isHor;
					path.push(new Node(y, i, password[index]));
					index++;
					if(index == password.length)
					{
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
						path.pop();
					}
				}
			}
			
		}
		else
		{
			for(int i = 0; i < n; i++)
			{
				if(matrix[x][i] == password[index])
				{
					isHor = !isHor;
					path.push(new Node(i, x, password[index]));
					index++;
					if(index == password.length)
					{
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
						path.pop();
					}
				}
			}
		}
		return false;
	}

}
