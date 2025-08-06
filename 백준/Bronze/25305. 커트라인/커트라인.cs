using System;
using System.Collections.Generic;
using System.Linq;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            string[] temp = Console.ReadLine().Split();
            int[] count = Array.ConvertAll(temp, int.Parse);
            string[] score_temp = Console.ReadLine().Split();
            List<int> list = new List<int>(Array.ConvertAll(score_temp,int.Parse));
            list.Sort();
            list.Reverse();
            Console.WriteLine(list[count[1]-1]);
        }
    }
}
