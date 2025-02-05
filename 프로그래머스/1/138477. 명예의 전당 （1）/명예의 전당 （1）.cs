using System;
using System.Linq;

public class Solution 
{
    public int[] solution(int k, int[] score) 
    {
        int[] answer = new int[score.Length];
        
        for(int i = 0; i < score.Length; i++)
        {
           int[] temp = score.Skip(0).Take(i + 1).OrderByDescending(element => element).ToArray();
            answer[i] = temp.Length < k ? temp.Min() : temp[k - 1];
        }
        return answer;
    }
}