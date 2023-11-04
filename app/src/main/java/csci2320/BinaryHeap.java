package csci2320;

import java.util.function.BiPredicate;

public class BinaryHeap<E> implements PriorityQueue<E> {
  // TODO: Add your data here.

  /**
   * Constructs a binary heap with a predicate that tells if the first argument is
   * higher priority than the second argument.
   * @param higherPriority the priority predicate
   */
  public BinaryHeap(BiPredicate<E, E> higherPriority) {
    // TODO: Add your constructor code here.
  }

  @Override
  public void enqueue(E elem) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'enqueue'");
  }

  @Override
  public E dequeue() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'dequeue'");
  }

  @Override
  public E peek() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'peek'");
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'size'");
  }
  
}
