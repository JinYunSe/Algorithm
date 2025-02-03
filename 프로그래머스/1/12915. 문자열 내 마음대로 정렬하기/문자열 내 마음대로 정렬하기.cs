using System.Linq;

public class Solution {
    public string[] solution(string[] strings, int n) 
    {
        return strings.OrderBy(element => element[n]).ThenBy(element => element).ToArray();
    }
}