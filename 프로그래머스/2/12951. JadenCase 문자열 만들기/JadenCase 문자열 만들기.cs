using System;
using System.Linq;

public class Solution {
    public string solution(string s) 
    {
        s = s.ToLower();
        string result = "";
        bool emptyCheck = true;
        for(int i = 0; i < s.Length; i++)
        {
            if(char.IsDigit(s[i]))
            {
                result += s[i];
                emptyCheck = false;
            }
            else if(s[i] == ' ' && !emptyCheck)
            {
                result += s[i];
                emptyCheck = true;
            }
            else if(char.IsLower(s[i]) && emptyCheck)
            {
                result += char.ToUpper(s[i]);
                emptyCheck = false;
            }
            else result += s[i];
        }
        
        //Console.WriteLine(result);
        
        return result;
    }
}