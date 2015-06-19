package com.samlikescode.stackoverflow.questions.q30917141;

import java.util.List;
import java.util.stream.Collectors;

    public class CustomPojoService {
        public static List<CustomPojo> removeUnwantedKeys(List<CustomPojo> customPojoArray) {
            return customPojoArray.stream().filter(
                    customPojo -> customPojo.getKeyToRemove() != null
            ).collect(Collectors.toList());
        }
    }
