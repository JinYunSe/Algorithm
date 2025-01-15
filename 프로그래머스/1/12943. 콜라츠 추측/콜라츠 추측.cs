using System;

public class Solution {
    public int solution(long num) {
        if(num == 1) return 0;
        
        int count = 0;
        
        do{
            num = num % 2 == 0 ? num / 2 : num * 3 + 1;
            count++;
        }while(num != 1);
        
        return count > 500 ? -1 : count;
    }
}