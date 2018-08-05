package com.litvas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class LimitedSetTest {

    private LimitedSet limitedSet = new LimitedHashSet();
    private LimitedHashSet limitedHashSet = new LimitedHashSet();

    @Before
    public void initValues() {
        limitedSet.add("TestStrng13");
        limitedSet.add("TestStrng2");
        limitedSet.add("TestStrng34");
        limitedSet.add("TestStrng5");
        limitedSet.add("TestStrng6");
        limitedSet.add("TestStrng7");
        limitedSet.add("TestStrng4");
        limitedSet.add("TestStrng9");
        limitedSet.add("TestStrng39");
        limitedSet.add("TestStrng346");
    }

    @Before
    public void initValuesForContains() {
        for (int i = 0; i < 152; i++) {
            limitedSet.contains("TestStrng13");
            limitedSet.contains("TestStrng2");
            limitedSet.contains("TestStrng34");
            limitedSet.contains("TestStrng5");
            limitedSet.contains("TestStrng7");
            limitedSet.contains("TestStrng4");
            limitedSet.contains("TestStrng9");
            limitedSet.contains("TestStrng39");
            limitedSet.contains("TestStrng346");
        }
        for (int i = 0; i < 18; i++) {
            limitedSet.contains("TestStrng6");
        }
    }

    @Test
    public void containsTrue() {
        Assert.assertTrue(limitedSet.contains("TestStrng13"));
    }

    @Test
    public void containsFalse() {
        Assert.assertFalse(limitedSet.contains("TestStrng131"));
    }

    @Test
    public void addLessThen10() {
        LimitedSet limitedSetWhole = new LimitedHashSet();
        String string = new String("123");
        limitedSetWhole.add(string);
        Assert.assertTrue(limitedSetWhole.contains(string));
    }

    @Test
    public void addMoreThen10() {
        limitedSet.add("TestStrng51");
        Assert.assertFalse(limitedSet.contains("TestStrng6"));
        Assert.assertTrue(limitedSet.contains("TestStrng51"));
    }

    @Test
    public void addDublicate() {
        Map<String, Long> testMap = limitedHashSet.getLimitedSet();
        String stringForTest = new String("TestStrng9");
        testMap.put(stringForTest, null);
        int count = 0;
        for (String s : testMap.keySet()) {
            if (stringForTest.equals(s)) {
                count++;
            }
        }
        Assert.assertTrue(count == 1);
    }

    @Test
    public void removeTrue() {
        Assert.assertTrue(limitedSet.remove("TestStrng5"));
    }

    @Test
    public void removeFalse() {
        Assert.assertFalse(limitedSet.remove("TestStrng4587"));
    }
}