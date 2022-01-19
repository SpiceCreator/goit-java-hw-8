import java.util.Arrays;

public class CustomArrayList <E> {
    public Object[] array;
    public int size = 0;

    public CustomArrayList() {
        Object[] array = new Object[size];
    }

    public <T extends E> void add(T t) {
        if (size == 0) {
            size++;
            array = new Object[] {t};
        } else {
            Object[] newArray = Arrays.copyOf(array, ++size);
            array = Arrays.copyOf(newArray, size);
            array[size - 1] = t;
        }
    }

    public void remove(int index) {
        try {
            if (size != 0) {
                Object[] newArray = new Object[--size];
                if (index == 0) {
                    System.arraycopy(array, 1, newArray, 0, size);
                } else if (index == size) {
                    System.arraycopy(array, 0, newArray, 0, size);
                } else {
                    System.arraycopy(array, 0, newArray, 0, index);
                    System.arraycopy(array, index + 1, newArray, index, size - index);
                }
                array = Arrays.copyOf(newArray, size);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    public void clear() {
        array = new Object[0];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        try {
            return array[index];
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
