using System;

public class Solution {
    public string solution(string s, int n) 
    {
        string answer = "";
        
        char[] charArray = s.ToCharArray();
        
        for(int i = 0; i < charArray.Length; i++)
        {
            if(charArray[i] == ' ') continue;
            else if(char.IsLower(charArray[i]))
            {
                charArray[i] = (int)charArray[i] + n > (int)'z' ? (char)(charArray[i] - 26 + n) : (char)(charArray[i] + n);
            }
            else
            {
                charArray[i] = (int)charArray[i] + n > (int)'Z' ? (char)(charArray[i] - 26 + n) : (char)(charArray[i] + n);
            }
        }
        
        return new string(charArray);
    }
}