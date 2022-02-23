package com.nemtsov.mikhail;

import java.util.List;

public interface DatesToCronConverter {
    String convert(List<String> dates) throws DatesToCronConvertException;
    String getImplementationInfo();
}
