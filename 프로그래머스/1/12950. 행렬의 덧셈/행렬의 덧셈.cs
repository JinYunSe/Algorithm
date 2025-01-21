using System.Linq;

public class Solution {
    public int[,] solution(int[,] arr1, int[,] arr2) 
    {
        for(int i = 0; i < arr1.GetLength(0); i++)
        {
            for(int j = 0; j < arr1.GetLength(1); j++)
                arr1[i,j] += arr2[i,j];
        }
        return arr1;
    }
}