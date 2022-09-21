package Breach;

import java.util.Arrays;
import java.util.Random;

public class Driver {

	static Random random = new Random();
	static boolean isHor = true;
	static int n = 10;
	static String[][] matrix = new String[n][n];
	static String[] password;
	
	public static void main(String[] args)
	{
		generatePW();
		populateMatrix();
		printMatrix();
		Breach breach = new Breach(matrix, password);
	}
	
	public static void generatePW()
	{
		int pwLength = n/2;
		password = new String[pwLength];
		
		for(int i = 0; i < pwLength; i++)
		{
			password[i] = getRandSymbol();
		}
		System.out.println("password: " +Arrays.toString(password));
	}
	
	public static void populateMatrix()
	{
		int x = 0;
		int y = random.nextInt(n);
		for(String element: password)
		{
			while(isHor == false)
			{
				int tempX = random.nextInt(n);
				
				if(matrix[tempX][y] == null)
				{
					x = tempX;
					matrix[x][y] = element;
					break;
				}
			}
			while(isHor == true)
			{
				int tempY = random.nextInt(n);
				
				if(matrix[x][tempY] == null)
				{
					y = tempY;
					matrix[x][y] = element;
					break;
				}
			}
//			System.out.println(y+" "+x);
			
			isHor = !isHor;
		}
		
		for(int a = 0; a < n; a++)
		{
			for(int b = 0; b < n; b++)
			{
				if(matrix[a][b] == null)
				{
					int determin = random.nextInt(n);
					if(determin < n/2)
					{
						matrix[a][b] = password[determin];
					}
					else
					{
						matrix[a][b] = getRandSymbol();
					}
				}
			}
		}
	}
	
	public static String getRandSymbol()
	{
		return random.nextInt(10) + String.valueOf(Character.toUpperCase((char)(random.nextInt(26) + 'a')));
	}
	
	public static void printMatrix()
	{
		System.out.println("matrix: ");
		for(int i = 0; i < n; i++)
		{
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}
