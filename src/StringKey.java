/**
 * StringKey - A class that is used to handle the information associated with a stringKey.
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

public class StringKey implements Comparable{
    private String keyName;

    /**
     * Constructor, initializes private fields for keyName.
     * @param keyName
     */
    public StringKey(String keyName) {
        this.keyName = keyName;
    }

    /**
     * @return the private keyName field.
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * Compares current stringKey to that of the passed stringKey.
     * @param stringKey
     * @return
     */
    @Override
    public int compareTo(Object stringKey) {
        StringKey convert = (StringKey) stringKey;
        return this.keyName.compareTo(convert.keyName);
    }

    /**
     * Generates the hash code based off the StringKey.
     * @return
     */
    @Override
    public int hashCode() {
        int length = this.keyName.length();
        char[] charArray = this.keyName.toCharArray();
        int hashCode = 0;

        for(int i = 0; i < length; i++) {
            hashCode = Math.abs(hashCode + (int)(Math.pow(31, i) * charArray[i]));
        }

        return hashCode;
    }

    /**
     * Checks if the stringKey passed is equal to the current stringKey.
     * @param stringKey
     * @return
     */
    @Override
    public boolean equals(Object stringKey) {
        if(stringKey != null && stringKey instanceof StringKey) {
            StringKey convert = (StringKey) stringKey;
            return this.keyName.equals(convert.keyName);
        }
        return false;
    }

    /**
     * @return KeyName: keyName HashCode: keyName.hashCode()
     */
    @Override
    public String toString() {
        return "KeyName: " + this.keyName + " HashCode: " + this.keyName.hashCode();
    }
}
