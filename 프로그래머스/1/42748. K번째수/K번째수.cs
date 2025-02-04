using System;
using System.Linq;

public class Solution {
    public int[] solution(int[] array, int[,] commands) 
    {
        int[] result = new int[commands.GetLength(0)];
        
        for(int i = 0; i < result.Length; i++)
        {
            int startIndex = commands[i,0] - 1;
            int count = commands[i,1] - startIndex;
            int findIndex = commands[i,2] - 1;
            int temp = array.Skip(startIndex).Take(count).OrderBy(element => element).ToArray()[findIndex];
            result[i] = temp;
        }
        
        return result;
    }
}