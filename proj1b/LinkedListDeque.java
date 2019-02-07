public class LinkedListDeque<Item> {
    private Node sentinel;
    private int size;

    private class Node {
        public Item item;
        public Node prev;
        public Node next;
        public Node(Item i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node((Item)null, null ,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    public void addFirst(Item item) {
        sentinel.next.prev =  sentinel.next = new Node(item, sentinel, sentinel.next);
        size += 1;
    }
    public void addLast(Item item) {
        sentinel.prev.next = sentinel.prev = new Node(item, sentinel.prev, sentinel);
        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        for (Node i = sentinel.next; i != sentinel; i = i.next) {
            System.out.print(i.item + " ");
        }
    }
    public Item removeFirst() {
        if (size > 0) {
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;  // pay attention to the order of this two lines
            size -= 1;
            return sentinel.next.item;
        }
        return null;
    }
    public Item removeLast() {
        if (size > 0) {
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;  // pay attention to the order of this two lines
            size -= 1;
            return sentinel.prev.item;
        }
        return null;
    }
    public Item get(int index) {
        if (index < size) {
            Node n = sentinel.next;
            while (index != 0) {
                n = n.next;
                index -= 1;
            }
            return n.item;
        }
        return null;
    }
    public Item getRecursiveHelper(int index, int count, Node n) {
        if (index == count) {
            return n.item;
        }
        return getRecursiveHelper(index, count + 1, n.next);
    }
    public Item getRecursive(int index) {
        if (index < size) {
            int count = 0;
            Node n = sentinel.next;
            return getRecursiveHelper(index, count, n);
        }
        return null;
    }
}
