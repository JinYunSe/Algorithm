using System;
using System.Collections.Generic;

namespace CodingTest
{
    class Class1
    {
        private static int m, n;
        private static char[][] board;

        static Class1()
        {
            string[] mn = Console.ReadLine().Split();
            m = int.Parse(mn[0]);
            n = int.Parse(mn[1]);

            board = new char[m][];

            for (int i = 0; i < m; i++)
            {
                board[i] = Console.ReadLine().ToCharArray();
            }
        }
        public static void Main()
        {
            int min = 32;

            for (int row = 0; row <= m - 8; row++)
            {
                for (int col = 0; col <= n - 8; col++)
                {
                    min = Math.Min(min, Check(row, col));
                }
            }

            Console.Write(min);
        }

        private static int Check(int startRow, int startCol)
        {
            (int a, int b) count = (0, 0);

            for (int row = 0; row < 8; row++)
            {
                for (int col = 0; col < 8; col++)
                {
                    switch ((row + col) % 2)
                    {
                        case 0:
                            if (board[startRow + row][startCol + col] != board[startRow][startCol])
                                count.a++;
                            else
                                count.b++;
                            break;

                        case 1:
                            if (board[startRow + row][startCol + col] == board[startRow][startCol])
                                count.a++;
                            else
                                count.b++;
                            break;
                    }
                }
            }

            return Math.Min(count.a, count.b);
        }
    }
}