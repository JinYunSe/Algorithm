using System;
using static System.Math;

public class Solution {
    public long solution(int a, int b) 
    {
        return (long)(Math.Abs(b - a) + 1) * (a + b) / 2;
    }
}