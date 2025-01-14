using System;

public class Solution {
    public int solution(int n) {
        int sum = 0;
        for(int i = 1; i <= (int)Math.Sqrt(n); i++)
        {
            if(n % i == 0)
            {
                sum += i;
                if(n / i != i)sum += n / i;
            }
        }
        return sum;
    }
}