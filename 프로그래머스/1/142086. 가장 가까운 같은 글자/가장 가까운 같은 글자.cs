using System;
using System.Linq;

public class Solution 
{
    public int[] solution(string s) 
    {
        int[] result = new int[s.Length];
        
        result[0] = -1;
        
        for(int i = 1; i < s.Length; i++)
        {
            string temp = s.Substring(0, i);
            for(int j = temp.Length - 1; j >= 0; j--)
            {
                if(s[i] == temp[j])
                {
                    result[i] = temp.Length - j;
                    break;
                }
            }
        }
        return result.Select(element => element == 0 ? -1 : element).ToArray();
    }
}

/*

        result[0] = -1;
        
        for(int i = 1; i < s.Length; i++)
        {
            string temp = s.Substring(0, i);
            for(int j = temp.Length - 1; j >= 0; j--)
            {
                if(s[i] == temp[j])
                {
                    result[i] = temp.Length - j;
                    break;
                }
            }
        }
        return result.Select(element => element == 0 ? -1 : element).ToArray();

*/