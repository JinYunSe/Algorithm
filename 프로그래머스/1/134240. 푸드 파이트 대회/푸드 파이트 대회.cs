using System;

public class Solution 
{
    public string solution(int[] food) 
    {
        string result = "0";
        for(int i = food.Length - 1; i >= 1; i--)
        {
            food[i] = food[i] / 2;
            for(int j = 0; j < food[i]; j++)
                result = i + result + i;
        }
        return result;
    }
}