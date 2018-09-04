// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Integer nextElem;
    private Iterator<Integer> itr;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    itr = iterator;
	    if(itr.hasNext()){
	        nextElem = itr.next();
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextElem;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int old = nextElem;
	    nextElem = itr.hasNext()? itr.next(): null; //Important
	    return old;
	}

	@Override
	public boolean hasNext() {
	    return nextElem != null;
	}
}