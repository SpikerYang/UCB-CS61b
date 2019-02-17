public class BinarySearchTree<T extends Comparable<T>> {
    private class Node {
        public T data;
        public Node left;
        public Node right;
        public Node (T d) {
            data = d;
        }
    }
    public Node root;
    public BinarySearchTree() {
        root = null;
    }
    public BinarySearchTree(T d) {
        root = new Node(d);
    }
    private void insertHelper(Node n, T i) {
        if (n == null) {
            n = new Node(i);
        }
        else if (i.compareTo(n.data) == -1){
            insertHelper(n.left, i);
        }
        else if (i.compareTo(n.data) == 1){
            insertHelper(n.right, i);
        }
        else {
            throw new RuntimeException("there should not include equal elements in a BST!");
        }
    }
    public boolean insert (T i) {
        Node current = root;
        if (current == null) {
            root = new Node(i);
            return true;
        }
        while (true) {
            if (i.compareTo(current.data) == -1) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new Node(i);
                    break;
                }
            }
            if (i.compareTo(current.data) == 1) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new Node(i);
                    break;
                }
            }
        }
        return true;
    }
    public boolean contains (T c) {
        Node current = root;
        while (current != null) {
            if (c.compareTo(current.data) == 0) {
                return true;
            } else if (c.compareTo(current.data) == 1) {
                current = current.left;
            } else if (c.compareTo(current.data) == -1) {
                current = current.right;
            }
        }
        return false;
    }
    public void preOrder(Node n) {
        System.out.println(n.data);
        if (n.left != null) {
            preOrder(n.left);
        }
        if (n.right != null) {
            preOrder(n.right);
        }
    }
    public void midOrder(Node n) {
        if (n.left != null) {
            midOrder(n.left);
        }
        System.out.println(n.data);
        if (n.right != null) {
           midOrder(n.right);
        }
    }
    public void aftOrder(Node n) {

        if (n.left != null) {
            aftOrder(n.left);
        }
        if (n.right != null) {
            aftOrder(n.right);
        }
        System.out.println(n.data);
    }
}
