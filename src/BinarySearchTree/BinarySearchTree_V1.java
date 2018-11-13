package BinarySearchTree;

import java.util.Objects;

/**
 * A class to model a basic binary search tree.
 */
public class BinarySearchTree_V1 {

    private Node root;

    /**
     * @param data Initializes root for binary tree.
     */
    public BinarySearchTree_V1(int data) {
        this.root = new Node(data);
    }

    public static void main(String[] args) {

        BinarySearchTree_V1 tree = new BinarySearchTree_V1(7);

        // test tree methods here.

    }

    /**
     * Calls recursive insert method.
     *
     * @param data Data to be inserted.
     */
    public void insert(int data) {
        root = recurseInsert(root, data);
    }

    /**
     * @param cur  Current node in question.
     * @param data Data in node in question.
     * @return Returns node.
     */
    private Node recurseInsert(Node cur, int data) {

        // Insert function base case. Creates a new node and inserts it if cur is null.
        if (cur == null) {
            cur = new Node();
            cur.setData(data);
            return cur;
        }

        // Recursive traversal.
        else {

            // Traverse left if data is less than or equal to cur.data.
            if (data <= cur.getData()) {
                cur.setLeftChild(recurseInsert(cur.getLeftChild(), data));
            }
            //Traverse right if data is less than cur.data.
            else if (data > cur.getData()) {
                cur.setRightChild(recurseInsert(cur.getRightChild(), data));
            }
        }
        return cur;
    }

    /**
     * Calls recursive delete method.
     *
     * @param data Data to be deleted.
     */
    public void delete(int data) {
        root = recurseDelete(root, data);
    }

    /**
     * @param cur  Current node in question.
     * @param data Data in node in question(To be deleted).
     * @return Returns node that was deleted.
     */
    private Node recurseDelete(Node cur, int data) {
        // Delete function base case. returns null to signal a deleted node.
        if (cur == null)
            return cur;

        // Recursive traversal.

        // Traverse left if data is less than cur.data.
        if (data < cur.getData())
            cur.setLeftChild(recurseDelete(cur.getLeftChild(), data));

            //Traverse right if data is less than cur.data.
        else if (data > cur.getData())
            cur.setRightChild(recurseDelete(cur.getRightChild(), data));

            // If data is equal and thus must be deleted case.
        else {

            // Changes node reference depending on which reference is null.
            // These cases handle deletions if the cur node has only one child.
            // It returns the reference of the other child (or null is both are null).
            if (cur.getLeftChild() == null)
                return cur.getRightChild();
            else if (cur.getRightChild() == null)
                return cur.getLeftChild();

            // This case handles deletions if the cur node has two children.
            // It sets the data of the cur node to the min of the cur nodes right child (why?)
            //  and deletes the given successor node from the tree.
            cur.setData(findMin(cur.getRightChild()).getData());
            cur.setRightChild(recurseDelete(cur.getRightChild(), data));
        }

        return cur;
    }

    /**
     * Function to find and return the node with the lowest value in the tree (or subtree) with cur as its root.
     *
     * @param cur Current node in question.
     * @return Returns child with the least value under a node (minimum node).
     */
    Node findMin(Node cur) {
        if (cur.getLeftChild() == null)
            return cur;
        else
            findMin(cur.getLeftChild());
        return cur;
    }

    /**
     * Calls in order recursive function.
     */
    public void printInOrder() {
        inOrder(root);
    }

    /**
     * Prints values in BinaryTree in order.
     *
     * @param cur Current node in question.
     */
    private void inOrder(Node cur) {

        if (cur != null) {
            inOrder(cur.getLeftChild());
            System.out.println(cur.getData());
            inOrder(cur.getRightChild());
        }

    }

    /**
     * Calls post order recursive function.
     */
    public void printPostOrder() {
        inOrder(root);
    }

    /**
     * Prints values in BinaryTree post order.
     *
     * @param cur Current node in question.
     */
    private void postOrder(Node cur) {

        if (cur != null) {
            // Adapt in order code to print post order
        }

    }

    /**
     * Calls pre order recursive function.
     */
    public void printPreOrder() {
        inOrder(root);
    }

    /**
     * Prints values in BinaryTree pre order.
     *
     * @param cur Current node in question.
     */
    private void preOrder(Node cur) {

        if (cur != null) {
            // Adapt in order code to print in pre order
        }

    }

    /**
     * Inner node class to build a binary search tree out of.
     */
    private class Node {
        Integer data = null;
        Node    leftChild;
        Node    rightChild;

        /**
         * @param data       Data to be added to a node.
         * @param leftChild  Reference to the nodes left child.
         * @param rightChild Reference to the nodes right child.
         */
        Node(int data, Node leftChild, Node rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        /**
         * @param data Data to be added to a node.
         */
        Node(int data) {
            this.data = data;
        }

        Node() {
        }

        int getData() {
            return data;
        }

        void setData(int data) {
            this.data = data;
        }

        Node getLeftChild() {
            return leftChild;
        }

        void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        Node getRightChild() {
            return rightChild;
        }

        void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        boolean isEmpty() {
            return data == null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return data.equals(node.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        /**
         * @return
         */
        @Override
        public String toString() {
            return "Node{" +
                   "data=" + data +
                   '}';
        }
    }
}
