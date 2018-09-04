class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n != 1){
            n = nextNum(n);
            if(!set.add(n)){
                return false;    
            }
        }
        return true;
    }
    
    private int nextNum(int n){
        int num = 0;
        while(n > 0){
            num += (int)Math.pow(n%10,2);
            n /= 10;
        }
        return num;
    }
}

class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = nextNum(slow);
        while(slow != fast){
            if(slow == 1){return true;}
            slow = nextNum(slow);
            fast = nextNum(nextNum(fast));
        }
        
        return slow == 1; //not return false!
    }
    
    private int nextNum(int n){
        int num = 0;
        while(n > 0){
            num += (int)Math.pow(n%10,2);
            n /= 10;
        }
        return num;
    }
}