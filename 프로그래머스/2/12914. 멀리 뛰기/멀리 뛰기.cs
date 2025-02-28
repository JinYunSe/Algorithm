using System;
using System.Collections.Generic;


public class Solution {
    public long solution(int n) {
        List<int> list = new List<int>() {1, 2};
        
        for(int i = 2; i < n; i++)
            list.Add((list[i - 1] + list[i - 2]) % 1234567);
        
        
        return list[n - 1];
    }
}