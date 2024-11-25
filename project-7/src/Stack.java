public class Stack <T> extends List <T> {

    // push
    public void push(T value) {
        if (empty()) {
            head = new Node(value, null, null);
        } else {
            head = new Node(value, null, head);
            head.next.prev = head;
        }
    }

    // pop
    public T pop() {
        if (empty()) {
            return null;
        } else {
            T value = head.value;
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return value;
        }
    }

    // peek
    public T peek() {
        if (empty()) {
            return null;
        } else {
            return head.value;
        }
    }

}
