using System;

public class Solution {
    public int[] solution(int[,] arr) {
        for(int i = 0; i < arr.GetLength(0); i++)
        {
            for(int j = 0; j < arr.GetLength(1); j++)
            {
                Console.Write(arr[i,j]+" ");
            }
            Console.WriteLine();
        }
        
        return new int[] {};
    }
}