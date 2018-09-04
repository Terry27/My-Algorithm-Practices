public class ZigzagIterator {
    Queue<Iterator> queue;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<Iterator>();
        if(!v1.isEmpty()){
            queue.offer(v1.listIterator());
        }
        if(!v2.isEmpty()){
            queue.offer(v2.listIterator());
        }
        
    }

    public int next() {
        Iterator itr = queue.poll();
        int res = (int)itr.next();
        if(itr.hasNext()){
            queue.offer(itr);
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