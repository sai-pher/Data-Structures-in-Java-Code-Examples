package Lists;

import java.util.Collection;

/**
 * A class to represent a singly linked list.
 * This class models the basic implementation of a singly linked list
 * with only basic operations (add and remove) implemented.
 * This is to serve as a guide for data structures students.
 */
public class SinglyLinkedList<T> extends AbstractList<T> {

    private Node<T> head;
    private Node<T> tail = null;

    // ================================================================

    public SinglyLinkedList() {
        head = new Node<>();
        tail = new Node<>();
    }

    public SinglyLinkedList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    // ================================================================

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    /**
     * A method to add new data to a singly linked list.
     *
     * @param data new data to be added to list.
     * @return
     */
    public boolean add(T data) {
        Node<T> newData = new Node<T>(data);

        if (this.isEmpty()) {
            head = newData;
            tail = newData;
        }
        else {
            // step 1: refer to previous head
            newData.setNext(head);

            // step 2: change head reference
            head = newData;
        }

        return true;
    }

    @Override
    public void add(int index, T item) {
        // Write code here
    }

    @Override
    public boolean addAll(Collection<? extends T> items) {
        // Write code here
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T item) {
        // Write code here
        return null;
    }

    @Override
    public int indexOf(T item) {
        // Write code here
        return 0;
    }

    @Override
    public int lastIndexOf(T item) {
        // Write code here
        return 0;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        // Write code here
        return null;
    }

    /**
     * A method to remove the first instance of a give input from the list.
     *
     * @param data data to be removed from the list.
     * @return boolean true or false denoting if the data has been removed.
     */
    @Override
    public boolean remove(Object data) {
        if (this.isEmpty()) {
            return false;
        }
        else {
            Node<T> cur = head;

            // loop through list: use cur value to update loop condition
            if (!cur.equals(tail) & cur.hasNext()) {

                // do ensures it checks once even if cur is the tail.
                do {
                    Node<T> next = cur.getNext();  // assign cur's next to use better.

                    // check if the data in cur is equal to the data we are trying to remove.
                    if (cur.getData().equals(data)) {

                        // check if cur is the first thing in the list.
                        if (cur.equals(head) & cur.equals(tail)) {
                            head = null;            // reassign head reference.
                            tail = null;            // reassign tail reference.
                            return true;
                        }

                        // check if cur is only the head and refers to something else.
                        else if (cur.equals(head) & cur.hasNext()) {
                            head = cur.getNext();   // reassign head reference.
                            return true;
                        }
                    }

                    // check if the data in next is equal to the data we are trying to remove.
                    else if (next.getData().equals(data)) {

                        // check if next refers to tail.
                        if (next.equals(tail)) {
                            cur.setNext(null);      // set cur's reference to null.
                            tail = cur;             // reassign tail reference.
                            return true;
                        }

                        // check if next refers to something else
                        // and if its next is equal to what we are looking for.
                        // NOTE: this case removes a node if it is in the middle of the list.
                        else if (next.hasNext() & next.getData().equals(data)) {

                            // make sure cur's next refers to something else
                            if (next.hasNext()) {
                                cur.setNext(next.getNext());    // reassign cur's next reference.
                                return true;
                            }
                            else {
                                return false;
                            }
                        }
                        else {
                            return false;
                        }

                    }
                    else {
                        cur = cur.getNext();
                    }
                }
                while (!cur.equals(tail) & cur.hasNext());
            }
        }
        return false;
    }

    /**
     * A method to count the number of items in the list.
     *
     * @return the size of the list.
     */
    @Override
    public int size() {
        // Write code here:
        return 0;
    }

    /**
     * @return boolean true or false if list is empty.
     */
    @Override
    public boolean isEmpty() {
        return head == null & tail == null;
    }

    /**
     * A method to loop through the list and print out all the data in the list.
     */
    public void printAll() {
        // Write code here:
    }


    // ================================================================

    /**
     * Node class of a singly linked list.
     */
    private static class Node<T> {

        private T data;           // data to hold
        private Node<T> next = null;   // reference to the next node

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        T getData() {
            return data;
        }

        void setData(T data) {
            this.data = data;
        }

        Node<T> getNext() {
            return next;
        }

        void setNext(Node<T> next) {
            this.next = next;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?> node = (Node<?>) o;

            if (!data.equals(node.data)) return false;
            return next != null ? next.equals(node.next) : node.next == null;
        }

        @Override
        public int hashCode() {
            int result = data.hashCode();
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return String.format("Node{\ndata=%s, next=>%s}", data, next);
        }
    }
}
