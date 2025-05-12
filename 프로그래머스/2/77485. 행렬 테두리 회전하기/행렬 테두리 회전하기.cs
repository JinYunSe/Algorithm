using System;
using System.Collections.Generic;

public class Solution {
    public int[] solution(int rows, int columns, int[,] queries) 
    {
        int[,] matrix = new int[rows, columns];
        List<int> result = new List<int>();
        
        for (int i = 0, count = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i, j] = count++;
            }
        }

        // 각 쿼리에 대해 테두리 회전
        for (int q = 0; q < queries.GetLength(0); q++) {
            int x1 = queries[q, 0] - 1;
            int y1 = queries[q, 1] - 1;
            int x2 = queries[q, 2] - 1;
            int y2 = queries[q, 3] - 1;

            int temp = matrix[x1, y1];
            int min = temp;

            // 위쪽
            for (int i = x1; i < x2; i++) {
                matrix[i, y1] = matrix[i + 1, y1];
                min = Math.Min(min, matrix[i, y1]);
            }
            // 오른쪽
            for (int i = y1; i < y2; i++) {
                matrix[x2, i] = matrix[x2, i + 1];
                min = Math.Min(min, matrix[x2, i]);
            }
            // 아래쪽
            for (int i = x2; i > x1; i--) {
                matrix[i, y2] = matrix[i - 1, y2];
                min = Math.Min(min, matrix[i, y2]);
            }
            // 왼쪽
            for (int i = y2; i > y1 + 1; i--) {
                matrix[x1, i] = matrix[x1, i - 1];
                min = Math.Min(min, matrix[x1, i]);
            }
            matrix[x1, y1 + 1] = temp;

            result.Add(min);
        }

        return result.ToArray();
    }
}
