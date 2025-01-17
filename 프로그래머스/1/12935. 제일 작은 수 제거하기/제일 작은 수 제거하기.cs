using System;
using System.Linq;

public class Solution {
    public int[] solution(int[] arr) 
    {
        int min = Int32.MaxValue;
        for(int i = 0; i < arr.Length; i++)
            if(arr[i] < min) min = arr[i];
        
        int[] tempArray = arr.Where(element => element != min).ToArray();
        
        return tempArray.Length == 0 ? new int[] { -1 } : tempArray;
    }
}