using System;
using System.Linq;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int min = 0;
        for(int i = 0; i < win_nums.Length; i++)
            min += lottos.Where(element => element == win_nums[i]).Count();
        
        int max = min + lottos.Where(element => element == 0).Count();
        
        if(max == 0 || max == 1) max = 6;
        else max = 6 - max + 1;
        if(min == 0 || min == 1) min = 6;
        else min = 6 - min + 1;
        
        return new int[] { max, min };
    }
}