using System;
using System.Collections.Generic;
using System.Text;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            int[] num = new int[3];
            for (int i = 0; i < num.Length; i++) num[i] = int.Parse(Console.ReadLine());
            string result = (num[0] * num[1] * num[2]).ToString();
            int[] count = new int[10];
            for (int i = 0; i < result.Length; i++) count[int.Parse(result[i].ToString())] += 1;
            for (int i = 0; i < count.Length; i++) Console.WriteLine(count[i]);
        }
    }
}