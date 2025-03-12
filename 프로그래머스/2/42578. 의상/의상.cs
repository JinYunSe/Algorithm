using System;
using System.Collections.Generic;

public class Solution {
    public int solution(string[,] clothes) 
    {
        Dictionary<string, List<string>> dictionary = new Dictionary<string, List<string>>();
        
        for(int i = 0; i < clothes.GetLength(0); i++)
        {
            if(!dictionary.ContainsKey(clothes[i, 1]))
                dictionary[clothes[i, 1]] = new List<string>();
            dictionary[clothes[i,1]].Add(clothes[i,0]);
        }
        
        int count = 1;
        
        foreach(List<string> values in dictionary.Values)
        {
            count *= values.Count + 1;
        }
        
        return count - 1;
    }
}