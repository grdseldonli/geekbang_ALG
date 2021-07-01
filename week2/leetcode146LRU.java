class LRUCache {
	public int capacity=0;
	class Node{
		public Node pre;
		public Node next;
		public int key;
		public int value;
		
	}
	
	public Node head =new Node();;
	public Node tail = new Node();
	
	
	public Map<Integer, Node> map=new HashMap<Integer,Node>();
	

    public LRUCache(int capacity) {
    	head.next=tail;
    	tail.pre=head;
    	head.pre=null;
    	tail.next=null;
    	this.capacity=capacity;
    }
    
    public int get(int key) {
    	if(map.containsKey(key)) {
    		
    		removeKeyFromList(map.get(key));
    		insertKeyToList(map.get(key));
    		return map.get(key).value;
    	}else {
    		
    		return -1;
    	}


    }
    
    public void put(int key, int value) {
    	if(map.containsKey(key)) {
    		removeKeyFromList(map.get(key));
    	}
    		
    		
        Node nodeinsert= new Node();
        nodeinsert.key=key;
        nodeinsert.value=value;
        map.put(key, nodeinsert);
    	
    	insertKeyToList(map.get(key));
    	
    	if(map.size()>capacity) {
    		removeKeyFromTail();
    		
    	}
    }
    public void removeKeyFromList(Node node) {
    	node.pre.next=node.next;
    	node.next.pre=node.pre;	
    }
    public void removeKeyFromTail() {
    	map.remove(tail.pre.key);

    	tail.pre.pre.next=tail;
    	tail.pre=tail.pre.pre;

    }
    public void insertKeyToList(Node node) {
    	Node temp=head.next;
    	head.next=node;
    	node.pre=head;
    	temp.pre=node;
    	node.next=temp;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */