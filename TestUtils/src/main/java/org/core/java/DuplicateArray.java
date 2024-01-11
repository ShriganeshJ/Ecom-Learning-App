package org.core.java;


import java.util.Arrays;
import java.util.Collections;

public class DuplicateArray {
	
	
	
	public static void main(String args[])
	{
		int arr[] ={10,20,11,12,10,14,12,15,16,11};
		findduplicate(arr);
		
	}
	
	static void findduplicate(int arr[])
	{
	   Arrays.sort(arr);
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					System.out.println("Duplicate"+arr[j]);
				}
			}
			
			
		}
		
		
	}
	
}
