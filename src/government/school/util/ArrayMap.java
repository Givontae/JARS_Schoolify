package government.school.util;

public class ArrayMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        // No "next" pointer here

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K, V>[] table;
    private int size;
    private final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ArrayMap() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % table.length; // Ensure non-negative index
    }

    public void put(K key, V value) {
        if (size > table.length * 0.75) {
            resize();
        }

        int index = hash(key);
        // Use linear probing to find the proper slot
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                // Key exists; update value
                table[index].value = value;
                return;
            }
            index = (index + 1) % table.length;
        }
        table[index] = new Entry<>(key, value);
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        // Probe until we find the key or hit an empty slot
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + 1) % table.length;
        }
        return null;
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        // Probe until we find the key or hit an empty slot
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return true;
            }
            index = (index + 1) % table.length;
        }
        return false;
    }

    public void remove(K key) {
        int index = hash(key);
        // Locate the key using linear probing
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                // Remove the entry by setting the slot to null
                table[index] = null;
                size--;
                // Rehash all following entries until an empty slot is found
                index = (index + 1) % table.length;
                while (table[index] != null) {
                    Entry<K, V> rehashEntry = table[index];
                    table[index] = null;
                    size--; // "put" will increment size
                    put(rehashEntry.key, rehashEntry.value);
                    index = (index + 1) % table.length;
                }
                return;
            }
            index = (index + 1) % table.length;
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;
        // Reinsert all non-null entries into the new table
        for (Entry<K, V> entry : oldTable) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }
    }

    public int size() {
        return size;
    }
}
