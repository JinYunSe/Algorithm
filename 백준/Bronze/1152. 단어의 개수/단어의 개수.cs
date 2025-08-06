using System;
using System.Collections.Generic;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            List<string> line = new List<string>(Console.ReadLine().Split());
            line.RemoveAll(string.IsNullOrEmpty);
            Console.WriteLine(line.Count);
        }
    }
}
