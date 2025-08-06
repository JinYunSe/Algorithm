using System;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            ulong[] input = Array.ConvertAll(Console.ReadLine().Split(), ulong.Parse);
            ulong[] num = new ulong[input[1]];
            ulong div = input[0] / input[1], rest = input[0] % input[1], result = 1;
            for (ulong i = 0; i < input[1]; i++) num[i] = div;
            for (ulong i = 0; i < rest; i++) num[i] += 1;
            for (ulong i = 0; i < input[1]; i++) result *= num[i];
            Console.WriteLine(result);
        }
    }
}