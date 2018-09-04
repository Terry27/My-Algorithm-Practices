public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> numList = new ArrayList<>();
        int[] factorial = new int[n+1];
        factorial[0] = 1;
        for(int i = 1; i <= n; i++){
            numList.add(i);
            factorial[i] = factorial[i-1]*i;
        }
        StringBuilder sb = new StringBuilder();
        // align k to start from zero
        k--;
        for(int i = n; i > 0; i--){
            int index = k/factorial[i-1];
            sb.append(numList.remove(index));
            k = k - index*factorial[i-1];
        }
        return sb.toString();
        
    }
}