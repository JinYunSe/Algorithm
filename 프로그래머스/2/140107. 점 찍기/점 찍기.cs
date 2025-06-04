using System;
using System.Linq;
using static System.Math;

public class Solution {
    public long solution(int k, int d) 
    {
        long num = (long)Math.Pow(d, 2);
        
        long total = 0;
        for(int i = 0; i <= d; i+=k)
        {
            int sqrt = (int)Math.Sqrt(num - Math.Pow(i, 2));
            int count = 1;
            
            total += (sqrt / k) + count;
        }
        
        return total;
    }
}