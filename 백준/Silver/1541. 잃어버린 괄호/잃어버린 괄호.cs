using System;
using System.Linq;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split('-');
            int result = 0;
            for (int i = 0; i < input.Length; i++) result += (i == 0 ? 1 : -1) * Array.ConvertAll(input[i].Split('+'),int.Parse).Sum();
            Console.WriteLine(result);
        }
    }
}
