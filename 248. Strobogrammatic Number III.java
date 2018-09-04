public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int res = 0;
        if(low.length() > high.length()){
            return 0;
        }
        for(int i = low.length(); i<= high.length(); i++){
            List<String> list = findStrobogrammatic(i);
            res += findStrobogrammatic(i).size();
            if(i == low.length() || i == high.length()){
                //first add all, then delete unqualified ones
                //String compareTo works for same length strings, not accurate for strings with different length
                for(String s: list){
                    if(( s.length() ==low.length() && s.compareTo(low) <0 ) || (s.length() == high.length() && s.compareTo(high) >0 )){
                        res -=1;
                    }
                }
            }
        }
        return res;
    }
    
    
    public List<String> findStrobogrammatic(int n) {
        List<String> list = new ArrayList<>();
        if(n<=0){
            return list;
        }
        char[][] dict = new char[][]{
            {'0','0'},{'1','1'},{'8','8'},{'6','9'},{'9','6'}
        };
        char[] cArray = new char[n];
        recursion(list, dict, cArray, 0, n);
        return list;
    }
    
    private void recursion(List<String> list, char[][] dict, char[] cArray, int curIndex,int n){
        if(curIndex == n/2 ){
            if(n % 2 == 0){
                list.add(new String(cArray));
            }else{
                cArray[n/2] = '0';
                list.add(new String(cArray));
                cArray[n/2] = '1';
                list.add(new String(cArray));
                cArray[n/2] = '8';
                list.add(new String(cArray));
            }
            return;
        }
        if(curIndex == 0){
            for(char[] pair: dict){
                if(pair[0] == '0'){
                    continue;
                }
                cArray[0] = pair[0];
                cArray[n-1] = pair[1];
                recursion(list,dict,cArray,curIndex+1,n);
            }
        }else{
            for(char[] pair: dict){
                cArray[curIndex] = pair[0];
                cArray[n-1-curIndex] = pair[1];
                recursion(list,dict,cArray,curIndex+1,n);
            }
        }
    }
}

    
    
    

