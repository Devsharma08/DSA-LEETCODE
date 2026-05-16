class Solution {

    public boolean dfs(int row, int col, int curr, char[][] board, String word) {
        if (curr == word.length()) return true;
        
        if (row >= board.length || row < 0 || col < 0 || col >= board[0].length || board[row][col] != word.charAt(curr)) {
            return false;
        }
        char originalChar = board[row][col];
        board[row][col] = '#'; 

        boolean found = dfs(row + 1, col, curr + 1, board, word) || 
                        dfs(row, col + 1, curr + 1, board, word) || 
                        dfs(row - 1, col, curr + 1, board, word) || 
                        dfs(row, col - 1, curr + 1, board, word);

        board[row][col] = originalChar;

        return found;
    }

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        
        for (int i = 0; row > i; i++) {
            for (int j = 0; col > j; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(i, j, 0, board, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}