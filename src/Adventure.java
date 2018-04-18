import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Iterator;

/**
 * Maze - A class that is used to handle the information associated with an item.
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

public class Adventure {

    private HashMap<StringKey, Item> map;

    /**
     * Constructor, reads contents of a file that is passed in and populates a HashMap with the data.
     * @param fileName
     */
    public Adventure(String fileName) {
        if(fileName == null)
            throw new IllegalArgumentException("Invalid fileName.");

        File file = new File(fileName);
        if(!file.exists())
            throw new IllegalArgumentException("Invalid fileName.");

        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            map = new HashMap<StringKey, Item>();

            while ((line = bufferedReader.readLine()) != null) {
                String[] lineItems;
                lineItems = line.replaceAll(" ", "").split(",");

                Item item = new Item(lineItems[0], Integer.parseInt(lineItems[1]), Double.parseDouble(lineItems[2]));
                StringKey stringKey = new StringKey(lineItems[0]);

                map.put(stringKey, item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the HashMap of data from the file read.
     */
    public HashMap<StringKey, Item> getMap() {
        return map;
    }

    /**
     * Prints the Items in the HashMap.
     * @return
     */
    public String printLootMap() {
        String lootMap = "";
        Iterator values = map.values();
        while (values.hasNext()) {
            Item curItem = (Item) values.next();
            if(curItem.getGoldPieces() != 0)
                lootMap += curItem.toString() + "\n";
        }
        return lootMap;
    }
}
