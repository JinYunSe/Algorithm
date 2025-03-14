using System;
using System.Linq;
using System.Collections.Generic;

public class Solution {
    public int solution(int[] priorities, int location) 
    {
        int answer = 0;
        Queue<int> process = new Queue<int>(priorities);
        
        while(process.Count != 0)
        {
            int max = process.Max();
            int dequeue = process.Dequeue();
            
            if(max != dequeue) process.Enqueue(dequeue);
            else
            {
                answer++;
                if(location == 0) break;
            }
            
            location = location - 1 < 0 ? process.Count - 1 : location - 1;
        }
        
        return answer;
    }
}