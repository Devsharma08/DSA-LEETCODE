class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if(len==0) return;
        List<int[]> list = new ArrayList<>();
        for(int i = 0 ; len > i ; i++){
            int[] temp = new int[len];
            int x = 0 ;
            for(int j = len - 1 ; 0 <= j ; j--){
                temp[x] = matrix[j][i];
                x++;
            }
            list.add(temp);
        }
        int z = 0 ;
        for(int i = 0 ; len > i ; i++){
            int[] temp = list.get(i);
            for(int j = 0 ; len > j ; j++){
                matrix[i][j] =  temp[j];
            }
        }

    }
}