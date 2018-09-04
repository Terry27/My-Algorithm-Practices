class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>(); //SAVE INDEX!!!
        for(int i = 0; i < nums2.length; i++){
            while(!stack.isEmpty() && nums2[stack.peekFirst()] < nums2[i]){
                map.put(nums2[stack.pollFirst()], nums2[i]);
            }
            stack.offerFirst(i); //DON'T forget!
        }
        for(int i = 0; i <nums1.length; i++){
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}