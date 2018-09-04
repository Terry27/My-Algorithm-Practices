class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> getFactors(int n) {
        res = new ArrayList<>();
        helper(new ArrayList<Integer>(), 2, n);
        return res;
    }
    
    private void helper(ArrayList<Integer> list, int start, int upperBound){
        if(upperBound <= 1){
            if(list.size() > 1){
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }
        // need start to avoid duplicates
        for(int i = start; i <= upperBound; i++){
            if(upperBound % i == 0){
                list.add(i);
                helper(list, i, upperBound/i);
                list.remove(list.size()-1);
            }
        }
    }
}

// Time complexity: O(NlogN). The explns are in the following:

// formula 1: time = (the number of nodes in the recursive tree) * (the time each node takes up)
// formula 2: the number of nodes in the recursive tree  = 
//                  (the most number of branches among each node) ^ (the height of the tree)
// For the number of branches, it has at most N (from 2 to n) and in terms of the height of the tree, it should be logN since when the given number n is only decomposed by 2 will lead to the solution which has the longest length (pls take 32 as example in the description page). Thus, the number of nodes = (N)^(logN). And since each node only takes up O(1) time, therefore, the total time should be O(N^(logN))

// Space complexity: O(logN)
// Things will cost EXTRA space:
// 1. the number of call stacks invoked = the height of the recursive tree = logN
// 2. the item used to store the current solution which takes up logN at most (again, when the input n is only decomposed by 2)