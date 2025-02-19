using System;
using System.Collections.Generic;
using System.Linq;

public class Solution {
    public int solution(int[] ingredient) {
        int[] canMake = new int[] {1,2,3,1};
        
        int count = 0;
        List<int> list = new List<int>();
        
        for(int i =0; i < ingredient.Length; i++)
        {
            list.Add(ingredient[i]);
            
            if(list.Count > 3)
            {
                int[] makeTry = { list[list.Count - 4], list[list.Count - 3], list[list.Count - 2],  list[list.Count - 1] };
                if(canMake.SequenceEqual(makeTry))
                {
                    list.RemoveRange(list.Count - 4, 4);
                    count++;
                }
            }
        }
        
        
        return count;
        
    }
}