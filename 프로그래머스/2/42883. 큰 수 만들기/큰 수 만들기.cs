using System;
using System.Text;

public class Solution {
    public string solution(string number, int k) 
    {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0, index = -1; i < number.Length - k; i++)
        {
            char max = '0';
            
            for(int j = index + 1; j <= k + i; j++)
            {
                if(max < number[j])
                {
                    max = number[j];
                    index = j;
                }
            }
            
            sb.Append(max);
        }
        
        return sb.ToString();
    }
}