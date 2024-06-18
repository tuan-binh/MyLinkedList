public class Main {
	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<>();
		list.add("Hello");
		list.add("World!");
		list.add(1, "My Animation");
//		list.add(1, "Animals");
//		System.out.println(list.get(2));
		list.remove(1);
		System.out.println(list);
	}
}