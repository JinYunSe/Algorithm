using System;
using System.Linq;

public class Solution {
    public string solution(int n) 
    {
        string temp = "";
        for(int i = 0; i < n / 2; i++)
        {
            temp += "수박";
        }
        return n % 2 == 1 ? temp + "수" : temp; 
    }
}