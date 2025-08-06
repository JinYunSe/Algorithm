using System;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            string num = Console.ReadLine();
            Console.WriteLine(num.Equals("1 2 3 4 5 6 7 8") ? "ascending" : num.Equals("8 7 6 5 4 3 2 1") ? "descending" : "mixed");
        }
    }
}