using System;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            int[] input = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            int[] peo = new int[input[1]];
            for (int i = 0; i < peo.Length; i++) peo[i] = int.Parse(Console.ReadLine());
            Array.Sort(peo); Array.Reverse(peo);
            int result = 0, price = 0, max = 0;
            for(int i = 0; i < peo.Length; i++)
            {
                if (i + 1 > input[0]) result = peo[i] * input[0];
                else result = peo[i] * (i + 1);
                if(max < result)
                {
                    price = peo[i];
                    max = result;
                }
            }
            Console.WriteLine(price + " " + max);
        }
    }
}