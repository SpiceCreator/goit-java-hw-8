import java.util.StringJoiner;

public class CustomQueue <E> {
    private Node<E> head = new Node<E>(null, null, null);
    private Node<E> tail = new Node<E>(null, null, null);
    private int size = 0;

    private static class Node <E> {
        E item;
        Node<E> prev;
        Node<E> next;
        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public <T extends E> void add(T t) {
        if (size == 0) {
            Node<E> newNode = new Node<E>(head, t, tail);
            head.next = newNode;
            tail.prev = newNode;
            size++;
        } else {
            Node<E> newNode = new Node<E>(tail.prev, t, tail);
            tail.prev.next = newNode;
            tail.prev = newNode;
            size++;
        }
    }

    public void remove(int index) {
        Node<E> pointer = head;
        for (int i = 0; i <= index; i++) {
            if (pointer.next != null) {
                pointer = pointer.next;
            } else {
                return;
            }
        }
        pointer.prev.next = pointer.next;
        pointer.next.prev = pointer.prev;
        size--;
    }

    public void clear() {
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        return head.next.item;
    }

    public E poll() {
        E result = head.next.item;
        head.next.next.prev = head;
        head.next = head.next.next;
        size--;
        return result;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(",");
        if (head.next != null) {
            Node<E> pointer = head;
            while (pointer.next.next != null) {
                result.add(pointer.next.item.toString());
                pointer = pointer.next;
            }
            return "[" + result.toString() + "]";
        }
        return null;
    }
}
