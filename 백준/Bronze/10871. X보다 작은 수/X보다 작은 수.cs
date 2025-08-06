using System;
using System.Collections.Generic;

namespace Project
{
    internal class Class1
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine().ToString();
            int size = int.Parse(input.Split(' ')[0]);
            int limit = int.Parse(input.Split(' ')[1]);
            List<int> list = new List<int>();
            string[] temp = Console.ReadLine().ToString().Split(' ');
            for (int i = 0; i < size; i++)
            {
                list.Add(int.Parse(temp[i]));
            }
            for(int i = 0;i < list.Count; i++)
            {
                if (list[i] < limit) Console.Write(list[i]+" ");
            }
        }
    }
}
