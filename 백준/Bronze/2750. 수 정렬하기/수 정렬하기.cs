using System;
using System.Collections.Generic;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            int testcase = int.Parse(Console.ReadLine());
            List<int> list = new List<int>();
            for (int i = 0; i < testcase; i++) list.Add(int.Parse(Console.ReadLine()));
            list.Sort();
            for (int i = 0; i < list.Count; i++) Console.WriteLine(list[i]);
        }
    }
}
