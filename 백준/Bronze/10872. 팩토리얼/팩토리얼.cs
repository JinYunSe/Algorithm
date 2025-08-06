using System;
using System.Collections.Generic;

namespace CodingTest
{
    class Class1
    {
        private static int Factorial(int num)
        {
            if (num == 0 || num == 1) return 1;
            return num * Factorial(num - 1);
        }
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            Console.WriteLine(Factorial(N));
        }
    }
}
