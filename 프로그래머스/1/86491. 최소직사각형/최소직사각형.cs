using System;

public class Solution {
    public int solution(int[,] sizes) 
    {
        int width = 0, height = 0;
        for(int i = 0; i < sizes.GetLength(0); i++)
        {
            width = Math.Max(width,Math.Max(sizes[i, 0], sizes[i, 1]));
            height = Math.Max(height,Math.Min(sizes[i, 0], sizes[i, 1]));
        }
        return width * height;
    }
}