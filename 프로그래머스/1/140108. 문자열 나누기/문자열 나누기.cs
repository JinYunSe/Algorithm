using System;

public class Solution 
{
    public int solution(string s) 
    {
        char[] temp = s.ToCharArray();
        // char 배열 형식으로 변환
        int count = 0;
        // 개수
        
        char first = temp[0];
        // 첫 번째 단어
        
        int same = 0, diff = 0;
        // 같은 개수, 다른 개수
        
        for(int i = 0; i < temp.Length; i++)
        {
            if(first == temp[i]) same++;
            else diff++;
            
            if(same == diff)
            {
                count++;
                if(i + 1 < temp.Length) first = temp[i + 1];
                
                
                same = 0;
                diff = 0;
            }
        }
        
        if(same > 0 || diff > 0) count++;
        
        return count;
    }
}