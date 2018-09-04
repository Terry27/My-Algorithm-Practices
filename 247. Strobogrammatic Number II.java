public class Solution {
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