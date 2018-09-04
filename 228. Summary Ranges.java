public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        int curHead = 0;
        for(int i = 1; i<= nums.length; i++){
            int currElem = i== nums.length? nums[i-1] + 2: nums[i];
            if(currElem != nums[i-1]+1){
                res.add(curHead == i-1 ? nums[i-1]+"" : nums[curHead]+"->"+nums[i-1]);
                curHead = i;
            }
        }
        
        return res;
    }
}


public class Solution { //my own version runtime O(n)
    public List<String> summaryRanges(int[] nums) {
        List<String> lists = new ArrayList<>();
        if(nums== null || nums.length==0){ 
            return lists;
        }
        int head= 0, tail = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]+1){
                tail = i;
                continue;
            }else{
                lists.add(gen(nums, head, tail));
                head = tail = i;
            }
        }
        lists.add(gen(nums, head, tail));
        return lists;
    }
    
    private String gen(int[] nums, int head, int tail){
        if(head == tail){
            return String.valueOf(nums[head]);
        }else{
            return new String(nums[head] + "->" + nums[tail]);
        }
    }
}





public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> lists = new ArrayList<>();
        if(nums== null || nums.length==0){ 
            return lists;
        }
        int preIndex; //this serves as the first pointer, i is the second pointer
        for(int i=0;i<nums.length;i++){
            preIndex = i; //the start of the new range
            while(i+1<nums.length && nums[i+1] == nums[i]+1){
                i++; //here we can find the index of the last consecutive element in current range
            }
            if(preIndex==i){ //if this range has only one element
                lists.add(nums[i]+""); //String.valueOf()
            }else{ 
                lists.add(nums[preIndex]+"->"+nums[i]);
            }
        }
        return lists;
    }
}