import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringKeyTest
{
    /// <summary>
    /// Tests the StringKey constructor.
    /// </summary>
    @Test
    void StringKeyConstructorTest()
    {
        String name = "Name";
        StringKey stringKey = new StringKey(name);

        assertEquals(stringKey.getKeyName(), name);
    }

    /// <summary>
    /// Test CompareTo using the same object.
    /// </summary>
    @Test
    void CompareToSameObjectTest()
    {
        int expectedResult = 0;
        StringKey stringKey = new StringKey("Name");

        assertEquals(expectedResult, stringKey.compareTo(stringKey));
    }

    /// <summary>
    /// Test CompareTo on two StringKeys with the same name.
    /// </summary>
    @Test
    void CompareToSameNameTest()
    {
        int expectedResult = 0;
        StringKey stringKey1 = new StringKey("A");
        StringKey stringKey2 = new StringKey("A");

        assertEquals(expectedResult, stringKey1.compareTo(stringKey2));

    }

    /// <summary>
    /// Test CompareTo with a stringKey with a name that comes alphabetically before the instance.
    /// </summary>
    @Test
    void CompareToAlphabeticallyBeforeNameTest()
    {
        StringKey stringKey1 = new StringKey("B");
        StringKey stringKey2 = new StringKey("A");

        assertTrue(stringKey1.compareTo(stringKey2) > 0);
    }

    /// <summary>
    /// Test CompareTo with a StringKey with a name that comes alphabetically after the instance.
    /// </summary>
    @Test
    void CompareToAlphabeticallyAfterNameTest()
    {
        StringKey stringKey1 = new StringKey("A");
        StringKey stringKey2 = new StringKey("B");

        assertTrue(stringKey1.compareTo(stringKey2) < 0);
    }


    /// <summary>
    /// Test that the GetHashCode method returns different values for words with same letters in different orders.
    /// </summary>
    @Test
    void GetHashCodeVarietyTest()
    {
        StringKey stringKey1 = new StringKey("stop");
        StringKey stringKey2 = new StringKey("pots");

        assertNotEquals(stringKey1.hashCode(), stringKey2.hashCode());
    }


    /// <summary>
    /// Test that the GetHashCode method returns positive values for large words.
    /// </summary>
    @Test
    void GetHashCode_is_not_negative_Test()
    {
        StringKey stringKey1 = new StringKey("A REALLY BIG STRING SHOULD NOT OVERFLOW TO NEGATIVE! ALWAYS ABSOLUTE VALUE YOUR HASHCODE!");

        assertTrue(stringKey1.hashCode() >= 0);
    }

    /// <summary>
    /// Test that GetHashCode returns 0 on an empty name.
    /// </summary>
    @Test
    void GetHashCodeEmptyNameTest()
    {
        int expectedResult = 0;
        StringKey stringKey = new StringKey("");
        assertEquals(expectedResult, stringKey.hashCode());
    }

    /// <summary>
    /// Test that Equals returns true when the same object is checked against itself.
    /// </summary>
    @Test
    void EqualsSameObjectTest()
    {
        StringKey stringKey = new StringKey("A");

        assertTrue(stringKey.equals(stringKey));
    }

    /// <summary>
    /// Test that Equals returns false when a null object is passed in.
    /// </summary>
    @Test
    void EqualsNullObjectTest()
    {
        StringKey stringKey = new StringKey("A");

        assertFalse(stringKey.equals(null));
    }

    /// <summary>
    /// Test that Equals returns false when a non StringKey object is passed in.
    /// </summary>
    @Test
    void EqualsNonStringKeyObjectTest()
    {
        StringKey stringKey = new StringKey("A");

        assertFalse(stringKey.equals("Not a String key"));
    }

    /// <summary>
    /// Test that Equals returns true when a StringKey with a matching name is compared.
    /// </summary>
    @Test
    void EqualsDifferentObjectsWithMatchingNameTest()
    {
        StringKey stringKey1 = new StringKey("A");
        StringKey stringKey2 = new StringKey("A");

        assertTrue(stringKey1.equals(stringKey2));
    }

    /// <summary>
    /// Test that Equals returns false when a StringKey with a mismatching name is compared.
    /// </summary>
    @Test
    void EqualsMisMatchedObjectsTest()
    {
        StringKey stringKey1 = new StringKey("A");
        StringKey stringKey2 = new StringKey("B");

        assertFalse(stringKey1.equals(stringKey2));
    }

    /// <summary>
    /// Test GetHashCode to ensure it returns expected result.
    /// </summary>
    @Test
    void GetHashCodeTest()
    {
        int expectedResult = 3446974;
        StringKey stringKey = new StringKey("stop");

        // NOTE: this may differ from your tests, you may ignore this test!
        assertEquals(expectedResult, stringKey.hashCode());
    }

    /// <summary>
    /// Test that ToString returns the expected string.
    /// </summary>
    @Test
    void ToStringTest()
    {
        String expectedString = "KeyName: stop HashCode: 3446974";
        StringKey stringKey = new StringKey("stop");

        // NOTE: this may differ from your tests, you may ignore this test!
        // THIS IS A GOOD IDEA FOR TESTING HOWEVER, YOU *SHOULD* DO IT ANYWAY.
        assertEquals(expectedString, stringKey.toString());
    }

}