public class ArrayDequeTest {
    public static void main(String args[]) {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(3);
        ad1.addFirst(2);
        ad1.addFirst(1);
        ad1.addLast(4);
        ad1.addLast(5);
        ad1.addLast(6);
        //System.out.println(ad1.get(1));
        ad1.removeFirst();
        ad1.removeLast();
        ad1.removeLast();
        ad1.printDeque();
    }
}
