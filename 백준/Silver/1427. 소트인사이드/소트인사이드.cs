using System;
using System.Collections.Generic;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            int[] number = new int[input.Length];
            for (int i = 0; i < number.Length; i++) number[i] = int.Parse(input[i].ToString());
            Array.Sort(number); Array.Reverse(number);
            for (int i = 0; i < number.Length; i++) Console.Write(number[i]);
        }
    }
}
