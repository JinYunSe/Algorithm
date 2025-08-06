using System;


namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            int input = int.Parse(Console.ReadLine());
            if (input == 1) return;
            int div = 2;
            while (input != 1)
            {
                if (input % div == 0)
                {
                    Console.WriteLine(div);
                    input /= div;
                }
                else div++;
            }
        }
    }
}
