Number of submatrix have sum X
Difficulty: HardAccuracy: 71.09%Submissions: 12K+Points: 8
Given a matrix mat[][] of size n × m and an integer x, find the number of square submatrices whose sum of elements is equal to x.

Examples:

Input: mat[][] = [[2, 4, 7, 8, 10], 
               [3, 1, 1, 1, 1], 
               [9, 11, 1, 2, 1], 
               [12, -17, 1, 1, 1]] , 
x = 10
Output: 3
Explanation: The sub-squares whose sum of elements = 10, are colored in the matrix.

Input: mat[][] = [[3, 3, 5, 3], 
               [2, 2, 2, 6], 
               [11, 2, 2, 4]] ,
x = 1
Output: 0
Explanation: There is no sub-squares whose sum of elements is 1.
Constraints:
1 ≤ n, m ≤ 100
-103 ≤ mat[i] ≤ 103
-109 ≤ x ≤ 109class Solution {
    public int countSquare(int[][] mat, int x) {
        int res = 0;
        int n = mat.length;
        int m = mat[0].length;
        int[][] rowPrefix = new int[n][m];
        for (int i = 0; i < n; i++) {
            rowPrefix[i][0] = mat[i][0];
            for (int j = 1; j < m; j++) {
                rowPrefix[i][j] = rowPrefix[i][j - 1] + mat[i][j];
            }
        }

        int maxSize = Math.min(n, m);

        for (int size = 1; size <= maxSize; size++) {
            for (int i = 0; i <= m - size; i++) {
                int j = i + size - 1;
                int sum = 0;

                for (int row = 0; row < size - 1; row++) {
                    sum += rowPrefix[row][j] - (i > 0 ? rowPrefix[row][i - 1] : 0);
                }

                for (int row = size - 1; row < n; row++) {
                    sum += rowPrefix[row][j] - (i > 0 ? rowPrefix[row][i - 1] : 0);

                    if (sum == x) res++;

                    sum -= rowPrefix[row - size + 1][j] -
                           (i > 0 ? rowPrefix[row - size + 1][i - 1] : 0);
                }
            }
        }

        return res;
    }
}
