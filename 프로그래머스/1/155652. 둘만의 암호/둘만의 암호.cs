using System;
using System.Linq;

public class Solution {
    public string solution(string s, string skip, int index) 
    {
        int[] charSkip = skip.Select(element => (int)element).ToArray();
        
                
        //Console.WriteLine("a :"+(int)'a');
        //Console.WriteLine("z :"+(int)'z');
        
        string temp = "";
        for(int i = 0; i < s.Length; i++)
        {
            int AsCode = (int)s[i];
            
            for(int j = 0; j < index; j++)
            {
                if(++AsCode > 122) AsCode = 97;
                if(charSkip.Contains(AsCode)) j--;
            }
            temp += (char)AsCode;
        }
        
        return temp;
    }
}