package common;

import junit.framework.TestCase;

import java.io.ByteArrayInputStream;

public class InputNameTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testAddCompetitorSymbolsEndingWithLetter() {
        InputName inputName = new InputName();
        String badName = "$'\"´<>:;-/*,.t";
        String goodName = "GoodName";

        // Redefine System.in to a custom ByteStream to escape the method
        System.setIn(new ByteArrayInputStream((badName + "\n" + goodName).getBytes()));

        // Call the method that uses scanner
        String acceptedName = inputName.addCompetitor();

        // Restore stream
        System.setIn(System.in);

        // Verify the acceptedName
        assertEquals(goodName, acceptedName);
    }

    public void testAddCompetitorSymbolsWithoutLetter() {
        InputName inputName = new InputName();
        String badName = "§'\"´<>:;-/*,.";
        String goodName = "GoodName";

        // Redefine System.in to a custom ByteStream to escape the method
        System.setIn(new ByteArrayInputStream((badName + "\n" + goodName).getBytes()));

        // Call the method that uses scanner
        String acceptedName = inputName.addCompetitor();

        // Restore stream
        System.setIn(System.in);

        // Verify the acceptedName
        assertEquals(goodName, acceptedName);
    }

    public void testAddCompetitorNumbersAndLetters() {
        InputName inputName = new InputName();
        String goodName = "123Name";

        // Redefine System.in to a custom ByteStream to escape the method
        System.setIn(new ByteArrayInputStream((goodName).getBytes()));

        // Call the method that uses scanner
        String acceptedName = inputName.addCompetitor();

        // Restore stream
        System.setIn(System.in);

        // Verify the acceptedName
        assertEquals(goodName, acceptedName);
    }

    public void testAddCompetitorOnlyLetters() {
        InputName inputName = new InputName();
        String goodName = "GoodName";

        // Redefine System.in to a custom ByteStream to escape the method
        System.setIn(new ByteArrayInputStream((goodName).getBytes()));

        // Call the method that uses scanner
        String acceptedName = inputName.addCompetitor();

        // Restore stream
        System.setIn(System.in);

        // Verify the acceptedName
        assertEquals(goodName, acceptedName);
    }

    public void testAddCompetitorSymbolWithLetters() {
        InputName inputName = new InputName();
        String badName = "bad$Name";
        String goodName = "GoodName";

        // Redefine System.in to a custom ByteStream to escape the method
        System.setIn(new ByteArrayInputStream((badName + "\n" + goodName).getBytes()));

        // Call the method that uses scanner
        String acceptedName = inputName.addCompetitor();

        // Restore stream
        System.setIn(System.in);

        // Verify the acceptedName
        assertEquals(goodName, acceptedName);
    }

    public void testAddCompetitorPoundSignShouldNotBeAccepted() {
        InputName inputName = new InputName();
        String badName = "£";
        String goodName = "GoodName";

        // Redefine System.in to a custom ByteStream to escape the method
        System.setIn(new ByteArrayInputStream((badName + "\n" + goodName).getBytes()));

        // Call the method that uses scanner
        String acceptedName = inputName.addCompetitor();

        // Restore stream
        System.setIn(System.in);

        // Verify the acceptedName
        assertEquals(goodName, acceptedName);
    }

    public void testAddCompetitorBracketsShouldNotBeAccepted() {
        InputName inputName = new InputName();
        String badName = "[";
        String goodName = "GoodName";

        // Redefine System.in to a custom ByteStream to escape the method
        System.setIn(new ByteArrayInputStream((badName + "\n" + goodName).getBytes()));

        // Call the method that uses scanner
        String acceptedName = inputName.addCompetitor();

        // Restore stream
        System.setIn(System.in);

        // Verify the acceptedName
        assertEquals(goodName, acceptedName);
    }

    public void testAddCompetitorBackslashShouldNotBeAccepted() {
        InputName inputName = new InputName();
        String badName = "\\";
        String goodName = "GoodName";

        // Redefine System.in to a custom ByteStream to escape the method
        System.setIn(new ByteArrayInputStream((badName + "\n" + goodName).getBytes()));

        // Call the method that uses scanner
        String acceptedName = inputName.addCompetitor();

        // Restore stream
        System.setIn(System.in);

        // Verify the acceptedName
        assertEquals(goodName, acceptedName);
    }

}