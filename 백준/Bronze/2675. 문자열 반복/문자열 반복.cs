using System;
namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            int input = int.Parse(Console.ReadLine());
            string[] line = new string[input];
            for (int i = 0; i < input; i++)
            {
                line[i] = Console.ReadLine();
            }
            for(int i = 0; i < input; i++) {
                for(int j = 2; j < line[i].Length; j++)
                {
                    for(int k = 0; k < int.Parse(line[i].Split()[0]); k++)
                    {
                        Console.Write(line[i][j]);
                    }
                }
                Console.WriteLine();
            }
        }
    }
}
