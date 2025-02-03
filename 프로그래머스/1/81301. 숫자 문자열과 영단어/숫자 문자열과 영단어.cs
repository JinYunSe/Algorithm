using System;

public class Solution {
    public int solution(string s) 
    {
        string[] stringTypeNumber = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(int i = 0; i < stringTypeNumber.Length; i++)
        {
            s = s.Replace(stringTypeNumber[i], i.ToString());
        }
        
        return int.Parse(s);
    }
}