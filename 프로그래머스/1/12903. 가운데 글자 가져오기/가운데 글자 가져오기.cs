using System;

public class Solution {
    public string solution(string s) {
        int size = s.Length - 1;
        
        Console.WriteLine(size);
        
        return size % 2 == 0 ? s[size / 2].ToString() : s[size / 2].ToString() + s[size / 2 + 1].ToString();
    }
}