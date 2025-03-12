using System;

using System.Collections.Generic;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<int> result = new List<int>();
        Queue<int> queueProgresses = new Queue<int>(progresses);
        Queue<int> queueSpeeds = new Queue<int>(speeds);
        
        while(queueProgresses.Count != 0)
        {
            for(int i = 0; i < queueProgresses.Count; i++)
            {
                int progress = queueProgresses.Dequeue();
                int speed = queueSpeeds.Dequeue();
                queueProgresses.Enqueue(progress + speed);
                queueSpeeds.Enqueue(speed);
            }
            
            int count = 0;
            while(queueProgresses.Count > 0 && queueProgresses.Peek() >= 100)
            {
                queueProgresses.Dequeue();
                queueSpeeds.Dequeue();
                count++;
            }
            if(count != 0) result.Add(count);
        }
        
        return result.ToArray();
    }
}