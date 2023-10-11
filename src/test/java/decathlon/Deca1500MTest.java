package decathlon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import common.CalcTrackAndField;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Deca1500MTest {

    private double A = 0.03768;
    private double B = 480;
    private double C = 1.85;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calculateResultCorrect() {
        double runningTime = 5;
        CalcTrackAndField calc = new CalcTrackAndField();
        int expected = calc.calculateTrack(A, B, C, runningTime);
        Deca1500M deca1500M = new Deca1500M();

        // Redirect System.out to a custom PrintStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customPrintStream = new PrintStream(outputStream);
        System.setOut(customPrintStream);

        // Call the method that prints to System.out
        deca1500M.calculateResult(runningTime);

        // Restore stream
        System.setOut(System.out);

        // Verify the printed output
        assertEquals("The result is: " + expected, outputStream.toString().trim());
    }

    @Test
    public void calculateResultLow() {
        double runningTime = 1.9;
        Deca1500M deca1500M = new Deca1500M();

        // Redirect System.out to a custom PrintStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customPrintStream = new PrintStream(outputStream);
        System.setOut(customPrintStream);

        // Redefine System.in to a custom ByteStream to escape the method
        System.setIn(new ByteArrayInputStream("5".getBytes()));

        // Call the method that prints to System.out
        deca1500M.calculateResult(runningTime);

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
        double runningTime = 7.1;
        Deca1500M deca1500M = new Deca1500M();

        // Redirect System.out to a custom PrintStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customPrintStream = new PrintStream(outputStream);
        System.setOut(customPrintStream);

        // Redefine System.in to a custom ByteStream to escape the method
        System.setIn(new ByteArrayInputStream("5".getBytes()));

        // Call the method that prints to System.out
        deca1500M.calculateResult(runningTime);

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