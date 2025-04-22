using System;

public class Solution {
    
    private int[] answer = new int[] {0,0};
    
    public int[] solution(int[,] arr) 
    {
        QuadCompression(0,0,arr.GetLength(0), arr);
        return answer;
    }
    
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
        
        QuadCompression(x, y, len / 2, arr);
        QuadCompression(x + len / 2, y, len / 2, arr);
        QuadCompression(x, y + len / 2, len / 2, arr);
        QuadCompression(x + len / 2, y + len / 2, len / 2, arr);
    }
}