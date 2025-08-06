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
            string[] input_temp = new string[9];
            for (int i = 0; i < input_temp.Length; i++)
            {
                input_temp[i] = Console.ReadLine();
            }
            int[,] list = new int[9,9];
            for(int i = 0; i < input_temp.Length; i++)
            {
                string[] temp = input_temp[i].Split(' ');
                for(int j = 0; j < temp.Length; j++)
                {
                    list[i,j] = int.Parse(temp[j]);
                }
            }
            int Row = 0, Column = 0, Max = -1;
            for (int i = 0; i < input_temp.Length; i++)
            {
                for (int j = 0; j < input_temp.Length; j++)
                {
                    if(Max < list[i,j])
                    {
                        Max = list[i, j];
                        Row = i + 1;
                        Column = j + 1;
                    }
                }
            }
            Console.WriteLine(Max);
            Console.Write(Row + " " + Column);
        }
    }
}
