using System;
using static System.Math;

public class Solution {
    public int solution(int number, int limit, int power) {
        int need = 0;
        
        for(int i = 1; i <= number;i++)
        {
            int count = 0;
            for(int j = 1; j <= Math.Sqrt(i); j++)
            {
                if(i % j == 0)
                {
                    count += i / j == j ? 1 : 2;
                }
            }
            need += count > limit ? power : count;
        }
        return need;
    }
}