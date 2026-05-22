class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ans = new int[m][n];

        for(int i = 0 ; m > i ;i++){
            ans[i][0] = 1;
            for(int j = 0 ; ( i==0 && n > j ) ; j++ ){
                ans[i][j] = 1;
            }
        }

        for(int i = 1 ; m > i ; i++){
            for(int j = 1 ; j < n ; j++ ){
                ans[i][j] = ans[i-1][j] + ans[i][j-1];
            }
        }

        return ans[m-1][n-1];
    }
}