using System;
using static System.Math;

class Solution
{
    public int solution(int n, double a, double b)
    {
        int answer = 0;
        
        while(a != b)
        {
            a = Math.Ceiling(a / 2);
            b = Math.Ceiling(b / 2);
            answer++;
        }
        
        return answer;
    }
}