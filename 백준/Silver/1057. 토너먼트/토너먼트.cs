using System;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            int[] num = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            int count = 0;
            while(num[1] != num[2])
            {
                num[1] = num[1] % 2 + num[1] / 2;
                num[2] = num[2] % 2 + num[2] / 2;
                count++;
            }
            Console.WriteLine(count);
        }
    }
}