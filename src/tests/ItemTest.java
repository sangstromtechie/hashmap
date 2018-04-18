import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest
{
    /// <summary>
    /// Test the Item constructor to make sure it sets the properties properly.
    /// </summary>
    @Test
    void ItemConstructorTest()
    {
        String name = "Awesome Item";
        int value = 100;
        double weight = 5.0;

        Item item = new Item(name, value, weight);

        assertEquals(name, item.getName());
        assertEquals(value, item.getGoldPieces());
        assertEquals(weight, item.getWeight());
    }

    /// <summary>
    /// Test that the ToString returns the expected String.
    /// </summary>
    @Test
    void ToStringTest()
    {
        String expectedResult = "Awesome Item is worth 100gp and weighs 5kg";

        Item item = new Item("Awesome Item", 100, 5.0);

        assertEquals(expectedResult, item.toString());
    }

    /// <summary>
    /// Test CompareTo using the same object.
    /// </summary>
    @Test
    void CompareToSameObjectTest()
    {
        int expectedResult = 0;
        Item item = new Item("Item", 10, 5.0);

        assertEquals(expectedResult, item.compareTo(item));
    }

    /// <summary>
    /// Test CompareTo on two Items with the same name.
    /// </summary>
    @Test
    void CompareToSameNameTest()
    {
        int expectedResult = 0;
        Item item1 = new Item("Item", 10, 5.0);
        Item item2 = new Item("Item", 10, 5.0);

        assertEquals(expectedResult, item1.compareTo(item2));

    }

    /// <summary>
    /// Test CompareTo with a item with a name that comes alphabetically before the instance.
    /// </summary>
    @Test
    void CompareToAlphabeticallyBeforeNameTest()
    {
        Item item1 = new Item("B", 10, 5.0);
        Item item2 = new Item("A", 10, 5.0);

        assertTrue(item1.compareTo(item2) > 0);
    }

    /// <summary>
    /// Test CompareTo with a Item with a name that comes alphabetically after the instance.
    /// </summary>
    @Test
    void CompareToAlphabeticallyAfterNameTest()
    {
        Item item1 = new Item("A", 10, 5.0);
        Item item2 = new Item("B", 10, 5.0);

        assertTrue(item1.compareTo(item2) < 0);
    }


    /// <summary>
    /// Test that Equals returns true when the same object is checked against itself.
    /// </summary>
    @Test
    void EqualsSameObjectTest()
    {
        Item item = new Item("Item", 10, 5.0);

        assertTrue(item.equals(item));
    }

    /// <summary>
    /// Test that Equals returns false when a null object is passed in.
    /// </summary>
    @Test
    void EqualsNullObjectTest()
    {
        Item item = new Item("Item", 10, 5.0);

        assertFalse(item.equals(null));
    }

    /// <summary>
    /// Test that Equals returns false when a non Item object is passed in.
    /// </summary>
    @Test
    void EqualsNonItemObjectTest()
    {
        Item item = new Item("Item", 10, 5.0);

        assertFalse(item.equals("Not an item"));
    }

    /// <summary>
    /// Test that Equals returns true when a Item with a matching name/gold/weight is compared.
    /// </summary>
    @Test
    void EqualsDifferentObjectsWithMatchingNameTest()
    {
        Item item1 = new Item("Item", 10, 5.0);
        Item item2 = new Item("Item", 10, 5.0);

        assertTrue(item1.equals(item2));
    }

    /// <summary>
    /// Test that Equals returns false when a Item with a mismatching name is compared.
    /// </summary>
    @Test
    void EqualsMisMatchedObjects_name_values_differ_Test()
    {
        Item item1 = new Item("Item", 10, 5.0);
        Item item2 = new Item("Item2", 10, 5.0);

        assertFalse(item1.equals(item2));
    }

    /// <summary>
    /// Test that Equals returns false when a Item with a mismatching gold value is compared.
    /// </summary>
    @Test
    void EqualsMisMatchedObject_gold_values_differ_Test()
    {
        Item item1 = new Item("Item", 10, 5.0);
        Item item2 = new Item("Item", 11, 5.0);

        assertFalse(item1.equals(item2));
    }


    /// <summary>
    /// Test that Equals returns false when a Item with a mismatching weight is compared.
    /// </summary>
    @Test
    void EqualsMisMatchedObject_weight_values_differ_Test()
    {
        Item item1 = new Item("Item", 10, 5.0);
        Item item2 = new Item("Item", 10, 4.0);

        assertFalse(item1.equals(item2));
    }
}