using System;

public class Solution {
    public int solution(int[] a, int[] b) {
        int sum = 0;
        for(int i = 0; i < a.Length; i++)
            sum += a[i] * b[i];
        return sum;
    }
}