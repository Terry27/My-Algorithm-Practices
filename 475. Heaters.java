//https://www.tutorialspoint.com/java/util/arrays_binarysearch_int.htm
//This method returns index of the search key, if it is contained in the array, else it returns (-(insertion point) - 1). The insertion point is the point at which the key would be inserted into the array: the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key.
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int radius = Integer.MIN_VALUE;
        for(int house: houses){
            int idx = Arrays.binarySearch(heaters, house);
            if(idx < 0){
                idx = -idx-1;
            }
            int left = idx == 0 ? Integer.MAX_VALUE : house - heaters[idx - 1] ;
            int right = idx >= heaters.length ? Integer.MAX_VALUE : heaters[idx] - house;
            radius = Math.max(radius, Math.min(left, right));
        }
        return radius;
    }
}
