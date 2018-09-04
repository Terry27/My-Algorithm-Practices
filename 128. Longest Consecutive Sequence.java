public class Solution { //hashmap implementation runtime O(n), space O(n)
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                continue;
            }
            int smallerSeq = map.getOrDefault(num-1, 0);
            int biggerSeq = map.getOrDefault(num+1, 0);
            int newSeq = biggerSeq+smallerSeq+1;
            max = Math.max(max, newSeq);
            map.put(num, newSeq);  //only update boundary
            map.put(num-smallerSeq, newSeq);
            map.put(num+biggerSeq, newSeq);
        }
        return max;
    }
}

public class Solution { //set implementation
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int num: set){
            if(set.contains(num-1)){
                continue;
            }
            int curMax = 1;
            while(set.contains(num+1)){ // not need to remove, will cause concurrent 					  //exception 
                curMax++;
                num++;
            }
            max = Math.max(max, curMax);
        }
        return max;
    }
}