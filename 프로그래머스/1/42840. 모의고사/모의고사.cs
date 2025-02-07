using System;
using System.Linq;
using System.Collections.Generic;

public class Solution {
    public int[] solution(int[] answers) {
        int[] one = new int[] { 1,2,3,4,5 };
        int[] two = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] three = new int[] { 3,3,1,1,2,2,4,4,5,5 };
        
        int[] count = new int[3];
        for(int i = 0; i < answers.Length; i++)
        {
            if(answers[i] == one[i % one.Length]) count[0]++;
            if(answers[i] == two[i % two.Length]) count[1]++;
            if(answers[i] == three[i % three.Length]) count[2]++;
        }
        
        List<int> list = new List<int>();
        int max = count.Max();
        for(int i = 0; i < count.Length; i++)
        {
            if(count[i] == max) list.Add(i + 1);
        }
        
        return list.ToArray();
    }
}