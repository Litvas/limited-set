package com.litvas;

import java.util.*;

public class LimitedHashSet<T> implements LimitedSet<T> {

    private Map<Object, Long> limitedSet = new HashMap<>(10);

    public void add(Object o) {
        if (limitedSet.size() < 10 & !limitedSet.containsKey(o)) {
            limitedSet.put(o, new Long("0"));
        }
        if (limitedSet.size() >= 10 & !limitedSet.containsKey(o)) {
            limitedSet.remove(searchMinValue().getKey());
            limitedSet.put(o, new Long("0"));
        }
    }

    public boolean remove(Object o) {
        return containsChecks(o);
    }

    public boolean contains(Object o) {
        countOfCall(o);
        return limitedSet.containsKey(o);
    }

    private void countOfCall(Object o) {
        if (limitedSet.containsKey(o)) {
            long countOfCall = limitedSet.get(o);
            limitedSet.put(o, countOfCall + 1);
        }
    }

    private boolean containsChecks(Object o) {
        if (limitedSet.containsKey(o)) {
            limitedSet.remove(o);
            return true;
        } else return false;
    }

    private Map.Entry<Object, Long> searchMinValue() {
        return limitedSet
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue()).get();
    }

    //This method only for test pasting of dublicate. It will be remove in production
    public Map<Object, Long> getLimitedSet() {
        return limitedSet;
    }
}
