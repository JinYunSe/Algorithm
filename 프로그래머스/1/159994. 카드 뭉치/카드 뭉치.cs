using System;
using System.Collections.Generic;

public class Solution 
{
    public string solution(string[] cards1, string[] cards2, string[] goal) 
    {
        Queue<string> queue1 = new Queue<string>(cards1);
        Queue<string> queue2 = new Queue<string>(cards2);
        
        bool check = true;
        for(int i = 0; i < goal.Length; i++)
        {
            if(queue1.Count > 0 && goal[i].Equals(queue1.Peek())) queue1.Dequeue();
            else if(queue2.Count > 0 && goal[i].Equals(queue2.Peek())) queue2.Dequeue();
            else
            {
                check = false;
                break;
            }
        }
        return check ? "Yes" : "No";
    }
}