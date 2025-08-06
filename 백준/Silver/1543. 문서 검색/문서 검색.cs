using System;
using System.Collections.Generic;
using System.Linq;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string check = Console.ReadLine();
            int count = 0;
            string temp = null;
            for(int i = 0; i < input.Length; i++)
            {
                temp += input[i];
                if (temp.Contains(check))
                {
                    count++;
                    temp = null;
                }
            }
            Console.WriteLine(count);
        }
    }
}