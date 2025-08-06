using System;
using System.Collections.Generic;
using System.Linq;

namespace Project
{
    internal class Class1
    {
        static void Main(string[] args)
        {
            int size = int.Parse(Console.ReadLine());
            List<int> list = new List<int>();
            string numbers = Console.ReadLine().ToString();
            string[] temp = numbers.Split(' ');
            for (int i = 0; i < temp.Length; i++)
            {
                list.Add(int.Parse(temp[i]));
            }
            Console.WriteLine(list.Min() + " " + list.Max());
        }
    }
}