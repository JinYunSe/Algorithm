using System;
using System.Linq;

public class Solution {
    public int solution(int[] arr) 
    {    
        for(int i = 0; i < arr.Length - 1; i++)
        {
            int big = arr[i + 1], small = arr[i];
            while(arr[i] != 0)
            {
                int temp  = arr[i + 1] % arr[i];
                arr[i + 1] = arr[i];
                arr[i] = temp;
            }
            
            arr[i + 1] = big * small / arr[i + 1]; 
        }
        
        return arr[arr.Length - 1];
    }
}