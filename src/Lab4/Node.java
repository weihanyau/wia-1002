package Lab4;

public class Node<E> {
    //element for storing variable of type E
    protected E element;
    //next variable for pointing to the next node
    protected Node<E> next;

    //Empty constructor
    public Node() {}

    //Constructor that accepts variable of type E and stores it in element variable
    public Node(E e) {
        this.element = e;
    }
}
