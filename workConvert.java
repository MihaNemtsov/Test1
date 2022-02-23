package com.nemtsov.mikhail;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
//import java.util.Date;

public class workConvert implements DatesToCronConverter {
    public String convert(List<String> dates) throws DatesToCronConvertException {

        //Самый быстрый и верный :) вариант в соответствии с заданием,
        //подходящий всегда и к любому правильному списку дат
        String res = "0 * * * * *";
        //return res;
        //Все что ниже нужно закомментировать

        //Варианты с парсингом дат
        Collections.sort(dates);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime dt;

        SortedSet<String> sMN = new TreeSet<String>();
        SortedSet<String> sHH = new TreeSet<String>();
        SortedSet<String> sDD = new TreeSet<String>();
        SortedSet<String> sMM = new TreeSet<String>();
        for(String item: dates) {
            try {
                dt = LocalDateTime.parse(item);
                sMN.add(String.valueOf(dt.getMinute()));
                sHH.add(String.valueOf(dt.getHour()));
                sDD.add(String.valueOf(dt.getDayOfMonth()));
                sMM.add(String.valueOf(dt.getMonthValue()));
            } catch (Exception e) {
                throw new DatesToCronConvertException();
            }
        }

        Iterator<String> s;
        res = "0 ";

        int i = 1;
        //Собираем минуты
        if (sMN.size() > 2) {
            res = res + "*";
        } else {
            s = sMN.iterator();
            while (s.hasNext()) {
                res = res + s.next();
                if (i < sMN.size()) {
                    res = res + ",";
                }
                i++;
            }
        }
        res = res + " ";

        i = 1;
        //Собираем часы
        if (sHH.size() > 2) {
            res = res + "*";
        } else {
            s = sHH.iterator();
            while (s.hasNext()) {
                res = res + s.next();
                if (i < sHH.size()) {
                    res = res + ",";
                }
                i++;
            }
        }
        res = res + " ";
        i = 1;
        //Собираем дни
        if (sDD.size() > 2) {
            res = res + "*";
        } else {
            s = sDD.iterator();
            while (s.hasNext()) {
                res = res + s.next();
                if (i < sDD.size()) {
                    res = res + ",";
                }
                i++;
            }
        }
        res = res + " ";
        i = 1;
        //Собираем месяцы
        if (sMM.size() > 2) {
            res = res + "*";
        } else {
            s = sMM.iterator();
            while (s.hasNext()) {
                res = res + s.next();
                if (i < sMM.size()) {
                    res = res + ",";
                }
                i++;
            }
        }
        res = res + " *";

        return res;
    }

    public String getImplementationInfo() {
        return "Mikhail Nemtsov; com.nemtsov.mikhail; https://github.com/";
    }


}
