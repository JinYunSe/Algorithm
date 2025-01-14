using System;
using System.Linq;

public class Solution {
    public int solution(int n) {
        return n.ToString().Select(c => int.Parse(c.ToString())).Sum();
    }
}