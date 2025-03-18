using System;
using System.Linq;

public class Solution {
    public int solution(int n, int k) {
        int count = 0;
        
        string temp = "";
        
        while(n / k != 0)
        {
            temp += n % k;
            n /= k;
        }
        
        temp += n;
        
        temp = new string(temp.Reverse().ToArray());
        
        string[] pNumber = temp.Split('0').Where(element=> element != "1").ToArray();
        
        for(int i = 0; i < pNumber.Length; i++)
        {
            long.TryParse(pNumber[i],out long result);
            bool check = true;
            if(result == 0) continue;
            for(long j = 2; j <= (long)Math.Sqrt(result); j++)
            {
                if(result % j == 0) check = false;
            }
            if(check) count++;
        }
        
        return count;
    }
}