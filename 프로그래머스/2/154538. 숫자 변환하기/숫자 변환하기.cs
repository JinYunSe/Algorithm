using System;
using System.Collections.Generic;

public class Solution {
    public int solution(int x, int y, int n) {
        if(x == y) return 0;
        
        HashSet<int> answer = new HashSet<int>() { x + n, x * 2, x * 3 } ;
        int count = 1;
        while(true)
        {
            if(answer.Contains(y)) break;
            count++;
            HashSet<int> temp = new HashSet<int>();
            foreach(int element in answer)
            {
                int result = element + n;
                if(result <= y) temp.Add(result);
                result = element * 2;
                if(result <= y) temp.Add(result);
                result = element * 3;
                if(result <= y) temp.Add(result);
            }
            if(temp.Count == 0) return -1;
            answer = temp;
        }
        
        return count;
    }
}