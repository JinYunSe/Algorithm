using System;
using System.Linq;

public class Solution 
{
    public int solution(int k, int m, int[] score) 
    {
        int result = 0;
        score = score.OrderByDescending(element => element).ToArray();
        int div = score.Length / m;
        for(int i = 0; i < div; i++)
            result += score.Skip((i * m)).Take(m).Min() * m;

        return result;
    }
}