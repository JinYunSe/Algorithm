using System;
using System.Linq;

public class Solution {
    public int[] solution(string[] park, string[] routes) 
    {
        int[] startPoint = new int[2];

        for (int i = 0; i < park.Length; i++)
        {
            int col = park[i].IndexOf('S');
            if(col != -1)
            {
                startPoint[0] = i;
                startPoint[1] = col;
                break;
            }
        }
        
        for(int i = 0; i < routes.Length; i++)
        {
            string[] direction = routes[i].Split(' ');
            
            int upDown = 0, leftRigth = 0;
            switch(direction[0])
            {
                case "N":
                    upDown--;
                    break;
                case "S":
                    upDown++;
                    break;
                case "W":
                    leftRigth--;
                    break;
                case "E":
                    leftRigth++;
                    break;
            }
            
            bool canMove = true;
            
            int nextUpDown = startPoint[0];
            int nextLeftRigth = startPoint[1];
            
            int nextMove = int.Parse(direction[1]);
            for(int j = 0; j < nextMove; j++)
            {
                nextUpDown += upDown;
                nextLeftRigth += leftRigth;
                if (nextUpDown < 0 || nextUpDown >= park.Length || 
                    nextLeftRigth < 0 || nextLeftRigth >= park[0].Length || 
                    park[nextUpDown][nextLeftRigth] == 'X')
                {
                    canMove = false;
                    break;
                }

            }
            
            // 최종 위치로 이동
            if (canMove)
            {
                startPoint[0] = nextUpDown;
                startPoint[1] = nextLeftRigth;
            }
        }
        
        return startPoint;
    }
}
