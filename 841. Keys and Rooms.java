class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] opened = new boolean[rooms.size()];
        opened[0] = true;
        int count = 1;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(0); //or BFS offerLast
        while(!deque.isEmpty()){
            List<Integer> cur = rooms.get(deque.pollFirst());
            for(int key: cur){
                if(!opened[key]){
                    deque.offerFirst(key); //or BFS offerLast
                    opened[key] = true;
                    count++;
                }
            }
        }
        return count == rooms.size();
    }
}