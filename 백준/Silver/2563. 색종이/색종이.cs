using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodingTest
{
    class Class1
    {
        static void Main(String[] args)
        {
            bool[,] page = new bool[100, 100];
            for(int i = 0; i < 100; i++)
            {
                for(int j = 0; j < 100; j++)
                {
                    page[i, j] = false;
                }
            }
            int input = int.Parse(Console.ReadLine());
            for(int i = 0; i < input; i++)
            {
                string line = Console.ReadLine();
                string [] point = line.Split(' ');
                for(int j = int.Parse(point[0]); j < int.Parse(point[0]) + 10; j++)
                {
                    for(int k = int.Parse(point[1]); k < int.Parse(point[1]) + 10; k++)
                    {
                        page[j, k] = true;
                    }
                }
            }
            int count = 0;
            for(int i = 0; i < 100; i++)
            {
                for(int j = 0; j < 100; j++)
                {
                    if (page[i, j] == true) count++;
                }
            }
            Console.WriteLine(count);
        }
    }
}
