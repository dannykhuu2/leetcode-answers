// using O(m + n) space for 1ms runtime on leetcode
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == true || cols[j] == true) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

// constant space solution using first element of row and column to store if there is 0
// class Solution {
//     public void setZeroes(int[][] matrix) {
//         boolean colIs0 = false;
//         int m = matrix.length;
//         int n = matrix[0].length;
        
//         for (int i = 0; i < m; i++) {
//             if (matrix[i][0] == 0) {
//                 colIs0 = true;
//             }
//             for (int j = 1; j < n; j++) {
//                 if (matrix[i][j] == 0) {
//                     matrix[i][0] = 0;
//                     matrix[0][j] = 0;
//                 }
//             }
//         }
        
//         for (int i = m - 1; i >= 0; i--) {
//             for (int j = n - 1; j >= 1; j--) {
//                 if (matrix[i][0] == 0 || matrix[0][j] == 0) {
//                     matrix[i][j] = 0;
//                 }
//             }
//             if (colIs0 == true) {
//                 matrix[i][0] = 0;
//             }
//         }
//     }
// }