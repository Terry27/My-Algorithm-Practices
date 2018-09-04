class MedianFinder {
    Queue<Integer> minPQ;
    Queue<Integer> maxPQ;
    /** initialize your data structure here. */
    public MedianFinder() { //maxPQ(smaller half) -> minPQ(larger half), minPQ has more elements
        minPQ = new PriorityQueue<Integer>();
        maxPQ = new PriorityQueue<Integer>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        minPQ.offer(num);
        maxPQ.offer(minPQ.poll());
        if(minPQ.size() < maxPQ.size()){
            minPQ.offer(maxPQ.poll());
        }
    }

    public double findMedian() {
        return minPQ.size() == maxPQ.size() ? (double)(minPQ.peek() + maxPQ.peek())/2 : (double)minPQ.peek();
    }
}

public class MedianFinder { //O(n) build , O(1) fetch
    ArrayList<Integer> list = new ArrayList<>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(list.isEmpty()){
            list.add(num);
        }else{
            int lo = 0, hi = list.size()-1;
            while(lo <= hi){
                int mid = lo+ (hi-lo)/2;
                int midEle = list.get(mid);
                if( midEle == num){
                    list.add(mid, num);
                    return;
                }else if(midEle < num ){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
            list.add(lo, num);
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        int size = list.size();
        if( size == 0){
            return 0.0;
        }
        if( size % 2 == 0){
            return (list.get(size/2)+list.get(size/2-1))/2.0;
        }
        return list.get(size/2);
    }
}
