using System;
using System.Collections.Generic;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            List<int> list = new List<int>();
            int[] peo_count = Array.ConvertAll(Console.ReadLine().Split(),int.Parse);
            for (int i = peo_count.Length - 1; i >= 0; i--) list.Insert(peo_count[i], i + 1);
            for (int i = 0; i < list.Count; i++) Console.Write(list[i]+" ");
        }
    }
}