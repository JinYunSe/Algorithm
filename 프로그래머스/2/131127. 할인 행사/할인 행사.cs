using System;
using System.Linq;
using System.Collections.Generic;

public class Solution {
    public int solution(string[] want, int[] number, string[] discount) {
        int answer = 0;
        
        Dictionary<string,int> dict = new Dictionary<string,int>();
        
        for(int i = 0; i < want.Length; i++)
            dict[want[i]] = number[i];
        
        for(int i = 0; i <= discount.Length - 10; i++)
        {
            Dictionary<string, int> totalSale = new Dictionary<string, int>();
            
            for(int j = i; j < i + 10; j++)
            {
                if(!totalSale.ContainsKey(discount[j])) totalSale[discount[j]] = 1;
                else totalSale[discount[j]]++;
            }
            
            bool check = true;
            for(int j = 0; j < want.Length; j++)
            {
                if(!totalSale.ContainsKey(want[j]) || dict[want[j]] != totalSale[want[j]])
                {
                    check = false;
                    break;
                }
            }
            if(check) answer++;
        }
        
        return answer;
    }
}
