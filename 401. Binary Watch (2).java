class Solution {
    public List<String> readBinaryWatch(int num) {
        int[] hours = {1, 2, 4, 8};
        int[] minutes = {1, 2, 4, 8, 16, 32};
        List<String> res = new ArrayList<>();
        for(int i = 0; i <= num; i++){
            List<Integer> hComb = genDigits(hours, num-i, 0, 0, new ArrayList<Integer>());
            List<Integer> mComb = genDigits(minutes, i, 0, 0, new ArrayList<Integer>());
            for(int h: hComb){
                if(h >= 12){continue;}
                for(int m: mComb){
                    if(m >= 60){continue;}
                    res.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return res;
    }
    
    private List<Integer> genDigits(int[] time, int count, int sum, int start, List<Integer> list){
        if(count == 0){
            list.add(sum);
            return list;
        }
        for(int i = start; i < time.length; i++){
            genDigits(time, count-1, sum+time[i], i+1, list);
        }
        return list;
    }
    
    
    
    
}