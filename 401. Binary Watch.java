public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        if(num < 0 || num > 10){
            return res;
        }
        int[] label = {8,4,2,1,32,16,8,4,2,1};
        dfs(label, new boolean[10], res, 0, num);
        return res;
    }
    
    private void dfs(int[] label, boolean[] choice, List<String> res, int startIndex, int num){
        if(num == 0){
            int hour = 0, min=0;
            for(int i = 0; i< choice.length; i++){
                if(i < 4){
                    hour += choice[i] == true? label[i]: 0;     
                }else{
                    min += choice[i] == true? label[i]: 0;
                }
            }
            if(hour < 12 && min < 60){
                String sol = hour+ ":"+ (min<10? "0"+min: min);
                res.add(sol);
            }
        }else{
            for(int i = startIndex; i< label.length - num + 1; i++){
                choice[i] = true;
                dfs(label, choice, res, i+1, num-1);
                choice[i] = false;
            }
        }
    }
}