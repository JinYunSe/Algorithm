using System;
namespace CodingTest
{
    class Class1
    {
        static void Main(string[] args)
        {
            char[] alpabat = new char[26];
            int[] position = new int[26];
            for(int i = 0; i < alpabat.Length; i++)
            {
                alpabat[i] = Convert.ToChar(i + 97);
                position[i] = -1;
            }
            string input = Console.ReadLine();
            for (int i = 0; i < input.Length; i++)
            {
                for (int j = 0; j < alpabat.Length; j++)
                {
                    if (alpabat[j].Equals(input[i])&& position[j] == -1) position[j] = i;
                }
            }
            for(int i = 0; i < position.Length; i++)
            {
                Console.Write(position[i] + " ");
            }
        }
    }
}
