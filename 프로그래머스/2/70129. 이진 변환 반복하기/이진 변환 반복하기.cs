using System;

public class Solution {
    public int[] solution(string s) {
        
        int count = 0;
        int zeroCount = 0;
        
        while(s.Length != 1)
        {
            string temp = "";
            for(int i = 0; i < s.Length; i++)
            {
                if(s[i] == '0') zeroCount++;
                else temp += s[i];
            }
            count++;
            s = Convert.ToString(temp.Length, 2);
        }
        
        return new int[] { count , zeroCount };
    }
}