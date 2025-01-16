using System;
using System.Linq;

public class Solution {
    public string solution(string phone_number) 
    {
        return string.Join("",phone_number.Select((element, index) => phone_number.Length - 4 > index ? '*' : element).ToArray());
    }
}