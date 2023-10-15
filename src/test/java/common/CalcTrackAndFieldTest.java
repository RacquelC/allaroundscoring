package common;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTrackAndFieldTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calculateField() {
        // Check calculation from example given in Calculating point for decathlon and heptathlon
        double A = 56.0211;
        double B = 1.5;
        double C = 1.05;
        double distance = 16.5;
        int expected = 962;
        CalcTrackAndField calc = new CalcTrackAndField();

        int actual = calc.calculateField(A, B, C, distance);
        assertEquals(expected, actual);
    }

    @Test
    public void calculateTrack() {
        // Check calculation from example given in Calculating point for decathlon and heptathlon
        double A = 25.4347;
        double B = 18;
        double C = 1.81;
        double distance = 11.00;
        int expected = 861;
        CalcTrackAndField calc = new CalcTrackAndField();

        int actual = calc.calculateTrack(A, B, C, distance);
        assertEquals(expected, actual);
    }
}