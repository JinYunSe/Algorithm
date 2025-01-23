using System;

public class Solution {
    public bool solution(string s) {
        return (s.Length == 4 || s.Length == 6) && int.TryParse(s, out int result);
    }
}