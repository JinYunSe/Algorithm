using System;
using System.Linq;

public class Solution {
    public long solution(long n) {
        double sqrt = (double)Math.Sqrt(n);
        return n % sqrt == 0 ? (long)((sqrt + 1) * (sqrt + 1)) : -1;
    }
}