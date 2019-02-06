public class ArrayDeque<Item> {
    private Item[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    private int indexChecker(int index){
        if (index < 0 ) {
            return index += items.length;
        }
        if (index >= items.length) {
            return index -= items.length;
        }
        return index;
    }
    private void resize(){
        if (size * 1.2 > items.length) {
            Item[] items_new = (Item[]) new Object[items.length * 2];
            for (int i = 0; i < size; i += 1){
                items_new[i + 1] = get(i);
            }
            items = items_new;
            nextFirst = 0;
            nextLast = size + 1;
        }
        if (size * 2 < items.length) {
            Item[] items_new = (Item[]) new Object[items.length - 8];
            for (int i = 0; i < size; i += 1){
                items_new[i + 1] = get(i);
            }
            items = items_new;
            nextFirst = 0;
            nextLast = size + 1;
        }
    }
    public ArrayDeque() {
        items = (Item[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    public void addFirst(Item item) {
        items[nextFirst] = item;
        nextFirst -= 1;
        nextFirst = indexChecker(nextFirst);
        size += 1;
    }
    public void addLast(Item item) {
        items[nextLast] = item;
        nextLast += 1;
        nextLast = indexChecker(nextLast);
        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        for (int i = 0; i < size; i += 1 ) {
            System.out.print(get(i) + " ");
        }

    }
    public Item removeFirst() {
        Item r = items[indexChecker(nextFirst + 1)];
        items[indexChecker(nextFirst + 1)] = null;
        nextFirst += 1;
        nextFirst = indexChecker(nextFirst);
        size -= 1;
        return r;
    }
    public Item removeLast() {
        Item r = items[indexChecker(nextLast - 1)];
        items[indexChecker(nextLast - 1)] = null;
        nextLast -= 1;
        nextLast = indexChecker(nextLast);
        size -= 1;
        return r;
    }
    public Item get(int index) {
        if (index < size) {
            return items[indexChecker(index + nextFirst + 1)];
        }
        return null;
    }

}
