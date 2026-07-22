import java.util.ArrayList;
import java.util.List;

public class GenericUtilitiesDemo {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(101, "Java");
        System.out.println("Pair: " + pair.getFirst() + " - " + pair.getSecond());

        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Popped: " + stack.pop());

        Integer[] numbers = {5, 12, 8, 3, 20};
        System.out.println("Max value: " + findMax(numbers));

        Repository<String> repo = new Repository<>();
        repo.add("Alpha");
        repo.add("Beta");
        System.out.println("Repository contains Alpha: " + repo.contains("Alpha"));

        List<Integer> ints = List.of(1, 2, 3);
        printList(ints);

        List<String> strings = List.of("A", "B", "C");
        printList(strings);
    }

    public static <T extends Comparable<T>> T findMax(T[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        T max = arr[0];
        for (T element : arr) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }
}

class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}

class Stack<T> {
    private final List<T> elements = new ArrayList<>();

    public void push(T value) {
        elements.add(value);
    }

    public T pop() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.remove(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}

class Repository<T> {
    private final List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public boolean contains(T item) {
        return items.contains(item);
    }

    public List<T> getAll() {
        return items;
    }
}
