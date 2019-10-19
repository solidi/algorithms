import java.util.ArrayList;
import java.util.Iterator;

/*
 * Given an iterator, write a method called peek that does not change the onNext().
 */
class Solution {

    public static class Container {
        private Iterator<Integer> iterator;
        private Integer peekValue;

        public Container(Iterator<Integer> iterator) {
            this.iterator = iterator;
        }

        public Integer next() {
            Integer temp = peekValue;

            if (peekValue != null) {
                peekValue = null;
                return temp;
            }

            if (iterator.hasNext()) {
                temp = iterator.next();
            }

            return temp;
        }

        public Integer peek() {
            if (peekValue != null) {
                return peekValue;
            }

            if (iterator.hasNext()) {
                peekValue = iterator.next();
            }

            return peekValue;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(50);
        list.add(60);
        list.add(70);

        Container container = new Container(list.iterator());

        System.out.println(container.peek());
        container.next();
        System.out.println(container.peek());
        System.out.println(container.peek());
        container.next();
        container.next();
        container.next();
        System.out.println(container.peek());
    }
}
