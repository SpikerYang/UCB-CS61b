import org.junit.Test;

public class BinarySearchTreeTest {
    @Test
    public void BSTinsertTest() {
        BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();
        bst1.insert(3);
        bst1.insert(2);
        bst1.insert(1);
        bst1.insert(5);
        bst1.insert(4);
        bst1.insert(6);
        bst1.aftOrder(bst1.root);
    }

}
