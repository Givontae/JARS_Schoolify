/**************************************************************************
 * File name: 
 * ArrayMap.java
 *
 * Description:
 * This file contains the ArrayMap class, which implements a basic
 * hash map using open addressing with linear probing.
 *
 * Author:
 * Givontae Mclean
 *
 * Date: April 01, 2025
 *
 * Concepts:
 * Use of generic types
 * Implementation of hash maps
 * Open addressing with linear probing
 ***************************************************************************/

package government.school.util; 

public class ArrayMap<K, V> {

    /* *************************************************************************
     * Private Nested Class: Entry
     *
     * Description:
     * This class represents a key-value pair entry used in the hash table.
     *************************************************************************/
    private static class Entry<K, V> {
        K key;
        V value;

        /**********************************************************************
         * Constructor: Entry
         *
         * Description:
         * This constructor initializes an entry with a key and a value.
         *
         * Parameters:
         * K key - the key of the entry
         * V value - the associated value
         *********************************************************************/
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    } /* End of Entry class */

    /* INSTANCE AND CLASS FIELD(S) */
    private Entry<K, V>[] table;
    private int size;
    private final int INITIAL_CAPACITY = 10;

    /**********************************************************************
     * Constructor: ArrayMap
     *
     * Description:
     * This constructor initializes the hash table with a default capacity.
     *********************************************************************/
    @SuppressWarnings("unchecked")
    public ArrayMap() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    } /* End of ArrayMap constructor */

    /**********************************************************************
     * Method name: hash
     *
     * Description:
     * This method computes the hash index for a given key.
     *
     * Parameters:
     * K key - the key to be hashed
     *
     * Return:
     * an integer representing the index within the table
     *********************************************************************/
    private int hash(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % table.length;
    } /* End of hash method */

    /**********************************************************************
     * Method name: put
     *
     * Description:
     * This method inserts or updates a key-value pair in the map.
     *
     * Parameters:
     * K key - the key to insert
     * V value - the value associated with the key
     *********************************************************************/
    public void put(K key, V value) {
        if (size > table.length * 0.75) {
            resize();
        }
        int index = hash(key);
        
        /* Linear probing to find an available slot */
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                /* Key exists; update value */
                table[index].value = value;
                return;
            }
            index = (index + 1) % table.length;
        }
        table[index] = new Entry<>(key, value);
        size++;
    } /* End of put method */

    /**********************************************************************
     * Method name: get
     *
     * Description:
     * This method retrieves a value associated with a given key.
     *
     * Parameters:
     * K key - the key to search for
     *
     * Return:
     * the value associated with the key, or null if not found
     *********************************************************************/
    public V get(K key) {
        int index = hash(key);
        
        /* Probe until key is found or an empty slot is reached */
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + 1) % table.length;
        }
        return null;
    } /* End of get method */

    /**********************************************************************
     * Method name: containsKey
     *
     * Description:
     * This method checks if a key exists in the map.
     *
     * Parameters:
     * K key - the key to check
     *
     * Return:
     * true if the key exists, false otherwise
     *********************************************************************/
    public boolean containsKey(K key) {
        int index = hash(key);
        
        /* Probe until key is found or an empty slot is reached */
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return true;
            }
            index = (index + 1) % table.length;
        }
        return false;
    } /* End of containsKey method */

    /**********************************************************************
     * Method name: remove
     *
     * Description:
     * This method removes a key-value pair from the map.
     *
     * Parameters:
     * K key - the key to remove
     *********************************************************************/
    public void remove(K key) {
        int index = hash(key);
        
        /* Locate key using linear probing */
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                table[index] = null;
                size--;
                
                /* Rehash remaining elements */
                index = (index + 1) % table.length;
                while (table[index] != null) {
                    Entry<K, V> rehashEntry = table[index];
                    table[index] = null;
                    size--;
                    put(rehashEntry.key, rehashEntry.value);
                    index = (index + 1) % table.length;
                }
                return;
            }
            index = (index + 1) % table.length;
        }
    } /* End of remove method */

    /**********************************************************************
     * Method name: resize
     *
     * Description:
     * This method doubles the table size and rehashes existing entries.
     *********************************************************************/
    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;
        
        /* Reinsert non-null entries */
        for (Entry<K, V> entry : oldTable) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }
    } /* End of resize method */

    /**********************************************************************
     * Method name: size
     *
     * Description:
     * This method returns the number of elements in the map.
     *
     * Return:
     * an integer representing the size of the map
     *********************************************************************/
    public int size() {
        return size;
    } /* End of size method */
} /* End of ArrayMap class */
