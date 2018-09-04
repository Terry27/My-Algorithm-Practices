class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        fast = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

//A-> B(start of loop) -> C(when slow arrives at loop) -> X(when they first meet)
// AB = k steps, BC = 2k - k = k steps into the loop, aka fast is loopSize-k steps behind slow
// fast catches 1 step/move to slow, after loopSize-k steps, they meet at X. BX = loopSize-k steps
// XB = loopSize - BX = k steps, then set fast to A, they both move at 1 step/move
// after k steps, they will meet at B.