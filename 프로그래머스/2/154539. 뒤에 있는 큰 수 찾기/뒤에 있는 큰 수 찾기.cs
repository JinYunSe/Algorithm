using System;
using System.Collections.Generic;

public class Solution {
    public int[] solution(int[] numbers) 
    {
        Stack<int> indexStack = new Stack<int>();
        int[] result = new int[numbers.Length];
        
        for(int i = 0; i < result.Length; i++)
        {
            result[i] = -1;
        }
        
        for(int i = 0; i < numbers.Length; i++)
        {
            
            while(indexStack.Count > 0 && numbers[indexStack.Peek()] < numbers[i])
            {
                result[indexStack.Pop()] = numbers[i];
            }
            indexStack.Push(i);
        }
        
        return result;
    }
}