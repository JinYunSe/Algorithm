using System;
using System.Collections.Generic;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine()),result = 0;
            int[] A = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            int[] B = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            Array.Sort(A); Array.Sort(B);
            for (int i = 0; i < A.Length; i++) result += A[i] * B[B.Length - 1 - i];
            Console.WriteLine(result);
        }
    }
}