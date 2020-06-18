package com.ola.timeApp;

import org.junit.*;
import static junit.framework.TestCase.assertEquals;

// Quick tests checking whether the Http response has been converted properly to a Json object
public class JsonObjectTest {

    private JsonObject jsonObj;

    @Before
    public void testSetup() {
        jsonObj = new JsonObject("CEST","89.64.88.68","2020-06-18T10:14:05.985710+02:00",4,170,true, "2020-03-29T01:00:00+00:00",
                3600,"2020-10-25T01:00:00+00:00", 3600, "Europe/Warsaw",1592468045, "2020-06-18T08:14:05.985710+00:00",
                "+02:00", 25);
    }

    @Test
    public void checkJsonTimezone() throws Exception {
		// Given
        final String outputTimezone = "Europe/Warsaw";

        // When
        final String result = jsonObj.getTimezone();

        // Then
        assertEquals(outputTimezone, result);
    }

    @Test
    public void checkJsonDatetime() throws Exception {
        // Given
        final String outputTimezone = "2020-06-18T10:14:05.985710+02:00";

        // When
        final String result = jsonObj.getDatetime();

        // Then
        assertEquals(outputTimezone, result);
    }

}