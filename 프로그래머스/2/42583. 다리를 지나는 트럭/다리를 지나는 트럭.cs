using System;
using System.Collections.Generic;


public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) 
    {
        Queue<int> processCar = new Queue<int>();
        int currentWeight = 0;
        int time = 0;
        
        foreach(int truck in truck_weights)
        {
            while(true)
            {
                if(processCar.Count == bridge_length)
                    currentWeight -= processCar.Dequeue();
                
                if(currentWeight + truck <= weight)
                {
                    processCar.Enqueue(truck);
                    currentWeight += truck;
                    time++;
                    break;
                }
                else
                {
                    processCar.Enqueue(0);
                    time++;
                }
            }
        }
        
        return time + bridge_length;
    }
}