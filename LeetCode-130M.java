class Solution {
    
public void dfs(int i, int j, char[][] board, int m, int n) {
    
    if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
        return;
    }
    
    board[i][j] = 'C'; 

    dfs(i + 1, j, board, m, n);
    dfs(i - 1, j, board, m, n);
    dfs(i, j + 1, board, m, n);
    dfs(i, j - 1, board, m, n);
}

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        // adding regions '0' to the queue
        // loop through the matrix and if found any 0 change data to 2 at edges then start dfs from there in 4 drxn and don't change all connected 0 
        // after reaching the end mark all other nodes as x and else as 0
        for (int i = 0; rows > i; i++) {
            for (int j = 0; cols > j; j++) {
                if (board[i][j]=='O' && (i == 0 || i == (rows - 1) || j == 0 || j == (cols - 1))) {
                    // board[i][j]="C";
                    dfs(i, j, board,rows,cols);
                }
            }
        }

        // now check for elements that remains 0 now turn them to x and all T to 0
        for (int i = 0; rows > i; i++) {
            for (int j = 0; cols > j; j++) {
                
                if ( board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if ( board[i][j] == 'C' ) {
                    board[i][j]  = 'O';
                }
            }
        }

    }
}