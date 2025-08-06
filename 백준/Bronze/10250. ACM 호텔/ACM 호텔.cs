using System;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            int test = int.Parse(Console.ReadLine()),x,y;
            int[] result = new int[test];
            for(int i = 0; i < result.Length; i++)
            {
                int[] peo = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
                y = peo[2] % peo[0];
                x = peo[2] / peo[0];
                if (y == 0) y = peo[0];
                else x += 1;
                result[i] = y * 100 + x;
            }
            for (int i = 0; i < result.Length; i++)
            {
                Console.WriteLine(result[i]);
            }
        }
    }
}
