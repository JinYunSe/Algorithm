using System;
using System.Collections.Generic;

public class Solution {
    public int[] solution(int brown, int yellow) 
    {
        int sum = brown + yellow;
        
        List<int> div = new List<int>();
        List<int> mod = new List<int>();
        
        for(int i = 2; i <= (int)Math.Sqrt(sum);i++)
        {
            if(sum % i == 0)
            {
                div.Add(sum / i);
                mod.Add(i);
            }
        }
        
        int index;
        for(index = 0; index < div.Count; index++)
        {
            if((div[index] - 2) * (mod[index] - 2) == yellow ) break;
        }
        
        return new int[] { div[index], mod[index] };
    }
}