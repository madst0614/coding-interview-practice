package DataStructure;

/*
 *  size() - 리스트 안의 데이터 개수를 반환한다.
 empty() - 리스트가 비어있다면 true를 반환한다.
 value_at(index) - index번째 위치의 value을 반환한다. (가장 앞은 0부터 시작한다.)
 push_front(value) - 가장 앞에 value를 추가한다.
 pop_front() - 가장 앞에 있는 것을 제거하고, 그 value를 반환한다.
 push_back(value) - 가장 끝에 value을 추가한다.
 pop_back() - 가장 끝에 있는 것을 제거하고, 그 value를 반환한다.
 front() - 가장 앞에 있는 것의 value를 가져온다.
 back() - 가장 끝에 있는 것의 value를 가져온다.
 insert(index, value) - index번째 위치에 value를 추가한다. 즉, index번째에 새로 추가된 것이 기존의 index번째에 있던 것을 가리킨다.
 erase(index) - index번째에 있는 노드를 삭제한다.
 value_n_from_end(n) - 뒤에서부터 n번째에 있는 노드의 value를 반환한다.
 reverse() - 리스트를 뒤집는다.
 remove_value(value) - value와 같은 값을 가지는 첫 번째 노드를 제거한다.
 */
public class LinkedList {

	private LinkedListNode head;
	private LinkedListNode tail;
	private int size;

	public LinkedList() {
		this.head = new LinkedListNode();
		this.tail = new LinkedListNode();
	}

	public int size() {
		return this.size;
	}

	public boolean empty() {
		if (size == 0)
			return true;

		return false;
	}

	public int valueAt(int index) {
		if (index >= size) {
			System.out.println("존재하지 않는 index 입니다.");
			return -1;
		}

		LinkedListNode temp = head.link;
		for (int i = 0; i < index; i++) {
			temp = temp.link;
		}

		return temp.data;
	}

	public void pushFront(int value) {
		LinkedListNode node = new LinkedListNode(value);

		if (this.head.link == null) {
			this.head.link = node;
			this.tail.link = node;
		} else {
			node.link = this.head.link;
			this.head.link = node;
		}

		this.size++;

		return;
	}

	public int popFront() {

		LinkedListNode node = this.head.link;
		int value = node.data;

		if (this.head.link == null) {
			System.out.println("리스트가 비어있습니다.");
			return -1;
		} else if (this.head.link == this.tail.link) {
			this.head.link = null;
			this.tail.link = null;
		} else {
			this.head.link = this.head.link.link;
		}

		size--;

		return value;
	}

	public int getFront() {
		return this.head.link.data;
	}

	public int getBack() {
		return this.tail.link.data;
	}

	public void insert(int index, int value) {
		if (index >= this.size) {
			System.out.println("index 오류!");

			return;
		}

		LinkedListNode prev = null;
		LinkedListNode node = this.head.link;

		for (int i = 0; i < index - 1; i++) {
			prev = node;
			node = node.link;
		}

		prev.link = new LinkedListNode(value, node);
	}

	public int erase(int index) {
		if (index >= this.size) {
			System.out.println("index 오류!");

			return -1;
		}
		LinkedListNode prev = null;
		LinkedListNode node = this.head.link;
		for (int i = 0; i < index - 1; i++) {
			prev = node;
			node = node.link;
		}

		int value = node.data;
		prev.link = node.link;

		return value;
	}

	public int valueNFromEnd(int n) {
		int index = this.size - n - 1;

		LinkedListNode node = this.head.link;

		for (int i = 0; i < index - 1; i++) {
			node = node.link;
		}

		return node.data;
	}

	public void reverse() {
		LinkedListNode prev, next;
		LinkedListNode node = this.head.link;

		while (node.link != null) {
			prev = node;
			next = node.link;

			node.link = prev;
			node = next;
		}
	}

	public int removeValue(int value) {
		LinkedListNode node = this.head.link;
		LinkedListNode prev = node;

		while ( node.link != null && node.data != value){
			prev = node;
			node = node.link;
		}
		
		if(node.data == value) {
			prev.link = node.link;
			
			return value;
		}
		else {
			System.out.println("찾는 값이 리스트 내에 없습니다!");
			return -1;
		}
			
	}

}
