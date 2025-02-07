using System;
using static System.Math;
using System.Collections.Generic;

class Solution
{
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
        
        for(int i = 0; i < list.Count; i++)
        {
            bool check = true;
            for(int j = 2; j <= (int)Math.Sqrt(list[i]); j++)
            {
                if(list[i] % j == 0)
                {
                    check = false;
                    break;
                }
            }
            if(check) count++;
        }
        
        return count;
    }
}