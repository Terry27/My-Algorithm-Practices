import java.util.*;

class RandomizedSet {
    HashMap<Integer,Integer> map;
    ArrayList<Integer> list;
    Random r;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
           return false; 
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int idx = map.get(val);
        int temp = list.get(list.size()-1);
        
        list.set(idx, temp);
        map.put(temp, idx); //don't forget to update map
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */