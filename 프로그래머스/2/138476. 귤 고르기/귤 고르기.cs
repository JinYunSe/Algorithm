using System;
using System.Linq;
using System.Collections.Generic;

public class Solution {
    public int solution(int k, int[] tangerine) 
    {
        Dictionary<int,int> dict = new Dictionary<int,int>();
        
        int count = 0;
        
        
        
        for(int i = 0; i < tangerine.Length; i++)
        {
            if(!dict.ContainsKey(tangerine[i])) dict.Add(tangerine[i], 1);
            else dict[tangerine[i]]++;
        }
        
        dict = dict.OrderByDescending(x => x.Value).ToDictionary(x => x.Key, x=> x.Value);
        
        foreach(int key in dict.Keys)
        {
            count++;
            if(k - dict[key] <= 0)
                break;
            else
                k -= dict[key];
        }
        
        return count;
    }
}