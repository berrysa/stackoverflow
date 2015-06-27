package com.samlikescode.stackoverflow.questions.q31036094;

import com.fasterxml.jackson.databind.util.StdConverter;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

public class MyKeyToListConverter extends StdConverter<Map<String, String>, List<Integer>> {
    @Override
    public List<Integer> convert(Map<String, String> input) {
        List<Integer> valueList = Lists.newArrayList();
        for (Map.Entry<String, String> entry : input.entrySet()) {
            if (entry.getKey().matches("key[0-9]+")) {
                valueList.add(Integer.parseInt(entry.getValue()));
            }
        }
        return valueList;
    }
}
