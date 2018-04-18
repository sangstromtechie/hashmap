import java.text.DecimalFormat;

/**
 * Item - A class that is used to handle the information associated with an item.
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

public class Item implements Comparable {

    private String name;
    private int goldPieces;
    private double weight;

    /**
     * Constructor, initializes private fields for name, goldPieces and weight.
     * @param name
     * @param value
     * @param weight
     */
    public Item(String name, int value, double weight) {
        this.name = name;
        this.goldPieces = value;
        this.weight = weight;
    }

    /**
     * @return the private name field.
     */
    public String getName() {
        return name;
    }

    /**
     * @return the private goldPieces field.
     */
    public int getGoldPieces() {
        return goldPieces;
    }

    /**
     * @return the private weight field.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @return name is worth goldPiecesgp and weighs weightkg
     */
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return name + " is worth " + goldPieces + "gp and weighs " + df.format(weight) + "kg";
    }

    /**
     * Compares current item name to that of the passed item.
     * @param item
     * @return
     */
    public int compareTo(Object item) {
        Item convert = (Item) item;
        return this.name.compareTo(convert.name);
    }

    /**
     * Checks if the item passed is equal to the current item.
     * @param item
     * @return
     */
    @Override
    public boolean equals(Object item) {

        if(item != null && item instanceof Item) {
            Item convert = (Item) item;
            if (this.name.equals(convert.name) && this.goldPieces == convert.goldPieces && this.weight == convert.weight) {
                return true;
            }
        }
        return false;
    }
}
