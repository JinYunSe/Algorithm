using System;
using System.Linq;

public class Solution {
    public string solution(int n) 
    {
        int share = n / 2;
        int mod = n % 2;
    
        string temp = string.Concat(Enumerable.Repeat("수박",share));
        return mod == 0 ? temp : temp + "수";
    }
}