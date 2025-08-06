using System;
using System.Collections.Generic;

namespace Project
{
    internal class Class1
    {
        static void Main(string[] args)
        {
            List<int> list = new List<int>();
            for(int i = 1; i <= 30; i++)
            {
                list.Add(i);
            }
            for (int i = 1; i <= 28; i++)
            {
                list.Remove(int.Parse(Console.ReadLine()));
            }
            for(int i = 0; i < list.Count; i++)
            {
                Console.WriteLine(list[i]);
            }
        }
    }
}
