public class Solution {  //simple O(n) solution
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        for(int i= 1; i<nums.length;i++){ //IMPORTANT
            if(i%2 == 1){
                if(nums[i] < nums[i-1]){
                    swap(nums, i-1, i);
                }
            }else{
                if(nums[i] > nums[i-1]){
                    swap(nums, i-1, i);
                }
            } 
        }
    }
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}



//derived from CTCI 10.11 peak and valley
public class Solution { //O(n)
    public void wiggleSort(int[] nums) { 
        if(nums == null || nums.length == 0){
            return;
        }
        for(int i= 1; i<nums.length;i+=2){ //IMPORTANT
            int biggestIndex = maxIndex(nums, i-1,i,i+1);
            if(i != biggestIndex){
                swap(nums, i, biggestIndex);
            }
        }
    }
    
    private int maxIndex(int[] nums, int a, int b, int c){
        int aValue = a>=0&& a<nums.length? nums[a]:Integer.MIN_VALUE;
        int bValue = b>=0&& b<nums.length? nums[b]:Integer.MIN_VALUE;
        int cValue = c>=0&& c<nums.length? nums[c]:Integer.MIN_VALUE;
        int max = Math.max(aValue, Math.max(bValue,cValue));
        if(max == aValue){
            return a;
        }else if(max == bValue){
            return b;
        }else{
            return c;
        }
    }
    
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}