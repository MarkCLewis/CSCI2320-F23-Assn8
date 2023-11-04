/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package csci2320;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class App {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            long seed = sc.nextLong();
            Random rand = new Random(seed);
            int size = sc.nextInt();
            String type = sc.next();
            switch(type) {
                case "heap":
                    heap(rand, size);
                    break;
                case "klargest":
                    kLargest(rand, size, sc.nextInt());
                    break;
            }
        }
    }

    static String randomString(Random rand, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            sb.append((char)('a'+rand.nextInt(26)));
        }
        return sb.toString();
    }

    private static <E> void testHeap(int size, Supplier<E> gen, BiPredicate<E, E> hp, Comparator<E> comp) {
        PriorityQueue<E> heap = new BinaryHeap<>(hp);
        var values = new ArrayList<E>(size);
        for (int i = 0; i < size; ++i) {
            var v = gen.get();
            heap.enqueue(v);
            values.add(v);
        }
        Collections.sort(values, comp);
        if (heap.isEmpty()) {
            System.out.println("Empty heap after pushing.");
        }
        for (int i = 0; i < size; ++i) {
            E v = values.get(i);
            if (!heap.peek().equals(v)) {
                System.out.println("Bad peek: " + i + " " + v);
            }
            if (!heap.dequeue().equals(v)) {
                System.out.println("Bad dequeue: " + i + " " + v);
            }
        }
    }

    public static void heap(Random rand, int size) {
        testHeap(size, () -> rand.nextDouble(), (x, y) -> x > y, (x, y) -> -Double.compare(x, y));
        testHeap(size, () -> rand.nextDouble(), (x, y) -> x < y, (x, y) -> Double.compare(x, y));
        testHeap(size, () -> randomString(rand, 8), (x, y) -> x.compareTo(y) < 0, (x, y) -> x.compareTo(y));
        System.out.println("Heap test completed.");
    }

    public static void kLargest(Random rand, int size, int k) {
        List<Double> nums = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            nums.add(rand.nextDouble());
        }
        var largest = KLargest.findKLargest(nums, k, (x, y) -> x > y);
        Collections.sort(nums, (x, y) -> -Double.compare(x, y));
        var realLargest = new HashSet<Double>(nums.subList(0, k));
        if (!largest.equals(realLargest)) {
            System.out.println("The largest elements don't match expectation.");
        }
        System.out.println("K-largest test completed.");
    }
}