class Solution {
    public void setZeroes(int[][] matrix) {
        // get position where element is 0
        Deque<int[]> list = new ArrayDeque<>();
        
        for (int i = 0; matrix.length > i; i++) {
            for (int j = 0; matrix[0].length > j; j++) {
                if (matrix[i][j] == 0) {
                    list.push(new int[]{i,j});
                }
            }
        }

        
        while (!list.isEmpty()) {
            int[] temp = list.getFirst();
            for (int i = 0; matrix.length > i; i++) {
                for (int j = 0; matrix[0].length > j; j++) {
                    if (i==temp[0] || j==temp[1]) {
                        matrix[i][j] = 0 ;
                    }
                }
            }
            list.removeFirst();
        }
        
    }
}