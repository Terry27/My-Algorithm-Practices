class Solution { //greedy
    public int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);
        int i = 0, j = 0;
        int count = 0;
        while(i < children.length && j < cookies.length){
            if(cookies[j] >= children[i]){
                count++;
                i++; //this child is satisfied, test next child
            }
            j++;
        }
        return count;
    }
}