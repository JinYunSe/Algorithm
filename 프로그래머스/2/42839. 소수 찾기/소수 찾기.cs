using System;
using System.Collections.Generic;

public class Solution {

    public HashSet<int> hashSet = new HashSet<int>();
    
    // 필요한 매개변수
    // 제한 시킬 글자 수
    // 현재 만들어진 숫자(문자열)
    // numbers(제공 될 문자열)
    public void MakeNumber(int length, string currentWords, string numbers) {
        
        if(currentWords.Length == length + 1) return;
        
        int.TryParse(currentWords, out int result);
        if(result != 0 && result != 1) hashSet.Add(result);
        
        for(int i = 0; i < numbers.Length; i++)
        {
            MakeNumber(length, currentWords + numbers[i], numbers.Remove(i, 1));
        }
    }
    
    public int IsPrime(int number)
    {
        bool check = true;
        for(int i = 2; i <= (int)Math.Sqrt(number); i++)
        {
            if(number % i == 0) check = false;
        }
        return check ? 1 : 0;
    }
    
    public int solution(string numbers) {
        int answer = 0;
        
        MakeNumber(numbers.Length, "",numbers);
        
        foreach(int element in hashSet)
        {
            answer += IsPrime(element);
        }
        
        return answer;
    }
}