package Breach;

import java.util.Arrays;
import java.util.Random;
import Breach.Generate;
import Breach.Node;

public class Driver {


	public static void main(String[] args)
	{
		Random rand = new Random();
		int n = 100;
		boolean hasFail = false;

		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 100; i++)
		{
			Generate gen = new Generate(rand.nextInt(n - 10)+10);
			String[][] matrix = gen.getMatrix();
			String[] password = gen.getPassword();
			
//			System.out.println("password: " +Arrays.toString(password));
//			printMatrix(matrix);
			
			Breach breach = new Breach(matrix, password);
			Node[] nodes = breach.solve();
			
//			System.out.println(Arrays.toString(nodes));
//			System.out.println(checkCorrectnexx(matrix, password, nodes));
//			System.out.println("-----------------------------------------");
			if(checkCorrectnexx(matrix, password, nodes) == false)
			{
				hasFail = true;
				System.out.println("ERROR!  BREACH DETECTED! YOU FAILED!!!!");
				break;
			}
		}
		
		if(hasFail == false)
		{
			long endTime = System.currentTimeMillis();
			long runTime = endTime - startTime;
			System.out.println("Breach complete, total runtime is "+runTime +"ms");	
		}

	}
	
	public static boolean checkCorrectnexx(String[][] matrix, String[] password, Node[] nodes)
	{
		for(int i = 0; i < nodes.length; i++)
		{
			int x = nodes[i].x;
			int y = nodes[i].y;
			
			String symbol = password[i];
			
			if(!matrix[y][x].contentEquals(symbol))
			{
				return false;
			}
		}
		
		boolean isHor = false;
		for(int i = 0; i < nodes.length; i++)
		{
			if(i == nodes.length -1)
			{
				break;
			}
			if(isHor == false)
			{
				if(nodes[i].x != nodes[i+1].x)
				{
					return false;
				}
			}
			else
			{
				if(nodes[i].y != nodes[i+1].y)
				{
					return false;
				}
			}
			
			isHor = !isHor;
		}
		
		return true;
	}
	
	public static void printMatrix(String[][] matrix)
	{
		int n = matrix.length;
		System.out.println("matrix: ");
		for(int i = 0; i < n; i++)
		{
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	

}
