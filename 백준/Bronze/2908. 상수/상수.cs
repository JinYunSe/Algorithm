using System;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string[] temp = input.Split(' ');
            int[] numbers = new int[2];
            for(int i = 0; i < numbers.Length; i++)
            {
                numbers[i] += int.Parse(temp[i][2].ToString()) * 100;
                numbers[i] += int.Parse(temp[i][1].ToString()) * 10;
                numbers[i] += int.Parse(temp[i][0].ToString()) * 1;
            }
            int big = numbers[0] > numbers[1] ? numbers[0] : numbers[1];
            Console.WriteLine(big);
        }
    }
}
