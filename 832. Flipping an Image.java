class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] res = new int[A.length][];
        for(int i = 0; i < A.length; i++){
            res[i] = reverseAndInvert(A[i]);
        }
        return res;
    }
    
    private int[] reverseAndInvert(int[] input){
        int[] res = new int[input.length];
        int i = 0, j = input.length-1;
        while(i <= j){ //must be <=
            res[i] = 1-input[j]; 
            res[j] = 1-input[i];
            i++;
            j--;
        }
        return res;
    }
}