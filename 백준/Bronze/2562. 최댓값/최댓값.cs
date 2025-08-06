using System;
using System.Collections.Generic;
using System.Linq;

namespace Project
{
    internal class Class1
    {
        static void Main(string[] args)
        {
            List<int> list = new List<int>();
            for(int i = 0; i < 9; i++)
            {
                list.Add(int.Parse(Console.ReadLine()));
            }
            Console.WriteLine(list.Max());
            Console.WriteLine(list.IndexOf(list.Max()) + 1);
        }
    }
}
