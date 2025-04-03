using System;
using System.Collections.Generic;

public class Solution {
    public int solution(int[] order) {
        
        int boxIndex = 0;
        
        Stack<int> stack= new Stack<int>();
        
        for(int i = 1; i <= order.Length; i++)
        {
            if(i == order[boxIndex])
                boxIndex++;
            else
                stack.Push(i);
            
            while(stack.Count > 0 && stack.Peek() == order[boxIndex])
            {
                stack.Pop();
                boxIndex++;
            }
        }
        
        return boxIndex;
    }
}