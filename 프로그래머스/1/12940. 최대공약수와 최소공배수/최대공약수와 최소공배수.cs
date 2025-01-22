using System;
using static System.Math;
public class Solution {
    public int[] solution(int n, int m) {
        int max = Math.Max(n,m);
        int min = Math.Min(n,m);
        
        while(min != 0)
        {
            int temp = max % min;
            max = min;
            min = temp;
        }
        
        return new int[] {max , n * m / max };
    }
}