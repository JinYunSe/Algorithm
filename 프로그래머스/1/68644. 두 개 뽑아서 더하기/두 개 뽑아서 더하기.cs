using System;
using System.Linq;
using System.Collections.Generic;

public class Solution 
{
    public int[] solution(int[] numbers) 
    {
        List<int> list = new List<int>();
        numbers = numbers.OrderBy(element => element).ToArray();
        for(int i = 0; i < numbers.Length - 1; i++)
        {
            for(int j = i + 1; j < numbers.Length; j++)
            {
                int temp = numbers[i] + numbers[j];
                if(!list.Contains(temp)) list.Add(temp);
            }
        }
        
        list.Sort();
        
        return list.ToArray();
    }
}