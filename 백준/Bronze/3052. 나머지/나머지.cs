using System;
using System.Collections.Generic;

namespace Project
{
    internal class Class1
    {
        static void Main(string[] args)
        {
            List<int> list = new List<int>(10);

            int num;
            for (int i = 0; i < 10; i++)
            {
                num = int.Parse(Console.ReadLine());
                num %= 42;
                if (!list.Contains(num)) list.Add(num);
            }

            Console.WriteLine(list.Count);
        }
    }
}