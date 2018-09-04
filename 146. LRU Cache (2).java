public class LRUCache {

    class Node{
    	Node prev;
    	Node next;
    	int key;
    	int val;
    	public Node(int key, int val){
    		this.key = key;
    		this.val = val;
    		prev = null;
    		next = null;
    	}
    }

    private Node head;
    private Node tail;
    private int capacity;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        detach(node);
        attach(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
        	Node temp = map.get(key);
        	temp.val = value;
        	detach(temp);
        	attach(temp);
        }else{ // new node
        	Node temp = new Node(key, value);
            // if(map.size() == capacity){
            // Node removed = head.next;
            // detach(removed);
            // map.remove(removed.key);
            // }
        	attach(temp);
        	map.put(key, temp);
        }
        if(map.size() > capacity){
        	Node removed = head.next;
        	detach(removed);
        	map.remove(removed.key);
        }
    }

    public void attach(Node node){
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    public void detach(Node node){
        node.prev.next = node.next;
    	node.next.prev = node.prev;
    	node.next = null;
    	node.prev = null;
    }
}
