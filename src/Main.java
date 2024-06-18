public class Main {
	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<>();
		list.add("Hello");
		list.add("World!");
		list.add(1, "My Animation");
		list.remove(1);
		System.out.println(list);
	}
}