class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map=new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev=head;
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        addToEnd(node);
        return node.value;
    }

    private void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev =node.prev;

    }

    private void addToEnd(Node node)
    {
        Node previous = tail.prev;
        previous.next= node;
        node.prev = previous;
        node.next= tail;
        tail.prev=node;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addToEnd(node);
            return;
        }

        if(map.size()>=capacity)
        {
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }

        Node node = new Node(key,value);
        map.put(key,node);
        addToEnd(node);
    }
}

public class Node
{
    int key;
    int value;
    Node prev;
    Node next;

    

    public Node(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
}
