/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution { //DFS approach
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return dfs(node, map);
    }
    
    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map){
        if(node == null){
            return null;
        }
        if(map.containsKey(node.label)){
            return map.get(node.label);
        }
        UndirectedGraphNode ClonedNode = new UndirectedGraphNode(node.label);
        
        // IMPORTANT, don't forget
        map.put(node.label, ClonedNode);
        
        for(UndirectedGraphNode child: node.neighbors){
            ClonedNode.neighbors.add(dfs(child, map));
        }
        return ClonedNode;
    }
}

public class Solution { //BFS approach
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        Deque<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offerLast(node);
        
        UndirectedGraphNode newStart = new UndirectedGraphNode(node.label);
        map.put(node.label, newStart);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode curr = queue.pollFirst();
            UndirectedGraphNode newCurr = map.get(curr.label);
            for(UndirectedGraphNode neighbor: curr.neighbors){
                UndirectedGraphNode cNeighbor= map.get(neighbor.label); //use get is way faster
                if(cNeighbor != null){
                    newCurr.neighbors.add(cNeighbor);
                }else{
                    cNeighbor = new UndirectedGraphNode(neighbor.label);
                    newCurr.neighbors.add(cNeighbor);
                    map.put(neighbor.label, cNeighbor);
                    queue.offerLast(neighbor);
                }
            }
        }
        return newStart;
    }
}