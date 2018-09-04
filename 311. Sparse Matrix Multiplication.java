class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        HashMap<Integer, HashMap<Integer, Integer>> aMap = convert(A); //(row, col, val)
        HashMap<Integer, HashMap<Integer, Integer>> bMap = convert(B);//(col, row, val)
        // save B as col, row for easy searching
        for(Map.Entry<Integer, HashMap<Integer, Integer>> xEntryA: aMap.entrySet()){
            int xA = xEntryA.getKey();
            HashMap<Integer,Integer> mapA = xEntryA.getValue();
            for(Map.Entry<Integer, Integer> yEntryA: mapA.entrySet()){
                int yA = yEntryA.getKey();
                int valA = yEntryA.getValue();
                // row based, each valA in colA should multiply with elements in rowB == colA
                HashMap<Integer, Integer> mapB = bMap.get(yA);
                if(mapB != null){
                    for(Map.Entry<Integer, Integer> yEntryB: mapB.entrySet()){
                        int yB = yEntryB.getKey();
                        int valB = yEntryB.getValue();
                        C[xA][yB] += valA*valB; //result is rowA, colB
                    }
                }
            }
        }
        return C;        
    }
    
    private HashMap<Integer, HashMap<Integer, Integer>> convert(int[][] mat){
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] != 0){
                    map.putIfAbsent(i, new HashMap<>());
                    map.get(i).put(j, mat[i][j]);
                }
            }
        }
        return map;
    }
    
}


class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        HashMap<Integer, HashMap<Integer, Integer>> aMap = convert(A); //(row, col, val)
        HashMap<Integer, HashMap<Integer, Integer>> bMap = revConvert(B);//(col, row, val)
        // save B as col, row for easy searching
        for(Map.Entry<Integer, HashMap<Integer, Integer>> xEntryA: aMap.entrySet()){
            int xA = xEntryA.getKey();
            HashMap<Integer,Integer> mapA = xEntryA.getValue();
            for(Map.Entry<Integer, Integer> yEntryA: mapA.entrySet()){
                int yA = yEntryA.getKey();
                int valA = yEntryA.getValue();
                //for each (row, col, val) in A, 
                // find in which cols in B that yA == xB
                for(Map.Entry<Integer, HashMap<Integer, Integer>> yEntryB: bMap.entrySet()){
                    //for each col in B
                    int yB = yEntryB.getKey();
                    HashMap<Integer,Integer> mapB = yEntryB.getValue();
                    // if(mapB.containsKey(yA)){
                    //     int valB = mapB.get(yA);
                    //     C[xA][yB] += valA * valB;
                    // }
                    Integer valB = mapB.get(yA);
                    if(valB != null){
                        C[xA][yB] += valA * valB;
                    }
                }
            }
        }
        return C;        
    }
    
    private HashMap<Integer, HashMap<Integer, Integer>> convert(int[][] mat){
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] != 0){
                    map.putIfAbsent(i, new HashMap<>());
                    map.get(i).put(j, mat[i][j]);
                }
            }
        }
        return map;
    }
    
        private HashMap<Integer, HashMap<Integer, Integer>> revConvert(int[][] mat){
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] != 0){
                    map.putIfAbsent(j, new HashMap<>());
                    map.get(j).put(i, mat[i][j]);
                }
            }
        }
        return map;
    }
}