using System;
using System.Linq;

public class Solution {
    public bool solution(int x) {
        int temp = x;
        int sum = 0;
        do
        {
            sum += temp % 10;
            temp /= 10;
        }while(temp != 0);
        return x % sum == 0;
    }
}