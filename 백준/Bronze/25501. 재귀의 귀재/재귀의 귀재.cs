using System;

namespace Project
{
    internal class Class1
    {
        public static int count = 0;
        public static int recursion(string s,int l, int r)
        {
            count++;
            if (l >= r) return 1;
            else if (!s[l].Equals(s[r])) return 0;
            else return recursion(s, l + 1, r - 1);
        }
        public static int isPalidrome(string s)
        {
            return recursion(s, 0, s.Length - 1);
        }

        public static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());
            string[] temp = new string[number];
            for (int i = 0; i < temp.Length; i++) temp[i] = Console.ReadLine();
            for(int i = 0; i < temp.Length; i++)
            {
                Console.WriteLine(isPalidrome(temp[i]) + " " + count);
                count = 0;
            }
        }
    }
}
