class Solution {
    public int findLonelyPixel(char[][] picture) {
        int count = 0;
        if(picture == null || picture.length == 0 || picture[0].length == 0){
            return count;
        }
        
        int[] rowC = new int[picture.length];
        int[] colC = new int[picture[0].length];
        for(int i= 0; i< picture.length; i++){
            for(int j = 0; j < picture[0].length; j++){
                if(picture[i][j] == 'B'){
                    rowC[i]++;
                    colC[j]++;
                }
            }
        }
        
        for(int i= 0; i< picture.length; i++){
            if(rowC[i] != 1){ //run faster
                continue;        
            }
            for(int j = 0; j < picture[0].length; j++){
                if(picture[i][j] == 'B' && rowC[i] == 1 && colC[j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}