using System;

public class Solution {
    public string solution(int a, int b) 
    {
        DateTime dateValue = new DateTime(2016,a,b);
        return dateValue.DayOfWeek.ToString().Substring(0,3).ToUpper();
    }
}