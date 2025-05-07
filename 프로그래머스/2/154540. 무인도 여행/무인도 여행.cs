using System;
using System.Linq;
using System.Collections.Generic;

public class Solution {
    public int[] solution(string[] maps) {
        List<int> list = new List<int>();
        bool[,] visited = new bool[maps.Length, maps[0].Length];
        
        for(int i = 0; i < maps.Length; i++)
        {
            for(int j = 0; j < maps[0].Length; j++)
            {
                if(maps[i][j] == 'X') continue;
                int sum = DFS(visited, maps, i, j);
                if(sum != 0)list.Add(sum);
            }
        }
        
        if(list.Count == 0) return new int[] { -1 };
        
        return list.OrderBy(element=>element).ToArray();
    }
    
    // 필요한 매개변수
    // 방문 여부
    // 지도
    // 현재 세로 위치
    // 현재 가로 위치
    public int DFS(bool[,] visited, string[] maps, int currentRow, int currentColum)
    {
        int sum = 0;
        if(!visited[currentRow, currentColum] && maps[currentRow][currentColum] != 'X')
        {
            visited[currentRow, currentColum] = true;
            //Console.WriteLine("currentRow : "+currentRow+", currentColum : "+currentColum+", maps : "+maps[currentRow][currentColum]);
            sum += int.Parse(maps[currentRow][currentColum].ToString());
            if((currentRow - 1) > -1)  sum += DFS(visited, maps, currentRow - 1, currentColum);
            if((currentRow + 1) < maps.Length)  sum += DFS(visited, maps, currentRow + 1, currentColum);
            if((currentColum - 1) > -1)  sum += DFS(visited, maps, currentRow, currentColum - 1);
            if((currentColum + 1) < maps[currentRow].Length)  sum += DFS(visited, maps, currentRow, currentColum + 1);
        }
        //Console.WriteLine("sum : "+sum);
        return sum;
    }
}