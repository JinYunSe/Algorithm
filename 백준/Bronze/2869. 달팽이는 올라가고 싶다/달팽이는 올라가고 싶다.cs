using System;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            double[] num = new double[3];
            for(int i = 0; i < num.Length; i++) num[i] = double.Parse(input.Split()[i]);
            num[2] -= num[0]; 
            num[2] /= (num[0] - num[1]); 
            Console.WriteLine(Math.Ceiling(num[2]) + 1);
        }
    }
}