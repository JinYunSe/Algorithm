using System;
using System.Collections.Generic;

public class Solution {
    public int solution(string s) 
    {
        if(s.Length % 2 == 1) return 0;
        
        Stack<char> stack = new Stack<char>();
        int count = 0;
        
        string currentString = s;
        
        for (int i = 0; i < s.Length; i++) 
        {
            bool check = true;
            stack.Clear();

            for(int j = 0; j < currentString.Length; j++)
            {
                if(currentString[j] == '[' || currentString[j] == '{' || currentString[j] == '(')
                    stack.Push(currentString[j]);
                else
                {
                    if (stack.Count == 0) 
                    {
                        check = false;
                        break;
                    }
                    
                    char open = stack.Pop();
                    if(open == '[' && currentString[j] == ']') continue;
                    else if(open == '{' && currentString[j] == '}') continue;
                    else if(open == '(' && currentString[j] == ')') continue;
                    
                    check = false;
                    break;
                }
            }
            if(check) count++;
            
            currentString = currentString.Substring(1) + currentString[0];
        }
        
        return count;
    }
}
