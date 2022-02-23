package com.nemtsov.mikhail;

import java.util.ArrayList;
import java.util.List;

public class testConvert {
    public static void main(String[] args) throws DatesToCronConvertException {
        List<String> list = new ArrayList<String>();
        list.add("2022-01-25T08:00:00");
        list.add("2022-01-25T08:30:00");
        list.add("2022-01-25T09:00:00");
        list.add("2022-01-25T09:30:00");
        list.add("2022-01-26T08:00:00");
        list.add("2022-01-26T08:30:00");
        list.add("2022-01-26T09:00:00");
        list.add("2022-01-26T09:30:00");

        workConvert WorkConvert = new workConvert();
        String s = WorkConvert.convert(list);

        System.out.println(s);

        list = new ArrayList<String>();
        list.add("2022-01-24T19:53:00");
        list.add("2022-01-24T19:54:00");
        list.add("2022-01-24T19:55:00");
        list.add("2022-01-24T19:56:00");
        list.add("2022-01-24T19:57:00");
        list.add("2022-01-24T19:58:00");
        list.add("2022-01-24T19:59:00");
        list.add("2022-01-24T20:00:00");
        list.add("2022-01-24T20:01:00");
        list.add("2022-01-24T20:02:00");

        WorkConvert = new workConvert();
        s = WorkConvert.convert(list);

        System.out.println(s);

        list = new ArrayList<String>();
        list.add("string1");
        list.add("string2");
        list.add("string3");

        WorkConvert = new workConvert();
        try {
            s = WorkConvert.convert(list);
            System.out.println(s);
        } catch (DatesToCronConvertException e) {
            System.out.println("Exception DatesToCronConvertException");
        }
    }
}
