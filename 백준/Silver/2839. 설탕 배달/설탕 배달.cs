using System;
using System.Collections.Generic;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            int sugar = int.Parse(Console.ReadLine());
            List<int> list = new List<int>();
            List<int> count = new List<int>();
            list.Add(3); count.Add(1);
            list.Add(5); count.Add(1);
            int index = 2;
            do
            {
                if (!list.Contains(list[index - 2] + 3))
                {
                    list.Add(list[index - 2] + 3);
                    count.Add(count[index - 2] + 1);
                }
                if (!list.Contains(list[index - 2] + 5))
                {
                    list.Add(list[index - 2] + 5);
                    count.Add(count[index - 2] + 1);
                }
                index++;
            } while (list[index - 2] <= sugar);
            bool check = true;
            for(int i = 0; i < list.Count; i++)
            {
                if(list[i] == sugar)
                {
                    Console.WriteLine(count[i]);
                    check = false;
                }
            }
            if (check) Console.WriteLine(-1);
        }
    }
}
