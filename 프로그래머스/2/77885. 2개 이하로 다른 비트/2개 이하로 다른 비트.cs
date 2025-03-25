using System;
using System.Collections.Generic;

public class Solution {
    public long[] solution(long[] numbers) 
    {
        string[] bit = new string[numbers.Length];
        
        for(int i = 0; i < bit.Length; i++)
        {
            bit[i] = Convert.ToString(numbers[i], 2);
            string temp = "0" + bit[i];
            
            if(temp[temp.Length - 1] == '0') temp = temp.Substring(0, temp.Length - 1) + '1';
            else
            {
                int index = temp.LastIndexOf("01");
                temp = temp.Substring(0, index) + "10" + temp.Substring(index + 2);
            }
            
            numbers[i] = Convert.ToInt64(temp, 2);
        }
        
        return numbers;
    }
}