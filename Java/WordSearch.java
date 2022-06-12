class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (searchBoard(board, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean searchBoard(char[][] board, boolean[][] visited, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        visited[i][j] = true;
        if (searchBoard(board, visited, word, i + 1, j, index + 1) || searchBoard(board, visited, word, i - 1, j, index + 1) ||
            searchBoard(board, visited, word, i, j + 1, index + 1) || searchBoard(board, visited, word, i, j - 1, index + 1)) {
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}