import java.util.Objects;
import java.util.StringJoiner;

public class CustomHashMap <K, V> {
    private Node<K, V> head = new Node<K, V>( null,null, null);
//    private Node<K, V> tail = new Node<K, V>( null,null, null);
    private int size = 0;

    private static class Node <K, V> {
        int key;
        V value;
        Node<K, V> next;
        Node(K key, V value, Node<K, V> next) {
            this.key = Objects.hashCode(key);
            this.value = value;
            this.next = next;
        }
    }

    public V put(K key, V value) {
        Node<K, V> pointer = head;
        if (size != 0) {
            while (pointer.next != null) {
                if (pointer.next.key == Objects.hashCode(key)) {
                    V previousValue = pointer.next.value;
                    pointer.next.value = value;
                    return previousValue;
                }
                pointer = pointer.next;
            }
        }
        pointer.next = new Node<>(key, value, null);
        size++;
        return null;
    }

    public boolean remove(K key) {
        Node<K, V> pointer = head;
        while (pointer.next != null) {
            if (pointer.next.key == Objects.hashCode(key)) {
                pointer.next = pointer.next.next;
                size--;
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }

    public void clear() {
        head.next = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        Node<K, V> pointer = head;
        while (pointer.next != null) {
            if (pointer.next.key == Objects.hashCode(key)) {
                return pointer.next.value;
            }
            pointer = pointer.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(",");
        if (head.next != null) {
            Node<K, V> pointer = head;
            while (pointer.next != null) {
                result.add("{" + pointer.next.key + "," + pointer.next.value.toString() + "}");
                pointer = pointer.next;
            }
            return "[" + result + "]";
        }
        return null;
    }
}
