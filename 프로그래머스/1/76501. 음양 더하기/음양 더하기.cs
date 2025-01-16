using System;

public class Solution {
    public int solution(int[] absolutes, bool[] signs) {
        int sum = 0;
        
        for(int i = 0; i < absolutes.Length; i++)
            sum += signs[i] == true ? absolutes[i] : -1 * absolutes[i];
        
        
        return sum;
    }
}