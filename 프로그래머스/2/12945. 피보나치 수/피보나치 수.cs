using System;
using System.Collections.Generic;

public class Solution {
    public int solution(int n) 
    {
        
        int zero = 0, one = 1, sum = 1;
        for(int i = 2; i <= n; i++)
        {
            sum = (one + zero) % 1234567;
            zero = one;
            one = sum;
        }
        return sum;
    }
}