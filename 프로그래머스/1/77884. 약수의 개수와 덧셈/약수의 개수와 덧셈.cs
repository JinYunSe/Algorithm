using System;
using static System.Math;

public class Solution {
    public int solution(int left, int right) 
    {
        int sum = 0;
        
        for(int i = left; i <= right; i++)
        {
            int count = 0;
            for(int j = 1; j <= (int)Math.Sqrt(i); j++)
            {
                if(i % j == 0 && i / j == j) count++;
                else if(i % j == 0) count += 2;
            }
            
            if(count % 2 == 0) sum += i;
            else sum -= i;
        }
        
        return sum;
    }
}