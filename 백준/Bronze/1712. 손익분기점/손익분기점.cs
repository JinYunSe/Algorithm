using System;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            int[] price = new int[3];
            for (int i = 0; i < price.Length; i++) price[i] = int.Parse(input.Split()[i]);
            int gain = price[2] - price[1];
            if(gain <= 0)
            {
                Console.WriteLine(-1);
                return;
            }
            int j = -1;
            while (true)
            {
                if (gain * j > price[0]) break;
                j++;
            }
            Console.WriteLine(j);
        }
    }
}
