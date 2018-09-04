public class NestedIterator implements Iterator<Integer> {
    
    Deque<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<NestedInteger>();
        for(int i = nestedList.size()-1; i >=0; i--){
            stack.offerLast(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pollLast().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()&& !stack.peekLast().isInteger()){ //always check emptyness
            NestedInteger cur = stack.pollLast();
            for(int i = cur.getList().size()-1; i >=0; i--){
                stack.offerLast(cur.getList().get(i));
            }
        }
        return !stack.isEmpty();
    }
}