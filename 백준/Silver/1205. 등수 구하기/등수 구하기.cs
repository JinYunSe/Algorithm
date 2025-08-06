using System;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            int[] input = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
            int[] rank = new int[50];
            int song_rank = 1, song_p = 1;
            string temp = Console.ReadLine();
            for(int i = 0; i < input[0]; i++)
            {
                rank[i] = int.Parse(temp.Split()[i]);
                if (rank[i] > input[1]) song_rank++;
                if (rank[i] >= input[1]) song_p++;
            }
            if (song_rank > input[2]) Console.WriteLine(-1);
            else if (song_p > input[2]) Console.WriteLine(-1);
            else Console.WriteLine(song_rank);
        }
    }
}