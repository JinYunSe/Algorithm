using System;
using System.Collections.Generic;

public class Solution {
    public int solution(int n, int m, int[] section) 
    {
        Queue<int> queue = new Queue<int>(section);
        
        int count = 0;
        
        while(queue.Count != 0)
        {
            
            int current = queue.Dequeue();
            count++;
            while(queue.Count > 0 &&queue.Peek() < current + m) queue.Dequeue();
        }
        
        return count;
    }
}