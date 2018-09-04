public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0 || people[0].length == 0){
            return new int[][]{};
        }
        //List<int[]> res = new LinkedList<>();
        //sort in descending order
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] == b[0]? a[1]-b[1]: b[0]-a[0];
            }
        });
        
        List<int[]> res = new ArrayList<int[]>();
        for(int[] cur : people){
        	res.add(cur[1],cur);       
        }
        return res.toArray(new int[people.length][]);
        
    }
}

