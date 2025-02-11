using System;

public class Solution {
    public int solution(string[] babbling) {
        int answer = 0;
        string[] canSpeak = {"aya", "ye", "woo", "ma"};

           for(int i= 0; i < babbling.Length; i++)
           {
                for(int j = 0; j < canSpeak.Length; j++)
                {
                    babbling[i] = babbling[i].Replace(canSpeak[j] + canSpeak[j], "#");
                    // 연속 발음으로 불가능한 경우 "#"으로 변경
                    
                    babbling[i] = babbling[i].Replace(canSpeak[j], " ");
                    // 발음 가능한 경우 ""으로 변경
                }
                if(babbling[i].Trim().Length == 0) answer++;
                // 길이가 0 즉, "#"이나 발음 불가능한 단어가 없을 경우 1 증가
           }
        return answer;
    }
}
