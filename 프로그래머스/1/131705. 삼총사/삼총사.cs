using System;

public class Solution {
    public int solution(int[] number) {
        int answer = 0;
        
        for(int i = 0; i < number.Length - 2; i++)
        {
            for(int j = i + 1; j < number.Length - 1; j++)
            {
                int sum = number[i] + number[j];
                for(int k = j + 1; k < number.Length; k++)
                {
                    if((sum + number[k]) == 0)
                        answer++;
                }
            }
        }
        
        return answer;
    }
}