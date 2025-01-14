using System;
using System.Linq;

public class Solution {
    public int solution(int n) {
        int sum = 0;
        do{
            sum += n % 10;
            n /= 10;
        }while(n != 0);
        return sum;
    }
}