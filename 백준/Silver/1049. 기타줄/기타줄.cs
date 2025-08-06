using System;
using System.Collections.Generic;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            int[] N = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            int result = 0;
            int[,] price = new int[N[1], 2];
            for(int i = 0; i < N[1]; i++)
            {
                string temp = Console.ReadLine();
                price[i, 0] = int.Parse(temp.Split()[0]);
                price[i, 1] = int.Parse(temp.Split()[1]);
            }
            int bundle_min = price[0, 0], one_min = price[0,1];
            for(int i = 0; i < N[1]; i++)
            {
                if (bundle_min > price[i, 0]) bundle_min = price[i, 0];
                if (one_min > price[i, 1]) one_min = price[i, 1];
            }
            while (N[0] != 0)
            {
                if(N[0] < 6)
                {
                    result += N[0] * one_min > bundle_min ? bundle_min : N[0] * one_min;
                    N[0] = 0;
                }
                else
                {
                    result += bundle_min > 6 * one_min ? 6 * one_min : bundle_min;
                    N[0] -= 6;
                }
            }
            Console.WriteLine(result);
        }
    }
}