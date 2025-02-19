using System;
using System.Collections.Generic;

public class Solution {
    public string solution(string[] survey, int[] choices) {
        Dictionary<char, int> dict = new Dictionary<char, int>();
        
        dict['R'] = 0;
        dict['T'] = 0;
        dict['C'] = 0;
        dict['F'] = 0;
        dict['J'] = 0;
        dict['M'] = 0;
        dict['A'] = 0;
        dict['N'] = 0;
        
        for(int i = 0; i < choices.Length; i++)
        {
            if(choices[i] == 4) continue;
            
            char[] key = survey[i].ToCharArray();
            
            switch(choices[i])
            {
                case 1:
                case 2:
                case 3:
                    dict[key[0]] += 4 - choices[i];
                    break;
                case 5:
                case 6:
                case 7:
                    dict[key[1]] += choices[i] - 4;
                    break;
            }
        }
        
        string personality = dict['R'] == dict['T'] || dict['R'] > dict['T'] ? "R" : "T";
        
        personality += dict['C'] == dict['F'] || dict['C'] > dict['F'] ? "C" : "F";
        personality += dict['J'] == dict['M'] || dict['J'] > dict['M'] ? "J" : "M";
        personality += dict['A'] == dict['N'] || dict['A'] > dict['N'] ? "A" : "N";
        
        return personality;
    }
}