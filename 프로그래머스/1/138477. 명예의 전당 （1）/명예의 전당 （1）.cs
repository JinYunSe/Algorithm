using System;
using System.Linq;
using System.Collections.Generic;

public class Solution 
{
    public int[] solution(int k, int[] score) 
    {
        List<int> list = new List<int>();
        int[] answer = new int[score.Length];
        
        for(int i = 0; i < score.Length; i++)
        {
            list.Add(score[i]);
            list.Sort();
            list.Reverse();
            answer[i] = list.Count < k ? list.Min() : list[k - 1];
        }
        return answer;
    }
}