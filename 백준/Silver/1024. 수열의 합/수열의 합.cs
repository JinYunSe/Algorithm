using System;
using System.Collections.Generic;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            int[] N = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            
            while (N[1] <= 100)
            {
                int start = (N[0] / N[1] - N[1]) > 0 ? N[0] / N[1] - N[1] : 0;
                int finish = (N[0] / N[1]) + (N[1] / 2);
                for(int i = start; i < finish; i++)
                {
                    int temp = 0;
                    for(int j = 0; j < N[1]; j++) temp += (i + j);
                    if (N[0] == temp)
                    {
                        Print(i, N[1]);
                        return;
                    }
                }
                N[1]++;
            }
            Console.WriteLine(-1);
        }

        private static void Print(int i, int N)
        {
            for (int j = 0; j < N; j++) Console.Write((i + j)+" ");
        }
    }
}