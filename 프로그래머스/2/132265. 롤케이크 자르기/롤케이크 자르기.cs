using System;
using System.Linq;
using System.Collections.Generic;

public class Solution {
    public int solution(int[] topping) 
    {
        int count = 0;
        Dictionary<int, int> oldBrother = new Dictionary<int, int>();
        Dictionary<int, int> youngerBrother = new Dictionary<int, int>();
        
        
        for(int i = 0; i < topping.Length; i++)
        {
            if(!oldBrother.ContainsKey(topping[i])) oldBrother[topping[i]] = 1;
            else oldBrother[topping[i]]++;
        }
        
        for(int i = 0; i < topping.Length; i++)
        {            
            if(!youngerBrother.ContainsKey(topping[i])) youngerBrother[topping[i]] = 1;
            else youngerBrother[topping[i]]++;
            
            if(oldBrother[topping[i]] > 1) oldBrother[topping[i]] -= 1;
            else if(oldBrother[topping[i]] == 1) oldBrother.Remove(topping[i]);
            
            if(youngerBrother.Count == oldBrother.Count) count++;
        }
        
        return count;
    }
}