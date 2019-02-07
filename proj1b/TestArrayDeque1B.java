import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDeque1B {
    @Test
    public void ArrayDequeTest(){
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();
        OperationSequence fs = new OperationSequence();
        while(true){
            double numberBetweenZeroAndOne = StdRandom.uniform();
            int i = StdRandom.uniform(20);
            if (numberBetweenZeroAndOne < 0.25) {
                sad1.addFirst(i);
                ads1.addFirst(i);
                fs.addOperation(new DequeOperation("addFirst", i));
            }
            else if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
                ads1.addLast(i);
                fs.addOperation(new DequeOperation("addLast", i));
            }
            else if (numberBetweenZeroAndOne < 0.75 && !ads1.isEmpty()) {
                sad1.removeFirst();
                ads1.removeFirst();
                fs.addOperation(new DequeOperation("removeFirst"));
            }
            else if (numberBetweenZeroAndOne < 1 && !ads1.isEmpty()) {
                sad1.removeLast();
                ads1.removeLast();
                fs.addOperation(new DequeOperation("removeLast"));
            }
            for (int k = 0; k < sad1.size(); k += 1) {
                assertEquals(fs.toString() ,sad1.get(k), ads1.get(k));
            }
        }
    }
}
