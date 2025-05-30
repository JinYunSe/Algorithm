using System;
using System.Linq;
using System.Collections.Generic;
using static System.Math;

class Solution
{
    // point to point 비용 저장
    public class Value
    {
        public int Point { set; get; }
        public int Cost { set; get; }
        public Value(int point, int cost)
        {
            this.Point = point;
            this.Cost = cost;
        }
    }
    
    public HashSet<int> list = new HashSet<int>();
    
    public int solution(int N, int[,] road, int K)
    {
        Dictionary<int, List<Value>> dict = new Dictionary<int, List<Value>>();
        
        // 시작 지점(1) - 원하는 지점 비용 저장
        // 가상의 다리가 있는 것 처럼 만들기
        int[] startToPointCost = new int[N + 1];
        
        startToPointCost[1] = 0;
        
        for(int i = 2; i < startToPointCost.Length; i++)
        {
            startToPointCost[i] = int.MaxValue;
        }
        
        for(int i = 0; i < road.GetLength(0); i++)
        {
            int point1 = road[i, 0], point2 = road[i, 1], cost = road[i, 2];
            
            if(!dict.ContainsKey(point1)) dict[point1] = new List<Value>();
            dict[point1].Add(new Value(point2, cost));
            
            if(!dict.ContainsKey(point2)) dict[point2] = new List<Value>();
            dict[point2].Add(new Value(point1, cost));
        }
        
        bool[] visited = new bool[N + 1];
        
        DFS(dict, visited, 1, startToPointCost, K, 0);
        
        // 개수 구하기
        return list.Count;
    }
    
    // 필요한 매개변수
    // 길 연결 정보 dictionary
    // 방문 여부
    // 현재 위치
    // 시작 - 해당 위치(가상의 다리) 최소 비용
    // 제한 비용
    // 현재 비용
    public void DFS(Dictionary<int, List<Value>> dict, bool[] visited, int currentPoint, int[] startToPointCost, int K, int currentCost)
    {
        if(!visited[currentPoint] && currentCost <= K)
        {
            visited[currentPoint] = true;
            list.Add(currentPoint);
            
            foreach(var next in dict[currentPoint])
            {
                if((currentCost + next.Cost) <= startToPointCost[next.Point])
                {
                    startToPointCost[next.Point] = currentCost + next.Cost;
                    DFS(dict, visited, next.Point, startToPointCost, K, currentCost + next.Cost);   
                }
            }
            visited[currentPoint] = false;
        }
    }
}
