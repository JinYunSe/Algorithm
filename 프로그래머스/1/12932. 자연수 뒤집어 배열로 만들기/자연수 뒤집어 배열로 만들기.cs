using System;

public class Solution {
    public long[] solution(long n) {
        
        int size = n.ToString().Length;
        long[] answer = new long[size];
        for(int i = 0; i < size; i++)
        {
            answer[i] = n % 10;
            n /= 10;
        }
        return answer;
    }
}