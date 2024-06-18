public class MyLinkedList<E> {
	private Node<E> head;
	private int numNodes = 0;
	
	public MyLinkedList() {
	}
	
	public MyLinkedList(Node<E> head, int numNodes) {
		this.head = head;
		this.numNodes = numNodes;
	}
	
	public Node<E> getHead() {
		return head;
	}
	
	public void setHead(Node<E> head) {
		this.head = head;
	}
	
	public int getNumNodes() {
		return numNodes;
	}
	
	public void setNumNodes(int numNodes) {
		this.numNodes = numNodes;
	}
	
	public void add(int index, E element) {
		if (index < 0 || index > numNodes) {
			System.err.println("Vượt quá số lượng mảng");
			return;
		}
		// tìm ra vị trí (index-1) và (index)
		Node<E> newElement = new Node<>(element, getNode(index));
		Node<E> prevNode = getNode(index - 1);
		prevNode.setNext(newElement);
		numNodes++;
	}
	
	private Node<E> getNode(int index) {
		Node<E> current = this.head;
		int i = 0;
		while (current != null) {
			if (i == index) {
				return current;
			}
			current = current.getNext();
			i++;
		}
		return null;
	}
	
	public void addFirst(E element) {
		add(0, element);
	}
	
	public void addLast(E element) {
		add(element);
	}
	
	public E remove(int index) {
		Node<E> prevNode = getNode(index - 1);
		Node<E> nextNode = getNode(index + 1);
		prevNode.setNext(nextNode);
		numNodes--;
		Node<E> current = getNode(index);
		return current.getData();
	}
	
	public E remove(E element) {
		return remove(indexOf(element));
	}
	
	public int size() {
		return this.numNodes;
	}
	
	public E clone() {
		return null;
	}
	
	public boolean contains(E element) {
		return indexOf(element) >= 0;
	}
	
	public int indexOf(E element) {
		Node<E> current = this.head;
		int i = 0;
		while (current != null) {
			if (current.getData().equals(element)) {
				return i;
			}
			i++;
			current = current.getNext();
		}
		return -1;
	}
	
	public boolean add(E element) {
		if (this.head == null) {
			this.head = new Node<>(element, null);
		} else {
			Node<E> current = this.head;
			int i = 0;
			while (true) {
				if (current.getNext() == null) {
					break;
				}
				current = current.getNext();
			}
			Node<E> newElement = new Node<>(element, null);
			current.setNext(newElement);
		}
		numNodes++;
		return true;
	}
	
	public void ensureCapacity(int minCapacity) {
	
	}
	
	public E get(int index) {
		Node<E> current = this.head;
		int i = 0;
		while (current != null) {
			if (i == index) {
				return current.getData();
			}
			current = current.getNext();
			i++;
		}
		return null;
	}
	
	public E getFirst() {
		return this.head.getData();
	}
	
	public E getLast() {
		Node<E> current = this.head;
		int i = 0;
		while (true) {
			if (current.getNext() == null) {
				break;
			}
			current = current.getNext();
		}
		return current.getData();
	}
	
	public void clear() {
		this.numNodes = 0;
		this.head = null;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		Node<E> current = this.head;
		while (current != null) {
			result.append(current.getData());
			if (current.getNext() != null) {
				result.append(" ,");
			}
			current = current.getNext();
		}
		result.append("]");
		return result.toString();
	}
}
