using System;
using System.Collections.Generic;

namespace CodingTest
{
    class Class1
    {
        public static void Main()
        {
            int[] N = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            char[,] wall = new char[N[0],N[1]];
            for (int i = 0; i < N[0]; i++)
            {
                string temp = Console.ReadLine();
                for(int j = 0; j < N[1]; j++)
                {
                    wall[i, j] = char.Parse(temp[j].ToString());
                }
            }
            int x = 0, y = 0;
            for(int i = 0; i < N[0]; i++)
            {
                bool check = false;
                for(int j = 0; j < N[1]; j++)
                {
                    if (!wall[i, j].Equals('.')) check = true;
                }
                if (!check) x++;
            }
            for (int i = 0; i < N[1]; i++)
            {
                bool check = false;
                for (int j = 0; j < N[0]; j++)
                {
                    if (!wall[j, i].Equals('.')) check = true;
                }
                if (!check) y++;
            }
            Console.WriteLine(Math.Max(x, y));
        }
    }
}