package decathlon;

import common.CalcTrackAndField;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DecaShotPutTest {

    private double A = 51.39;
    private double B = 1.5;
    private double C = 1.05;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calculateResultCorrect() {
        double distance = 5;
        CalcTrackAndField calc = new CalcTrackAndField();
        int expected = calc.calculateField(A, B, C, distance);
        DecaShotPut decaShotPut = new DecaShotPut();

        // Redirect System.out to a custom PrintStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customPrintStream = new PrintStream(outputStream);
        System.setOut(customPrintStream);

        // Call the method that prints to System.out
        decaShotPut.calculateResult(distance);

        // Restore stream
        System.setOut(System.out);

        // Verify the printed output
        assertEquals("The result is: " + expected, outputStream.toString().trim());
    }

    @Test
    public void calculateResultLow() {
        double distance = -0.1;
        DecaShotPut decaShotPut = new DecaShotPut();

        // Redirect System.out to a custom PrintStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customPrintStream = new PrintStream(outputStream);
        System.setOut(customPrintStream);

        // Redefine System.in to a custom ByteStream to escape the method
        System.setIn(new ByteArrayInputStream("5".getBytes()));

        // Call the method that prints to System.out
        decaShotPut.calculateResult(distance);

        // Restore streams
        System.setOut(System.out);
        System.setIn(System.in);

        // Clean and select output line
        String[] outputLines = outputStream.toString().split("\n");
        String actual = outputLines[0].trim();

        // Verify the printed output
        assertEquals("Value too low", actual);
    }

    @Test
    public void calculateResultHigh() {
        double distance = 30.1;
        DecaShotPut decaShotPut = new DecaShotPut();

        // Redirect System.out to a custom PrintStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customPrintStream = new PrintStream(outputStream);
        System.setOut(customPrintStream);

        // Redefine System.in to a custom ByteStream to escape the method
        System.setIn(new ByteArrayInputStream("5".getBytes()));

        // Call the method that prints to System.out
        decaShotPut.calculateResult(distance);

        // Restore streams
        System.setOut(System.out);
        System.setIn(System.in);

        // Clean and select output line
        String[] outputLines = outputStream.toString().split("\n");
        String actual = outputLines[0].trim();

        // Verify the printed output
        assertEquals("Value too high", actual);
    }
}