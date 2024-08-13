package com.liooos.example.other.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionSortAvoidNullPointException {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("BB");
        strings.add("AA");
        strings.add(null);
        strings.add("EE");
        strings.add("DD");

//        Collections.sort(strings);

        Comparator<String> nullsLastComparator = Comparator.nullsLast(Comparator.naturalOrder());
        Collections.sort(strings, nullsLastComparator);
        System.out.println(strings);
    }
}
