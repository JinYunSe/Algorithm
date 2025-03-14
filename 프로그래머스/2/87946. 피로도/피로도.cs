using System;
using System.Linq;
using System.Collections.Generic;

public class Solution {
    public List<int> answer = new List<int>();
    
    // 필요한 매개 변수
    
    // 현재 방문 횟수
    // 현재 피로도
    // 던전
    // 방문 여부
    public void DFS(int count, int k, int[,] dungeons, bool[] visited)
    {
        // 모든 던전을 방문 못 할 수도 있기 때문에 여기에 두기
        answer.Add(count);
        
        // 탐색 및 방문 가능 여부 조회
        for(int i = 0; i < dungeons.GetLength(0); i++)
        {
            if(!visited[i] && k >= dungeons[i, 0])
            {
                visited[i] = true;
                DFS(count + 1, k - dungeons[i,1], dungeons, visited);
                // 다른 DFS에서 동작하기 위해 방문 여부 false로 변경
                // 어차피 함수의 매개변수로 visited를 넘겨줬기 때문에 방문 여부 제공됨
                visited[i] = false;
            }
        }
    }

    
    public int solution(int k, int[,] dungeons) {
        bool[] visited = new bool[dungeons.GetLength(0)];
        
        DFS(0, k, dungeons, visited);
        
        return answer.Max();
    }
}