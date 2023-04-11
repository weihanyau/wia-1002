package Lab4;

public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.addLast("a");
        linkedList.addLast("b");
        linkedList.addLast("c");
        linkedList.addLast("d");
        linkedList.addLast("e");
        System.out.println("Linked list:");
        linkedList.print();
        System.out.println("Reverse linked list:");
        linkedList.reverse();
        linkedList.print();
        System.out.println("Linked list size: " + linkedList.getSize());
        System.out.println("First value: " + linkedList.getFirst());
        System.out.println("Last value: " + linkedList.getLast());
        System.out.println("Deleted third value: " + linkedList.remove(2));
        System.out.println("Linked list after deleted third value:");
        linkedList.print();
        System.out.println("Second item (b) index location: " + linkedList.indexOf("b"));
        System.out.println("Third item (d) index location: " + linkedList.indexOf("d"));
        System.out.println("List contains (c): " + linkedList.contains("c"));
        linkedList.set(0, "j");
        linkedList.set(1, "a");
        linkedList.set(2, "v");
        linkedList.set(3, "a");
        System.out.println("Linked list replace items individually:");
        linkedList.print();
    }
}
