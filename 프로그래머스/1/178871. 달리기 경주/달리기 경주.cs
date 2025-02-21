using System;
using System.Linq;
using System.Collections.Generic;

public class Solution {
    public string[] solution(string[] players, string[] callings) 
    {
        Dictionary<string,int> order = new Dictionary<string,int>();
        
        for(int i = 0; i < players.Length; i++)
        {
            order[players[i]] = i;
        }
        
        foreach(string element in callings)
        {
            int currentOrder = order[element];
            string overTakenPlayer = players[currentOrder - 1];
            
            players[currentOrder - 1] = element;
            order[element] = currentOrder - 1;
            players[currentOrder] = overTakenPlayer;
            order[overTakenPlayer] = currentOrder;
        }

        return players;
    }
}