using System;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            int[,] apart = new int[16, 15];
            for (int i = 0; i < 16; i++) apart[i, 0] = 1;
            for (int j = 0; j < 15; j++) apart[0, j] = j + 1;
            for (int i = 1; i < 16; i++)
            {
                for (int j = 1; j < 15; j++)
                {
                    for (int k = 0; k <= j; k++) apart[i, j] += apart[i - 1, k];
                }
            }
            int count = int.Parse(Console.ReadLine());
            int[] floor = new int[count];
            int[] room = new int[count];
            for(int i = 0; i < count; i++)
            {
                floor[i] = int.Parse(Console.ReadLine());
                room[i] = int.Parse(Console.ReadLine()) - 1;
            }
            for (int i = 0; i < count; i++) Console.WriteLine(apart[floor[i], room[i]]);
        }
    }
}
