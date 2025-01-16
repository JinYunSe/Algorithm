using System;
using System.Linq;

public class Solution {
    public int[] solution(int[] arr, int divisor) 
    {
        int[] temps = arr.Where(element => element % divisor == 0).OrderBy(element => element).ToArray();
        return temps.Length == 0 ? new int[] { -1 } : temps; 
    }
}