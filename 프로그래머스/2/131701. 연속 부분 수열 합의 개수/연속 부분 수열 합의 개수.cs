using System;
using System.Linq;
using System.Collections.Generic;

public class Solution {
    public int solution(int[] elements) {
        HashSet<int> hashSet = new HashSet<int>();
        List<int> list = new List<int>(elements);
        
        for(int i = 0; i < list.Count; i++)
        {
            int sum = 0;
            for(int j = 0; j < list.Count; j++)
            {
                sum += list[j];
                hashSet.Add(sum);
            }
            int temp = list[0];
            list.RemoveAt(0);
            list.Add(temp);
        }
        
        return hashSet.Count;
    }
}