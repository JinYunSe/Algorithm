using System;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            string[] croatia_language = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
            string input = Console.ReadLine();
            for(int i = 0; i < croatia_language.Length; i++)
            {

                input = input.Replace(croatia_language[i], "%");
            }

            Console.WriteLine(input.Length);
        }
    }
}
