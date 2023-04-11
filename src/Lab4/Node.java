package Lab4;

public class Node<E> {
    protected E element;
    protected Node<E> next;

    public Node() {}

    public Node(E e) {
        this.element = e;
    }
}
