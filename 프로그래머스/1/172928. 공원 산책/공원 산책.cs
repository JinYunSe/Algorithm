using System;
using System.Linq;

public class Solution {
    public int[] solution(string[] park, string[] routes) 
    {
        int[] startPoint = new int[2];
        bool found = false;
        for (int i = 0; i < park.Length; i++)
        {
            int col = park[i].IndexOf('S');
            if(col != -1)
            {
                startPoint = new int[] { i, col };
                found = true;
                break;
            }
        }
        
        foreach (string route in routes)
        {
            string[] parts = route.Split(' ');
            char position = parts[0][0];
            int move = int.Parse(parts[1]);

            // 이동 방향
            int upDown = 0, leftRight = 0;
            switch (position)
            {
                case 'N': upDown = -1; break;
                case 'S': upDown = 1; break;
                case 'W': leftRight = -1; break;
                case 'E': leftRight = 1; break;
            }

            // 이동 가능한지 검사
            bool canMove = true;
            int nextUpDown = startPoint[0];
            int nextLeftRigth = startPoint[1];

            for (int j = 0; j < move; j++)
            {
                nextUpDown += upDown;
                nextLeftRigth += leftRight;

                if (nextUpDown < 0 || nextUpDown >= park.Length || 
                    nextLeftRigth < 0 || nextLeftRigth >= park[0].Length || 
                    park[nextUpDown][nextLeftRigth] == 'X')
                {
                    canMove = false;
                    break;
                }
            }

            // 안전하면 최종 위치로 이동
            if (canMove)
            {
                startPoint[0] = nextUpDown;
                startPoint[1] = nextLeftRigth;
            }
        }

        return startPoint;
    }
}
