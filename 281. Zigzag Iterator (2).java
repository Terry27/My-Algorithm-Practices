public class ZigzagIterator {

    Deque<Iterator<Integer>> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new ArrayDeque<>();
        if(v1 != null && !v1.isEmpty()){
            queue.offerLast(v1.iterator());
        }
        if(v2 != null && !v2.isEmpty()){
            queue.offerLast(v2.iterator());
        }
    }

    public int next() {
        Iterator<Integer> itr = queue.pollFirst();
        int res = itr.next();
        if(itr.hasNext()){
            queue.offerLast(itr);
        }
        return res;
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */