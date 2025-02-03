using System;

public class Solution {
    public string[] solution(string[] strings, int n) 
    {
        for(int i = 0; i < strings.Length - 1; i++)
        {
            for(int j = i + 1; j < strings.Length; j++)
            {
                bool check = false;
                if((int)strings[i][n] > (int)strings[j][n]) check = true;
                else if((int)strings[i][n] == (int)strings[j][n] && String.Compare(strings[i], strings[j]) > 0) check = true;
                
                if(check)
                {
                    string temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;  
                }
            }
        }
        return strings;
    }
}