using System;
using static System.Math;

public class Solution {
    public long solution(int a, int b) 
    {
        if(a == b) return a;
        
        int min = Math.Min(a, b);
        int max = Math.Max(a, b);
        
        return (long)(Math.Abs(max - min) + 1) * (min + max) / 2;
    }
}