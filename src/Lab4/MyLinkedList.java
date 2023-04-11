package Lab4;

public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public MyLinkedList() {
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;
        if (tail == null) {
            tail = newNode;
        }
    }

    public void addLast(E e) {
        if (head == null) {
            addFirst(e);
            return;
        }

        Node<E> newNode = new Node<>(e);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void add(int index, E e) {
        if (head == null) {
            addFirst(e);
            return;
        }
        if (index > size - 1) {
            addLast(e);
            return;
        }
        Node<E> newNode = new Node<>(e);
        Node<E> curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    public E removeFirst() {
        if (head == null) {
            return null;
        }
        E result = head.element;
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return result;
    }

    public E removeLast() {
        if (head == null) {
            return null;
        }
        if (size == 1) {
            return removeFirst();
        }
        E result = tail.element;
        Node<E> curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        size--;
        tail = curr;
        return result;
    }

    public E remove(int index) {
        if (head == null) {
            return null;
        }
        if (size == 1) {
            return removeFirst();
        }
        if (index >= size - 1) {
            return removeLast();
        }
        Node<E> curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        E result = curr.next.element;
        curr.next = curr.next.next;
        size--;
        return result;
    }

    public boolean contains(E e) {
        if (head == null) {
            return false;
        }
        Node<E> curr = head;
        while (curr != null) {
            if (curr.element.equals(e)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public E get(int index) {
        if (head == null) {
            return null;
        }
        if (index >= size - 1) {
            return getLast();
        }
        if (index == 0) {
            return getFirst();
        }
        Node<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.element;
    }

    public E getFirst() {
        if (head == null) {
            return null;
        }
        return head.element;
    }

    public E getLast() {
        if (tail == null) {
            return null;
        }
        return tail.element;
    }

    public int indexOf(E e) {
        if (head == null) {
            return -1;
        }
        Node<E> curr = head;
        for (int i = 0; curr != null; i++, curr = curr.next) {
            if (curr.element.equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(E e) {
        if (head == null) {
            return -1;
        }
        Node<E> curr = head;
        int found = -1;
        for (int i = 0; curr != null; i++, curr = curr.next) {
            if (curr.element.equals(e)) {
                found = i;
            }
        }
        return found;
    }

    public E set(int index, E e) {
        if (head == null) {
            return null;
        }
        if (index > size - 1) {
            return null;
        }
        Node<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        E result = curr.element;
        curr.element = e;
        return result;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void print() {
        System.out.print("{");

        Node<E> curr = head;
        for (int i = 0; i < size; i++) {
            System.out.print(curr.element);
            if (i != size - 1) {
                System.out.print(", ");
            }
            curr = curr.next;
        }
        System.out.println("}");
    }

    public void reverse() {
        if (head == null) {
            return;
        }
        Node<E> curr = head;
        Node<E> previous = null;
        Node<E> next;
        while (curr.next != null) {
            next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }
        curr.next = previous;
        Node<E> oldTail = tail;
        tail = head;
        head = oldTail;
    }

    public int getSize() {
        return size;
    }
}
