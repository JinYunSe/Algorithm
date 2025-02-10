using System;
using System.Linq;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int min = lottos.Intersect(win_nums).Count();
    
        int max = lottos.Where(element => element == 0).Count();
        
        return new int[] { Math.Min(6, 7 - (max + min)) , Math.Min(6, 7 - (min)) };
    }
}