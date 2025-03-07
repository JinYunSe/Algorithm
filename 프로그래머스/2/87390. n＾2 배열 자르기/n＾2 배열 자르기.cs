using System;
using System.Collections.Generic;

public class Solution {
    public int[] solution(int n, long left, long right) 
    {
        List<int> list = new List<int>();
        for(long i = left; i <= right; i++)
        {
            int div = (int)(i / n);
            int mod = (int)(i % n);
            
            int temp = mod >= div ? mod + 1 : div + 1;
            list.Add(temp);
        }
        
        return list.ToArray();
    }
}