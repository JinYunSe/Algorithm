using System;
using System.Linq;

public class Solution {
    public int solution(int[] absolutes, bool[] signs) {
        return absolutes.Select((element, index)=> signs[index] ? element : -1 * element).Sum();
    }
}