using System;
using System.Numerics;

namespace CodingTest
{
    class Class1
    {

        static void Main(string[] args)
        {
            string[] number = Console.ReadLine().Split();
            Console.WriteLine(BigInteger.Parse(number[0]) + BigInteger.Parse(number[1]));
        }
    }
}
