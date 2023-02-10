package DataStructure;

/*
 * 벡터 구현하기 (자동 리사이징을 포함한 동적 배열):
 배열, 포인터 및 인덱싱 대신하여 특정 인덱스에 접근하는 포인터 연산을 통한 코딩 연습
 메모리 할당을 포함한 새 배열
배열 메소드 등의 기능을 활용하지 않으면서 정수 배열에 메모리를 할당할 수 있어야 함
16으로 시작하거나 시작하는 숫자가 크다면 2의 제곱수(16, 32, 64, 128)로 시작
 size() - 항목의 개수
 capacity() - 들어갈 수 있는 항목의 최대 개수
 is_empty()
 value_at(index) - 인덱스에 있는 항목을 돌려주고, 인덱스가 범위 밖이면 에러를 냄
 push(item)
 insert(index, item) - index에 item을 삽입하고 기존 인덱스의 값부터 쭉 오른쪽으로 쉬프트
 prepend(item) - 맨 앞에 원소를 삽입
 pop() - 마지막 원소를 삭제하고 값을 돌려준다
 delete(index) - delete item at index, shifting all trailing elements left
 remove(item) - looks for value and removes index holding it (even if in multiple places)
  find(item) - looks for value and returns first index with that value, -1 if not found
 resize(new_capacity) // private 함수
용량이 꽉 차면, 그 두배로 크기를 조정한다.
item을 하나 꺼낼 때, 용량이 1/4이라면, 용량을 절반으로 줄인다.
 시간 복잡도
접근, 수정, 끝에 추가/삭제하는 데 O(1)
다른 곳에 추가/삭제하는 데 O(n)
 공간 복잡도
메모리에 연속적으로 있어서, 근접성이 성능을 향상시킨다.
필요한 공간 = (n 이상인 배열의 용량) * item의 크기, 하지만 2n 크기에서는 여전히 O(n)
 */
public class Array {

	private int[] arr;
	private int size;
	private int capacity;

	public Array() {
		this.capacity = 16;
		this.arr = new int[capacity];
	}

	public int size() {
		return this.size;
	}

	public int capacity() {
		return this.capacity;
	}

	public boolean isEmpty() {
		if (this.size == 0)
			return true;

		return false;
	}

	public int valueAt(int index) {
		if (index < 0 || index >= capacity) {
			System.out.println("error!");
			return -1;
		}

		return arr[index];
	}

	public void prepend(int value) {
		if (size == capacity) {
			this.resize(this.capacity * 2);
		}

		for (int i = size; i > 0; i--) {
			this.arr[i] = this.arr[i - 1];
		}

		this.arr[0] = value;
		size++;

		return;
	}

	public void pushBack(int value) {
		if (size == capacity)
			this.resize(this.capacity * 2);

		this.arr[size++] = value;
	}

	public int pop() {
		if (size == 0) {
			System.out.println("남은 원소가 없습니다!");
			return -1;
		}

		if (this.size < (this.capacity / 4)) {
			resize(this.capacity / 2);
		}
		
		--size;
		return this.arr[size];
	}

	public int delete(int index) {
		int num = this.arr[index];

		for (int i = index; i < size - 1; i++) {
			this.arr[i] = this.arr[i + 1];
		}
		size--;

		return num;
	}

	public int remove(int value) {
		int index = this.find(value);

		if (index != -1) {
			this.delete(index);

		}

		return index;
	}

	public int find(int value) {
		for (int i = 0; i < this.size; i++) {
			if (this.arr[i] == value)
				return i;
		}

		return -1;
	}

	private void resize(int capacity) {
		System.out.println("Resizing! " + this.capacity + " -> " + capacity);

		this.capacity = capacity;
		int[] newArr = new int[this.capacity];

		for (int i = 0; i < this.size; i++) {
			newArr[i] = this.arr[i];
		}

		this.arr = newArr;
	}

}
