import java.util.HashMap;

public class LRUCache {
	private HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
	private DoubleLinkedListNode head;		/* Most recently used */
	private DoubleLinkedListNode tail;		/* Least recently used */
	private int capacity;
	private int length;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		length = 0;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			DoubleLinkedListNode latest = map.get(key);
			removeNode(latest);
			setHead(latest);
			return latest.val;
		}
		else {
			return -1;
		}
	}

	public void removeNode(DoubleLinkedListNode node) {
		DoubleLinkedListNode curr = node;
		DoubleLinkedListNode prev = node.prev;
		DoubleLinkedListNode post = curr.next;

		if ( prev != null ) {
			prev.next = post;
		} else {
			head = post;
		}

		if ( post != null ) {
			post.prev = prev;
		} else {
			tail = prev;
		}
	}

	public void setHead (DoubleLinkedListNode node) {
		node.next = head;
		node.prev = null;
		if (head != null) {
			head.prev = node;
		}

		head = node;
		if (tail == null) {
			tail = node;
		}
	}

	public void set ( int key, int value ) {
		if (map.containsKey(key)) {
			DoubleLinkedListNode oldNode = map.get(key);
			oldNode.val = value;
			removeNode(oldNode);
			setHead(oldNode);
		} else {
			DoubleLinkedListNode newNode = new DoubleLinkedListNode(key,value);
			if (length < capacity) {
				setHead(newNode);
				map.put(key,newNode);
				length++;
			} else {
				map.remove(tail.key);
				tail = tail.prev;
				if (tail != null) {
					tail.next = null;
				}
				setHead(newNode);
				map.put(key,newNode);
			}
		}
	}

}


class DoubleLinkedListNode {
	public int key;
	public int val;
	public DoubleLinkedListNode prev;
	public DoubleLinkedListNode next;

	public DoubleLinkedListNode (int key, int val) {
		this.val = val;
		this.key = key;
	}

}