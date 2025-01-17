using System;

public class Solution {
    public string solution(string s) {
        int size = s.Length - 1;
        return s.Substring(size / 2, size % 2 == 0 ? 1 : 2);
    }
}