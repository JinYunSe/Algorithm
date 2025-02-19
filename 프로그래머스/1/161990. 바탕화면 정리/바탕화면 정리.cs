using System;
using System.Collections.Generic;

public class Solution {
    public int[] solution(string[] wallpaper) 
    {
        int startHeight = int.MaxValue, startWidth = int.MaxValue;
        int endHeight = int.MinValue, endWidth = int.MinValue;
        
        for(int i = 0; i < wallpaper.Length; i++)
        {
            string temp = wallpaper[i];
            
            if(!temp.Contains("#")) continue;
            
            int startIndex = temp.IndexOf("#");
            
            if(startIndex != -1)
            {
                startHeight = Math.Min(i, startHeight);
                startWidth = Math.Min(startIndex, startWidth);
            }
            
            int endIndex = temp.LastIndexOf("#");
            
            if(endIndex != -1)
            {
                endHeight = Math.Max(i + 1, endHeight);
                endWidth = Math.Max(endIndex + 1, endWidth);
            }
        }
        
        return new int[] {startHeight, startWidth, endHeight, endWidth};
    }
}