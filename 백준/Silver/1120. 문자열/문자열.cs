using System;
using System.Collections.Generic;
using System.Linq;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            string[] input = Console.ReadLine().ToLower().Split();
            if (input[0].Length > input[1].Length)
            {
                string temp = input[0];
                input[0] = input[1];
                input[1] = temp;
            }
            int len = input[1].Length - input[0].Length, min = 51;
            for(int i = 0; i < len + 1; i++)
            {
                string temp = null;
                int count = 0;
                for (int first = len - i; first > 0; first--) temp += "%";
                temp += input[0];
                for (int last = 0; last < i; last++) temp += "%";
                for(int j = 0; j < input[1].Length; j++)
                {
                    if (temp[j].Equals('%')) continue;
                    else if (!temp[j].Equals(input[1][j])) count++;
                }
                min = Math.Min(count, min);
            }
            Console.WriteLine(min);
        }
    }
}