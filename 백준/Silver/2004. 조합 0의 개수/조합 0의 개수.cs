using System;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            ulong[] num = Array.ConvertAll(Console.ReadLine().Split(), ulong.Parse);
            ulong[] count = new ulong[2];
            ulong temp = num[0] - num[1];
            for (ulong i = 2; i <= num[0]; i *= 2) count[0] += num[0] / i;
            for (ulong i = 2; i <= temp; i *= 2) count[0] -= temp / i;
            for (ulong i = 2; i <= num[1]; i *= 2) count[0] -= num[1] / i;
            for (ulong i = 5; i <= num[0]; i *= 5) count[1] += num[0] / i;
            for (ulong i = 5; i <= temp; i *= 5) count[1] -= temp / i;
            for (ulong i = 5; i <= num[1]; i *= 5) count[1] -= num[1] / i;
            Console.WriteLine(Math.Min(count[0], count[1]));
        }
    }
}