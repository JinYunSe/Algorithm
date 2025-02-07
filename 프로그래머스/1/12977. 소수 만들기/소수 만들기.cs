using System;
using static System.Math;
using System.Collections.Generic;

class Solution
{
    private bool IsPrime(int num)
    {
        for (int i = 2; i <= (int)Math.Sqrt(num); i++)
        {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    public int solution(int[] nums)
    {
        List<int> list = new List<int>();
        
        for(int i = 0; i < nums.Length - 2; i++)
        {
            for(int j = i + 1; j < nums.Length - 1; j++)
            {
                for(int k = j + 1; k < nums.Length; k++)
                {
                    list.Add(nums[i] + nums[j] + nums[k]);   
                }
            }
        }
        
        int count = 0;
        
        foreach (int num in list)
        {
            if (IsPrime(num)) count++;
        }
        
        return count;
    }
}