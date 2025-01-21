public class Solution {
    public int[][] solution(int[,] arr1, int[,] arr2) {
        int rows = arr1.GetLength(0);
        int cols = arr1.GetLength(1);
        int[][] answer = new int[rows][];

        for (int i = 0; i < rows; i++) {
            answer[i] = new int[cols];

            for (int j = 0; j < cols; j++) {
                answer[i][j] = arr1[i, j] + arr2[i, j];
            }
        }

        return answer;
    }
}
