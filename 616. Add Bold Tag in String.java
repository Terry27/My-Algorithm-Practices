class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] check = new boolean[s.length()];
        for(int i = 0, ending = 0; i < s.length(); i++){
            for(String word: dict){
                if(s.startsWith(word, i)){
                    ending = Math.max(ending, i+ word.length());
                }
            }
            check[i] = ending > i;
        }
        StringBuilder sb = new StringBuilder();
        for(int i= 0; i < s.length(); i++){
            if(!check[i]){
                sb.append(s.charAt(i));
                continue;
            }
            int j = i;
            while(j < check.length && check[j]){
                j++;
            }
            sb.append("<b>" + s.substring(i,j) + "</b>");
            i = j-1;
        }
        return sb.toString();
    }
}

// 
    public String addBoldTag(String s, String[] dict) {
        int n = s.length();
        int[] mark = new int[n+1];
        for(String d : dict) {
            int i = -1;
            while((i = s.indexOf(d, i+1)) >= 0) {
                mark[i]++;
                mark[i + d.length()]--;
            }
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i = 0; i <= n; i++) {
            int cur = sum + mark[i];
            if (cur > 0 && sum == 0) sb.append("<b>");
            if (cur == 0 && sum > 0) sb.append("</b>");
            if (i == n) break;
            sb.append(s.charAt(i));
            sum = cur;
        }
        return sb.toString();
    }