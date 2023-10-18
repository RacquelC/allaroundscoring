package heptathlon;

import common.CalcTrackAndField;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Hep200MTest {

    private double A = 4.99087;
    private double B = 42.5;
    private double C = 1.81;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calculateResultCorrect() {
        double runningTime = 15.0;
        CalcTrackAndField calc = new CalcTrackAndField();
        int expected = calc.calculateTrack(A, B, C, runningTime);
        Hep200M hep200M = new Hep200M();

        // Redirect System.out to a custom PrintStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customPrintStream = new PrintStream(outputStream);
        System.setOut(customPrintStream);

        // Call the method that prints to System.out
        hep200M.calculateResult(runningTime);

        // Restore stream
        System.setOut(System.out);

        // Verify the printed output
        assertEquals("The result is: " + expected, outputStream.toString().trim());
    }

    @Test
    public void calculateResultLow() {
        double runningTime = 13.9;
        Hep200M hep200M = new Hep200M();

        // Redirect System.out to a custom PrintStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customPrintStream = new PrintStream(outputStream);
        System.setOut(customPrintStream);

        // Redefine System.in to a custom ByteStream to escape the method
        System.setIn(new ByteArrayInputStream("15".getBytes()));

        // Call the method that prints to System.out
        hep200M.calculateResult(runningTime);

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
        double runningTime = 42.09;
        Hep200M hep200M = new Hep200M();

        // Redirect System.out to a custom PrintStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customPrintStream = new PrintStream(outputStream);
        System.setOut(customPrintStream);

        // Redefine System.in to a custom ByteStream to escape the method
        System.setIn(new ByteArrayInputStream("15".getBytes()));

        // Call the method that prints to System.out
        hep200M.calculateResult(runningTime);

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