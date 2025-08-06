using System;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine()), result2 = -1;
            int[] input = new int[n];
            for (int i = 0; i < n; i++) input[i] = int.Parse(Console.ReadLine());
            Array.Sort(input);
            for(int i = 0; i < input.Length - 2; i++)
            {
                int sum = input[i] + input[i + 1];
                if (sum > input[i + 2]) result2 = Math.Max(sum, sum + input[i + 2]);
            }
            Console.WriteLine(result2);
        }
    }
}