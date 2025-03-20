using System;
using System.Collections.Generic;

public class Solution {
    public char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    public List<string> list = new List<string>();
    
    public void DFS(string currentWord, int len)
    {
        if(len > 5) return;
        
        list.Add(currentWord);
        
        for(int i = 0; i < alphabet.Length; i++)
            DFS(currentWord + alphabet[i], len + 1);
        
        return;
    }
    
    public int solution(string word) {
        DFS("", 0);
        return list.IndexOf(word);
    }
}