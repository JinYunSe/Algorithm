using System;
using System.Collections.Generic;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine()),search = 1;
            while (search <= N)
            {
                int temp = search;
                for (int i = 0; i < search.ToString().Length; i++) temp += int.Parse(search.ToString()[i].ToString());
                if(temp == N)
                {
                    Console.WriteLine(search);
                    return;
                }
                search++;
            }
            Console.WriteLine(0);
        }
    }
}