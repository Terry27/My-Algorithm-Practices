public class PhoneDirectory {
    
    Set<Integer> used;
    Deque<Integer> available;
    int capacity;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        capacity = maxNumbers;
        used = new HashSet<>();
        available = new ArrayDeque<>();
        for(int i = 0; i < maxNumbers; i++){
            available.offerLast(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(available.isEmpty()){
            return -1;
        }
        Integer cur = available.pollFirst();
        used.add(cur);
        return cur;
        
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if(number >= capacity || number < 0){
            return false;
        }
        return !used.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(number >= capacity || number < 0){
            return;
        }
        if(used.remove(number)){
            available.offerLast(number);
        }
    }
}