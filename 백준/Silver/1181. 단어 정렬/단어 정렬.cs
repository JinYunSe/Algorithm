using System;
using System.Collections.Generic;

namespace Project
{
    internal class Class1
    {
        static int compare(string i, string j)
        {
            if (i.Length == j.Length) return i.CompareTo(j);
            else return i.Length.CompareTo(j.Length);
        }
        static void Main(string[] args)
        {
            int input = int.Parse(Console.ReadLine());
            List<string> list = new List<string>();
            for (int i = 0; i < input; i++)
            {
                string temp = Console.ReadLine().ToString();
                if (list.Contains(temp)) continue;
                list.Add(temp);
            }
            list.Sort(compare);
            for (int i = 0; i < list.Count; i++)
            {
                Console.WriteLine(list[i]);
            }
        }
    }
}