package Breach;

import java.util.Random;


public class Generate {
	
	static Random random = new Random();
	static boolean isHor = true;
	String[][] matrix;
	String[] password;
	
	public Generate(int n)
	{
		password = generatePW(n);
		matrix = populateMatrix(n, password);
	}
	
	public String[][] getMatrix()
	{
		return matrix;
	}
	public String[] getPassword()
	{
		return password;
	}
	
	public String[] generatePW(int n)
	{
		int pwLength = n/2;
		String[] password = new String[pwLength];
		
		for(int i = 0; i < pwLength; i++)
		{
			password[i] = getRandSymbol();
		}
		return password;
	}
	
	public String[][] populateMatrix(int n, String[] password)
	{
		String[][] matrix = new String[n][n];
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
		
		return matrix;
	}
	
	public static String getRandSymbol()
	{
		return random.nextInt(10) + String.valueOf(Character.toUpperCase((char)(random.nextInt(26) + 'a')));
	}
	

}
