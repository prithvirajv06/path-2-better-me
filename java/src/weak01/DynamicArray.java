import java.util.Arrays;
import java.util.Objects;

public class DynamicArray<T> {
    private Object[] data = new Object[4];
    private int size = 0;

    // Amortized O(1): doubling makes resizes rare
    public void add(T value) {
        if (size == data.length)
            data = Arrays.copyOf(data, data.length * 2);
        data[size++] = value;
    }

    // O(1): direct index into contiguous memory
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    // O(n): every element after index shifts left
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkIndex(index);
        T removed = (T) data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null; // let the GC reclaim the reference
        return removed;
    }

    @SuppressWarnings("unchecked")
    public void insert(int index, T value) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("index " + index + ", size " + size);
        if (size() == data.length) {
            grow();
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }

    public boolean contains(T value) {
        if (value == null)
            return false;
        for (Object d : data) {
            if (Objects.equals(d, value)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index " + index + ", size " + size);
    }

    private void grow() {
        Object[] newArray = new Object[Math.max(data.length + (data.length >> 1), data.length + 1)];
        System.arraycopy(data, 0, newArray, 0, size);
        data = newArray;
    }
}