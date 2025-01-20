using System.Linq;

public class Solution {
    public string solution(string s)
    {
        return string.Join("",s.Select((element)=> (int)element).OrderByDescending((element)=> element).Select((element)=> (char)element).ToArray());    
    }
}