public class Vector2D implements Iterator<Integer> {
    
    
    private Iterator<List<Integer>> itrList;
	private Iterator<Integer> itrInt;
	
	public Vector2D(List<List<Integer>> vec2d){
		itrList = vec2d.iterator();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		while( (itrInt == null || !itrInt.hasNext()) && itrList.hasNext()){
			itrInt = itrList.next().iterator();
		}
		return itrInt != null && itrInt.hasNext();
	}

	@Override
	public Integer next() {
		return itrInt.next();
	}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */