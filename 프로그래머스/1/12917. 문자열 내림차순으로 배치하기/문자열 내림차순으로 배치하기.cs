public class Solution {
    public string solution(string s) {
        string answer = "";
        char[] a = s.ToCharArray();
        System.Array.Sort(a);
        System.Array.Reverse(a);
        answer = new string(a);
        return answer;
    }
}