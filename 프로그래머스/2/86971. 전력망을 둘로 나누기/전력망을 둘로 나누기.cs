using System;
using System.Linq;
using System.Collections.Generic;
using static System.Math;

public class Solution {
    public int solution(int n, int[,] wires) 
    {
        bool[] visited = new bool[n];
        Dictionary<int, HashSet<int>> dict = new Dictionary<int, HashSet<int>>();
        
        // point 간 연결이 2개인 경우를 대비해서 Dictionary와 HashSet 사용
        for(int i = 0; i < wires.GetLength(0); i++)
        {
            for(int j = 0; j < wires.GetLength(1); j++)
            {
                int point1 = wires[i, 0], point2 = wires[i, 1];
                if(!dict.ContainsKey(point1)) dict[point1] = new HashSet<int>();
                
                dict[point1].Add(point2);
                
                if(!dict.ContainsKey(point2)) dict[point2] = new HashSet<int>();
                
                dict[point2].Add(point1);
            }
        }
        
        int min = int.MaxValue;
        
        for(int i = 0; i < wires.GetLength(0); i++)
        {
            int point1 = wires[i, 0], point2 = wires[i, 1];
            
            // 연결 해제
            dict[point1].Remove(point2);
            dict[point2].Remove(point1);
            
            int count = BFS(dict, point1, n);
            
            // n - count로 연결이 끊긴 포인트의 연결 개수에서
            // - count로 차이 구하기
            int diff = Math.Abs((n - count) - count);
            
            if(diff < min) min = diff;
            
            // 다음 진행을 위해 다시 연결
            dict[point1].Add(point2);
            dict[point2].Add(point1);
        }
        
        return min;
    }
    
    public int BFS(Dictionary<int, HashSet<int>> dict, int point1, int n)
    {
        bool[] visited = new bool[n + 1];
        Queue<int> queue = new Queue<int>();
        int count = 0;
        
        queue.Enqueue(point1);
        visited[point1] = true;
        
        while(queue.Count > 0)
        {
            int current = queue.Dequeue();
            count++;
            
            foreach(var nextPoint in dict[current])
            {
                if(!visited[nextPoint])
                {
                    visited[nextPoint] = true;
                    queue.Enqueue(nextPoint);
                }
            }
        }
        
        return count;
    }
}