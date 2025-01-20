using System;
using System.Linq;

public class Solution 
{
    public int solution(int[] a, int[] b) {
        return a.Select((element, index)=> element * b[index]).Sum();
    }
}