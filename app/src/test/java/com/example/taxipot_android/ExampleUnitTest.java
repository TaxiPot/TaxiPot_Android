package com.example.taxipot_android;

import com.example.taxipot_android.domain.entity.TaxiPot;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void dateFormat_isCorrect() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019,8,15,13,30);
        TaxiPot taxiPot = new TaxiPot(calendar, "출발지", "목적지");
        assertEquals(taxiPot.dateFormat(), "09/15 13:30");
        System.out.println(taxiPot.dateFormat());
    }
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}