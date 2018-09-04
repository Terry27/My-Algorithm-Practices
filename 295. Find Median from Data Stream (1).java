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


public class MedianFinder { //O(logn) build each, O(1) find
    Queue<Integer> minHeap = new PriorityQueue<Integer>();
    Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    // Adds a number into the data structure.
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if(minHeap.size()<maxHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(minHeap.size() != maxHeap.size()){
            return (double)minHeap.peek();
        }else{
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
    }
};