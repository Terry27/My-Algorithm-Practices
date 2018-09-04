class Solution {
    public String nextClosestTime(String time) {
        
        char[] timeC = time.toCharArray();
        Set<Integer> set = new HashSet<>();
        for(char c: timeC){
            if(c != ':'){
                set.add(c-'0');
            }
        }
        int curTime = Integer.parseInt(time.substring(0,2))*60 + Integer.parseInt(time.substring(3));
        for(int i = 1; i <= 60*24; i++){
            int newTime = (curTime + i)%(60*24);
            int[] newDigits = new int[]{(newTime/60)%10, newTime/600, (newTime%60)/10, (newTime%60)%10};
            int count = 0;
            for(int t: newDigits){
                if(!set.contains(t)){
                    break;
                }
                count++;
            }
            if(count == 4){
                return String.format("%02d:%02d",newTime/60, newTime%60);
            }
        }
        return "";
    }
}