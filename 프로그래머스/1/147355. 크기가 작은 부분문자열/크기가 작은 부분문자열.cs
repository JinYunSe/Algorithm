using System;
using System.Linq;

public class Solution 
{
    public int solution(string t, string p) 
    {
        int count = 0;
        for(int i = 0; i < t.Length - p.Length + 1; i++)
        {
            long temp  = long.Parse(t.Substring(i, p.Length));
            if(temp <= long.Parse(p)) count++;
        }
        
        return count;
        
    }
}