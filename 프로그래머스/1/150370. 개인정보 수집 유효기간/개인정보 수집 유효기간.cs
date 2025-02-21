using System;
using System.Collections.Generic;
using System.Linq;

public class Solution {
    public int[] solution(string today, string[] terms, string[] privacies) {
        int[] todays = today.Split('.').Select(element => int.Parse(element)).ToArray();
        
        // 오늘 일수
        int todayDays = todays[0] * 12 * 28 + (todays[1] - 1) * 28 + todays[2];
        
        Dictionary<string, int> dictTerms = new Dictionary<string, int>();
            
        for(int i = 0; i < terms.Length; i++)
        {
            string[] term = terms[i].Split(' ');
            dictTerms[term[0]] = int.Parse(term[1]) * 28;
        }
        
        List<int> expired = new List<int>();
        
        for(int i = 0; i < privacies.Length; i++)
        {
            string[] privacy = privacies[i].Split(' ');
            int[] starts = privacy[0].Split('.').Select(element => int.Parse(element)).ToArray();
            
            // 계약 시작 일수
            int startDays = starts[0] * 12 * 28 + (starts[1] - 1) * 28 + starts[2];
            
            // 종료 일수
            int endDays = startDays + dictTerms[privacy[1]];
            
            // 종료 일수와 오늘 일수 비교
            if(endDays <= todayDays) expired.Add(i + 1);
        }
        
        return expired.ToArray();
    }
}