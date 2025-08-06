using System;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string[] numbers = { "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };
            int time = 0;
            for(int i = 0; i < input.Length; i++)
            {
                for(int j = 0; j < numbers.Length; j++)
                {
                    if (numbers[j].Contains(input[i].ToString())) time += (3 + j);
                }
            }
            Console.WriteLine(time);
        }
    }
}
