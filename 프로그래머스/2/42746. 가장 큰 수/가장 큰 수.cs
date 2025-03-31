using System;
using System.Linq;

public class Solution {    
    public string solution(int[] numbers) {
        
        
        string[] stringNumbers = numbers.Select(element => element.ToString()).ToArray();
        
        Array.Sort(stringNumbers, (a, b)=> (b + a).CompareTo(a + b));
        
        string result = string.Join("", stringNumbers);
        
        return result[0] == '0' ? "0" : result;
    }
}