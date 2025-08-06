using System;
using System.Collections.Generic;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            List<int> list = new List<int>();
            for (int i = 0; i < 5; i++) list.Add(int.Parse(Console.ReadLine()));
            list.Sort();
            int sum = 0;
            for (int i = 0; i < list.Count; i++) sum += list[i];
            Console.WriteLine(sum / 5);
            Console.WriteLine(list[2]);
        }
    }
}
