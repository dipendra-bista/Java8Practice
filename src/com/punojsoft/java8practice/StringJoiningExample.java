package com.punojsoft.java8practice;

import java.time.ZoneId;
import java.util.List;
import java.util.Set;

/**
 * So far till java 7,
 * SO far till java 7, we had String.split() method which can split a string based on some token passed as parameter.
 * It returned list of string tokens as string array. But, if you want to join a string or
 * create a CSV by concatenating string tokens using some separator between them, you have to iterate through list of Strings,
 * or array of Strings, and then use StringBuilder or StringBuffer object to concatenate those string tokens and finally get the CSV.
 */
public class StringJoiningExample {
    public static void main(String[] args) {
        //java8
        String ids = String.join(",", ZoneId.getAvailableZoneIds());
//        System.out.println(ids);
        byJavaSeven();
    }

    public static void byJavaSeven() {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        for (String id : zoneIds) {
            System.out.print(id + ",");
        }
    }
}
