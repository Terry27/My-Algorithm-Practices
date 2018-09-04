public class Solution { //brute force O(mn)
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        for(int m = 0; m< matrix.length; m++){
            for(int n= 0; n< matrix[0].length; n++){
                if(matrix[m][n] == target){
                    return true;
                }
            }
        }
        return false;
    }
}

public class Solution { //O(m+n)
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = 0, col = matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col] ==  target){
                return true;
            }else if(matrix[row][col] <  target){
                row++;
            }else{
                col--;
            }
        }
        
        return false;
    }
}

we can also do binary search to each row or col, then O(nlogm) or O(nlogn)