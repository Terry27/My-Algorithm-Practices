public class Solution {
    public String frequencySort(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int max = 0;
        int[] freq = new int[256];
        for(char c: s.toCharArray()){
            freq[c]++;
            max = Math.max(max, freq[c]);
        }
        StringBuilder[] buckets = new StringBuilder[max+1]; //record each char with its freq
        for(int cur = 0; cur<freq.length; cur++){
            int curFreq = freq[cur];
            if(buckets[curFreq] == null){
                buckets[curFreq] = new StringBuilder();
            }
            for(int i = 0; i< freq[cur]; i++){
                buckets[curFreq].append((char)(cur));
            }
        }
        StringBuilder res = new StringBuilder(); 
        for(int i = buckets.length-1; i>=0; i--){ // print from highest frequence
            if(buckets[i] != null){
                res.append(buckets[i]);
            }
        }
        return res.toString();
    }
}