import java.util.*;
import java.util.stream.Stream;
/**
 * HashMap - A class that is used to create a map of Hash codes.
 *
 * <pre>
 *
 * Assignment:     #1
 * Course:         ADEV-3001
 * Date Created:   February 2nd 2018
 *
 * Revision Log
 * Who       When          Reason
 * --------- ------------- ---------------------------------
 *
 * </pre>
 *
 * @author Christian Wenham
 * @version 1.0
 *
 */

public class HashMap<K, V> implements Map {

    private static int DEFAULT_CAPACITY = 11;
    private static double DEFAULT_LOAD_FACTOR = 0.75;
    private int capacity;
    private Entry<K, V>[] table;
    private double loadFactor;
    private int threshold;
    private int size = 0;

    /**
     * Uses defaults for both initialCapacity and loadFactor.
     */
    public HashMap() {
        this.capacity = DEFAULT_CAPACITY;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.table = (Entry<K, V>[]) new Entry[capacity];
        this.threshold = (int)(capacity * loadFactor);
    }

    /**
     * Allows creation of a custom HashMap, uses default size for loadFactor.
     * @param capacity
     */
    public HashMap(int capacity) {
        if(capacity < 1)
            throw new IllegalArgumentException("Cannot use a capacity value less than 1 for the HashMap.");

        this.capacity = capacity;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.table = (Entry<K, V>[]) new Entry[capacity];
        this.threshold = (int)(capacity * loadFactor);
    }

    /**
     * Allows creation of a custom sized HashMap
     * @param capacity
     * @param loadFactor
     */
    public HashMap(int capacity, double loadFactor) {
        if(loadFactor < 0 || loadFactor > 1)
            throw new IllegalArgumentException("loadFactor must be a value greater than 0 and less than 1.");

        if(capacity < 1)
            throw new IllegalArgumentException("Cannot use a capacity value less than 1 for the HashMap.");

        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = (Entry<K, V>[]) new Entry[capacity];
        this.threshold = (int)(capacity * loadFactor);
    }

    /**
     * @return the number of used HashMap entries
     */
    public int size() {
        return size;
    }

    /**
     * @return true if no entries are used, false otherwise.
     */
    public boolean isEmpty() {
        if(size == 0)
            return true;

        return false;
    }

    /**
     * Sets all entries in the HashMap to null and sets size to zero.
     */
    public void clear() {
        Arrays.fill(table, null);
        this.size = 0;
    }

    /**
     * @param key
     * @return the value associated with the passed key.
     */
    public Item get(Object key) {
        Entry<K, V> entry = table[findBucket(key)];

        return entry == null? null : entry.getValue();
    }

    /**
     * Attempts to either add a new Entry or replace the key already in the HashMap
     * @param key
     * @param value
     * @return
     */
    public Item put(StringKey key, Item value) {
        if(key == null)
            throw new IllegalArgumentException("Cannot put a null key into the HashMap.");

        if(value == null)
            throw new IllegalArgumentException("Cannot put a null value into the HashMap.");

        int bucket = findBucket(key);
        int notNull = 0;

        Item replaced = null;
        if(table[bucket] != null) {
           replaced = table[bucket].getValue();
        }

        table[bucket] = new Entry<>(key, value);
        if(replaced == null)
            this.size += 1;

        for(int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                notNull++;
            }
        }

        if(notNull >= threshold) {
            rehash();
        }

        return replaced;
    }

    /**
     * Removes the Entry with the key & value from the HashMap for key specified.
     * @param key
     * @return
     */
    public Item remove(Object key) {
        if(key == null)
            throw new IllegalArgumentException("Cannot remove a null from the HashMap");

        int bucket = findBucket(key);
        Item replaced;
        if(table[bucket] != null) {
            replaced = table[bucket].getValue();
        } else {
            replaced = null;
        }
        table[bucket] = new Entry<K, V>((StringKey) key, null);


        this.size -= 1;
        return replaced;
    }

    /**
     * @return an iterator of all keys in the HashMap.
     */
    public Iterator keys() {
        return getFilledEntriesStream()
                .map(Entry::getKey)
                .iterator();
    }

    /**
     * @return an iterator of all values in the HashMap.
     */
    public Iterator values() {
        return getFilledEntriesStream()
                .map(Entry::getValue)
                .sorted()
                .iterator();
    }

    public Entry<K, V>[] getTable() {
        return table;
    }

    public int findBucket(Object key) {
        boolean finished = false;
        int hashCode = key.hashCode();
        int bucket = hashCode % table.length;

        while (!finished) {
            if (table[bucket] != null) {
                if (!table[bucket].getKey().equals(key)) {
                    if(bucket == table.length - 1) {
                        bucket = 0;
                    } else {
                        bucket += 1;
                    }
                } else {
                    finished = true;
                }
            } else {
                finished = true;
            }
        }
        return bucket;
    }

    public int resize(int capacity) {
        int newCap = capacity;
        for(int i = 2; i < Math.sqrt(newCap); i++) {
            if(newCap % i == 0) {
                newCap = resize(newCap + 2);
            }
        }
        return newCap;
    }

    public void rehash() {
        int transferIndex = 0;
        this.capacity = resize(this.capacity * 2 + 1);
        Entry<K, V>[] replaced = table;
        this.threshold = (int)(this.capacity * this.loadFactor);
        table = (Entry<K, V>[]) new Entry[this.capacity];

        for(int i = 0; i < replaced.length; i++) {
            if(replaced[i] != null) {
                transferIndex = findBucket(replaced[i].getKey());
                table[transferIndex] = replaced[i];
            }
        }
    }

    private Stream<Entry<K, V>> getFilledEntriesStream() {
        return Arrays.stream(table).filter(Objects::nonNull)
                .filter(e -> e.getValue() != null);
    }
}
