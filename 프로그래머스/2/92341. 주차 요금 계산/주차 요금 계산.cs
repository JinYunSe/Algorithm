using System;
using System.Linq;
using System.Collections.Generic;

public class Solution {
    public int[] solution(int[] fees, string[] records) 
    {
        Dictionary<string, List<TimeSpan>> dictionary = new Dictionary<string, List<TimeSpan>>();
        
        for(int i = 0; i < records.Length; i++)
        {
            string[] info = records[i].Split(' ');
            if(!dictionary.ContainsKey(info[1])) dictionary[info[1]] = new List<TimeSpan>();
            dictionary[info[1]].Add(TimeSpan.Parse(info[0]));
        }
        
        dictionary = dictionary.OrderBy(X=> X.Key).ToDictionary(X => X.Key, X => X.Value);
        
        int[] priceRecords = new int[dictionary.Count];
        
        for(int i = 0; i < dictionary.Count; i++)
        {
            var entity = dictionary.ElementAt(i);
            
            if(entity.Value.Count % 2 == 1) entity.Value.Add(TimeSpan.Parse("23:59"));
            
            TimeSpan sumMinutes = TimeSpan.Zero;
            
            for(int j = 0; j < entity.Value.Count; j+=2)
                sumMinutes += entity.Value[j + 1] - entity.Value[j];
            
            int totalPrise = fees[1];
            
            
            if(sumMinutes.TotalMinutes > fees[0])
            {
                sumMinutes -= TimeSpan.FromMinutes(fees[0]);
                totalPrise += (int)Math.Ceiling((double)sumMinutes.TotalMinutes / fees[2]) * fees[3];
            }
            
            priceRecords[i] = totalPrise;
        }
        
        return priceRecords;
    }
}