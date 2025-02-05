using System;

public class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(int.Parse(n / a) > 0)
        {
            answer += int.Parse(n / a) * b;
            n = int.Parse(n / a) * b + n % a;
        }
        
        return answer;
    }
}
/*

function solution(a, b, n) {
    let answer = 0;
    while(parseInt(n / a) > 0)
    {
        answer += parseInt(n / a) * b
        n = parseInt(n / a) * b + n % a
    }
    return answer
}

*/