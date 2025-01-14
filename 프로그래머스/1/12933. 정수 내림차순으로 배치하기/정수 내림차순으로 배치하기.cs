using System;
using System.Linq;

public class Solution {
    public long solution(long n) {
        string temp = new string(n.ToString().OrderByDescending(c => c).ToArray());
        return long.Parse(temp);
    }
}