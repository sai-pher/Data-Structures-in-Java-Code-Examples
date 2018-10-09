package SinglyLinkedList;

/**
 * A class to represent a singly linked list.
 * This class models the basic implementation of a singly linked list
 * with only basic operations (add and remove) implemented.
 * This is to serve as a guide for data structures students.
 */
public class SinglyLinkedList_V1 {

    private Node head = null;

    // ================================================================
    private Node tail = null;

    public SinglyLinkedList_V1() {

    }

    public SinglyLinkedList_V1(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public static void main(String[] args) {

        // create a singly linked list
        SinglyLinkedList_V1 list = new SinglyLinkedList_V1();

        // insert 10 numbers into the list
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }


        // System.out.println(list);

        int numToRemove = 0;
        System.out.println("\nremoving: " + numToRemove);
        boolean bool = list.remove(numToRemove);

        // print out the content of the list here:
        // System.out.println("\n" + bool + "\n" +list);

    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    /**
     * A method to add new data to a singly linked list.
     *
     * @param data new data to be added to list.
     */
    public void add(int data) {
        Node newData = new Node(data);

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

    }

    /**
     * A method to remove the first instance of a give input from the list.
     *
     * @param data data to be removed from the list.
     * @return boolean true or false denoting if the data has been removed.
     */
    public boolean remove(int data) {
        if (this.isEmpty()) {
            return false;
        }
        else {
            Node cur = head;

            // loop through list: use cur value to update loop condition
            if (!cur.equals(tail) & cur.hasNext()) {

                // do ensures it checks once even if cur is the tail.
                do {
                    Node next = cur.getNext();  // assign cur's next to use better.

                    // check if the data in cur is equal to the data we are trying to remove.
                    if (cur.getData() == data) {

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
                    else if (next.getData() == data) {

                        // check if next refers to tail.
                        if (next.equals(tail)) {
                            cur.setNext(null);      // set cur's reference to null.
                            tail = cur;             // reassign tail reference.
                            return true;
                        }

                        // check if next refers to something else
                        // and if its next is equal to what we are looking for.
                        // NOTE: this case removes a node if it is in the middle of the list.
                        else if (next.hasNext() & next.getData() == data) {

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

    // helper methods

    /**
     * A method to loop through the list and print out all the data in the list.
     */
    public void printAll() {
        // Write code here:
    }

    /**
     * A method to count the number of items in the list.
     *
     * @return the size of the list.
     */
    public int getListSize() {
        // Write code here:
        return 0;
    }

    /**
     * @return boolean true or false if list is empty.
     */
    public boolean isEmpty() {
        return head == null & tail == null;
    }

    // ================================================================

    /**
     * Node class of a singly linked list.
     */
    private class Node {

        private int data;           // data to hold
        private Node next = null;   // reference to the next node

        Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        int getData() {
            return data;
        }

        void setData(int data) {
            this.data = data;
        }

        Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return data == node.data;
        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(data);
//        }

        @Override
        public String toString() {
            return "Node{" +
                    "\ndata=" + data +
                    ", next=>" + next +
                    "}";
        }
    }
}
