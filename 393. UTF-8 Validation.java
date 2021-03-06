public class Solution {
    public boolean validUtf8(int[] data) {
        int numOfBytes = 0;
        for(int i = 0; i < data.length; i++){
            if(data[i] > 255){
                return false;
            }
            if( (data[i] & 128) == 0){
                numOfBytes = 1;
            }else if( (data[i] & 224) == 192){
                numOfBytes = 2;
            }else if( (data[i] & 240) == 224){
                numOfBytes = 3;
            }else if( (data[i] & 248) == 240){
                numOfBytes = 4;
            }else{
                return false;
            }
            for(int j = 1; j< numOfBytes; j++){
                if(i+j >= data.length){return false;}
                if( (data[i+j] & 192) != 128){
                    return false;
                }
            }
            i += numOfBytes-1;
        }
        
        return true;
    }
}