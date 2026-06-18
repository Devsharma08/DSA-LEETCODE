class Solution {
    public static int countAlive(int row, int col, int[][] board) {
        int[][] allN = new int[][] {
            {1, 0}, {0, 1}, {1, 1}, {-1, 1}, 
            {1, -1}, {-1, 0}, {0, -1}, {-1, -1}
        };
        int alive = 0;
        for (int[] t : allN) {
            int r = row + t[0];
            int c = col + t[1];
            
            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
                if (board[r][c] == 1 || board[r][c] == 2) {
                    alive++;
                }
            }
        }
        return alive;
    }

    public void gameOfLife(int[][] board) {
        int r = board.length;
        int c = board[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int n = countAlive(i, j, board);
                int current = board[i][j];

                if (current == 1) {
                    if (n < 2 || n > 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (n == 3) {
                        board[i][j] = 3; 
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}