using System;
using System.Linq;

public class Solution {
    public string solution(string s) 
    {
        int[] temp = s.Split(' ').Select(element => int.Parse(element.ToString())).ToArray();   
        return temp.Min() + " " +temp.Max();
    }
}