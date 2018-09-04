//dumb version
//merge and then take median
public class Solution { //O(n) time and space
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length+nums2.length];
        int i = 0, j= 0, curr=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                temp[curr++] = nums1[i++];
            }else{
                temp[curr++] = nums2[j++];
            }
        }
        while(i< nums1.length){
            temp[curr++] = nums1[i++];
        }
        while(j< nums2.length){
            temp[curr++] = nums2[j++];
        }
        if(temp.length % 2==0){
            return (temp[(temp.length-1)/2]+temp[(temp.length-1)/2+1])/2.0;
        }else{
            return (double)temp[(temp.length-1)/2];
        }
    }
}

public class Solution { //O(n) runtime, O(1) space
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length+nums2.length;
        int first=0, second = 0;
        int targetIndex1 = (size-1)/2, targetIndex2 = (size-1)/2+1;
        int i = 0, j= 0, curr=0;
        int currNum1, currNum2, currNum;
        while(i<nums1.length || j<nums2.length){
            currNum1 = i<nums1.length? nums1[i]: Integer.MAX_VALUE;
            currNum2 = j<nums2.length? nums2[j]: Integer.MAX_VALUE;
            if(currNum1<currNum2){
                currNum = currNum1;
                i++;
            }else{
                currNum = currNum2;
                j++;
            }
            if(curr == targetIndex1){
                first = currNum;
            } else if(curr == targetIndex2){
                second = currNum;
            }
            curr++;
        }
        
        if(size % 2 == 0){
            return (first+second)/2.0;
        }else{
            return (double)first;
        }
    }
}

public class Solution {    //O(n/2) runtime, O(1) space
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length+nums2.length;
        int first=0, second = 0;
        boolean isOdd = false;
        if(size % 2 != 0){
            isOdd = true;
        }
        int targetIndex1 = (size-1)/2, targetIndex2 = (size-1)/2+1;
        int i = 0, j= 0, curr=0;
        int currNum1, currNum2, currNum;
        while(i<nums1.length || j<nums2.length){
            currNum1 = i<nums1.length? nums1[i]: Integer.MAX_VALUE;
            currNum2 = j<nums2.length? nums2[j]: Integer.MAX_VALUE;
            if(currNum1<currNum2){
                currNum = currNum1;
                i++;
            }else{
                currNum = currNum2;
                j++;
            }
            
            if(curr == targetIndex1){  //better
                first = currNum;
                if(isOdd){
                    return (double)first;
                }
            } else if(curr == targetIndex2){
                second = currNum;
                return (first+second)/2.0;
            }
            curr++;
        }
        return 0.0;
    }
}
