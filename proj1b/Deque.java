public interface Deque<Item> {
    void addFirst(Item item);
    void addLast(Item item);
    boolean isEmpty();
    Item removeFirst();
    Item removeLast();
    Item get(int index);
}
