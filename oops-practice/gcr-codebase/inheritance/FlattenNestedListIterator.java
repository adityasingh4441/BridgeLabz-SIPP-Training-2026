import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator {
    interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }

    static class SimpleNestedInteger implements NestedInteger {
        private Integer value;
        private List<NestedInteger> list;

        SimpleNestedInteger(Integer value) {
            this.value = value;
        }

        SimpleNestedInteger(List<NestedInteger> list) {
            this.list = list;
        }

        public boolean isInteger() {
            return value != null;
        }

        public Integer getInteger() {
            return value;
        }

        public List<NestedInteger> getList() {
            return list;
        }
    }

    static class NestedIterator implements Iterator<Integer> {
        private List<Integer> flattened = new ArrayList<>();
        private int index = 0;

        NestedIterator(List<NestedInteger> nestedList) {
            flatten(nestedList);
        }

        private void flatten(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    flattened.add(nestedInteger.getInteger());
                } else {
                    flatten(nestedInteger.getList());
                }
            }
        }

        public Integer next() {
            return flattened.get(index++);
        }

        public boolean hasNext() {
            return index < flattened.size();
        }
    }

    public static void main(String[] args) {
        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new SimpleNestedInteger(1));
        nestedList.add(new SimpleNestedInteger(List.of(new SimpleNestedInteger(2), new SimpleNestedInteger(3))));

        NestedIterator iterator = new NestedIterator(nestedList);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
