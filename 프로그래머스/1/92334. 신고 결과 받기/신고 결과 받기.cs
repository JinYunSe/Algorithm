using System;
using System.Collections.Generic;
using System.Linq;

public class Solution {
    public int[] solution(string[] id_list, string[] report, int k) 
    {
        report = report.Distinct().ToArray();
        List<int> list = new List<int>();
        Dictionary<string, int> bans = new Dictionary<string,int>();
        Dictionary<string, List<string>> reporter = new Dictionary<string, List<string>>();
        
        foreach(string id in id_list)
        {
            reporter[id] = new List<string>();
        }
        
        for(int i = 0; i < report.Length; i++)
        {
            string[] names = report[i].Split(' ');
            
            if(!reporter[names[0]].Contains(names[1]))
            {
                reporter[names[0]].Add(names[1]);
                
                if(!bans.ContainsKey(names[1]))
                    bans[names[1]] = 0;
                
                bans[names[1]]++;
            }
        }
        
        foreach (var entry in reporter)
        {
            int count = 0;
            foreach (string reported in entry.Value)
            {
                if (bans[reported] >= k)
                    count++;
                
            }
            list.Add(count);
        }
        
        return list.ToArray();
    }
}