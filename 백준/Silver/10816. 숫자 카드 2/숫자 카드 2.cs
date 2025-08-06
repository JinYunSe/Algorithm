using System;
using System.Collections.Generic;
using System.Text;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            StringBuilder stringBuilder = new StringBuilder();
            Dictionary<int, int> dictionary = new Dictionary<int, int>();
            int temp = int.Parse(Console.ReadLine());
            int[] card = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            for (int i = 0; i < card.Length; i++)
            {
                if (!dictionary.ContainsKey(card[i])) dictionary.Add(card[i], 1);
                else dictionary[card[i]] += 1;
            }
            temp = int.Parse(Console.ReadLine());
            int[] find_key = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            for (int i = 0; i < find_key.Length; i++)
            {
                if (dictionary.ContainsKey(find_key[i])) stringBuilder.Append(dictionary[find_key[i]] + " ");
                else stringBuilder.Append("0 ");
            }
            Console.WriteLine(stringBuilder.ToString());
        }
    }
}