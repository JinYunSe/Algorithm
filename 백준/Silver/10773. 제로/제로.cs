using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            List<int> list = new List<int>();
            int K = int.Parse(Console.ReadLine());
            for (int i = 0; i < K; i++)
            {
                int temp = int.Parse(Console.ReadLine());
                if (temp == 0) list.RemoveAt(list.Count - 1);
                else list.Add(temp);
            }
            Console.WriteLine(list.Sum());
        }
    }
}
