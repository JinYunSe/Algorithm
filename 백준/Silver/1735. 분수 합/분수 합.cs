using System;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            int[] num1 = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            int[] num2 = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            int denominator = num1[1] * num2[1];
            int molecule = num1[0] * num2[1] + num2[0] * num1[1];
            int count = 2, result = 1;
            int div = Euclidean(denominator, molecule);
            Console.WriteLine(molecule / div + " " + denominator / div);
        }

        private static int Euclidean(int denominator, int molecule)
        {
            while (true)
            {
                int temp = molecule;
                molecule = denominator % molecule;
                denominator = temp;
                if (molecule == 0) break;
            }
            return denominator;
        }
    }
}