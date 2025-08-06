using System;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            int[] num = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            int result = num[0] * 60 + num[1] - 45;
            Console.WriteLine(result < 0 ? 23 + " " + (60 + result) : (result / 60) + " " + (result % 60));
        }
    }
}