package com.wipro.basic;

public class TwoDimensionalArray {

	public static void main(String[] args)
	{
		int numbers[][]={{1000,1010,1020,1030},{2000,2010,2020,2030},{3000,3010,3020,3030},{4000,4010,4020,4030}};
		for(int i=0;i<numbers.length;i++)
		{
			for(int j=0;j<numbers[i].length;j++)
			{
				System.out.print(numbers[i][j]+"  ");
			}
			System.out.println();
		}

	}

}
