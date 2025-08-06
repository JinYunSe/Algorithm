using System;
using System.Collections.Generic;
using System.Text;

namespace CodingTest
{
    class Class1
    {
        public static void Main(string[] args)
        {
            StringBuilder stringBuilder = new StringBuilder();
            while (true)
            {
                string input = Console.ReadLine();
                if (input.Equals("*")) break;
                if(input.Length == 1)
                {
                    stringBuilder.Append(input + " is surprising.\n");
                    continue;
                }
                bool check = true;
                for(int i = 0; i < input.Length - 1; i++)
                {
                    List<string> list = new List<string>();
                    int blank = input.Length - 1 - i;
                    for(int j = 0; (j + blank) < input.Length; j++)
                    {
                        if (list.Contains(input[j].ToString() + input[j + blank].ToString()))
                        {
                            stringBuilder.Append(input + " is NOT surprising.\n");
                            check = false;
                            i = input.Length;
                            break;
                        }
                        list.Add(input[j].ToString()+input[j + blank].ToString());
                    }
                }
                if (check) stringBuilder.Append(input + " is surprising.\n");
            }
            Console.WriteLine(stringBuilder.ToString());
        }
    }
}