//CANNOT use treeset, because duplicate values are not allowed in treeset
class Solution { //TREEMAP, O(nlogn) all ops are logn by treemap
    public List<int[]> getSkyline(int[][] buildings) {
        //enter, enter, pick highest
        //leave, leave, pick lowest
        //enter, leave, pick enter
        
        List<int[]> res = new ArrayList<>();
        if(buildings == null || buildings.length == 0 || buildings[0].length == 0){return res;}
        List<int[]> points = new ArrayList<>();
        
        for(int[] building: buildings){
            points.add(new int[]{building[0], building[2]}); //1 means is entering
            points.add(new int[]{building[1], -building[2]}); //negative means is leaving
        }
        Collections.sort(points, (a,b)-> (a[0] == b[0] ? Integer.compare(b[1],a[1]):Integer.compare(a[0],b[0]))); 
        //sort by X axis first, if X is same, sort height in descending order, so enter is max first, and leaving is min first
        TreeMap<Integer, Integer> DS = new TreeMap<>();
        DS.put(0, Integer.MAX_VALUE);
        int prev = 0;
        for(int[] height: points){
            if(height[1] > 0){ //a entering point, check max
                DS.put(height[1], DS.getOrDefault(height[1], 0) + 1);
            }else{
                //do not need to worry about key being null
                int freq = DS.get(-height[1]);
                if(freq == 1){
                    DS.remove(-height[1]);                    
                }else{
                    DS.put(-height[1], freq -1);                    
                }
            }
            int cur = DS.lastKey();
            if(prev != cur){
                res.add(new int[]{height[0], cur});
                prev = cur; 
            }
        }
        
        return res;
    }
}

class Solution { //PriorityQueue, O(n^2) because remove is O(n)
    public List<int[]> getSkyline(int[][] buildings) {
        //enter, enter, pick highest
        //leave, leave, pick lowest
        //enter, leave, pick enter
        
        List<int[]> res = new ArrayList<>();
        if(buildings == null || buildings.length == 0 || buildings[0].length == 0){return res;}
        List<int[]> points = new ArrayList<>();
        
        for(int[] building: buildings){
            points.add(new int[]{building[0], building[2]}); //1 means is entering
            points.add(new int[]{building[1], -building[2]}); //negative means is leaving
        }
        Collections.sort(points, (a,b)-> (a[0] == b[0] ? Integer.compare(b[1],a[1]):Integer.compare(a[0],b[0]))); 
        //sort by X axis first, if X is same, sort height in descending order, so enter is max first, and leaving is min first
        PriorityQueue<Integer> DS = new PriorityQueue<>((a,b)->(Integer.compare(b,a))); //sort height in descending order
        DS.offer(0);
        int prev = 0;
        for(int[] height: points){
            if(height[1] > 0){ //a entering point, check max
                DS.offer(height[1]);
            }else{
                DS.remove(-height[1]);
            }
            int cur = DS.peek();
            if(prev != cur){
                res.add(new int[]{height[0], cur});
                prev = cur; 
            }
        }
        
        return res;
    }
}

