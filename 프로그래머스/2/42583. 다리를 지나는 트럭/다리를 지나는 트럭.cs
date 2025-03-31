using System;
using System.Collections.Generic;


public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) 
    {
        // 다리를 건너는 자동차 Queue
        Queue<int> processCar = new Queue<int>();
        // 현재 다리 위 자동차 무게
        int currentWeight = 0;
        // 시간
        int time = 0;
        
        foreach(int truck in truck_weights)
        {
            while(true)
            {
                // 진행 중인 차량 수가 다리 길이와 같으면
                if(processCar.Count == bridge_length)
                    // 가장 앞에 있는 차량 제거 및 무게 뺴주기
                    currentWeight -= processCar.Dequeue();
                
                // 현재 다리 위 무게, 다리 위로 올라가기 시도 중인 차량
                // 의 합이 무게 제한을 넘지 않으면
                if(currentWeight + truck <= weight)
                {
                    // 다리 위에 추가
                    processCar.Enqueue(truck);
                    currentWeight += truck;
                    time++;
                    break;
                }
                else
                {
                    // 가짜 차량 추가(기존 다리 위 차량 한 칸 이동 표현)
                    processCar.Enqueue(0);
                    time++;
                }
            }
        }
        
        // 마지막 트럭이 다리를 다 건너는 시간 추가
        return time + bridge_length;
    }
}