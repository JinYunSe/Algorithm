using System;
using System.Collections.Generic;

public class Solution {
    public char[] alpabet = {'A', 'E', 'I', 'O', 'U'};
    public List<string> list = new List<string>();
    
    public void DFS(string currentWords)
    {
        if(currentWords.Length > 5) return;
        
        list.Add(currentWords);
        
        for(int i = 0; i < alpabet.Length; i++)
            DFS(currentWords + alpabet[i]);
        
        return;
    }
    
    public int solution(string word) {
        DFS("");
        return list.IndexOf(word);
    }
}