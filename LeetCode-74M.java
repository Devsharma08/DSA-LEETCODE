// ---------------- method - 1 ------------------

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int rowLength = matrix.length - 1 ;
//         int columnLength = matrix[0].length - 1;
//         int row = 0 ;
//         int i = 0 ; int low = 0 ; int high = columnLength ;
//         while(i<=rowLength){
//             if(target <= matrix[i][columnLength]){
//                 row = i ;
//                 break;
//             }
//             i++;
//         }

//         while(low<=high){
//             int mid = low + (high-low)/2 ;
//             if(matrix[row][mid] == target){
//                 return true;
//             }
//             else if( matrix[row][mid] > target){
//                 high = mid - 1 ;
//             }
//             else if( matrix[row][mid] < target){
//                 low = mid + 1 ;
//             }
//         }
//         return false;
//     }
// }

// ---------------- method - 2 ------------------

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int rowLength = matrix.length ;
       int colLength = matrix[0].length ;

       int high =  rowLength * colLength - 1 ;
        int low = 0 ; 
        int mid = low + ( high - low ) / 2 ; 
       while(low <= high){
        if(matrix[mid/colLength][mid%colLength] == target) {
            return true;
        }
        else if(target > matrix[mid/colLength][mid%colLength]){
            low = mid + 1 ;
        }
        else if(target < matrix[mid/colLength][mid%colLength]){
            high = mid - 1 ;
        }
        mid = low + ( high - low ) / 2 ; 
       }
       return false;
    }
}