using System;
using System.Collections.Generic;

public class Solution {
    public int[] solution(string[] keymap, string[] targets) 
    {
        int[] result = new int[targets.Length];
        Dictionary<char, int> dict = new Dictionary<char,int>();
        
        foreach(string row in keymap)
        {
            for(int i = 0; i < row.Length; i++)
            {
                dict[row[i]] = dict.ContainsKey(row[i]) ? Math.Min(dict[row[i]], i + 1) : i + 1;
            }
        }
        
        for(int i = 0; i < targets.Length; i++)
        {
            string target = targets[i];
            int count = 0;
            for(int j = 0; j < target.Length; j++)
            {
                if(dict.ContainsKey(target[j])) count += dict[target[j]];
                else 
                {
                    count = -1;
                    break;
                }
            }
            result[i] = count;
        }
        
        return result;
    }
}