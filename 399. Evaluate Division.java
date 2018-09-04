class Solution {
    
    HashSet<String> visited;
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        
        visited= new HashSet<String>();
        HashMap<String, ArrayList<String>> graph = new HashMap<>(); //arraylists with same position in graph and edgeValues are corresponded
        HashMap<String, ArrayList<Double>> edgeValues = new HashMap<>(); 
        
        for(int i = 0; i < equations.length; i++){ //preprocess
            String[] equation = equations[i];
            double val = values[i];
            if(!graph.containsKey(equation[0])){
                graph.put(equation[0], new ArrayList<String>());
                edgeValues.put(equation[0], new ArrayList<Double>());
            }
            if(!graph.containsKey(equation[1])){
                graph.put(equation[1], new ArrayList<String>());
                edgeValues.put(equation[1], new ArrayList<Double>());
            }
            graph.get(equation[0]).add(equation[1]);
            edgeValues.get(equation[0]).add(val);
            graph.get(equation[1]).add(equation[0]);
            edgeValues.get(equation[1]).add(1/val);
        }
        double[] res = new double[queries.length];
        //for each query, DFS the graph to see if they are connected
        for(int i = 0; i <queries.length; i++){
            String[] query = queries[i];
            if(query[0].equals(query[1])){
                if(graph.containsKey(query[0])){
                    res[i] =  1.0;    
                }else{
                    res[i] = -1.0;
                }
                continue;
            }
            res[i] = dfs(query[0], query[1], 1.0, graph, edgeValues);
            visited.clear(); //necessary
        }
        return res;
    }
    
    private double dfs(String cur, String dst, double val, HashMap<String, ArrayList<String>> graph, HashMap<String, ArrayList<Double>> edgeValues){
        if(cur.equals(dst)){return val;}
        visited.add(cur);
        double tmp = -1;
        ArrayList<String> neighbors = graph.get(cur);
        ArrayList<Double> neighborVals = edgeValues.get(cur);
        if(neighbors != null){
            for(int i = 0; i <neighbors.size(); i++){
                String neighbor = neighbors.get(i);
                if(visited.contains(neighbor)){continue;}
                tmp = dfs(neighbor, dst, val*neighborVals.get(i), graph, edgeValues); 
                if(Math.abs(tmp+1) >= 1e-8){ //return when necessary tmp != -1
                    return tmp;
                }
            }
        }
        visited.remove(cur);
        return tmp;
    }
}