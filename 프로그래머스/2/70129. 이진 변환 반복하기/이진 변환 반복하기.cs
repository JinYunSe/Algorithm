using System;
using System.Linq;

public class Solution {
    public int[] solution(string s) {
        
        int count = 0;
        int zeroCount = 0;
        
        while(s.Length != 1)
        {
            int oneCount = s.Where(element=> element == '1').Count();
            zeroCount += s.Length - oneCount;
            s = Convert.ToString(oneCount, 2);
            count++;
        }
        
        return new int[] { count , zeroCount };
    }
}