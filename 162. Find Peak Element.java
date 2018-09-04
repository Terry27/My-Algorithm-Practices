public class Solution { //O(logn)
    public int findPeakElement(int[] A) {
        if(A == null || A.length == 0){
            return -1;
        }
        int lo = 0, hi = A.length-1;
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            if(A[mid]<A[mid+1]){
                lo = mid +1;
            }else{
                hi = mid;
            }
            
        }
        return lo;
    }
}

public class Solution { //O(logn)
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int start = 0, end = nums.length-1; 
        while(start + 1 <  end) {
            int mid = (start + end) / 2;
            int leftSide = mid - 1 <0 ? Integer.MIN_VALUE: nums[mid-1];
            int rightSide = mid + 1 == nums.length ? Integer.MIN_VALUE: nums[mid+1];
            if(nums[mid] < leftSide) {
                end = mid;
            } else if(nums[mid] < rightSide) {
                start = mid;
            } else {
                end = mid; //start is ok too
            }
        }
        if(nums[start] < nums[end]) {
            return end;
        } else { 
            return start;
        }
    }
}


public class Solution { //O(n)
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        for(int i =1 ; i< nums.length; i++){
            if(nums[i]< nums[i-1]){
                return i-1;
            }
        }
        return nums.length-1;
    }
}
