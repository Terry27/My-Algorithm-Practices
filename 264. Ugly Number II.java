public class Solution {
    public int nthUglyNumber(int n) {
        //use set for duplicate multiplications
        Set<Long> set = new HashSet<>();
        // default min heap
        PriorityQueue<Long> pQueue = new PriorityQueue<>();
        pQueue.offer(1l);
        set.add(1l);
        long[] primes = {2,3,5};
        while(n-- > 1){
            long cur = pQueue.poll();
            for(long num: primes){
                if(!set.contains(cur*num)){
                    pQueue.offer(cur*num);
                    set.add(cur*num);
                }
            }
            
        }
        return pQueue.poll().intValue();
    }
}

public class Solution {
    public int nthUglyNumber(int n) {
        // default min heap
        PriorityQueue<Long> pQueue = new PriorityQueue<>();
        pQueue.offer(1l);
        long[] primes = {2,3,5};
        while(n-- > 1){
            long cur = pQueue.poll();
            //without using set
            while(!pQueue.isEmpty() && pQueue.peek() == cur){
                pQueue.poll();
            }
            for(long num: primes){
                pQueue.offer(cur*num);
            }
            
        }
        return pQueue.poll().intValue();
    }
}

//dp O(n)
public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for(int i = 1; i < n; i++){
            int curMin = Math.min(Math.min(ugly[index2]*2, ugly[index3]*3), ugly[index5]*5);
            ugly[i] = curMin;
            if(curMin % 2 == 0){
                index2++;
            }
            if(curMin % 3 == 0){
                index3++;
            }
            if(curMin % 5 == 0){
                index5++;
            }
        }
        
        return ugly[n-1];
    }
}


public class Solution { //dp
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int fact2 = 2, fact3 = 3, fact5 = 5;
        for(int i = 1; i < n; i++){
            int curMin = Math.min(Math.min(fact2, fact3), fact5);
            ugly[i] = curMin;
            if(curMin == fact2){
                fact2 = 2*ugly[++index2];
            }
            if(curMin == fact3){
                fact3 = 3*ugly[++index3];
            }
            if(curMin == fact5){
                fact5 = 5*ugly[++index5];
            }
        }
        
        return ugly[n-1];
    }
}