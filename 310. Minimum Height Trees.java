public class Solution {
    int n;
    List<Integer>[] graph;
    
    public void bfs(int startNode, int[] distance, int[] prev){
        boolean[] visited = new boolean[n];
        Deque<Integer> deque = new ArrayDeque<>(); //queue
        deque.offerLast(startNode);
        prev[startNode] = -1;
        visited[startNode] = true;
        while(!deque.isEmpty()){
            int cur = deque.pollFirst();
            for(int neighbor: graph[cur]){
                if(!visited[neighbor]){
                    distance[neighbor] = distance[cur]+1;
                    prev[neighbor] = cur;
                    visited[neighbor] = true;
                    deque.offerLast(neighbor);
                }
            }
        }
    }
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        this.n = n;
        graph = new List[n];
        for(int i= 0; i< n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] dist1 = new int[n];
        bfs(0, dist1, new int[n]);
        int maxDis = -1;
        int maxIndex = 0;
        for(int i = 0; i< n; i++){
            if(dist1[i] > maxDis){
                maxDis = dist1[i];
                maxIndex = i;
            }
        }
        
        int[] dist2 = new int[n];
        int[] prev = new int[n];
        maxDis = -1;
        bfs(maxIndex, dist2, prev);
        for(int i = 0; i< n; i++){
            if(dist2[i] > maxDis){
                maxDis = dist2[i];
                maxIndex = i;
            }
        }
        List<Integer> res= new ArrayList<>();
        while(maxIndex != -1){
            res.add(maxIndex);
            maxIndex = prev[maxIndex];
        }
        if(res.size() % 2 == 0){
            return Arrays.asList(res.get(res.size()/2-1), res.get(res.size()/2));
        }
        return Arrays.asList(res.get(res.size()/2));
    }
}

public class Solution { //degree topological
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if( n == 1){
            return Arrays.asList(0);
        }
        List<Integer>[] graph = new List[n];
        int[] degree = new int[n];
        for(int i= 0; i< n; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2;
        
        int count = n;
        for(int i = 0; i< n; i++){
            
            if(degree[i] == 1){
                deque1.offerLast(i);
                count--;
                degree[i]--;
            }
        }
        while(count != 0){
            deque2 = new ArrayDeque<>();
            while(!deque1.isEmpty()){
                int cur = deque1.pollFirst();
                for(int neighbor: graph[cur]){
                    degree[neighbor]--;
                    if(degree[neighbor] == 1){
                        deque2.offerLast(neighbor);
                        count--;
                    }
                }
            }
            deque1 = deque2;
        }
        if(deque1.size() == 2){
            return Arrays.asList(deque1.pollFirst(), deque1.pollFirst());
        }
        return Arrays.asList(deque1.pollFirst());
    }
}