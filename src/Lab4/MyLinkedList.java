package Lab4;

public class MyLinkedList<E> {
    //Head node that points to the first node
    private Node<E> head;
    //Tail node that points to the last node
    private Node<E> tail;
    //Size integer variable that keep tracks of the number of
    //element in the linked list
    private int size = 0;

    //Default constructor
    public MyLinkedList() {
    }

    public void addFirst(E e) {
        //Declare a new node with e
        Node<E> newNode = new Node<>(e);

        //newNode's next pointer to head
        newNode.next = head;
        //Set the head pointer to the newNode
        head = newNode;
        size++;
        if (tail == null) {
            tail = newNode;
        }
    }

    public void addLast(E e) {
        //If linked list is empty
        if (head == null) {
            addFirst(e);
            return;
        }

        //If linked list is not empty
        Node<E> newNode = new Node<>(e);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void add(int index, E e) {
        //Check whether the linked list is empty
        if (head == null || index == 0) {
            addFirst(e);
            return;
        }
        //Check if index is bigger than the size of the linked list - 1
        if (index > size - 1) {
            addLast(e);
            return;
        }

        //If the index is in the middle of the linked list
        Node<E> newNode = new Node<>(e);
        //Declare curr variable as pointer to the target index
        Node<E> curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    public E removeFirst() {
        //Check if linked list is empty
        if (head == null) {
            return null;
        }
        //If the linked list is not empty
        //Save the result of head element since will be unable to access
        //after removing
        E result = head.element;
        //Set the head pointer to the 2nd node in the linked list
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return result;
    }

    public E removeLast() {
        //Check if linked list is empty
        if (head == null) {
            return null;
        }
        //If only 1 element in linked list, we removeFirst()
        if (size == 1) {
            return removeFirst();
        }
        //Save the result of head element since will be unable to access
        //after removing
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
        //Check if linked list is empty
        if (head == null) {
            return null;
        }
        //If only 1 element in linked list, we removeFirst()
        if (size == 1) {
            return removeFirst();
        }
        //Check if index is bigger than the size of the linked list - 1
        if (index >= size - 1) {
            return removeLast();
        }
        Node<E> curr = head;
        //Go to the node before the target index
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        E result = curr.next.element;

        //Set the curr next pointer to the next next node (remove reference
        //for the next node by pointing directly to next next node)
        curr.next = curr.next.next;
        size--;
        return result;
    }

    public boolean contains(E e) {
        //Check if linked list is empty
        if (head == null) {
            return false;
        }
        Node<E> curr = head;
        //Go through the whole linked list
        while (curr != null) {
            //Check whether curr.element equals to e
            if (curr.element.equals(e)) {
                return true;
            }
            //Go through the next node
            curr = curr.next;
        }

        //No equals element, return false
        return false;
    }

    public E get(int index) {
        //Check if linked list is empty
        if (head == null) {
            return null;
        }
        if (index >= size - 1) {
            return getLast();
        }
        if (index == 0) {
            return getFirst();
        }
        //If in the middle of the linked list
        Node<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.element;
    }

    public E getFirst() {
        //Check if linked list is empty
        if (head == null) {
            return null;
        }
        //Return head element
        return head.element;
    }

    public E getLast() {
        //Check if linked list is empty
        if (tail == null) {
            return null;
        }
        //Return tail element
        return tail.element;
    }

    public int indexOf(E e) {
        //Check if linked list is empty
        if (head == null) {
            return -1;
        }

        Node<E> curr = head;

        //For loop that go through the whole linked list
        for (int i = 0; curr != null; i++, curr = curr.next) {
            if (curr.element.equals(e)) {
                return i;
            }
        }
        //Otherwise if no matching element, return -1
        return -1;
    }

    public int lastIndexOf(E e) {
        if (head == null) {
            return -1;
        }
        Node<E> curr = head;
        //We declare variable found = -1 (not found)
        int found = -1;
        for (int i = 0; curr != null; i++, curr = curr.next) {
            if (curr.element.equals(e)) {
                found = i;
            }
        }
        return found;
    }

    public E set(int index, E e) {
        //Check if linked list is empty
        if (head == null) {
            return null;
        }
        //Check if index is bigger than linked list size - 1
        if (index > size - 1) {
            return null;
        }
        Node<E> curr = head;
        //For loop to go to target index
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        E result = curr.element;
        curr.element = e;
        return result;
    }

    public void clear() {
        //Set head and tail to null to remove reference
        //Garbage collector will remove the unreferenced node from memory
        head = null;
        tail = null;
        size = 0;
    }

    public void print() {
        System.out.print("{");

        Node<E> curr = head;
        for (int i = 0; i < size; i++) {
            System.out.print(curr.element);
            //If the index is not at the last node, print ', '
            if (i != size - 1) {
                System.out.print(", ");
            }
            curr = curr.next;
        }
        System.out.println("}");
    }

    public void reverse() {
        //Check if linked list is empty
        if (head == null) {
            return;
        }
        Node<E> curr = head;
        Node<E> previous = null;
        Node<E> next;
        //Go through each node
        while (curr.next != null) {
            //Save the next node into the next variable
            next = curr.next;
            //Set the curr next pointer to the previous node
            curr.next = previous;
            //Set the previous node to the curr node (for the next node)
            previous = curr;
            //Go to the next node
            curr = next;
        }
        //Set the next pointer of the last node manually since
        //will exit the while loop early during the second last node
        curr.next = previous;
        //Swap head with tail
        Node<E> oldTail = tail;
        tail = head;
        head = oldTail;
    }

    public int getSize() {
        return size;
    }
}
