using System;
using System.Collections.Generic;

namespace CodingTest
{
    class Class1
    { 
        public static void Main()
        {
            int N = int.Parse(Console.ReadLine());
            int[] A = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            int min = 1000000, max = 1;
            for (int i = 0; i < A.Length; i++)
            {
                if (min > A[i]) min = A[i];
                if (max < A[i]) max = A[i];
            }
            int number = min * max;
            int count = 0;
            for(int i = 0; i < A.Length; i++)
            {
                if (number % A[i] == 0) count++;
            }
            if (count == N) Console.WriteLine(number);
        }
    }
}