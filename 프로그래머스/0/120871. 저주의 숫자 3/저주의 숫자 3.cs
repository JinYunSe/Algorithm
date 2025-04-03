using System;

public class Solution {
    public int solution(int n) {
        
        int i = 1;
        for(; i <= n; i++)
        {
            if(i % 3 == 0 || i.ToString().Contains("3"))
            {
                n++;
                continue;
            }
        }
        
        return i - 1;
    }
}