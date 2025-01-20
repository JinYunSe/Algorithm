using System.Linq;

public class Solution {
    public string solution(string s) {
        return string.Concat(s.OrderByDescending(element => element));
    }
}