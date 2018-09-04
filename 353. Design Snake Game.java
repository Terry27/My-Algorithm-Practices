public class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
        
    int row;
    int col;
    int score;
    Deque<Integer> deque;
    BitSet bs;
    int[][] food;
    int foodIndex;
    
    public SnakeGame(int width, int height, int[][] food) {
        row = height;
        col = width;
        score = 0;
        this.food = food;
        deque = new ArrayDeque<>();
        deque.offerLast(0);
        bs = new BitSet(width*height);
        bs.set(0, true);
        foodIndex = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int curRow = deque.peekLast() / col; 
        int curCol = deque.peekLast() % col;
        
        switch(direction){
            case "U":
                curRow--;
                break;
            case "L":
                curCol--;
                break;
            case "R":
                curCol++;
                break;
            case "D":
                curRow++;
                break;
            default:
                return -1;
                //break;
        }
        int newHead = curRow*col+ curCol;
        // remove tail first, since newHead can be at current tail position 
        int curTail = deque.pollFirst();
        bs.set(curTail, false);
        
        // dead case, hit walls or hit itself
        if(curRow < 0 || curRow >= row || curCol < 0 || curCol >= col || bs.get(newHead)){
            return -1;
        }
        
        // food case
        if(foodIndex < food.length && food[foodIndex][0] == curRow && food[foodIndex][1] == curCol){
            foodIndex++;
            bs.set(newHead, true);
            bs.set(curTail, true);
            deque.offerLast(newHead);
            deque.offerFirst(curTail);
            return ++score;
        }
        
        bs.set(newHead, true);
        deque.offerLast(newHead);
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */