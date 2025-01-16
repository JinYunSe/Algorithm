using System;
using System.Linq;

public class Solution {
    public string solution(string phone_number) 
    {
        string result = "";
        for(int i = 0; i < phone_number.Length; i++)
        {
            result += phone_number.Length - 4 > i ? "*" : phone_number[i].ToString(); 
        }
        return result;
    }
}