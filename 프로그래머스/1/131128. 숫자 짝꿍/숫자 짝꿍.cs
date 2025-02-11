using System;
using System.Linq;
using System.Collections.Generic;

public class Solution {
    public string solution(string X, string Y) 
    {
        int[] tempX = new int[10];
        int[] tempY = new int[10];
        
        for(int i = 0; i < X.Length; i++) tempX[int.Parse(X[i].ToString())]++;
        for(int i = 0; i < Y.Length; i++) tempY[int.Parse(Y[i].ToString())]++;
        
        string result = "";
        
        for(int i = 9; i >= 0; i--)
        {
            if(tempX[i] == 0 || tempY[i] == 0) continue;
            int count = Math.Min(tempX[i], tempY[i]);
            result += string.Concat(Enumerable.Repeat(i, count));
        }
        
        if(result.Length == 0) result = "-1";
        if(result.Substring(0,1) == "0") result = "0";
        
        return result;
    }
}