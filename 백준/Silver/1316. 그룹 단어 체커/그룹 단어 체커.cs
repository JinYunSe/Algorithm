using System;

namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            int input = int.Parse(Console.ReadLine());
            string[] word = new string[input];
            for (int i = 0; i < input; i++)
            {
                word[i] = Console.ReadLine();
            }
            int count = 0;
            for(int i = 0; i < word.Length; i++)
            {
                if (CheckGroup(word[i])) count++;
            }
            Console.WriteLine(count);
        }

        private static bool CheckGroup(string word)
        {
            for(int i = 0; i < word.Length; i++)
            {
                for(int j = i + 1; j < word.Length; j++)
                {
                    if (word[i].Equals(word[j])&&(i + 1) == j)
                    {
                        i = j;
                        continue;
                    }
                    if (word[i].Equals(word[j])) return false;
                }
            }
            return true;
        }
    }
}
