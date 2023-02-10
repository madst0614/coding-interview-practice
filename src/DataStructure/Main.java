package DataStructure;

public class Main {
	public static void main(String[] args) {
		Array arr = new Array();
		
		System.out.println(arr.size());
		System.out.println(arr.capacity());
		System.out.println(arr.isEmpty());
		arr.prepend(-1);
		System.out.println(arr.valueAt(0));
		arr.pushBack(-2);
		System.out.println(arr.valueAt(1));
		System.out.println(arr.pop());
		System.out.println(arr.pop());
		arr.pop();
		arr.prepend(-1);
		arr.prepend(-2);
		arr.prepend(-3);
		System.out.println(arr.valueAt(0));
		System.out.println(arr.valueAt(1));
		System.out.println(arr.valueAt(2));
		System.out.println(arr.delete(0));
		System.out.println(arr.remove(-2));
		System.out.println("----------");
		for(int i=0; i<16; i++) {
			arr.prepend(i);
		}
		for(int i=0; i<16; i++) {
			System.out.println(arr.pop());
		}
		
	}

}
