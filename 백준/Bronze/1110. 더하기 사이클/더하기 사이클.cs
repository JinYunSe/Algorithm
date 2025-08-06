using System;

namespace CodingTest
{
    class Class1
    {
        public static void Main()
        {
            int N = int.Parse(Console.ReadLine());
            int result = N;
            for (int i = 0; ; i++)
            {
                int ten = result / 10;
                int one = result % 10;
                result = ten + one;
                if (result < 10) result += one * 10;
                else result =  one * 10 + result % 10;
                if (N == result)
                {
                    Console.WriteLine(i+1);
                    break;
                }
            }
        }
    }
}