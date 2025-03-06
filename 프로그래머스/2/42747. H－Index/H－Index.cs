using System;
using System.Linq;

public class Solution {
    public int solution(int[] citations) 
    {
        citations = citations.OrderByDescending(element => element).ToArray();
        
        for(int i = 0; i < citations.Length; i++)
        {
            if(citations[i] == (i + 1)) return i + 1;
            else if(citations[i] < (i + 1)) return i;
        }
        
        return citations.Length;
    }
}