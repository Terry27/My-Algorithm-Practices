class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) { //TreeSet, Nlogk
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            long curNum = (long)nums[i];
            Long floor = set.floor(curNum);
            Long ceiling = set.ceiling(curNum);
            
            if((floor != null && curNum - floor <= t) || (ceiling != null && ceiling - curNum <= t) ){
                return true;
            }
            set.add(curNum); //important, add here
            if(set.size() > k){
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}

 public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) { //bucket, O(n)
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}