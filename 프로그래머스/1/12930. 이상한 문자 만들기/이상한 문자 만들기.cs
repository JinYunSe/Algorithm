using System;
using System.Linq;

public class Solution {
    public string solution(string s) 
    {
        int index = 0;
        
        char[] charTemp = s.ToCharArray();
        for(int i = 0; i < charTemp.Length; i++)
        {
            if(charTemp[i] == ' ')
            {
                index = 0;
                continue;
            }
            charTemp[i] = index % 2 == 0 ? char.ToUpper(charTemp[i]) : char.ToLower(charTemp[i]);
            index++;
        }
        return new string(charTemp);
    }
}