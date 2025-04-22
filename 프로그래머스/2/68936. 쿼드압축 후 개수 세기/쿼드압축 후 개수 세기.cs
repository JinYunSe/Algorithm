using System;

public class Solution {
    
    // 0과 1 결과 담을 그릇
    private int[] answer = new int[] {0,0};
    
    public int[] solution(int[,] arr) 
    {
        QuadCompression(0,0,arr.GetLength(0), arr);
        return answer;
    }
    
    // 필요한 매개변수
    // 시작 x, y 위치
    // 배열 탐색 범위
    // 2차원 배열
    public void QuadCompression(int x, int y, int len, int[,] arr)
    {
        bool checkZero = true;
        bool checkOne = true;
        
        for(int i = x; i < x + len; i++)
        {
            for(int j = y; j < y + len; j++)
            {
                if(arr[i, j] == 0) checkOne = false;
                if(arr[i, j] == 1) checkZero = false;
            }
        }
        
        // 모든 값이 0 또는 1이면 개수 증가 및 재귀함수 종료
        if(checkZero) 
        {
            answer[0]++;
            return;
        }
        if(checkOne) 
        {
            answer[1]++;
            return;
        }
        
        // 원쪽 위 탐색
        QuadCompression(x, y, len / 2, arr);
        // 오른쪽 위 탐색
        QuadCompression(x + len / 2, y, len / 2, arr);
        // 윈쪽 아래 탐색
        QuadCompression(x, y + len / 2, len / 2, arr);
        // 오른쪽 아래 탐색
        QuadCompression(x + len / 2, y + len / 2, len / 2, arr);
    }
}