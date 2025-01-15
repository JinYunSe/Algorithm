using System;
using static System.Math;

public class Solution {
    public long solution(int a, int b) 
    {
        if(a == b) return a;
        return (long)(Math.Abs(b - a) + 1) * (a + b) / 2;
    }
}