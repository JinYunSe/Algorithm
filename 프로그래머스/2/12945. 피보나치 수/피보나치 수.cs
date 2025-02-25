using System;
using System.Collections.Generic;

public class Solution {
    public int solution(int n) 
    {
        List<int> list = new List<int>();
        
        list.Add(0);
        list.Add(1);
        
        for(int i = 2; i <= n; i++)
        {
            list.Add((list[i - 1] + list[i - 2]) % 1234567);
        }
        
        return list[n];
    }
}