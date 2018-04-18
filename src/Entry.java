/**
 * Entry - A class that holds references to Key and Value Object.
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
public class Entry<K, V> {
    private StringKey key;
    private Item value;

    /**
     * Sets default values for an Entry.
     * @param key
     * @param value
     */
    public Entry(StringKey key, Item value) {
        this.key = key;
        this.value = value;
    }

    /**
     * @return the key for the Entry.
     */
    public StringKey getKey() {
        return key;
    }

    /**
     * @return the value for the Entry.
     */
    public Item getValue() {
        return value;
    }

    /**
     * @return "[" + key + " : " + values + "]"
     */
    @Override
    public String toString() {
        return "[" + key + " : " + value + "]";
    }
}
